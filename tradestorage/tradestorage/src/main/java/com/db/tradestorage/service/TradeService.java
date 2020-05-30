package com.db.tradestorage.service;

import com.db.tradestorage.dao.TradeDao;
import com.db.tradestorage.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.DoubleToIntFunction;

@Service
public class TradeService {
    @Autowired
    TradeDao tradeDao;

    public boolean isValid(Trade trade){
        Trade exsitingTrade =tradeDao.findTrade(trade.getTradeId());
        if(!Objects.isNull(exsitingTrade)){
            return  false;
        }
        return true;
    }

    public void  persist(Trade trade){
        tradeDao.save(trade);
    }

    public List<Trade> findAll(){
       return tradeDao.findAll();
    }

}
