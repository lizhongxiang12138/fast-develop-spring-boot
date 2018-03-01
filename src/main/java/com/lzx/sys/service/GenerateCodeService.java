package com.lzx.sys.service;

import org.springframework.stereotype.Service;

/**
 * 
 * <p>Title: 代码生成服务类</p>
 * <p>Description: 用于代码生成的相关业务实现</p>
 * <p>Company: lzx</p> 
 * @author lzx
 * @date 2018年2月25日下午2:39:53
 */
@Service
public class GenerateCodeService {
	
	public String printExceptionTest(){
		try{
			int i=1/0;
			return "success";
		}catch (Exception e) {
			StringBuffer sbf = new StringBuffer();
			sbf.append(e.getMessage()+"\n");
			StackTraceElement[] stackTrace = e.getStackTrace();
			for (StackTraceElement stackTraceElement : stackTrace) {
				sbf.append(stackTraceElement.toString()+"\n");
			}
			System.out.println(sbf.toString());
			return sbf.toString();
		}
	}

}
