package com.lease.design.cmd.enums;

/**
 * Created by HP on 2018/5/26.
 */
public enum CmdEnums {

	CMD_CD("cd","打开文件夹"),CMD_LS("ls","查看当前文件夹下的文件名"),
	CMD_LL("ll","查看当前文件夹下的文件详情"),CMD_CAT("cat","查看文件内容"),
	CMD_ZIP("zip","将指定目录的文件或者文件夹,压缩到指定文件名"),CMD_UNZIP("unzip","将执行的压缩文件,解压到指定文件路径"),
	CMD_VIM("vim","修改执行的文件内容"),CMD_MKDIR("mkdir","创建一个文件夹"),CMD_TOUCH("touch","创建一个文件"),
	CMD_RM("rm","删除文件或者文件夹"),CMD_ENUMS("","默认命令"),CMD_PWD("pwd","查看当前所处文件目录"),
	CMD_SZ("sz","下载文件"),CMD_RZ("rz","上传文件");

	private String cmd;

	private String desc;

	CmdEnums(String cmd,String desc){
		this.cmd = cmd;
		this.desc = desc;
	}

	public String getCmd() {
		return cmd;
	}

	public String getDesc() {
		return desc;
	}
}
