package by.ansgar.helper.dao;

import java.sql.SQLException;

import by.ansgar.helper.entity.Ratings;

public interface RatingsDAO {

	public void addRating(Ratings ratings) throws SQLException;
	
	public void editRating(Ratings ratings) throws SQLException;
	
	
}
