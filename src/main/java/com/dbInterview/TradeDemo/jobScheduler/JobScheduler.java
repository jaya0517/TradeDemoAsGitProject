package com.dbInterview.TradeDemo.jobScheduler;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dbInterview.TradeDemo.repository.TradeRepository;

@Component
public class JobScheduler {
	
	@Autowired
	TradeRepository tradeRepo;
	
	@Scheduled(fixedRate = 180000)
	public void expireTradeOnMaturityDate() {
	
		System.out.println("Running job");
		tradeRepo.updateExpiredFlag(LocalDate.now());
		
	}
}
