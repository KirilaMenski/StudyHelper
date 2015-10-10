package by.ansgar.helper.service;

import java.sql.SQLException;
import java.util.List;

import by.ansgar.helper.entity.LinkStudentsLessonsRating;

public interface LinkStudentsLessonsRatingsService {
	
public void addLink(LinkStudentsLessonsRating linkSLR) throws SQLException;
	
	public List<LinkStudentsLessonsRating> getStudLessons (long id) throws SQLException;
	
	public List<LinkStudentsLessonsRating> getLessRatings (long id) throws SQLException;
	
	public List<LinkStudentsLessonsRating> getStudRatings(long id) throws SQLException;
	

}
