package com.dreamnight.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/home")
public class HomeController {
	
	/**
	 * consumes : 指定处理请求[request]的提交内容类型（Content-Type），例如application/json;
	 * @return
	 */
	@RequestMapping(value={"/profile"},method=RequestMethod.GET,consumes="application/json")
	public @ResponseBody String profile(){
		return "profile";
	}
	
	/**
	 * produces : 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；
	 * @return
	 */
	@RequestMapping(value="/profile1", method=RequestMethod.GET,produces="application/json")
	public @ResponseBody String profile1(){
		return "profile1";
	}
	
	/**
	 * params： 指定request中必须包含某些参数值是，才让该方法处理。
	 * headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求。
	 * @return
	 */
	@RequestMapping(value="/profile2", method=RequestMethod.GET,produces="application/json",params="uid=1",headers="Referer=http://www.test.com/")
	public @ResponseBody String profile2(){
		return "profile2";
	}

}
