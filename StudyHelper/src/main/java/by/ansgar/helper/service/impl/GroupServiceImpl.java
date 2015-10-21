package by.ansgar.helper.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.ansgar.helper.dao.GroupDAO;
import by.ansgar.helper.entity.Group;
import by.ansgar.helper.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDAO groupDAO;

	@Transactional
	public void addGroup(Group group) throws SQLException {
		groupDAO.addGroup(group);
	}

	@Transactional
	public void editGroup(Group group) throws SQLException {
		groupDAO.editGroup(group);
	}

	@Transactional
	public void deleteGroup(Group group) throws SQLException {
		groupDAO.deleteGroup(group);
	}

	@Transactional
	public List<Group> getAllGroup() throws SQLException {
		List<Group> allGroup = groupDAO.getAllGroup();
		return allGroup;
	}

}
