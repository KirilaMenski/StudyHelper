package by.ansgar.helper.service;

import java.sql.SQLException;

import by.ansgar.helper.entity.Ratings;

public interface RatingsService {

	public void addRating(Ratings ratings) throws SQLException;
	
	public void editRating(Ratings ratings) throws SQLException;
	
	
}
