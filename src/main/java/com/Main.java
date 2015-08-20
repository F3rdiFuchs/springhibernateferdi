package com;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.User;
import com.model.UserDAO;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserDAO userDAP = context.getBean(UserDAO.class);
		
		User u = new User();
		u.setUserName("XBerndY");
		u.setName("Bernd");
		u.setLastName("Gutmann");
		u.seteMail("erefr@web.de");
		u.setPassWord("123456");
		u.setGroupId(25);
		
		userDAP.save(u);
		
        //close resources
        context.close(); 
	}

}
