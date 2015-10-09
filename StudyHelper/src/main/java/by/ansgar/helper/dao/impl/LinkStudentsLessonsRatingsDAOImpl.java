package by.ansgar.helper.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import by.ansgar.helper.dao.LinkStudentsLessonsRatingsDAO;
import by.ansgar.helper.entity.LinkStudentsLessonsRating;

@Repository
public class LinkStudentsLessonsRatingsDAOImpl implements LinkStudentsLessonsRatingsDAO{

	public void addLink(LinkStudentsLessonsRating linkSLR) throws SQLException {
		
	}

	public List<LinkStudentsLessonsRating> getlessons(long id)
			throws SQLException {
		return null;
	}

	public List<LinkStudentsLessonsRating> getRating(long id)
			throws SQLException {
		return null;
	}

}
