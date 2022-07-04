package com.user.services;

import java.util.List;

import org.json.simple.JSONObject;

import com.user.Dto.UpdatePasswordDto;
import com.user.Dto.UpdateUserDetailsDto;
import com.user.model.User;


public interface UserService {
	JSONObject saveUser(User user);

	List<User> getUser();

	JSONObject delateUser(int id);

	JSONObject updateUser(UpdateUserDetailsDto user, int id);

	JSONObject updateUserPassword(UpdatePasswordDto updatePasswordDto, int id);

}
