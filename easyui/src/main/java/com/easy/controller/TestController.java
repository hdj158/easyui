package com.easy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.easy.vo.User;

@Controller
public class TestController {

	@RequestMapping("/one")
	public ModelAndView TestOne(User user) {
		
		
		System.out.println(user);
		ModelAndView mv=new ModelAndView("jsp/work");
		
		mv.addObject("user", user);
		
		
		return mv;
		
	}
	@RequestMapping("/main")
	public ModelAndView testTwo5(long message) {
		System.out.println("login+++++++++++++++++++++++++++++");	
		System.out.println(message);
		ModelAndView mv=new ModelAndView("jsp/user");
		if(message==0) {
			mv.addObject("message", "登录成功!!");
		}else {
			mv.addObject("message", "登录失败!!");
		}
		
		return mv;
		
		
	}
	@RequestMapping("/message")
	public ModelAndView testTwo(String message) {
		System.out.println("message+++++++++++++++++++++++++++++");
		
		ModelAndView mv=new ModelAndView("success");
		mv.addObject("message", message);
		return mv;
		
		
	}
	@RequestMapping("/manger01")
	public String testTwo1() {
		
		return "jsp/manger01";
		
		
	}
	@RequestMapping("/manger02")
	public String testTwo2() {
		
		return "jsp/manger02";
		
		
	}
	
	
	
}
