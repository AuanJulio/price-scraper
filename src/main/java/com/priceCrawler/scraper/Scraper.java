package com.priceCrawler.scraper;

import java.math.BigDecimal;
import java.util.Optional;

public interface Scraper {
	Optional<BigDecimal> scrapePrice(String url);
}
