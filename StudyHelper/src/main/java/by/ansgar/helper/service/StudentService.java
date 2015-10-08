package by.ansgar.helper.service;

import java.sql.SQLException;
import java.util.List;


import by.ansgar.helper.entity.Students;

public interface StudentService {

	public void addStudent(Students students) throws SQLException;
	
	public void addStudentFromFile( String name) throws SQLException;

	public void editStudent(Students students) throws SQLException;

	public void deleteStudent(Students students) throws SQLException;
	
	public Students getStudentById(long id) throws SQLException;

	public List<Students> getAllStudents() throws SQLException;

	public List<Students> sortStudents(int numPage, String colName) throws SQLException;

}
