package com.revature.daos;
import com.revature.utlities.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.Transaction;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Users;

public class UserDaoImpl implements UserDao{
	private static Logger log = Logger.getRootLogger();
	@Override
	public List<Users> getUsers() {
		
			List<Users> users = null;
			try(Session s = HibernateUtil.getSession()){
				CriteriaBuilder cb = s.getCriteriaBuilder();
				CriteriaQuery<Users> cq = cb.createQuery(Users.class);
				
				cq.select(cq.from(Users.class));
				
				Query<Users> query = s.createQuery(cq);
				users = query.list();
				log.info("Getting all Users");
			}
			return users;
		}
	public boolean createAccount(Users u) {
		
	
			
			try(Session s = HibernateUtil.getSession()){
				Transaction tx = s.beginTransaction();
				s.save(u);
				tx.commit();
			}
			return true;
		}


		public Users getUserById(int userid) {
			
			try(Session s = HibernateUtil.getSession()) {
				String hql = "from Users where userid = :id";
				Query<Users> p = s.createQuery(hql, Users.class);
				p.setParameter("id", userid);
				Users e = p.getSingleResult();
				
				return e;
			}
		}
		
		
		
		@Override
		public int deleteUserById(int userId) {
			int x=0;
			try(Session s = HibernateUtil.getSession()) {
				Transaction tx = s.beginTransaction();
		        Query qry = s.createQuery("delete from Users u where u.userId=:id");
		        qry.setParameter("id",userId);
		       x = qry.executeUpdate();
		       tx.commit();
			}
			return x;
		}
	
		
		@Override
		public boolean updateUser(int userid, String email, String password, String firstName, String lastName) {
			
			try(Session s = HibernateUtil.getSession()){
				Transaction tx = s.beginTransaction();
				Users u = this.getUserById(userid);

				if(email!=null) {
				u.setEmailAddress(email);
				}
				else {
					u.setEmailAddress(u.getEmailAddress());
				}
				if(password!= null && password!=" ") {
				u.setPassword(password);
				}
				else {
					u.setPassword(u.getPassword());
				}
				if(firstName!= null && firstName!= " ") {
					u.setFirstName(firstName);
				}
				else {
					u.setFirstName(u.getFirstName());
				}
				if(lastName!= null && lastName!= " ") {
				u.setLastName(lastName);
				}
				
				else {
					u.setLastName(u.getLastName());
				}
				s.update(u);
				tx.commit();
				
				return true;
			}
	
		}
		@Override
		public Users Login(String email, String password, boolean isBanned) throws SQLException {
		
		try(Session s = HibernateUtil.getSession()){
					String hql = "from Users where emailAddress = :email and pass= :pass and isBanned=false";
					Query<Users> q = s.createQuery(hql,Users.class);
					q.setParameter("email", email);
					q.setParameter("pass", password);
					Users m = q.getSingleResult();
					return m;
					
				}
			}
		}
		
		
	
	
	
	
	


