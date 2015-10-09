package by.ansgar.helper.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.ansgar.helper.dao.LessonsDAO;
import by.ansgar.helper.entity.Lessons;

@Repository
public class LessonsDAOImpl implements LessonsDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addLessons(Lessons lessons) throws SQLException {
		currentSession().save(lessons);
	}

	public void editLessons(Lessons lessons) throws SQLException {
		currentSession().update(lessons);
	}

	@SuppressWarnings("unchecked")
	public List<Lessons> getAllLessons() throws SQLException {
		List<Lessons> allLessons = new ArrayList<Lessons>();
		allLessons = currentSession().createQuery("From Lessons").list();
		return allLessons;
	}

	@SuppressWarnings("unchecked")
	public List<Lessons> getLesson(String name) throws SQLException {
		List<Lessons> lesson = new ArrayList<Lessons>();
		lesson = currentSession().createQuery("From Lessons l WHERE l.lesson_eng = :lesson_eng").setParameter("lesson_eng", name).list();
		return lesson;
	}
	
	private Session currentSession(){
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession;
	}

}
