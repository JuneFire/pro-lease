package com.lease.design.cmd.impl;

import com.lease.design.cmd.ConsumeResult;
import com.lease.design.cmd.annotation.CmdCode;
import com.lease.design.cmd.enums.CmdEnums;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HP on 2018/5/26.
 */
@CmdCode(code = CmdEnums.CMD_VIM)
public class VimCmd extends BaseCmd{
	@Override
	public String getCmdName() {
		return CmdEnums.CMD_VIM.getCmd();
	}

	@Override
	public ConsumeResult completeCmd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
}
