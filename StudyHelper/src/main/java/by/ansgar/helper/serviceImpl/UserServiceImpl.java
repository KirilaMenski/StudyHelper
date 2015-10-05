package by.ansgar.helper.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.ansgar.helper.DAO.UserDAO;
import by.ansgar.helper.entity.User;
import by.ansgar.helper.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void addUser(User user) throws SQLException {
		userDAO.addUser(user);
	}

	@Transactional
	public void editUser(User user) throws SQLException {
		userDAO.editUser(user);
	}

	@Transactional
	public void deleteUser(User user) throws SQLException {
		userDAO.deleteUser(user);

	}

	public User getUserById(long id) throws SQLException {
		return userDAO.getUserById(id);
	}

	@Transactional
	public List<User> getAllUsers() throws SQLException {
		List<User> allUsers = new ArrayList<User>();
		try {
			allUsers = userDAO.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allUsers;
	}

	@Transactional
	public List<User> sortUsers(int page, int name) throws SQLException {
		// TODO
		return null;
	}

}
