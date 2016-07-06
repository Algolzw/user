package dao.inter;

public interface UserState {
	
	void initState(int userId);
	void initState(int userId,String password);
	void initState(int userId,String password,String email);
	void approve(int userId);
	void loginUpdate(int userId);
	void logoutUpdate(int userId);

}
