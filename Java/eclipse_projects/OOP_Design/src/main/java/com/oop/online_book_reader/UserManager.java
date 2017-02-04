package com.oop.online_book_reader;

import java.util.HashMap;

public class UserManager {

	HashMap<Integer, User> users;

	public UserManager() {
		users = new HashMap<>();
	}

	public void addUser(User u) {
		users.put(u.getUserId(), u);
	}

	public void removeUser(Integer uId) {
		users.remove(uId);
	}

}
