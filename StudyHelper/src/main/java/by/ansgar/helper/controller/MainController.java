package by.ansgar.helper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value="/main")
	public ModelAndView doMain(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("main");
		return mav;
	}

}
