package com.model;

public class User {
	private Integer 	m_userId;
	private String		m_userName;
	private String 		m_name;
	private String 		m_lastName;
	private String 		m_eMail;
	private String 		m_passWord;
	private Integer 	m_groupId;
	
	public void setUserId(Integer _userId)
	{
		this.m_userId = _userId;
	}
	public void setUserName(String _userName)
	{
		this.m_userName = _userName;
	}
	public void setName(String _name)
	{
		this.m_name = _name;
	}
	public void setLastName(String _lastName)
	{
		this.m_lastName = _lastName;
	}
	public void setEmail(String _eMail)
	{
		this.m_eMail = _eMail;
	}
	public void setPassword(String _password)
	{
		this.m_passWord = _password;
	}
	public void setGroupId(Integer _groupId)
	{
		this.m_groupId = _groupId;
	}
	public Integer getUserId()
	{
		return this.m_userId;
	}
	public String getUserName()
	{
		return this.m_userName;
	}
	public String getName()
	{
		return this.m_name;
	}
	public String getLastName()
	{
		return this.m_lastName;
	}
	public String getEmail()
	{
		return this.m_eMail;
	}
	public String getPassword()
	{
		return this.m_passWord;
	}
	public Integer getGroupId()
	{
		return this.m_groupId;
	}

}
