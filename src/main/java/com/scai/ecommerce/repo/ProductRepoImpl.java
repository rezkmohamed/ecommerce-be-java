package com.scai.ecommerce.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scai.ecommerce.entity.Product;


@Repository
public class ProductRepoImpl implements ProductRepo {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Product> findProducts() {
		Session session = entityManager.unwrap(Session.class);
		Query<Product> query = session.createQuery("from Product");
		List<Product> products = query.getResultList();
		
		return products;
	}
	
	@Override
	public List<Product> findProductsByIdProfile(String idProfile) {
		Session session = entityManager.unwrap(Session.class);	
		Query<Product> query = session.createQuery("from Product where id_profile = :idProfile");
		query.setParameter("idProfile", idProfile);
		List<Product> products = query.getResultList();
		
		return products;
	}

	@Override
	public List<Product> findProductsByCategory(String category) {
		Session session = entityManager.unwrap(Session.class);
		Query<Product> query = session.createQuery("from Product where category = :categoryPar");
		query.setParameter("categoryPar", category);
		List<Product> products = query.getResultList();
		
		return products;
	}

	@Override
	public Product findProductById(String idProduct) {
		Session session = entityManager.unwrap(Session.class);
		Query<Product> query = session.createQuery("from Product where id_product = :idProduct");
		query.setParameter("idProduct", idProduct);
		try {
			Product product = query.getSingleResult();
			return product;
		} catch (Exception e) {
			// TODO: nothing to do
		}
		
		return null;
	}

	@Override
	public List<Product> findProductByNameLike(String nameLike) {
		Session session = entityManager.unwrap(Session.class);	
		Query<Product> query = session.createQuery("from Product where name LIKE :nameLike");
		query.setParameter("nameLike", "%"+nameLike+"%");
		List<Product> products = query.getResultList();
		System.out.println("products___" + products);
		
		return products;
	}

	@Override
	public String saveProduct(Product product) {
		Session session = entityManager.unwrap(Session.class);	
		String id = (String)session.save(product);
		
		return id;
	}
}
