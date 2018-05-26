package com.lease.design.cmd.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HP on 2018/5/26.
 */
@Data
public class FileDetailListVO implements Serializable{

	private static final long serialVersionUID = -7785230001524521121L;

	private List<FileDetailVO> list;

}
