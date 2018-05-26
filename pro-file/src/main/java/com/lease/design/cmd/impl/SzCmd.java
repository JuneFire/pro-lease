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

/**
 * Created by HP on 2018/5/26.
 */
@CmdCode(code = CmdEnums.CMD_SZ)
public class SzCmd extends BaseCmd{

	private static final Logger logger = LoggerFactory.getLogger(SzCmd.class);

	@Override
	public String getCmdName() {
		return CmdEnums.CMD_SZ.getCmd();
	}

	@Override
	public ConsumeResult completeCmd(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String path = getRequestPath(request);

		File file = new File(path);

		if (!file.exists()){
			logger.info("当前文件不存在.path = {}",path);
			throw new FileServiceException("当前文件不存在");
		}



		return null;
	}
}
