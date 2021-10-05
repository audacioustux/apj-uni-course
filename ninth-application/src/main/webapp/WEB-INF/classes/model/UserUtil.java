package model;

import java.util.*;

public class UserUtil {

	private static List<User> users = new ArrayList<>();

	public void insert(String loginId, String password) {
		int newId = users.size() + 1;
		User user = new User(newId, loginId, password);
		users.add(user);
	}

	public List<User> getAllUsers() {
		return users;
	}

	public boolean isValidUser(String loginId, String password) {
		for(User user: users) {
			if (loginId.equals(user.getLoginId()) && password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
