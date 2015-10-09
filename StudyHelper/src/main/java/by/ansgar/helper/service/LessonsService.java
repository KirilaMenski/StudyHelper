package by.ansgar.helper.service;

import java.sql.SQLException;
import java.util.List;

import by.ansgar.helper.entity.Lessons;

public interface LessonsService {
	
	public void addLessons(Lessons lessons) throws SQLException;
	
	public void editLessons(Lessons lessons) throws SQLException;
	
	public List<Lessons> getAllLessons () throws SQLException;
	
	public List<Lessons> getLesson (String name) throws SQLException;
	

}
