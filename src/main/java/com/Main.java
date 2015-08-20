package com;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.*;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UserDAO userDAO				= context.getBean(UserDAO.class);
		GroupsDAO userGroupDAO 	= context.getBean(GroupsDAO.class);
		//TaskDAO taskDAO 			= context.getBean(TaskDAO.class);
		
		
		List<Groups> list = userGroupDAO.list();
		
		for(Groups p : list){
            System.out.println("Person List::"+p);
        }
        //close resources
        context.close(); 
	}

}
