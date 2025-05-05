package com.priceCrawler.scraper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class AmazonScraper implements Scraper {

	@Override
	public Optional<BigDecimal> scrapePrice(String url) {
		
		try {
			Document doc = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
					.timeout(10000)
					.get();
			
			Element titleElement = doc.selectFirst("#productTitle");
			String productName = titleElement != null ? titleElement.text() : "Product not found";
			
			Element priceElement = doc.selectFirst(".a-price .a-offscreen");
			
			if(priceElement != null) {
				String priceText = priceElement.text().replaceAll("[^\\d,\\.]", "");
				return Optional.of(new BigDecimal(priceText));
			}
		} catch (Exception e) {
			System.err.println("Error scraping Amazon: " + e.getMessage());
		}
		return Optional.empty();
	}

}
