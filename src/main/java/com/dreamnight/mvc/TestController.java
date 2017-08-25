package com.dreamnight.mvc;

import com.dreamnight.model.SimpleUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController{

	@RequestMapping("/test1")
	public @ResponseBody String test1(@RequestBody String rb){
		logger.info("--------------------------TestController test1");
		logger.info("rb : "+rb);
		return ""+rb;
	}
	
	@RequestMapping("/test2")
	public @ResponseBody String test2(@RequestParam(value="test2") String test2){
		logger.info("--------------------------TestController test2");
		return "test2 : "+test2;
	}

	@RequestMapping(value="/test3", produces = {"application/xml", "application/json"})
	public @ResponseBody SimpleUser test3(@RequestBody SimpleUser simpleUser){
		logger.info("--------------------------TestController test3");
		return simpleUser;
	}

	@RequestMapping(value="/test4/{uid}/{username}")
	public @ResponseBody String test4(@PathVariable(value="uid") Integer uid, @PathVariable(value="username") String username){
		logger.info("--------------------------TestController test4");
		return "uid : "+uid+", username : "+username;
	}

	@RequestMapping(value="/test5")
	public @ResponseBody String test5(){
		logger.info("--------------------------TestController test5");
		return "test5";
	}
	
}
