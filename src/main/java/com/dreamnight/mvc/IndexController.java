package com.dreamnight.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamnight.model.User;
import com.dreamnight.restful.remote.IUserRemote;
import com.dreamnight.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IUserRemote userRemote;
	
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
	
	@RequestMapping(value="/getDubboUser", method=RequestMethod.GET)
	public @ResponseBody com.dreamnight.restful.model.User getUser(){
		return userRemote.getUserById(1L);
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

}
