package by.ansgar.helper.service.impl;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.ansgar.helper.dao.RatingsDAO;
import by.ansgar.helper.entity.Ratings;
import by.ansgar.helper.service.RatingsService;

@Service
public class RatingsServiceImpl implements RatingsService{
	
	@Autowired
	private RatingsDAO ratingsDAO;

	@Transactional
	public void addRating(Ratings ratings) throws SQLException {
		ratingsDAO.addRating(ratings);
		
	}

	@Transactional
	public void editRating(Ratings ratings) throws SQLException {
		ratingsDAO.editRating(ratings);
		
	}

}
