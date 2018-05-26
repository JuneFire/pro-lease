package com.lease.design.cmd.impl;

import com.lease.design.cmd.ConsumeResult;
import com.lease.design.cmd.annotation.CmdCode;
import com.lease.design.cmd.enums.CmdEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HP on 2018/5/26.
 */
@CmdCode(code = CmdEnums.CMD_MKDIR)
public class MkdirCmd extends BaseCmd {

	private static final Logger logger = LoggerFactory.getLogger(MkdirCmd.class);

	private static final String REGEX = "^[A-z]:\\\\\\\\(.+?\\\\\\\\)*$";

	@Override
	public String getCmdName() {
		return CmdEnums.CMD_MKDIR.getCmd();
	}

	@Override
	public ConsumeResult completeCmd(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String finalPath = getRequestPath(request);
		File file = new File(finalPath);
		if (file.exists()) {
			logger.info("当前文件夹已经存在.finalPath = {}", finalPath);
			return new ConsumeResult<>().buildFailConsumeResult("当前文件夹已经存在");
		}

		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(finalPath);
		if (!matcher.find()) {
			logger.info("创建的不是一个文件夹.finalPath = {}", finalPath);
			return new ConsumeResult<>().buildFailConsumeResult("创建的不是一个文件夹");
		}

		file.mkdir();

		if (!file.isDirectory()) {
			// 发现创建的不是一个文件夹,删掉改文件.
			file.delete();
			logger.info("创建不是一个文件夹,不允许通过.finalPath = {}", finalPath);
			return new ConsumeResult<>().buildFailConsumeResult("创建的不是一个文件夹");
		}

		return new ConsumeResult<String>().buildSuccessConsumeResult(finalPath);
	}
}
