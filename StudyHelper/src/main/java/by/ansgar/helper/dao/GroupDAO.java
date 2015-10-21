package by.ansgar.helper.dao;

import java.sql.SQLException;
import java.util.List;

import by.ansgar.helper.entity.Group;

public interface GroupDAO {
	
	public void addGroup (Group group) throws SQLException;
	
	public void editGroup(Group group) throws SQLException;
	
	public void deleteGroup(Group group) throws SQLException;
	
	public List<Group> getAllGroup () throws SQLException;

}
