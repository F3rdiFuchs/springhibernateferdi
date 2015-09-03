package com.model.User;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.model.Groups.Groups;
import com.model.Message.Message;
import com.model.Tasks.Tasks;

@Entity
@Table(name="USER")
public class User {
	private static final int PASSWORD_SECURITY = 2;
	
	@Id
    @GeneratedValue
    @Column(name="userId")
	private Integer userId;
	
	@NotNull
	@Size(min=5, max=15, message="Must be between 5 and 15 letters")
	@Column(name="userName")
	private String userName;
	
	@Size(max=15, message="max 15 chars")
	@Column(name="name")
	private String name;
	
	@Size(max=15,message="max 15 chars")
	@Column(name="lastName")
	private String lastName;
	
	@NotEmpty(message = "Please enter your email addresss.")
	@Size(max=45)
	@Email
	@Column(name="eMail")
	private String eMail;

	@NotEmpty(message = "Please enter your password")
	@Size(max=150)
	@Column(name="passWord")
	private String passWord;
	
	@ManyToOne
	@JoinColumn(name="groupId")
	private Groups groups;
	
	@ManyToMany(mappedBy = "user")
	private List<Tasks> tasks;
	
	
	@OneToMany(mappedBy = "fromUser")
	private List<Message> messageFrom;
	
	@OneToMany(mappedBy = "toUser", cascade=CascadeType.REMOVE) //delete user -> delet all his messages
	private List<Message> messageTo;
		
	
	public Groups getGroups() {
		return groups;
	}


	public void setGroups(Groups groups) {
		this.groups = groups;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public List<Message> getMessageFrom() {
		return messageFrom;
	}


	public void setMessageFrom(List<Message> messageFrom) {
		this.messageFrom = messageFrom;
	}


	public List<Message> getMessageTo() {
		return messageTo;
	}


	public void setMessageTo(List<Message> messageTo) {
		this.messageTo = messageTo;
	}

	public void encryptPasswd() {
		int count = 0;
		while(count < PASSWORD_SECURITY)
		{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			this.passWord = passwordEncoder.encode(this.passWord);
			count++;
		}
	}
	
	@Override
	public String toString()
	{
		return this.userName;
	}
	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}
}
