package taesu.faster.coop.cooperation.user.service;

import taesu.faster.coop.cooperation.user.model.User;

import java.util.List;

/**
 * @author Lee Tae Su
 * @version 1.0
 * @project cooperation
 * @since 2018-01-22
 */
public interface UserService {
	
	List<User> getUsers();
	
	User getUserByUserId(String userId);
	
	User getUserByUserIdAndPassword(String userId, String password);
	
}
