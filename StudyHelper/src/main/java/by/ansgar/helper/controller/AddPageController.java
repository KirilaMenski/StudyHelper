package by.ansgar.helper.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.ansgar.helper.entity.User;
import by.ansgar.helper.service.UserService;

@Controller
public class AddPageController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add_page")
	public ModelAndView doAddPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add_page");

		return mav;

	}

	@RequestMapping(value = "/add_users", method = { RequestMethod.GET, RequestMethod.POST })
	public String addUsers(@ModelAttribute User user, BindingResult result) {
		try {
			userService.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "main";
	}

	@RequestMapping(value = "/add_usersFromFile", method = { RequestMethod.GET, RequestMethod.POST })
	public String addUserdFromFile( HttpServletRequest request) {

		String name = request.getParameter("file_name");
		System.out.println(name);
		try {
			userService.addUserFromFile(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "forward:/show_all";
	}
	
	@RequestMapping(value="/delete_user_{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteUser(@ModelAttribute User user, @PathVariable long id, BindingResult result){
		try {
			user.setId(id);
			userService.deleteUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "forward:/show_all";
	}

	@ModelAttribute("users")
	public User user() {
		return new User();
	}

}
