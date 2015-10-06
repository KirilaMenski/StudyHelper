package by.ansgar.helper.DAOImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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

	public void addUserFromFile(String name) throws SQLException {
		InputStream is = null;
		HSSFWorkbook wb = null;

		try {
			is = new FileInputStream(name);
			wb = new HSSFWorkbook(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = wb.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row rowSheet = sheet.getRow(i);
			
			User user = new User();
			System.out.println(rowSheet.getCell(0));
			System.out.println(rowSheet.getCell(1));
			System.out.println(rowSheet.getCell(2));
			System.out.println(rowSheet.getCell(3));
			System.out.println(rowSheet.getCell(4));

			user.setName(rowSheet.getCell(0) + "");
			user.setSurname(rowSheet.getCell(1) + "");
			user.setPassword(rowSheet.getCell(2) + "");
			user.setEmail(rowSheet.getCell(3) + "");
			user.setPhone(rowSheet.getCell(4) + "");

			addUser(user);

		}

	}

	public void editUser(User user) throws SQLException {
		currentSession().update(user);
	}

	public void deleteUser(User user) throws SQLException {
		currentSession().delete(user);
	}

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
