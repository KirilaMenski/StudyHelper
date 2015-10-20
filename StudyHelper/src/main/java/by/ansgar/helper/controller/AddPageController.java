package by.ansgar.helper.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import by.ansgar.helper.entity.Students;
import by.ansgar.helper.service.StudentService;
import by.ansgar.helper.util.Upload;

@Controller
public class AddPageController {

	private static final Logger LOG = Logger.getLogger(AddPageController.class);

	@Autowired
	private StudentService studentsService;

	@RequestMapping(value = "/add_page")
	public ModelAndView doAddPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add_page");

		return mav;

	}

	@RequestMapping(value = "/add_student", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String addUsers(@ModelAttribute Students students,
			BindingResult result) {
		try {
			studentsService.addStudent(students);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.warn(e);
		}
		return "main";
	}

	@RequestMapping(value = "/add_usersFromFile", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView addUserdFromFile(
			@RequestParam(value = "file", required = false) MultipartFile multipartFile) {
		ModelAndView mav = new ModelAndView();
		Upload.doUpload(multipartFile);
		
		try {
			studentsService.addStudentFromFile(Upload.path.toString());
		}  catch (SQLException e) {
			e.printStackTrace();
			LOG.warn(e);
		}
		
		mav.setViewName("forward:/show_all_page_1_sorting_by_id");
		return mav;
	}

	@ModelAttribute("students")
	public Students students() {
		return new Students();
	}

}
