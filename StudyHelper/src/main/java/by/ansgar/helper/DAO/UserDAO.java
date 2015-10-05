package by.ansgar.helper.DAO;

import java.sql.SQLException;
import java.util.List;

import by.ansgar.helper.entity.User;

public interface UserDAO {

	public void addUser(User user) throws SQLException;

	public void editUser(User user) throws SQLException;

	public void deleteUser(User user) throws SQLException;
	
	public User getUserById(long id) throws SQLException;

	public List<User> getAllUsers() throws SQLException;

	public List<User> sortUsers(int page, int name) throws SQLException;
}
