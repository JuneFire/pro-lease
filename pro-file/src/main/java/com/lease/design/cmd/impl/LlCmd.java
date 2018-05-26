package com.lease.design.cmd.impl;

import com.lease.design.cmd.ConsumeResult;
import com.lease.design.cmd.annotation.CmdCode;
import com.lease.design.cmd.dto.FileDetailVO;
import com.lease.design.cmd.enums.CmdEnums;
import com.lease.design.cmd.helper.FileBuilderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 2018/5/26.
 */
@CmdCode(code = CmdEnums.CMD_LL)
public class LlCmd extends BaseCmd {

	private static final Logger logger = LoggerFactory.getLogger(LlCmd.class);

	@Override
	public String getCmdName() {
		return CmdEnums.CMD_LL.getCmd();
	}

	@Override
	public ConsumeResult completeCmd(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String path = getCurrentPath(request);

		File file = new File(path);

		if (!file.exists()) {
			logger.info("文件不存在.path = {}", path);
			return new ConsumeResult<>().buildFailConsumeResult("文件不存在");
		}

		if (!file.isDirectory()) {
			logger.info("当前path不是文件夹.path = {}", path);
			return new ConsumeResult<>().buildFailConsumeResult("当前path不是文件夹");
		}

		File[] files = file.listFiles();

		List<FileDetailVO> list = new ArrayList<>();
		if (files == null || files.length <= 0) {
			logger.info("当前文件夹下文件数量为0.path = {}", path);
			return new ConsumeResult<List<FileDetailVO>>().buildSuccessConsumeResult(list);
		}
		FileDetailVO fileDetailVO;

		for (File file1 : files) {
			fileDetailVO = FileBuilderHelper.buildFileDetail(file1);
			list.add(fileDetailVO);
		}

		return new ConsumeResult<List<FileDetailVO>>().buildSuccessConsumeResult(list);

	}
}
