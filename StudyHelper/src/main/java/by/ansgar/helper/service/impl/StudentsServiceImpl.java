package by.ansgar.helper.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.ansgar.helper.dao.StudentDAO;
import by.ansgar.helper.entity.Students;
import by.ansgar.helper.service.StudentService;

@Service
public class StudentsServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentsDAO;

	@Transactional
	public void addStudent(Students students) throws SQLException {
		studentsDAO.addStudent(students);
	}
	
	@Transactional
	public void addStudentFromFile(String name) throws SQLException{
		studentsDAO.addStudentFromFile(name);
	}

	@Transactional
	public void editStudent(Students students) throws SQLException {
		studentsDAO.editStudent(students);
	}

	@Transactional
	public void deleteStudent(Students students) throws SQLException {
		studentsDAO.deleteStudent(students);

	}
	
	@Transactional
	public Students getStudentById(long id) throws SQLException {
		return studentsDAO.getStudentById(id);
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
	public List<Students> sortStudents(int numPage, String colName) throws SQLException {
		List<Students> sortStudents = new ArrayList<Students>();
		try{
			sortStudents = studentsDAO.sortStudents(numPage, colName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return sortStudents;
	}

}
