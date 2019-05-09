package com.money.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.money.market.model.Stock;

@Repository
public interface StockExchangeRepository extends JpaRepository<Stock, Long>{

}
