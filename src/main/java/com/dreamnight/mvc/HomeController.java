package com.dreamnight.mvc;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{
	
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
	
	/**
	 * 客户端指定请求头accept=application/json，response数据必须为json格式
	 * @return json
	 */
	@RequestMapping(value="/profile3", headers="Accept=application/json")
	public @ResponseBody String profile3(){
		return "{\"profile3\":\"1\"}";
	}
	
	@RequestMapping(value="/model")
	public @ResponseBody String model(Model model, Map model2, ModelMap model3){
		model.addAttribute("a", "a");
		model2.put("b", "b");
		model3.addAttribute("c", "c");
		boolean b1 = (model == model2);
		boolean b2 = (model3 == model2);
		System.out.println("------------------------model == model2 : "+b1);
		System.out.println("------------------------model2 == model3 : "+b2);
		return "b1 : "+b1+" ; b2 : "+b2;
	}
	
	@RequestMapping(value="/dateTest")
	public @ResponseBody String dateTest(@RequestParam(value="date", required=false)Date date){
		logger.info("dateTest date : "+date);
		return "dateTest";
	}

}
