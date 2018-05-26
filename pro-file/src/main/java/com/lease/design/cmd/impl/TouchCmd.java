package com.lease.design.cmd.impl;

import com.lease.design.cmd.ConsumeResult;
import com.lease.design.cmd.annotation.CmdCode;
import com.lease.design.cmd.enums.CmdEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by HP on 2018/5/26.
 */
@CmdCode(code = CmdEnums.CMD_TOUCH)
public class TouchCmd extends BaseCmd {

	private static final Logger logger = LoggerFactory.getLogger(TouchCmd.class);

	@Override
	public String getCmdName() {
		return CmdEnums.CMD_TOUCH.getCmd();
	}

	@Override
	public ConsumeResult completeCmd(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String finalPath = getRequestPath(request);
		File file = new File(finalPath);
		if (file.exists()) {
			logger.info("当前文件已经存在.finalPath = {}", finalPath);
			return new ConsumeResult<>().buildFailConsumeResult("当前文件已经存在");
		}
		file.createNewFile();
		if (!file.isFile()) {
			// 发现创建的不是一个文件夹,删掉改文件.
			file.delete();
			logger.info("创建不是一个文件,不允许通过.finalPath = {}", finalPath);
			return new ConsumeResult<>().buildFailConsumeResult("仅允许创建文件.");
		}
		return new ConsumeResult<String>().buildSuccessConsumeResult(finalPath);
	}

}
