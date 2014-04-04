package com.vinod.docsch.dao;

// Generated Nov 29, 2013 12:59:06 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.vinod.docsch.db.entity.TblRole;

/**
 * Home object for domain model class TblRole.
 * @see com.vinod.docsch.db.entity.TblRole
 * @author Hibernate Tools
 */
public class TblRoleHome {

	private static final Log log = LogFactory.getLog(TblRoleHome.class);

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

	public void persist(TblRole transientInstance) {
		log.debug("persisting TblRole instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TblRole instance) {
		log.debug("attaching dirty TblRole instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TblRole instance) {
		log.debug("attaching clean TblRole instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TblRole persistentInstance) {
		log.debug("deleting TblRole instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TblRole merge(TblRole detachedInstance) {
		log.debug("merging TblRole instance");
		try {
			TblRole result = (TblRole) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TblRole findById(java.lang.Integer id) {
		log.debug("getting TblRole instance with id: " + id);
		try {
			TblRole instance = (TblRole) sessionFactory.getCurrentSession()
					.get("com.vinod.docsch.db.TblRole", id);
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

	public List findByExample(TblRole instance) {
		log.debug("finding TblRole instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.vinod.docsch.db.TblRole")
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
