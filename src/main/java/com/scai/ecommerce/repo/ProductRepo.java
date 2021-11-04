package com.scai.ecommerce.repo;

import java.util.List;

import com.scai.ecommerce.entity.Product;

public interface ProductRepo {
	public List<Product> findProducts();
	
	public List<Product> findProductsByIdProfile(String idProfile);
	
	public List<Product> findProductsByCategory(String category);
	
	public Product findProductById(String idProduct);
	
	public List<Product> findProductByNameLike(String nameLike);
	
	public String saveProduct(Product product);
	
	public boolean shopProducts(List<Product> products);
}
