package by.ansgar.helper.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.ansgar.helper.entity.Students;
import by.ansgar.helper.service.StudentService;

@Controller
public class StudentsListController {

	@Autowired
	private StudentService studentsService;

	@RequestMapping(value = "/show_all")
	public ModelAndView showAll() {
		ModelAndView mav = new ModelAndView();
		try {
			List<Students> allStudents = studentsService.getAllStudents();
			mav.addObject("students", allStudents);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		mav.setViewName("students_list");

		return mav;
	}
	
	@ModelAttribute("students")
	public Students students(){
		return new Students();
	}

}
