package com.lease.design.cmd.filter;

import com.lease.design.cmd.impl.BaseCmd;
import com.lease.design.cmd.manager.CmdManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by HP on 2018/5/26.
 */
public class CmdFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(CmdFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String cmd = request.getParameter("cmd");
		try {
			BaseCmd baseCmd = CmdManager.getCmd(cmd);
			baseCmd.execute((HttpServletRequest) request, (HttpServletResponse) response);
		} catch (Exception e) {
			logger.error("执行filter异常.cmd = {}", cmd, e);
		}
	}

	@Override
	public void destroy() {

	}
}
