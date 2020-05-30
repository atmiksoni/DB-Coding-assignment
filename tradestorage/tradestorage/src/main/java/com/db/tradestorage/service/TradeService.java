package com.db.tradestorage.service;

import com.db.tradestorage.dao.TradeDao;
import com.db.tradestorage.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {
    @Autowired
    TradeDao tradeDao;

    public boolean isValid(Trade trade){

        return true;
    }

    public void  persist(Trade trade){
        tradeDao.save(trade);
    }

    public List<Trade> findAll(){
       return tradeDao.findAll();
    }

}
