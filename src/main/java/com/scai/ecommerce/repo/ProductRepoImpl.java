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
	public Product findProductByNameLike(String nameLike) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
