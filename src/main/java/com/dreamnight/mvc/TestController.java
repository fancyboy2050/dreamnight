package com.dreamnight.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController{

	@RequestMapping("/test1")
	public @ResponseBody String test1(@RequestBody String rb){
		logger.info("rb : "+rb);
		return ""+rb;
	}
	
	@RequestMapping("/test2")
	public @ResponseBody String test2(@RequestParam(value="test2") String test2){
		return "test2 : "+test2;
	}
	
}
