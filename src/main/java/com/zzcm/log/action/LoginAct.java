package com.zzcm.log.action;

import com.zzcm.log.bean.User;
import com.zzcm.log.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;

@Controller
@RequestMapping(value="/user")
public class LoginAct {
	private static final Logger log = LoggerFactory.getLogger(LoginAct.class);
	
	@Autowired
	private UserService userService;
	

	//@RequestMapping(value="/login")	//如果类级别上已有映射地址（/user），此处的完整请求地址是/user/login
	public String doLogin(Model model,Object loginForm){
		//model.addAttribute("username",username);	//model被用来封装数据，向前台传递
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		ServletContext sc = context.getServletContext();
		
		return "/welcome";
	}
	
	@RequestMapping(value="/login")
	public String login(User user,Model model){
		log.info(user.getUsername());
		model.addAttribute(user);
		return "/welcome";
	}
	
	@RequestMapping(value="/save")
	public String save(@ModelAttribute User user,Model model,RedirectAttributes attr){
		log.info(user.getUsername());
		userService.saveUser(user);
		//model.addAttribute(user);
		attr.addFlashAttribute(user);
		//attr.addFlashAttribute("user",user);
		return "redirect:/user/login";
		//return "/welcome";
	}
}
