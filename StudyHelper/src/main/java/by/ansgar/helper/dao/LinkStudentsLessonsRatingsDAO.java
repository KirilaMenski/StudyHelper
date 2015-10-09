package by.ansgar.helper.dao;

import java.sql.SQLException;
import java.util.List;

import by.ansgar.helper.entity.LinkStudentsLessonsRating;

public interface LinkStudentsLessonsRatingsDAO {
	
	public void addLink(LinkStudentsLessonsRating linkSLR) throws SQLException;
	
	public List<LinkStudentsLessonsRating> getlessons (long id) throws SQLException;
	
	public List<LinkStudentsLessonsRating> getRating (long id) throws SQLException;
	

}
