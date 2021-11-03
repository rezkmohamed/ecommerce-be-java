package com.scai.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scai.ecommerce.dto.ProductDTO;
import com.scai.ecommerce.service.ProductService;
import com.scai.ecommerce.utils.RequestUtils;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private RequestUtils requestUtils;
	
	
	@GetMapping("")
	public ResponseEntity<List<ProductDTO>> getProducts(){
		List<ProductDTO> products = productService.findProducts();
		
		if(products != null) {
			return new ResponseEntity<>(products, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/percategory/{category}")
	public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String category){
		List<ProductDTO> products = productService.findProductsByCategory(category);
		if(products != null) {
			return new ResponseEntity<>(products, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/namelike/{nameLike}")
	public ResponseEntity<List<ProductDTO>> getProductsByNameLike(@PathVariable String nameLike){
		List<ProductDTO> products = productService.findProductByNameLike(nameLike);
		if(products != null) {
			return new ResponseEntity<>(products, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{idProduct}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable String idProduct){
		ProductDTO product = productService.findProductById(idProduct);
		if(product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/new")
	public ResponseEntity<Boolean> addProduct(@RequestBody ProductDTO product, HttpServletRequest request){
		String idProfile = requestUtils.idProfileFromToken(request);
		product.setIdprofile(idProfile);
		if(productService.saveProduct(product) != null) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}
}
