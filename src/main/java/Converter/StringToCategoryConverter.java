package Converter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.model.Category.Category;


public class StringToCategoryConverter implements Converter <String, Category> {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Category convert(String categoryId) {
		Category category = new Category();
		List <Category>categoryList = new ArrayList<Category>();
		
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		
		categoryList= session.createQuery("FROM Category").list();
		
		for(Category tCategory : categoryList)
		{
			if(tCategory.getCategoryId().toString().equals(categoryId))
			{
				category = tCategory;
				session.getTransaction().commit();
				session.close();
				return category;
			}
		}
		return null;
	}

}
