package com.mkyong.common.controller;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Controller
@RequestMapping("/welcome")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) throws IOException, ParseException {
		File jsonFile = new File("C:/Users/asinelni/projects/SpringMVC-master/SpringMVC-master/src/main/resources/page_1001.json");
		JSONParser parser = new JSONParser();
		JSONObject array = (JSONObject) parser.parse(new FileReader(jsonFile));
		String json = array.toJSONString();
		model.addAttribute("message", "Spring 3 MVC Hello World");
		model.addAttribute("json", json);
		return "hello";

	}
	
}