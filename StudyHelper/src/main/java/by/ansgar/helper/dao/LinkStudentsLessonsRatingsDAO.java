package by.ansgar.helper.dao;

import java.sql.SQLException;
import java.util.List;

import by.ansgar.helper.entity.LinkStudentsLessonsRating;

public interface LinkStudentsLessonsRatingsDAO {

	public void addLink(LinkStudentsLessonsRating linkSLR) throws SQLException;

	public List<LinkStudentsLessonsRating> getStudLessons(long id)
			throws SQLException;

	public List<LinkStudentsLessonsRating> getLessRatings(long id)
			throws SQLException;

	public List<LinkStudentsLessonsRating> getStudRatings(long id)
			throws SQLException;

	public List<LinkStudentsLessonsRating> getRatingsByStudAndLesson(
			long lessonId, long studentId) throws SQLException;

	public List<LinkStudentsLessonsRating> getRatingsByStudAndLesson(
			long groupId, long lessonId, long studentId) throws SQLException;

}
