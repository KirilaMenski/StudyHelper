package by.ansgar.helper.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.ansgar.helper.DAO.StudentDAO;
import by.ansgar.helper.entity.Students;
import by.ansgar.helper.service.StudentService;

@Service
public class StudentsServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentsDAO;

	@Transactional
	public void addUser(Students students) throws SQLException {
		studentsDAO.addUser(students);
	}
	
	@Transactional
	public void addUserFromFile(String name) throws SQLException{
		studentsDAO.addUserFromFile(name);
	}

	@Transactional
	public void editUser(Students students) throws SQLException {
		studentsDAO.editUser(students);
	}

	@Transactional
	public void deleteUser(Students students) throws SQLException {
		studentsDAO.deleteUser(students);

	}

	public Students getUserById(long id) throws SQLException {
		return studentsDAO.getUserById(id);
	}

	@Transactional
	public List<Students> getAllStudents() throws SQLException {
		List<Students> allStudents = new ArrayList<Students>();
		try {
			allStudents = studentsDAO.getAllStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allStudents;
	}

	@Transactional
	public List<Students> sortStudents(int page, int name) throws SQLException {
		// TODO
		return null;
	}

}
