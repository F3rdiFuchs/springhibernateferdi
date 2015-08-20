package com;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.UserDAO;
public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserDAO userDAP = context.getBean(UserDAO.class);

	}

}
