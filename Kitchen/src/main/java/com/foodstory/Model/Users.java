package com.foodstory.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer iduser;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "profil")
	private int profil;
	
	@Column(name = "stateconnect")
	private boolean stateconnect;
	
	public Users() {}

	public Users(String firstname, String lastname, String userName, String password, int profil,
			boolean stateconnect) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.profil = profil;
		this.stateconnect = stateconnect;
	}

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getProfil() {
		return profil;
	}

	public void setProfil(int profil) {
		this.profil = profil;
	}

	public boolean isStateconnect() {
		return stateconnect;
	}

	public void setStateconnect(boolean stateconnect) {
		this.stateconnect = stateconnect;
	}

	@Override
	public String toString() {
		return "Users [iduser=" + iduser + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + ", profil=" + profil + ", stateconnect=" + stateconnect + "]";
	}
	

}
