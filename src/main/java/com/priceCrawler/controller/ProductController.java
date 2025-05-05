package com.priceCrawler.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priceCrawler.dto.ProductCreateDTO;
import com.priceCrawler.dto.ProductDTO;
import com.priceCrawler.model.Product;
import com.priceCrawler.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@GetMapping
	public List<ProductDTO> getAll(){
		return productService.getAll().stream().map(ProductDTO::fromEntity).toList();
	}
	
	@GetMapping(value = "/{cdProduct}")
	public ProductDTO findById(@PathVariable Integer cdProduct) {
		return ProductDTO.fromEntity(productService.getProductById(cdProduct));
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> save(@RequestBody ProductCreateDTO dto) {
		Product product = productService.save(dto.toEntity());
		return new ResponseEntity<ProductDTO>(ProductDTO.fromEntity(product), HttpStatus.CREATED);
	}
	
	@PutMapping("/{cdProduct}")
	public ProductDTO update(@PathVariable Integer cdProduct, @RequestBody ProductCreateDTO dto) {
		Product product = productService.update(cdProduct, dto.toEntity());
		return ProductDTO.fromEntity(product);
	}
	
	@DeleteMapping("/{cdProduct}")
	public ResponseEntity<Void> delete(@PathVariable Integer cdProduct) {
		productService.delete(cdProduct);
		return ResponseEntity.noContent().build();
	}
}
