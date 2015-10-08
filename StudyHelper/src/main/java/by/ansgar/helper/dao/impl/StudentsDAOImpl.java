package by.ansgar.helper.dao.impl;

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

import by.ansgar.helper.dao.StudentDAO;
import by.ansgar.helper.entity.Students;

@Repository
public class StudentsDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public static final int MAX_RES = 10;

	public void addStudent(Students students) throws SQLException {
		currentSession().save(students);
	}

	public void addStudentFromFile(String name) throws SQLException {
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

			Students students = new Students();
			System.out.println(rowSheet.getCell(0));
			System.out.println(rowSheet.getCell(1));
			System.out.println(rowSheet.getCell(2));
			System.out.println(rowSheet.getCell(3));
			System.out.println(rowSheet.getCell(4));

			students.setName(rowSheet.getCell(0) + "");
			students.setSurname(rowSheet.getCell(1) + "");
			students.setPassword(rowSheet.getCell(2) + "");
			students.setEmail(rowSheet.getCell(3) + "");
			students.setPhone(rowSheet.getCell(4) + "");
			students.setGroup(rowSheet.getCell(5) + "");

			addStudent(students);

		}

	}

	public void editStudent(Students students) throws SQLException {
		currentSession().update(students);
	}

	public void deleteStudent(Students students) throws SQLException {
		currentSession().delete(students);
	}

	public Students getStudentById(long id) throws SQLException {
		Students studentById = null;
		try {
			studentById = (Students) currentSession().get(Students.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentById;
	}

	@SuppressWarnings("unchecked")
	public List<Students> getAllStudents() throws SQLException {
		List<Students> allStudents = new ArrayList<Students>();
		allStudents = currentSession().createQuery("FROM Students").list();
		return allStudents;
	}

	@SuppressWarnings("unchecked")
	public List<Students> sortStudents(int numPage, String colName)
			throws SQLException {
		List<Students> sortStudents = new ArrayList<Students>();
		sortStudents = currentSession()
				.createQuery("From Students stud ORDER BY stud." + colName)
				.setFirstResult(numPage * MAX_RES - MAX_RES)
				.setMaxResults(MAX_RES).list();
		return sortStudents;
	}

	private Session currentSession() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession;
	}

}
