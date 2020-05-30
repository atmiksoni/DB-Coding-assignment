package com.db.tradestorage.dao;

import com.db.tradestorage.model.Trade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TradeDao {

    public  static Map<String,Trade> tradeMap =new HashMap<>();

    public void save(Trade trade);

    List<Trade> findAll();
}
