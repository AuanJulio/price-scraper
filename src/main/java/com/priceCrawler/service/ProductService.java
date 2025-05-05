package com.priceCrawler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.priceCrawler.model.Product;
import com.priceCrawler.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	public Product getProductById(Integer cdProduct) {
		return productRepository.findById(cdProduct)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Product update(Integer cdProduct, Product product) {
		
		Product productNew = getProductById(cdProduct);
		
		if(product.getTxName() != null) productNew.setTxName(product.getTxName());
		if(product.getTxSite() != null) productNew.setTxSite(product.getTxSite());
		if(product.getTxUrl() != null) productNew.setTxUrl(product.getTxUrl());
		if(product.getVlPrice() != null) productNew.setVlPrice(product.getVlPrice());
		
		return productRepository.save(productNew);
	}
	
	public void delete(Integer cdProduct) {
		productRepository.deleteById(cdProduct);
	}
}
