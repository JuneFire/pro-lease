package com.lease.design.cmd.exception;

/**
 * Created by HP on 2018/5/21.
 */
public class FileServiceException extends RuntimeException{

	public FileServiceException(String message) {
		super(message);
	}

	public FileServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
