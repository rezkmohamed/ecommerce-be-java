package com.scai.ecommerce.utils;

import java.util.ArrayList;
import java.util.List;

import com.scai.ecommerce.dto.ProductDTO;
import com.scai.ecommerce.entity.Product;

public class ProductUtils {
	public ProductDTO productEntityToDTO(Product product) {
		ProductDTO productDTO = new ProductDTO(product.getIdProduct(), product.getName(), 
											   product.getCategory(), product.getImg(), product.getPrice());
		
		return productDTO;
	}
	
	public List<ProductDTO> productEntityToDTO(List<Product> products) {
		List<ProductDTO> ris = new ArrayList<>();
		
		for(Product p : products) {
			ris.add(productEntityToDTO(p));
		}
		
		return ris;
	}
} 
