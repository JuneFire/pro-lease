package com.lease.design.cmd.helper;

import com.lease.design.cmd.dto.FileDetailVO;
import com.lease.design.cmd.enums.FileTypeEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HP on 2018/5/26.
 */
public class FileBuilderHelper {

	private static final byte[] ZIP_HEADER_1 = new byte[]{80, 75, 3, 4};
	private static final byte[] ZIP_HEADER_2 = new byte[]{80, 75, 5, 6};

	/**
	 * 构建PO
	 * @param file
	 * @return
	 */
	public static FileDetailVO buildFileDetail(File file) {
		FileDetailVO fileDetailPO = new FileDetailVO();
		fileDetailPO.setFileName(file.getName());
		fileDetailPO.setPath(file.getPath());
		fileDetailPO.setSize(getFileSize(new File(file.getPath())));
		setFileType(fileDetailPO, file);
		return fileDetailPO;
	}

	/**
	 * 修改文件类型
	 * @param fileDetailPO
	 * @param file
	 */
	private static void setFileType(FileDetailVO fileDetailPO, File file) {
		if (file.isDirectory()) {
			fileDetailPO.setFileType(FileTypeEnum.FILE_TYPE_DIR.getCode());
		}
		if (file.isFile()) {
			fileDetailPO.setFileType(FileTypeEnum.FILE_TYPE_FILE.getCode());
		}
		if (isArchiveFile(file)) {
			fileDetailPO.setFileType(FileTypeEnum.FILE_TYPE_JAR.getCode());
		}
	}

	/**
	 * 判断文件是否为一个压缩文件
	 *
	 * @param file
	 * @return
	 */
	private static boolean isArchiveFile(File file) {

		if (file == null) {
			return false;
		}

		if (file.isDirectory()) {
			return false;
		}

		boolean isArchive = false;
		InputStream input = null;
		try {
			input = new FileInputStream(file);
			byte[] buffer = new byte[4];
			int length = input.read(buffer, 0, 4);
			if (length == 4) {
				isArchive = (Arrays.equals(ZIP_HEADER_1, buffer)) || (Arrays.equals(ZIP_HEADER_2, buffer));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
				}
			}
		}

		return isArchive;
	}

	/**
	 * 得到文件夹的大小
	 *
	 * @return
	 */
	public static Long getFileSize(File file) {

		if (!file.exists()) {
			return 0L;
		}

		if (file.isFile()) {
			return file.length();
		}

		List<Long> size = new ArrayList<>();
		File[] files = file.listFiles();
		for (File file1 : files) {
			if (file1.isDirectory()) {
				getFileSize(file1, size);
			}
			else {
				size.add(file1.length());
			}
		}

		Long allSize = 0L;
		for (Long size1 : size) {
			allSize = allSize + size1;
		}

		return allSize;
	}

	/**
	 * 递归得到文件大小,可以是文件夹
	 * @param file
	 * @param list
	 */
	private static void getFileSize(final File file, List<Long> list) {
		if (file.isFile()) {
			list.add(file.length());
		}
		File[] files = file.listFiles();
		if (files == null || files.length == 0) {
			return;
		}
		for (File file1 : files) {
			getFileSize(file1, list);
		}
	}

}
