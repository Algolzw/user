package controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.inter.UserService;
import dao.inter.UserBase;
import domain.User;

@Controller
public class UserBaseController {
	
	@Inject
	UserService userService;
	
	@RequestMapping("/home")
	public String login(){
		return "home";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody User login(String username,String password){
		User user = userService.login(username, password);
		if(user!=null){
			if(user.isDeleted())
				return null;
		}
		return user;
	}

	@RequestMapping(value="/reghome")
	public String registerHome(){
		return "register";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody User register(String username,String password,String email){
		User user = userService.register(username,password,email);
		userService.verify(user.getUserId());
		return user;
	}
	
	
}
