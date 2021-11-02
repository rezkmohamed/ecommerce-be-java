package com.scai.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scai.ecommerce.dto.ProductDTO;
import com.scai.ecommerce.entity.Product;
import com.scai.ecommerce.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	
	

	@Override
	@Transactional
	public List<ProductDTO> findProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<ProductDTO> findProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ProductDTO findProductById(String idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<ProductDTO> findProductByNameLike(String nameLike) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String saveProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
