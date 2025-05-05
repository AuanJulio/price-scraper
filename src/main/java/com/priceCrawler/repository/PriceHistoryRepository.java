package com.priceCrawler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priceCrawler.model.PriceHistory;

@Repository
public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {

	List<PriceHistory> findByCdPriceHistoryOrderByDtRetrievedAtDesc(Integer cdPriceHistory);
}
