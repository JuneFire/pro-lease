package com.lease.design.cmd;

import com.lease.design.cmd.constants.ConsumeResultConstants;

/**
 * 消费结果
 *
 **/
public class ConsumeResult<T> {

	/**
	 * 结果代码,包含{@link ConsumeResultConstants}中列举的常量
	 */
	private String code;

	private String msg;

	private T data;

	public ConsumeResult(){}

	/**
	 * 构建消费结果对象
	 *
	 * @param code 结果代码,参考: {@link ConsumeResultConstants}
	 * @param msg  结果描述
	 * @return {@link ConsumeResult}
	 */
	public ConsumeResult buildConsumeResult(String code, String msg) {
		this.code = code;
		this.msg = msg;
		return this;
	}

	/**
	 * 构建成功消费结果对象
	 *
	 * @return {@link ConsumeResult}
	 */
	public ConsumeResult buildSuccessConsumeResult(T t) {
		this.code = ConsumeResultConstants.RESULT_SUCCESS;
		this.msg = "执行成功";
		this.data = t;
		return this;
	}

	/**
	 * 构建成功消费结果对象
	 *
	 * @return {@link ConsumeResult}
	 */
	public ConsumeResult buildSuccessConsumeResult() {
		this.code = ConsumeResultConstants.RESULT_SUCCESS;
		this.msg = "执行成功";
		return this;
	}

	/**
	 * 构建失败消费结果对象
	 *
	 * @param msg 结果描述
	 * @return {@link ConsumeResult}
	 */
	public ConsumeResult buildFailConsumeResult(String msg) {
		this.code = ConsumeResultConstants.RESULT_ERROR;
		this.msg = msg;
		return this;
	}

	/**
	 * 判断是否执行成功
	 *
	 * @return boolean
	 */
	public boolean isSuccess() {
		return ConsumeResultConstants.RESULT_SUCCESS.equals(this.code);
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
