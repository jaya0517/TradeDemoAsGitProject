package com.dbInterview.TradeDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbInterview.TradeDemo.model.Trade;
import com.dbInterview.TradeDemo.repository.TradeRepository;


@Service
public class TradeService {

	@Autowired
	TradeRepository tradeRepository;

	public List<Trade> getAllTrades() {
		List<Trade> tradesList = new ArrayList<Trade>();
	//	tradeRepository.findAll().forEach(trade -> tradesList.add(trade));
		tradeRepository.findAll().forEach(tradesList::add);
		return tradesList;
	}

	public Trade addTrade(Trade newTrade) throws Exception {

		List<Trade> allTradesWithId = tradeRepository.findByTradeId(newTrade.getTradeId());
		for (Trade trade : allTradesWithId) {
			if (newTrade.getVersion().compareTo(trade.getVersion()) < 0) {
				throw new Exception("Trade version is lower than existing");
			}
		}
		Trade tradeWithSameTradeAndVersionId = tradeRepository.findByTradeIdAndVersion(newTrade.getTradeId(),
				newTrade.getVersion());
		if (tradeWithSameTradeAndVersionId != null) {
			return updateExistingTrade(newTrade, tradeWithSameTradeAndVersionId);
		} else {
			tradeRepository.save(newTrade);
			return newTrade;
		}

	}

	private Trade updateExistingTrade(Trade newTrade, Trade tradeWithSameTradeAndVersionId) {
		tradeWithSameTradeAndVersionId.setBookId(newTrade.getBookId());
		tradeWithSameTradeAndVersionId.setCounterPartyId(newTrade.getCounterPartyId());
		tradeWithSameTradeAndVersionId.setCreatedDate(newTrade.getCreatedDate());
		tradeWithSameTradeAndVersionId.setMaturityDate(newTrade.getMaturityDate());
		tradeWithSameTradeAndVersionId.setExpired(false);
		tradeRepository.save(tradeWithSameTradeAndVersionId);
		return tradeWithSameTradeAndVersionId;
	}



}
