package by.ansgar.helper.DAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.ansgar.helper.DAO.UserDAO;
import by.ansgar.helper.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) throws SQLException {
		currentSession().save(user);
	}

	public void editUser(User user) throws SQLException {
		currentSession().update(user);
	}

	public void deleteUser(User user) throws SQLException {
		currentSession().delete(user);
	}

	@Override
	public User getUserById(long id) throws SQLException {
		User userById = null;
		try {
			userById = (User) currentSession().get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userById;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() throws SQLException {
		List<User> allUsers = new ArrayList<User>();
		allUsers = currentSession().createQuery("FROM User").list();
		return allUsers;
	}

	public List<User> sortUsers(int page, int name) throws SQLException {
		// TODO
		return null;
	}

	private Session currentSession() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession;
	}

}
