package homework.services;

import java.util.ArrayList;
import java.util.List;

import homework.constants.Messages;
import homework.models.User;

public class UserService {
	
	private List<User> _users = new ArrayList<User>();
	
	public void add(User user) {
		
		if(!this.checkNameLength(user)) {
			System.out.println("\"" + user.name + "\" is " + user.name.length() + " characters but \"name\" cannot exceed 25 characters.");
			return;
		}
		
		this._users.add(user);
		System.out.println(user.name + " " + Messages.Added);
	}
	
	public void add(User[] users) {
		for (User user : users) {
			this.add(user);
		}
	}
	
	public void update(User user) {
		
		if(!this.checkNameLength(user)) {
			System.out.println("\"" + user.name + "\" is " + user.name.length() + " characters but \"name\" cannot exceed 25 characters.");
			return;
		}
		
		int userIndex = this._users.indexOf(user);
		
		this._users.set(userIndex, user);
		System.out.println(user.name + " " + Messages.Updated);
	}
	
	public void delete(User user) {
		
		int userIndex = this._users.indexOf(user);
		
		this._users.remove(userIndex);
		System.out.println(user.name + " " + Messages.Deleted);
	}
	
	public List<User> getAll() {
		return _users;
	}
	
	public User getById(int id) {
		
		return _users.stream().filter(u -> u.id == id).findFirst().get();
	}
	
	private boolean checkNameLength(User user) {
		
		if(user.name.length() > 25) {
			return false;
		}
		
		return true;
	}
}
