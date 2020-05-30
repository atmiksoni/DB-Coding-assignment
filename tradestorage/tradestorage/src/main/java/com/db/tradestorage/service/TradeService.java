package com.db.tradestorage.service;

import com.db.tradestorage.dao.TradeDao;
import com.db.tradestorage.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.DoubleToIntFunction;

@Service
public class TradeService {
    @Autowired
    TradeDao tradeDao;

    public boolean isValid(Trade trade){
         if(validateMaturityDate(trade)) {
             Trade exsitingTrade = tradeDao.findTrade(trade.getTradeId());
             if (!Objects.isNull(exsitingTrade)) {
                 return validateVersion(trade, exsitingTrade);
             }else{
                 return true;
             }
         }
             return false;
    }

    private boolean validateVersion(Trade trade,Trade oldTrade) {
        //validation 1  During transmission if the
        // lower version is being received by the store it will reject the trade and throw an exception.
        if(trade.getVersion() < oldTrade.getVersion()){
            return false;
        }
        return true;
    }

    //2.	Store should not allow the trade which has less maturity date then today date
    private boolean validateMaturityDate(Trade trade){
        return trade.getMaturityDate().isBefore(LocalDate.now())  ? false:true;
    }

    public void  persist(Trade trade){
        tradeDao.save(trade);
    }

    public List<Trade> findAll(){
       return tradeDao.findAll();
    }

}
