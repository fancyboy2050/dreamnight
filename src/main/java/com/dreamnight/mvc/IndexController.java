package com.dreamnight.mvc;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamnight.model.User;
import com.dreamnight.service.UserService;

@Controller
public class IndexController {
	
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/index","/"})
	public String index(){
		return "index";
	}
	
	@RequestMapping("/getId/{id}")
	public @ResponseBody User getUserById(@PathVariable(value="id")Long id){
		return userService.getUserById(id);
	}
	
	@RequestMapping(value="/getId",method=RequestMethod.POST)
	public @ResponseBody User getUserById1(Long id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(value="/getId2", method=RequestMethod.GET)
	public @ResponseBody User getUserById2(Long id){
		long x = 1/id;
		return userService.getUserById(id);
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public @ResponseBody User createUser(String email, String password, String nickname){
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setNickname(nickname);
		user = userService.createUser(user);
		return user;
	}
	
	/** 
     * 异常页面控制 
     * @param runtimeException
     * @return 
     */  
    @ExceptionHandler(RuntimeException.class)  
    public @ResponseBody  Map<String,Object> runtimeExceptionHandler(RuntimeException runtimeException) {  
        logger.error("ExceptionControllerAdvice get error!", runtimeException); 
        Map<String, Object> model = new TreeMap<String, Object>();  
        model.put("status", false);  
        return model;  
    } 

}
