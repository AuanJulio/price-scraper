package com.priceCrawler.dto;

import java.math.BigDecimal;

import com.priceCrawler.model.Product;

public record ProductCreateDTO(
		String txName,
		String txUrl,
		String txSite,
		BigDecimal vlPrice
		) {

	public Product toEntity() {
		Product p = new Product();
		p.setTxName(txName);
		p.setTxSite(txSite);
		p.setTxUrl(txUrl);
		p.setVlPrice(vlPrice);
		return p;
	}
}
