package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Favorites;
import com.revature.models.Movies;
import com.revature.utlities.HibernateUtil;

public class FavoriteDaoImpl implements FavoriteDao {
	private static Logger log = Logger.getRootLogger();
	
	
	
	@Override
	public List<Favorites> getAllFavorites() {
		
		List<Favorites> movies = null;
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Favorites> cq = cb.createQuery(Favorites.class);
			
			cq.select(cq.from(Favorites.class));
			
			Query<Favorites> query = s.createQuery(cq);
			movies = query.list();
			log.info("Getting all Favorites");
		}
		return movies;
}
	

	@Override
	public List<Favorites> FavoritesById(int userId) {
		List<Favorites> favorites = null;
		try(Session s = HibernateUtil.getSession()) {
			String hql = "from Favorites where userid = :id";
			Query<Favorites> p = s.createQuery(hql, Favorites.class);
			p.setParameter("id", userId);
		
			favorites=p.list();
			
		}
		return favorites;
	}

	@Override
	public boolean deleteFavoriteByName(String name) {
	
		try(Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
	        Query qry = s.createQuery("delete from Favorites u where u.movietitle=:id");
	        qry.setParameter("id",name);
	       qry.executeUpdate();
	       tx.commit();
	       
	       return true;
		}
	}


	@Override
	public boolean addFavorite(Favorites fav) {
		
		
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.save(fav);
			tx.commit();
		}
		return true;
	}

	}


