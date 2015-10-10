package by.ansgar.helper.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.ansgar.helper.dao.LinkStudentsLessonsRatingsDAO;
import by.ansgar.helper.entity.LinkStudentsLessonsRating;
import by.ansgar.helper.service.LinkStudentsLessonsRatingsService;

@Service
public class LinkStudentsLessonsRatingsServiceImpl implements LinkStudentsLessonsRatingsService{
	
	@Autowired
	private LinkStudentsLessonsRatingsDAO linkSLRDAO;

	@Transactional
	public void addLink(LinkStudentsLessonsRating linkSLR) throws SQLException {
		linkSLRDAO.addLink(linkSLR);
		
	}

	@Transactional
	public List<LinkStudentsLessonsRating> getStudLessons(long id)
			throws SQLException {
		List<LinkStudentsLessonsRating> lessonsById = new ArrayList<LinkStudentsLessonsRating>();
		lessonsById = linkSLRDAO.getStudLessons(id);
		return lessonsById;
	}

	@Transactional
	public List<LinkStudentsLessonsRating> getLessRatings(long id)
			throws SQLException {
		List<LinkStudentsLessonsRating> ratingById = new ArrayList<LinkStudentsLessonsRating>();
		ratingById = linkSLRDAO.getLessRatings(id);
		return ratingById;
	}
	
	@Transactional
	public List<LinkStudentsLessonsRating> getStudRatings(long id)
			throws SQLException {
		List<LinkStudentsLessonsRating> ratingById = new ArrayList<LinkStudentsLessonsRating>();
		ratingById = linkSLRDAO.getStudRatings(id);
		return ratingById;
	}

}
