package com.scai.ecommerce.repo;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scai.ecommerce.entity.Profile;


@Repository
public class ProfileRepoImpl implements ProfileRepo {
	@Autowired
	private EntityManager entityManager;

	@Override
	public Profile findProfile(String idProfile) {
		Session session = entityManager.unwrap(Session.class);
		Query<Profile> query = session.createQuery("from Profile where id_profile = :idProfile");
		query.setParameter("idProfile", idProfile);
		try {
			Profile profile = query.getSingleResult();
			return profile;
		} catch (Exception e) {
			// TODO: nothing to do
		}
		
		return null;
	}

	@Override
	public Profile findProfileByEmailAndPassword(String email, String password) {
		Session session = entityManager.unwrap(Session.class);
		Query<Profile> query = session.createQuery("from Profile where email = :emailPar AND password = :passwordPar");
		query.setParameter("emailPar", email);
		query.setParameter("passwordPar", password);
		try {
			Profile profile = query.getSingleResult();
			return profile;
		} catch (Exception e) {
			// TODO: nothing to do
		}
		
		return null;
	}

	@Override
	public Profile findProfileByEmail(String email) {
		Session session = entityManager.unwrap(Session.class);
		Query<Profile> query = session.createQuery("from Profile where email = :emailPar");
		query.setParameter("emailPar", email);
		try {
			Profile profile = query.getSingleResult();
			return profile;
		} catch (Exception e) {
			// TODO: nothing to do
		}
		
		return null;
	}

	@Override
	public String saveProfile(Profile profile) {
		Session session = entityManager.unwrap(Session.class);
		String id = (String)session.save(profile);
		
		return id;
	}

}
