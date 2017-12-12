package com.chabed.spring.controller;


import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chabed.spring.utils.JasperReportFactory;


@Controller
public class WelcomeController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(WelcomeController.class);

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model,HttpServletRequest request,HttpServletResponse response) {
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("/openStaticReport")
	public String openStaticReport(HttpServletResponse response) {
		new JasperReportFactory().openReport("test",null, response);
		return null;
	}
	
	@RequestMapping("/openDynamicReport")
	public String openDynamicReport(@RequestParam("pid") String pid,HttpServletResponse response) {
		logger.info("openReport"+pid);
		//Parameters as Map to be passed to Jasper
		HashMap<String,Object> hmParams=new HashMap<String,Object>();
		hmParams.put("pid", pid);
		new JasperReportFactory().openReport("student",hmParams, response);
		return null;
	}
	
}