package com.priceCrawler.dto;

import java.math.BigDecimal;

import com.priceCrawler.model.Product;

public record ProductDTO(
		Integer cdProduct,
		String txName,
		String txUrl,
		String txSite,
		BigDecimal vlPrice
		) {

	public static ProductDTO fromEntity(Product entity) {
		return new ProductDTO(
				entity.getCdProduct(), 
				entity.getTxName(),
				entity.getTxUrl(),
				entity.getTxSite(),
				entity.getVlPrice()
			);
	}
}
