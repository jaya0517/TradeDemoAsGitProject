package com.dbInterview.TradeDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbInterview.TradeDemo.model.Trade;
import com.dbInterview.TradeDemo.service.TradeService;

/**
 * @author jaya
 *
 */

@RestController
@RequestMapping("/tradeStore")
public class TradeStoreController {

	@Autowired
	TradeService tradeService;

	@RequestMapping("/health")
	public String healthCheck() {
		return "Welcome to Trade Store App";
	}
	
	@GetMapping("/trades")
	public ResponseEntity<List<Trade>> getAllTrades() {
		List<Trade> allTrades = new ArrayList<Trade>();
		allTrades = tradeService.getAllTrades();
		return new ResponseEntity<List<Trade>>(allTrades, HttpStatus.OK);
	}

	@PostMapping("/trade")
	public ResponseEntity<Trade> addTrade(@Valid @RequestBody Trade trade) throws Exception {
		Trade tradeSaved = tradeService.addTrade(trade);
		return new ResponseEntity<Trade>(tradeSaved, HttpStatus.OK);
	}
}
