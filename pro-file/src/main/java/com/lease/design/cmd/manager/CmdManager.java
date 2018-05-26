package com.lease.design.cmd.manager;

import com.lease.design.cmd.impl.BaseCmd;
import com.lease.design.cmd.annotation.CmdCode;
import com.lease.design.cmd.enums.CmdEnums;
import com.lease.design.cmd.exception.FileServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2018/5/26.
 * 指令管理器
 */
public class CmdManager {

	private static final Logger logger = LoggerFactory.getLogger(CmdManager.class);

	// key 指令名称
	private static final Map<String, BaseCmd> cmdMap = new HashMap<>();


	public static void init() throws Exception {
		// 获得最初的baseCmd的类对象
		Class baseClass = Class.forName(BaseCmd.class.getName());
		List<Class<?>> list = getAllClass(baseClass);

		for (Class<?> clazz : list) {
			CmdCode cmdCode = clazz.getAnnotation(CmdCode.class);
			if (cmdCode == null) {
				continue;
			}
			if (cmdMap.get(cmdCode.code().getCmd()) != null) {
				logger.error("存在相同的指令.初始化cmd异常.cmd = {}", cmdCode);
				throw new FileServiceException("有相同的指令");
			}
			BaseCmd object = (BaseCmd) clazz.newInstance();
			cmdMap.put(cmdCode.code().getCmd(), object);
		}
	}

	public static BaseCmd getCmd(String cmd) throws Exception {
		BaseCmd baseCmd = cmdMap.get(cmd);
		if (baseCmd == null) {
			logger.info("找不到执行命令.cmd = {}", cmd);
			throw new FileServiceException("指令找不到.");
		}
		return baseCmd;
	}

	/**
	 * 获取当前class下的所有文件
	 *
	 * @param clazz
	 * @return
	 */
	private static List<Class<?>> getAllClass(Class<?> clazz) throws Exception {
		String pk = clazz.getPackage().getName();
		String path = pk.replace('.', '/');
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource(path);
		return getClass(new File(url.getFile()), pk);
	}

	/**
	 * 迭代查找类
	 *
	 * @param dir
	 * @param pk
	 * @return
	 * @throws ClassNotFoundException
	 */
	private static List<Class<?>> getClass(File dir, String pk) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!dir.exists()) {
			return classes;
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				classes.addAll(getClass(f, pk + "." + f.getName()));
			}
			String name = f.getName();
			if (name.endsWith(".class")) {
				String pkName = pk + "." + name.substring(0,name.indexOf(".class"));
				logger.info("pkName = {}",pkName);
				classes.add(Class.forName(pkName));
			}
		}
		return classes;
	}

	public static void main(String[] args){
		try {
			CmdManager.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseCmd baseCmd = cmdMap.get(CmdEnums.CMD_CAT.getCmd());
		logger.info("baseCmd = {}",baseCmd.getCmdName());
	}

}
