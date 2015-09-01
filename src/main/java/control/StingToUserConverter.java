package control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.model.User;

public class StingToUserConverter implements Converter <String, User> {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
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
