package by.ansgar.helper.util;

import java.util.ArrayList;
import java.util.List;

import by.ansgar.helper.dao.impl.StudentsDAOImpl;

public class NumbPages {

	@SuppressWarnings("rawtypes")
	public static List countPage(List list) {
		List<Integer> pages = new ArrayList<Integer>();
		for (int i = 0; i < Math.ceil(
				(double) list.size() / (double) StudentsDAOImpl.MAX_RES); i++) {
			pages.add(i + 1);
		}
		return pages;
	}

}
