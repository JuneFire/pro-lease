package com.lease.design.cmd.enums;

/**
 * Created by HP on 2018/5/21.
 */
public enum FileTypeEnum {

	FILE_TYPE_FILE(1,"文件"),FILE_TYPE_DIR(2,"文件夹"),FILE_TYPE_JAR(3,"压缩文件");

	private int code;

	private String desc;

	FileTypeEnum(int code, String desc){
		this.code = code;
		this.desc = desc;
	}


	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
