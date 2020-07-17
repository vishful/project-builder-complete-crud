	package dao;

	import java.sql.SQLException;
	import java.util.List;

	import model.Blog;
	import model.User;

public interface UserInterface {
		
		int signUp(User user) throws Throwable, Throwable;
		boolean loginUser(User user);
	}


