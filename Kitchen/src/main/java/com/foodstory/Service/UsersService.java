package com.foodstory.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodstory.Dao.UsersDao;
import com.foodstory.General.CryptPassword;
import com.foodstory.Model.Users;

@Service
public class UsersService {

	@Autowired
	private UsersDao usersDao;
	
	//register
	public boolean addUsers(Users users)
	{
		boolean isadd = false;
		CryptPassword passwordCrypter = new CryptPassword();
		
		String aCryptedPw = passwordCrypter.CryptPasswordSHA3256(users.getPassword());
		
		users.setPassword(aCryptedPw);
		
		if(usersDao.save(users) != null)
		{
			isadd = true;
		}
		return isadd;
	}
	
	
	//load all user
	public List<Users> loadAllUsers()
	{
		List<Users> allUsers = null;
		
		
		allUsers = (List<Users>)usersDao.findAll();
		
		return allUsers;
	}
	
	
	//load by username
	public Users loadUserByUserNameAndPassword(String theUserName, String thePassword)
	{
		Users aUser = null;
		
		if(theUserName != null && thePassword != null) {
			aUser = usersDao.findByUsernameAndPassword(theUserName,thePassword);
		}
		
		return aUser;
	}
	
	
	//load last user
	public Users loadUserLastUser()
	{
		Users aUser = null;
		
		aUser = usersDao.findLastUser();
		
		return aUser;
	}
	
	
	//validate user login
	public Users validateUserLogin(String theUserName, String theUserPw) throws Exception
	{

		Users connectedUser = null;
		
		CryptPassword passwordCrypter = new CryptPassword();
		
		String aCryptedPw = passwordCrypter.CryptPasswordSHA3256(theUserPw); //crypt the entered password
		
		try
		{
			connectedUser = loadUserByUserNameAndPassword(theUserName,aCryptedPw);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
			
		return connectedUser;
	}
	
	//validate user login
	public Users validateAdminUserLogin(String theUserName, String theUserPw) throws Exception
	{

		Users connectedUser = null;
		
		CryptPassword passwordCrypter = new CryptPassword();
		
		String aCryptedPw = passwordCrypter.CryptPasswordSHA3256(theUserPw); //crypt the entered password
		
		try
		{
			connectedUser = loadUserByUserNameAndPassword(theUserName,aCryptedPw);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
			
		return connectedUser;
	}
	
	
	//change password
	public boolean changePassword(String theUsername, String theOldPassword, String theNewPassword)
	{
		Users connectedUser = null;
		boolean isDone = false;
		
		CryptPassword passwordCrypter = new CryptPassword();
		
		try
		{
			String aCryptedOldPw = passwordCrypter.CryptPasswordSHA3256(theOldPassword); //crypt the entered password
			
			connectedUser = loadUserByUserNameAndPassword(theUsername,aCryptedOldPw);
			
			if(connectedUser != null)
			{
				String currentUser = connectedUser.getUsername();
				String aCryptedNewPw = passwordCrypter.CryptPasswordSHA3256(theNewPassword);
				
				isDone = UpdatePassword(currentUser, aCryptedNewPw);
			}
			else
				isDone = false;
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return isDone;
	}
	
	
	//update password
	private boolean UpdatePassword(String theUsername, String theNewpassword)
	{
		boolean itChanged = false;
		
		itChanged = usersDao.changePassword(theUsername, theNewpassword);
				
		return itChanged;
	}
}
