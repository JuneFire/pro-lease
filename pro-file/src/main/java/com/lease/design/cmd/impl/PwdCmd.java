package com.lease.design.cmd.impl;

import com.lease.design.cmd.ConsumeResult;
import com.lease.design.cmd.annotation.CmdCode;
import com.lease.design.cmd.enums.CmdEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HP on 2018/5/26.
 */
@CmdCode(code = CmdEnums.CMD_PWD)
public class PwdCmd extends BaseCmd {

	private static final Logger logger = LoggerFactory.getLogger(PwdCmd.class);

	@Override
	public String getCmdName() {
		return CmdEnums.CMD_PWD.getCmd();
	}

	@Override
	public ConsumeResult completeCmd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = getCurrentPath(request);
		return new ConsumeResult<String>().buildSuccessConsumeResult(path);
	}
}
