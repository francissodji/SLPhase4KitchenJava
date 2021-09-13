package com.foodstory.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodstory.Model.Users;
import com.foodstory.Service.UsersService;

 
@RestController
@RequestMapping("/api/user")
public class UsersController {

	@Autowired
	private UsersService userService;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allusers", produces = "application/json")
	public List<Users> getAllUsers () 
	{

		List<Users> allUsers = null;
		try {
			allUsers = userService.loadAllUsers();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allUsers;
	}
	
	//Add User
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> registerUser(@RequestBody Users theUser) {

		userService.addUsers(theUser);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(theUser.getIduser())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	//Register user
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public Users validateUser(@RequestBody Users theUser) throws Exception
	{
		Users aValideUser = null;
		String tempUsername = theUser.getUsername();
		String tempPassWord = theUser.getPassword();
		
		System.out.println("Username = "+tempUsername+" - Password = "+tempPassWord);

			if(tempUsername != null && tempPassWord != null)
			{
				
				aValideUser = userService.validateUserLogin(tempUsername,tempPassWord);
				
				System.out.println("In Controler ==> "+aValideUser.toString());
			}
			
			if(aValideUser == null)
			{
				throw new Exception("In controller ==> Bad credential");
			}
			
			
		return aValideUser;
	}
	
	//Register user
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/lastuser", produces = "application/json")
	public Users getLastUser ()
	{
		Users theLastuser = null;
		
		try {
			theLastuser = userService.loadUserLastUser();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return theLastuser;
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(path = "/updatepassword/{username},{password},{password}", consumes = "application/json", produces = "application/json")
	public boolean UpdateUserPassword(@PathVariable("username") String theUsername, @PathVariable("password") String theOldUsername, @PathVariable("password") String theNewUsername) {

		boolean itisUpdated = false;
		
		try {
			
			itisUpdated = userService.changePassword(theUsername,theOldUsername,theNewUsername);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return itisUpdated;
		

	}
}
