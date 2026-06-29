package com.ormlearn.service;

import com.ormlearn.model.Stock;
import com.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public List<Stock> getFacebookSeptember2019() {
        return stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30));
    }

    @Transactional
    public List<Stock> getGoogleAbove1250() {
        return stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
    }

    @Transactional
    public List<Stock> getTop3ByVolume() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional
    public List<Stock> getNetflixLowest3() {
        return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
    }
}
