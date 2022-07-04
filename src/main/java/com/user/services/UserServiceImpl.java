package com.user.services;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Dto.UpdatePasswordDto;
import com.user.Dto.UpdateUserDetailsDto;
import com.user.Repositories.UserRepository;
import com.user.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	public JSONObject userResponse(String status,String message, String accessToken)
	{

   	 JSONObject obj=new JSONObject();
   	 obj.put("ststus",status);
   	 obj.put("message",message);
   	 obj.put("accessToken",accessToken);
   	 return obj;
	}

	@Override
	public JSONObject saveUser(User user) {
		User save = userRepo.save(user);
		UserServiceImpl userServ=new UserServiceImpl();
		if(save!=null)
		{
			return userServ.userResponse("ok","Registration was succesfull" , "eyJhbGciOiJIUzI1NiIsInR5a...");
	    	 
		}
		else
		{
			return userServ.userResponse("Not ok","Registration was failed" , "eyJhbGciOiJIUzI1NiIsInR5b...");
	    	 
		}
	}

	@Override
	public List<User> getUser() {
		
		return userRepo.findAll();
			
	}

	@Override
	public JSONObject delateUser(int id) {
		UserServiceImpl userServ=new UserServiceImpl();
		userRepo.deleteById(id);
		return userServ.userResponse("ok","User record getting deleted" , "eyJhbGciOiJIUzI1NiIsInR5g...");
  	    
		
	}

	@Override
	public JSONObject updateUser(UpdateUserDetailsDto user, int id) {
		Optional<User> findById = userRepo.findById(id);
		User user1 = findById.get();
		UserServiceImpl userServ=new UserServiceImpl();
		
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String email = user.getEmail();
	    user1.setFirstName(firstName);
		user1.setLastName(lastName);
		user1.setEmail(email);
		User saveUser = userRepo.save(user1);
		if(saveUser!=null)
		{
			return userServ.userResponse("ok","User Details are Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dCh...");
	    	 
		}
		else
		{
			JSONObject response = userServ.userResponse("Not ok","User Details are Not Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC2i...");
	    	  return response;
		}
		
	}

	@Override
	public JSONObject updateUserPassword(UpdatePasswordDto updatePasswordDto, int id) {
		String newPassword = updatePasswordDto.getNewPassword();
		String confirmNewPassword = updatePasswordDto.getConfirmNewPassword();
		Optional<User> findById = userRepo.findById(id);
		User user = findById.get();
		UserServiceImpl userServ=new UserServiceImpl();
		if(user.getPassword().equals(updatePasswordDto.getOldPassword()))
	     {

			if(newPassword.equals(confirmNewPassword))
			{
			if(newPassword.equals(updatePasswordDto.getOldPassword()))
			{
				return userServ.userResponse("Not ok","old passwoprd and new password both are same please enter different new password" , "eyJhbGciOiJIUzI1NiIsInR5dCj...");
		    	 
			}
			else {
				user.setPassword(newPassword);
				User save = userRepo.save(user);
				if(save!=null)
				{
					return userServ.userResponse("ok","Password getting updated" , "eyJhbGciOiJIUzI1NiIsInR5k...");
			    	  
				}
				else
				{
					return userServ.userResponse("Not ok","Password not getting updated" , "eyJhbGciOiJIUzI1NiIsInR5l...");
			    	  
				}
			 }
	     }
			else
			{
				return userServ.userResponse("Not ok","New apssword and conformed password both are not match" , "eyJhbGciOiJIUzI1NiIsInR5m...");
		    	  	
			}
	     }
	     
	     else
	     {
	    	  return userServ.userResponse("Not ok"," Old passsword was in correct Please enter valid old password " , "eyJhbGciOiJIUzI1NiIsInR5cCn...");
	    	 
	     }
	}

}
