package com.lease.design.cmd.utils;

import com.lease.design.cmd.dto.FileDetailVO;
import com.lease.design.cmd.exception.FileServiceException;
import com.lease.design.cmd.helper.FileBuilderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 2018/5/21.
 */
public class FileUtils {

	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * 创建文件
	 * @param path
	 * @param fileName
	 */
	public static void createNewFile(String path, String fileName) {

		String absolutePath = path + fileName;

		logger.info("创建文件,path = {},fileName = {}", path, fileName);

		File file = new File(absolutePath);

		if (file.exists()) {
			logger.info("当前文件夹已经存在.path = {},fileName = {}", path, fileName);
			throw new FileServiceException("当前文件夹已经存在");
		}

		try {
			file.createNewFile();
		} catch (IOException e) {
			logger.info("创建文件异常.path = {},fileName = {}", path, fileName, e);
		}

	}

	/**
	 * 根据目录得到文件列表
	 * @param path
	 * @return
	 */
	public static List<FileDetailVO> getFileList(String path) {
		File file = new File(path);

		if (!file.exists()) {
			logger.info("当前文件目录不存在.path = {}", path);
			throw new FileServiceException("当前文件目录不存在");
		}

		File[] files = file.listFiles();
		List<FileDetailVO> list = new ArrayList<>();
		if (files == null || files.length == 0) {
			return list;
		}
		FileDetailVO fileDetailPO;
		for (File file1 : files) {
			fileDetailPO = FileBuilderHelper.buildFileDetail(file1);
			list.add(fileDetailPO);
		}
		return list;
	}

	public static void main(String[] agrs) {
		String path = "E:\\webTest";
		List<FileDetailVO> list = FileUtils.getFileList(path);
		for (FileDetailVO fileDetailPO : list) {
			logger.info("fileDetailPO = {}", fileDetailPO);
		}
	}

}
