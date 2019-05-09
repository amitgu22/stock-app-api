package com.money.market.controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.money.market.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.money.market.exception.ResourceNotFoundException;
import com.money.market.repository.StockExchangeRepository;

@RestController
@RequestMapping("/stock/api/")
@Api(value="Stock System", description="Stock list , modify stock details")
public class StockExchangeController {
	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	@ApiOperation(value = "View a list of available stock", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/stockList")
	public List<Stock> getAllStocks() {
		return stockExchangeRepository.findAll();
	}

	@ApiOperation(value = "Get stock by Id")
	@GetMapping("/stock/{id}")
	public ResponseEntity<Stock> getStockById(
			@ApiParam(value = "Stock id from which stock object will retrieve", required = true)
			@PathVariable(value = "id") Long stockId)
			throws ResourceNotFoundException {
		Stock stock = stockExchangeRepository.findById(stockId)
				.orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + stockId));
		return ResponseEntity.ok().body(stock);
	}

	@ApiOperation(value = "Add a stock")
	@PostMapping("/stock")
	public Stock createEmployee(
			@ApiParam(value = "Stock object store in database table", required = true)
			@Valid @RequestBody Stock stock) {
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		stock.settimeStamp(timestamp);
		return stockExchangeRepository.save(stock);
	}

	@ApiOperation(value = "Update the stock")
	@PutMapping("/stock/{id}")
	public ResponseEntity<Stock> updateEmployee(
			@ApiParam(value = "Stock Id to update stock object", required = true)
			@PathVariable(value = "id") Long stockId,
			@ApiParam(value = "Update stock object", required = true)
			@Valid @RequestBody Stock stockDetails) throws ResourceNotFoundException {
		Stock stock = stockExchangeRepository.findById(stockId)
				.orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + stockId));


		stock.settimeStamp(stockDetails.gettimeStamp());
		stock.setstockPrice(stockDetails.getstockPrice());
		stock.setstockName(stockDetails.getstockName());
		final Stock updatedStock = stockExchangeRepository.save(stock);
		return ResponseEntity.ok(updatedStock);
	}


}
