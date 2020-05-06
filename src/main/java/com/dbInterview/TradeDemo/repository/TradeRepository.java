package com.dbInterview.TradeDemo.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dbInterview.TradeDemo.model.Trade;

public interface TradeRepository extends JpaRepository<Trade, String> {

	
	public List<Trade> findByTradeId(String tradeId);
	
	public Trade findByTradeIdAndVersion(String tradeId, String version);
	
	
	 @Modifying
	 @Transactional
	 @Query("update Trade t set t.expired = true where t.maturityDate < :date") 
	 public void updateExpiredFlag(@Param("date") LocalDate date);
	 
}
