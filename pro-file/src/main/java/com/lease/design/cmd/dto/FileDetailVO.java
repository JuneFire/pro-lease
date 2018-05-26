package com.lease.design.cmd.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by HP on 2018/5/26.
 */
@Data
public class FileDetailVO implements Serializable{

	private static final long serialVersionUID = -5942723257824870050L;

	private String fileName;

	private String path;

	private Long size;

	private Integer fileType;

}
