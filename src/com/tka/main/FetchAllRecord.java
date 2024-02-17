package com.tka.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import com.tka.entity.song;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class FetchAllRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(song.class);
		
		SessionFactory factory=config.buildSessionFactory();
		
		Session session=factory.openSession();
		
		HibernateCriteriaBuilder cb=session.getCriteriaBuilder();
		
		CriteriaQuery <song> cq=cb.createQuery(song.class);
		
		Root<song> root=cq.from(song.class);
		
		cq.select(root);
		
		Query query =session.createQuery(cq);
		List <song> list=query.getResultList();
		
		for(song song:list) {
			System.out.println(song);
			
		}
		
	}

}
