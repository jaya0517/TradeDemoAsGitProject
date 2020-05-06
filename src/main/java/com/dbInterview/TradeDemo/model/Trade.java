package com.dbInterview.TradeDemo.model;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;

import org.hibernate.annotations.DynamicUpdate;

import com.dbInterview.TradeDemo.utility.BooleanConverter;

@Entity
@DynamicUpdate
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Trade {

	@Id
	@GeneratedValue
	private int id;
	private String tradeId;
	private String version;
	private String counterPartyId;
	private String bookId;
	@Future(message="Dear User Trade Maturity must be a future date")
	private LocalDate maturityDate;
	@SuppressWarnings("unused")
	private LocalDate createdDate;
	@Convert(converter=BooleanConverter.class)
	private Boolean expired;
	

	
	public Trade(int id, String tradeId, String version, String counterPartyId, String bookId,
			LocalDate maturityDate, LocalDate createdDate, Boolean expired) {
		super();
		this.id = id;
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}

	public Trade() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public LocalDate getCreatedDate() {
		return  LocalDate.now();
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = LocalDate.now();
	}

	public Boolean getExpired() {
		return expired;
	}

	public void setExpired(Boolean expired) {
		this.expired = expired;
	}
	
	
	
	
	
	
	
	
}
