package dao;

import domain.UserProfile;

public interface UserProfileDAO {

	public void insertUser(UserProfile userProfile);
	public UserProfile selectUser(String userid);
	
}
