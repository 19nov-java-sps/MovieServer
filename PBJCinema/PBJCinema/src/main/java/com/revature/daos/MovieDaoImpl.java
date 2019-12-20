package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Movies;

import com.revature.utlities.HibernateUtil;

public class MovieDaoImpl implements MovieDao{
	private static Logger log = Logger.getRootLogger();
	@Override
	public List<Movies> getMovies() {
	
		
			
				List<Movies> movies = null;
				try(Session s = HibernateUtil.getSession()){
					CriteriaBuilder cb = s.getCriteriaBuilder();
					CriteriaQuery<Movies> cq = cb.createQuery(Movies.class);
					
					cq.select(cq.from(Movies.class));
					
					Query<Movies> query = s.createQuery(cq);
					movies = query.list();
					log.info("Getting all Movies");
				}
				return movies;
	}

	@Override
	public boolean addMovie(Movies re) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.save(re);
			tx.commit();
		}
		return true;
	}
	

	@Override
	public boolean deleteMovie(int movieId) {
		int x=0;
		try(Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
	        Query qry = s.createQuery("delete from Movies u where u.movieId=:id");
	        qry.setParameter("id",movieId);
	       x = qry.executeUpdate();
	       tx.commit();
		}
		return x==1;
	}

	@Override
	public Movies getMovieById(int movieId) {
		try(Session s = HibernateUtil.getSession()) {
			String hql = "from Movies where movieid = :id";
			Query<Movies> p = s.createQuery(hql, Movies.class);
			p.setParameter("id", movieId);
			Movies e = p.getSingleResult();
			return e;
		}
	}

}
