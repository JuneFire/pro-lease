package com.lease.design.cmd.impl;

import com.lease.design.cmd.ConsumeResult;
import com.lease.design.cmd.annotation.CmdCode;
import com.lease.design.cmd.cookie.FileCookieCaChe;
import com.lease.design.cmd.enums.CmdEnums;
import com.lease.design.cmd.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HP on 2018/5/26.
 */
@CmdCode(code = CmdEnums.CMD_CD)
public class CdCmd extends BaseCmd {

	private static final Logger logger = LoggerFactory.getLogger(CdCmd.class);

	@Override
	public String getCmdName() {
		return CmdEnums.CMD_CD.getCmd();
	}

	@Override
	public ConsumeResult completeCmd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getParameter("path");
		ConsumeResult consumeResult = getFileNameByPath(path);
		if (consumeResult.isSuccess()){
			FileCookieCaChe.put(RequestUtils.getIPAddress(request),path);
		}
		return consumeResult;
	}

}
