package by.ansgar.helper.DAO;

import java.sql.SQLException;
import java.util.List;

import by.ansgar.helper.entity.Students;

public interface StudentDAO {

	public void addUser(Students students) throws SQLException;
	
	public void addUserFromFile(String name) throws SQLException;

	public void editUser(Students students) throws SQLException;

	public void deleteUser(Students students) throws SQLException;
	
	public Students getUserById(long id) throws SQLException;

	public List<Students> getAllStudents() throws SQLException;

	public List<Students> sortStudents(int page, int name) throws SQLException;
}
