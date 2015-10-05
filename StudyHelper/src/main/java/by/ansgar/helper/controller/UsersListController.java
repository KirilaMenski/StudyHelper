package by.ansgar.helper.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.ansgar.helper.entity.User;
import by.ansgar.helper.service.UserService;

@Controller
public class UsersListController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/show_all")
	public ModelAndView showAll() {
		ModelAndView mav = new ModelAndView();
		try {
			List<User> allUsers = userService.getAllUsers();
			mav.addObject("users", allUsers);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		mav.setViewName("users_list");

		return mav;
	}
	
	@ModelAttribute("users")
	public User user(){
		return new User();
	}

}
