package by.ansgar.helper.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.ansgar.helper.dao.GroupDAO;
import by.ansgar.helper.entity.Group;

@Repository
public class GroupDAOImpl implements GroupDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addGroup(Group group) throws SQLException {
		currentSession().save(group);
	}

	public void editGroup(Group group) throws SQLException {
		currentSession().update(group);
	}

	public void deleteGroup(Group group) throws SQLException {
		currentSession().delete(group);
	}

	@SuppressWarnings("unchecked")
	public List<Group> getAllGroup() throws SQLException {
		List<Group> allGroup = new ArrayList<Group>();
		allGroup = currentSession().createQuery("From Group").list();
		return allGroup;
	}
	
	private Session currentSession(){
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession;
	}

}
