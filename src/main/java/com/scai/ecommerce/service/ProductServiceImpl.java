package com.scai.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scai.ecommerce.dto.ProductDTO;
import com.scai.ecommerce.entity.Product;
import com.scai.ecommerce.entity.Profile;
import com.scai.ecommerce.repo.ProductRepo;
import com.scai.ecommerce.repo.ProfileRepo;
import com.scai.ecommerce.utils.ProductUtils;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ProfileRepo profileRepo;
	

	@Override
	@Transactional
	public List<ProductDTO> findProducts() {
		List<Product> products = productRepo.findProducts();
		
		return ProductUtils.productEntityToDTO(products);
	}

	@Override
	@Transactional
	public List<ProductDTO> findProductsByCategory(String category) {
		List<Product> products = productRepo.findProductsByCategory(category);
		
		return ProductUtils.productEntityToDTO(products);
	}

	@Override
	@Transactional
	public ProductDTO findProductById(String idProduct) {
		Product productToFind = productRepo.findProductById(idProduct);
		
		return ProductUtils.productEntityToDTO(productToFind);
	}

	@Override
	@Transactional
	public List<ProductDTO> findProductByNameLike(String nameLike) {
		List<Product> products = productRepo.findProductByNameLike(nameLike);
		
		return ProductUtils.productEntityToDTO(products);
	}

	@Override
	@Transactional
	public String saveProduct(ProductDTO product) {
		Product productToSave = ProductUtils.productDTOToEntity(product);
		Profile profile = profileRepo.findProfile(product.getIdprofile());
		productToSave.setProfile(profile);
		System.out.println(productToSave);
		
		return productRepo.saveProduct(productToSave);
	}

}
