package com.bookapi.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookapi.spring.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Book book) {
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	@Override
	public Book get(long id) {
		return 	sessionFactory.getCurrentSession().get(Book.class, id);
		
	}

	@Override
	public List<Book> list() 
	{
		List<Book> list = sessionFactory.getCurrentSession().createQuery("from Book").list();
		return list;
	}

	@Override
	public void update(long id, Book book) {
		Session session = sessionFactory.getCurrentSession();
		Book oldBook = session.byId(Book.class).load(id);
		System.out.println("oldBook details : "+oldBook.toString());
		oldBook.setTitle(book.getTitle());
		oldBook.setAuthor(book.getAuthor());
		System.out.println("New Book details : "+oldBook.toString());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session=sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
		session.flush();
	}

}
