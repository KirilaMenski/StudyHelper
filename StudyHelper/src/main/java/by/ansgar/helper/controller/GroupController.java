package by.ansgar.helper.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.ansgar.helper.entity.Lessons;
import by.ansgar.helper.entity.LinkStudentsLessonsRating;
import by.ansgar.helper.entity.Ratings;
import by.ansgar.helper.entity.Students;
import by.ansgar.helper.service.LessonsService;
import by.ansgar.helper.service.LinkStudentsLessonsRatingsService;
import by.ansgar.helper.service.StudentService;

@Controller
public class GroupController {

	private static final Logger LOG = Logger.getLogger(GroupController.class);

	@Autowired
	private StudentService studentService;
	@Autowired
	private LessonsService lessonsService;
	@Autowired
	private LinkStudentsLessonsRatingsService lslrService;

	@RequestMapping(value = "/view_group_{group}_lesson_{lesson}")
	public ModelAndView showGroup(@PathVariable String group,
			@PathVariable long lesson) {
		ModelAndView mav = new ModelAndView();
		try {
			List<Students> studentsByGroup = studentService
					.getStudentsByGroup(group);
			List<Lessons> lessons = lessonsService.getAllLessons();
			
			List<LinkStudentsLessonsRating> studRatingById = new ArrayList<LinkStudentsLessonsRating>();
			
			for (int i = 0; i < studentsByGroup.size(); i++) {
				studRatingById.addAll(lslrService.getRatingsByStudAndLesson(
						lesson, studentsByGroup.get(i).getId()));
			}
			
			List<Integer> numb = new ArrayList<Integer>();
			for(int i = 0; i < 10; i++){
				numb.add(i);
			}
			
			int [][] x = new int [5][5];
			for(int i = 0; i < 5; i++){
				
				for(int j = 0; j < 5; j++){
					x[i][j] = i;
					System.out.print(x[i][j]);
					int y = x[0][1];
					mav.addObject("xj", x[j]);
				}
				System.out.println();
				mav.addObject("xi", x[i]);
			}
			System.out.println(x[3][1]);
			
			
			mav.addObject("numb", numb);
			mav.addObject("studRatings", studRatingById);
			mav.addObject("lessons", lessons);
			mav.addObject("group", group);
			mav.addObject("studentsByGroup", studentsByGroup);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.warn(e);
		}

		mav.setViewName("group");
		return mav;
	}

	
	@ModelAttribute("ratings")
	public Ratings ratings() {
		return new Ratings();
	}
	
}
