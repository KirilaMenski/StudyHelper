package by.ansgar.helper.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.ansgar.helper.dao.LinkStudentsLessonsRatingsDAO;
import by.ansgar.helper.entity.LinkStudentsLessonsRating;

@Repository
public class LinkStudentsLessonsRatingsDAOImpl
		implements LinkStudentsLessonsRatingsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addLink(LinkStudentsLessonsRating linkSLR) throws SQLException {
		currentSession().save(linkSLR);
	}

	@SuppressWarnings("unchecked")
	public List<LinkStudentsLessonsRating> getStudLessons(long id)
			throws SQLException {

		List<LinkStudentsLessonsRating> lessons = new ArrayList<LinkStudentsLessonsRating>();
		lessons = currentSession()
				.createQuery(
						"SELECT les FROM LinkStudentsLessonsRating slr LEFT OUTER JOIN slr.lessons les LEFT OUTER JOIN slr.students stud"
								+ " WHERE slr.lessons.id = slr.lessons"
								+ " AND slr.students = slr.students.id"
								+ " AND slr.students.id = :id")
				.setParameter("id", id).list();

		return lessons;
	}

	@SuppressWarnings("unchecked")
	public List<LinkStudentsLessonsRating> getLessRatings(long id)
			throws SQLException {
		List<LinkStudentsLessonsRating> ratings = new ArrayList<LinkStudentsLessonsRating>();
		ratings = currentSession()
				.createQuery(
						"SELECT rat FROM LinkStudentsLessonsRating slr LEFT OUTER JOIN slr.ratings rat LEFT OUTER JOIN slr.lessons les"
								+ " WHERE slr.ratings.id = slr.ratings"
								+ " AND slr.lessons = slr.lessons.id"
								+ " AND slr.lessons.id = :id")
				.setParameter("id", id).list();
		return ratings;
	}

	@SuppressWarnings("unchecked")
	public List<LinkStudentsLessonsRating> getStudRatings(long id)
			throws SQLException {
		List<LinkStudentsLessonsRating> ratings = new ArrayList<LinkStudentsLessonsRating>();
		ratings = currentSession()
				.createQuery(
						"SELECT rat FROM LinkStudentsLessonsRating slr LEFT OUTER JOIN slr.ratings rat LEFT OUTER JOIN slr.students stud"
								+ " WHERE slr.ratings.id = slr.ratings"
								+ " AND slr.students = slr.students.id"
								+ " AND slr.students.id = :id")
				.setParameter("id", id).list();
		return ratings;
	}

	@SuppressWarnings("unchecked")
	public List<LinkStudentsLessonsRating> getRatingsByStudAndLesson(
			long lessonId, long studentId) throws SQLException {
		List<LinkStudentsLessonsRating> ratings = new ArrayList<LinkStudentsLessonsRating>();
		ratings = currentSession()
				.createQuery(
						"SELECT rat FROM LinkStudentsLessonsRating slr LEFT OUTER JOIN slr.ratings rat LEFT OUTER JOIN slr.lessons les LEFT OUTER JOIN slr.students stud"
								+ " WHERE slr.ratings.id = slr.ratings"
								+ " AND slr.lessons = slr.lessons.id"
								+ " AND slr.lessons.id = :lessonId"
								+ " AND slr.students = slr.students.id"
								+ " AND slr.students.id = :studentId")
				.setParameter("lessonId", lessonId)
				.setParameter("studentId", studentId).list();
		return ratings;
	}

	private Session currentSession() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession;
	}

	// TODO
	@SuppressWarnings("unchecked")
	public List<LinkStudentsLessonsRating> getRatingsByStudAndLesson(
			long groupId, long lessonId, long studentId) throws SQLException {
		List<LinkStudentsLessonsRating> ratings = new ArrayList<LinkStudentsLessonsRating>();
		ratings = currentSession()
				.createQuery(
						"SELECT rat FROM LinkStudentsLessonsRating slr LEFT OUTER JOIN slr.ratings rat LEFT OUTER JOIN slr.lessons les LEFT OUTER JOIN slr.students stud LEFT OUTER JOIN slr.group gr"
								+ " WHERE slr.ratings.id = slr.ratings"
								+ " AND slr.group = slr.group.id"
								+ " AND slr.group.id = :groupId"
								+ " AND slr.lessons = slr.lessons.id"
								+ " AND slr.lessons.id = :lessonId"
								+ " AND slr.students = slr.students.id"
								+ " AND slr.students.id = :studentId")
				.setParameter("groupId", groupId)
				.setParameter("lessonId", lessonId)
				.setParameter("studentId", studentId).list();
		return ratings;
	}

}
