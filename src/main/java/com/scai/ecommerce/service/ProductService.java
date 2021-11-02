package com.scai.ecommerce.service;

import java.util.List;

import com.scai.ecommerce.dto.ProductDTO;
import com.scai.ecommerce.entity.Product;

public interface ProductService {
	public List<ProductDTO> findProducts();
	
	public List<ProductDTO> findProductsByCategory(String category);
	
	public ProductDTO findProductById(String idProduct);
	
	public List<ProductDTO> findProductByNameLike(String nameLike);
	
	public String saveProduct(Product product);
}
