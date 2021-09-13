package com.foodstory.Dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



import com.foodstory.Model.Users;

@Repository
public interface UsersDao extends CrudRepository<Users, Integer>{

	@Query(value="select * from users where username = ?1", nativeQuery= true)
	Users findByUsername(String ausername);
	
	@Query(value="select * from users where username = ?1 and password = ?2", nativeQuery= true)
	Users findByUsernameAndPassword(String ausername, String apassword);
	
	@Query(value="select * from users where iduser = (select max(iduser) from user)", nativeQuery= true)
	Users findLastUser();
	
	@Query(value="select * from users where username = ?1 and password = ?2 and profil = 1", nativeQuery= true)
	Users findByAdminByUsernameAndPassword(String ausername, String apassword);
	
	@Transactional
	@Modifying
	@Query(value="update Users set password =?2 where username = ?1", nativeQuery= true)
	boolean changePassword(String aUsername, String aNewPassword);
	
	/*
	@Query("from User u where u.stateconnect = true")
	List<User> findAllConnectedUsers();
	
	
	
	
	*/
}
