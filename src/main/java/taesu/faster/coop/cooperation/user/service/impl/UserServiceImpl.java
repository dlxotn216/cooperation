package taesu.faster.coop.cooperation.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taesu.faster.coop.cooperation.user.model.User;
import taesu.faster.coop.cooperation.user.repository.UserRepository;
import taesu.faster.coop.cooperation.user.service.UserService;

import java.util.List;

/**
 * @author Lee Tae Su 
 * @project cooperation
 * @version 1.0
 * @since 2018-02-07
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User getUserByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
	
	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		return userRepository.findByUserIdAndPassword(userId, password);
	}
}
