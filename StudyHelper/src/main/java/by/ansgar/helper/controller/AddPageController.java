package by.ansgar.helper.controller;

import java.io.IOException;
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

import by.ansgar.helper.entity.Students;
import by.ansgar.helper.service.StudentService;

@Controller
public class AddPageController {

	@Autowired
	private StudentService studentsService;

	@RequestMapping(value = "/add_page")
	public ModelAndView doAddPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add_page");

		return mav;

	}

	@RequestMapping(value = "/add_student", method = { RequestMethod.GET, RequestMethod.POST })
	public String addUsers(@ModelAttribute Students students, BindingResult result) {
		try {
			studentsService.addUser(students);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "main";
	}

	//TODO
	@RequestMapping(value = "/add_usersFromFile", method = { RequestMethod.GET, RequestMethod.POST })
	public String addUserdFromFile( HttpServletRequest request) throws IOException {

		String name = request.getParameter("file_name");
		System.out.println(name);

		try {
			studentsService.addUserFromFile(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "forward:/show_all";
	}
	
	@RequestMapping(value="/delete_student_{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteStudent(@ModelAttribute Students students, @PathVariable long id, BindingResult result){
		try {
			students.setId(id);
			studentsService.deleteUser(students);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "forward:/show_all";
	}

	@ModelAttribute("students")
	public Students students() {
		return new Students();
	}
	
	

}
