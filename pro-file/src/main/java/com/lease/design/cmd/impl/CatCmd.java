package com.lease.design.cmd.impl;

import com.lease.design.cmd.ConsumeResult;
import com.lease.design.cmd.annotation.CmdCode;
import com.lease.design.cmd.enums.CmdEnums;
import com.lease.design.cmd.exception.FileServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * Created by HP on 2018/5/26.
 */
@CmdCode(code = CmdEnums.CMD_CAT)
public class CatCmd extends BaseCmd {

	private static final Logger logger = LoggerFactory.getLogger(CatCmd.class);

	@Override
	public String getCmdName() {
		return CmdEnums.CMD_CAT.getCmd();
	}

	@Override
	public ConsumeResult completeCmd(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String path = getRequestPath(request);

		File file = new File(path);

		if (!file.exists()) {
			logger.info("当前文件不存在.path = {}", path);
			throw new FileServiceException("文件找不到.");
		}

		if (!file.isFile()) {
			logger.info("当前文件不是一个文件.path = {}", path);
			throw new FileServiceException("当前文件不是一个文件.");
		}
		FileInputStream fileInputStream = null;
		OutputStream outputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			outputStream = response.getOutputStream();
			outputStream.write(fileInputStream.read());
		} finally {
			if (fileInputStream != null) {
				fileInputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
		return new ConsumeResult<>().buildSuccessConsumeResult("文件打开成功.");
	}

}
