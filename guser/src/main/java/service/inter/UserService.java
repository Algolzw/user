package service.inter;

import domain.User;

public interface UserService {
	//---------------------------------------------base operations
	User login(String username,String password);
	User register(String username,String password);
	User register(String username,String password,String email);
	User anonymousLogin();
	void verify(int userId);
	void logout(int userId);
	User getUser(int userId);
	User getUser(String username);
	boolean existUser(String username);



}
