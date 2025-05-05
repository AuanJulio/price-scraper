package com.priceCrawler.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_price_history")
public class PriceHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdPriceHistory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal vlPrice;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtRetrievedAt;
}
