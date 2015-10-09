package by.ansgar.helper.dao.impl;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.ansgar.helper.dao.RatingsDAO;
import by.ansgar.helper.entity.Ratings;

@Repository
public class RatingsDAOImpl implements RatingsDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addRating(Ratings ratings) throws SQLException {
		currentSession().save(ratings);
	}

	public void editRating(Ratings ratings) throws SQLException {
		currentSession().save(ratings);
	}
	
	private Session currentSession(){
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession;
	}

}
