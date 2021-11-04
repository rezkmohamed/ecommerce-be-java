package com.scai.ecommerce.service;

import java.util.List;

import com.scai.ecommerce.dto.ProductDTO;

public interface ProductService {
	public List<ProductDTO> findProducts();
	
	public List<ProductDTO> findProductsByIdProfile(String idProfile);
	
	public List<ProductDTO> findProductsByCategory(String category);
	
	public ProductDTO findProductById(String idProduct);
	
	public List<ProductDTO> findProductByNameLike(String nameLike);
	
	public String saveProduct(ProductDTO product);
	
	public boolean shopProducts(List<ProductDTO> products, String idProfileShopper);
}
