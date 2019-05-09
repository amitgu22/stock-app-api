package com.money.market.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "Stock")
@ApiModel(description="All details about the Stock. ")
public class Stock {

	@ApiModelProperty(notes = "The database generated stock ID")
	private long id;

	@ApiModelProperty(notes = "The stock name")
	private String stockName;

	@ApiModelProperty(notes = "The stock price")
	private Double stockPrice;

	@ApiModelProperty(notes = "The timestamp of stock")
	private Timestamp timeStamp;

	public Stock() {

	}

	public Stock(String stockName, Double stockPrice, Timestamp timeStamp) {
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.timeStamp = timeStamp;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "stock_name", nullable = false)
	public String getstockName() {
		return stockName;
	}

	public void setstockName(String stockName) {
		this.stockName = stockName;
	}

	@Column(name = "stock_price", nullable = false)
	public Double getstockPrice() {
		return stockPrice;
	}

	public void setstockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	@Column(name = "timestamp", nullable = false)
	public Timestamp gettimeStamp() {
		return timeStamp;
	}

	public void settimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", stockName=" + stockName + ", stockPrice=" + stockPrice + ", timeStamp=" + timeStamp
				+ "]";
	}

}
