package com.vinod.docsch.dao;

// Generated Nov 29, 2013 12:59:06 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.vinod.docsch.db.entity.TblUser;

/**
 * Home object for domain model class TblUser.
 * @see com.vinod.docsch.db.entity.TblUser
 * @author Hibernate Tools
 */
public class TblUserHome {

	private static final Log log = LogFactory.getLog(TblUserHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TblUser transientInstance) {
		log.debug("persisting TblUser instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TblUser instance) {
		log.debug("attaching dirty TblUser instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TblUser instance) {
		log.debug("attaching clean TblUser instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TblUser persistentInstance) {
		log.debug("deleting TblUser instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TblUser merge(TblUser detachedInstance) {
		log.debug("merging TblUser instance");
		try {
			TblUser result = (TblUser) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblUser findById(java.lang.Long id) {
		log.debug("getting TblUser instance with id: " + id);
		try {
			TblUser instance = (TblUser) sessionFactory.getCurrentSession()
					.get("com.vinod.docsch.db.TblUser", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TblUser instance) {
		log.debug("finding TblUser instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.vinod.docsch.db.TblUser")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
