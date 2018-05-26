package com.lease.design.cmd.annotation;

import com.lease.design.cmd.enums.CmdEnums;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by HP on 2018/5/26.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CmdCode {
	CmdEnums code() default CmdEnums.CMD_ENUMS;
}
