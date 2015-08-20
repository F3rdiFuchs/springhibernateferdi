package com;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.User;
import com.model.UserDAO;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserDAO userDAP = context.getBean(UserDAO.class);
		
		List<User> list = userDAP.list();
		
		for(User p : list){
            System.out.println("Person List::"+p);
        }
        //close resources
        context.close(); 
	}

}
