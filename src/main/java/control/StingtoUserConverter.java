package control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.convert.converter.Converter;

import com.model.User;
 

public class StingtoUserConverter implements Converter <String, User>{
	private SessionFactory sessionFactory;

	public StingtoUserConverter(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public User convert(String userId) {
		User uUser = new User();
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
			
		uUser = (User)session.get(User.class, Integer.parseInt(userId));
	
		return uUser;
	}

}
