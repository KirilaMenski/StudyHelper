package by.ansgar.helper.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.ansgar.helper.dao.LessonsDAO;
import by.ansgar.helper.entity.Lessons;
import by.ansgar.helper.service.LessonsService;

@Service
public class LessonsServiceImpl implements LessonsService{

	@Autowired
	private LessonsDAO lessonsDAO;
	
	public void addLessons(Lessons lessons) throws SQLException {
		lessonsDAO.addLessons(lessons);
		
	}

	@Transactional
	public void editLessons(Lessons lessons) throws SQLException {
		lessonsDAO.editLessons(lessons);
	}

	@Transactional
	public List<Lessons> getAllLessons() throws SQLException {
		List<Lessons> allLessons = new ArrayList<Lessons>();
		allLessons = lessonsDAO.getAllLessons();
		return allLessons;
	}

	@Transactional
	public List<Lessons> getLesson(String name) throws SQLException {
		List<Lessons> lesson = new ArrayList<Lessons>();
		lesson = lessonsDAO.getLesson(name);
		return lesson;
	}

}
