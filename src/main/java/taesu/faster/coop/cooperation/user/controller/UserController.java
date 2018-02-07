package taesu.faster.coop.cooperation.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import taesu.faster.coop.cooperation.user.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lee Tae Su 
 * @project cooperation
 * @version 1.0
 * @since 2018-02-07
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Map<String, Object> getUsers(){
		Map<String, Object> result= new HashMap<>();
		result.put("result", userService.getUsers());
		
		return result;
	}
	
	@GetMapping("/users/{userId}")
	public Map<String, Object> getUserByUserId(@PathVariable("userId") String userId){
		Map<String, Object> result= new HashMap<>();
		result.put("result", userService.getUserByUserId(userId));
		
		return result;
	}
	
	@GetMapping("/users/{userId}/password/{password}")
	public Map<String, Object> getUserByUserId(@PathVariable("userId") String userId,
											   @PathVariable("password") String password){
		Map<String, Object> result= new HashMap<>();
		result.put("result", userService.getUserByUserIdAndPassword(userId, password));
		
		return result;
	}
}
