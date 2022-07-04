package com.user.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.Dto.UpdatePasswordDto;
import com.user.Dto.UpdateUserDetailsDto;
import com.user.model.User;
import com.user.services.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	private UserService userService;
	 
	@PostMapping("/saveUser")
	public JSONObject  saveUser(@RequestBody User user)
	{
		JSONObject saveUserResponse = userService.saveUser(user);
		return saveUserResponse;
	}
	@GetMapping("/getUsers")
	public List<User> getUsers()
	{
		
	//	List<User> users = userRepo.findAll();
		return userService.getUser();
		
	}
	
	@DeleteMapping(value="/deleteUser/{id}")
	public JSONObject delateUser(@PathVariable int id)
	{
		JSONObject delateUserResponse = userService.delateUser(id);
		return delateUserResponse;
		
	}
	@PutMapping(value="updateUser/{id}")
	public JSONObject updateUser(@RequestBody UpdateUserDetailsDto user ,@PathVariable int id)
	{
		JSONObject updateUserResponse = userService.updateUser(user, id);
		return updateUserResponse;
	}
		@PutMapping(value="updateUserPassword/{id}")
		public JSONObject updateUserPassword(@RequestBody UpdatePasswordDto updatePasswordDto ,@PathVariable int id)
		{
			JSONObject updateUserPasswordResponse = userService.updateUserPassword(updatePasswordDto, id);
			return updateUserPasswordResponse;
		}
		
	
	}
	


