package com.lzx.sys.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzx.sys.service.GenerateCodeService;

@RestController
@RequestMapping("/generateCode")
public class GenerateCodeController {
	
	@Resource
	private GenerateCodeService generateCodeService;
	
	@GetMapping("/printExceptionTest")
	public synchronized String printExceptionTest(){
		return generateCodeService.printExceptionTest();
	}

}
