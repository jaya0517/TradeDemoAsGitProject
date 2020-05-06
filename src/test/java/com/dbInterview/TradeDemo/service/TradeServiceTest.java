package com.dbInterview.TradeDemo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbInterview.TradeDemo.model.Trade;
import com.dbInterview.TradeDemo.repository.TradeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeServiceTest {

	
	@Autowired
	private TradeService tradeService;
	
	@MockBean
	private TradeRepository tradeRepository;
	
	@Test
	public void getAllTradesTest() {
		
		List<Trade> dummyTrades = new ArrayList<Trade>();
		Trade trade1 = new Trade(1, "T1", "V1", "CP1", "B1", LocalDate.now(), LocalDate.now(),
				false);
		dummyTrades.add(trade1);
		
		Mockito.when(tradeRepository.findAll()).thenReturn(dummyTrades);
		
		Assertions.assertEquals(1, tradeService.getAllTrades().size());
	}
	
	
	
	
}
