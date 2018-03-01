package com.lzx.sys.entity;

import javax.persistence.*;

@Entity(name = "EXCEPTION_RECORD")
public class ExceptionRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ORDER_ID", unique = true,nullable=false)
	private Long id;

	/**
	 * 错误的堆栈信息
	 */
	@Column(name = "EXCEPTION_STACK_TRACE")
	private String exceptionStackTrace;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

	public void setExceptionStackTrace(String exceptionStackTrace) {
		this.exceptionStackTrace = exceptionStackTrace;
	}
}
