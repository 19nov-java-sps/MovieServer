package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Movies;
import com.revature.models.Reviews;
import com.revature.models.Users;
import com.revature.utlities.HibernateUtil;

public class ReviewDaoImpl implements ReviewDao {
	
	private static Logger log = Logger.getRootLogger();

	public List<Reviews> getReviews(){
	

	
	List<Reviews> reviews = null;
	
			
		try(Session s = HibernateUtil.getSession()){
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Reviews> cq = cb.createQuery(Reviews.class);
		
		cq.select(cq.from(Reviews.class));
		
		Query<Reviews> query = s.createQuery(cq);
		reviews = query.list();
		log.info("Getting all Reviews");
	}
	return reviews;
	
	}

	@Override
	public boolean createReview(Reviews re) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.save(re);
			tx.commit();
		}
		return true;
	}
	

	@Override
	public boolean deleteReviewById(int reId) {
		int x=0;
		try(Session s = HibernateUtil.getSession()) {
			Transaction tx = s.beginTransaction();
	        Query qry = s.createQuery("delete from Reviews u where u.reviewId=:id");
	        qry.setParameter("id",reId);
	       x = qry.executeUpdate();
	       tx.commit();
		}
		return x==1;
	}

	@Override
	public Reviews getReviewsById(int reId) {
		try(Session s = HibernateUtil.getSession()) {
			String hql = "from Reviews where reviewId = :id";
			Query<Reviews> p = s.createQuery(hql, Reviews.class);
			p.setParameter("id",reId);
			Reviews e = p.getSingleResult();
			return e;
		}
	}

	@Override
	public boolean editReview(int reId, String postTitle, String postBody) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			Reviews u = this.getReviewsById(reId);
//			Employee e = new Employee();
			u.setPostTitle(postTitle);
			u.setPostBody(postBody);
			s.update(u);
			tx.commit();
			
			return true;
		}
	}
	

}
