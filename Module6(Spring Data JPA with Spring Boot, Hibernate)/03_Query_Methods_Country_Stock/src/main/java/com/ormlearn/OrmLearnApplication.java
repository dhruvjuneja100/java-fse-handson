package com.ormlearn;

import com.ormlearn.model.Country;
import com.ormlearn.model.Stock;
import com.ormlearn.service.CountryService;
import com.ormlearn.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    private static StockService stockService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        stockService = context.getBean(StockService.class);
        testSearchByContaining();
        testSearchByStartingWith();
        testStockQueries();
    }

    private static void testSearchByContaining() {
        LOGGER.info("Start");
        List<Country> countries = countryService.searchByNameContainingSorted("ou");
        LOGGER.debug("Countries containing 'ou' sorted: {}", countries);
        LOGGER.info("End");
    }

    private static void testSearchByStartingWith() {
        LOGGER.info("Start");
        List<Country> countries = countryService.searchByNameStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", countries);
        LOGGER.info("End");
    }

    private static void testStockQueries() {
        LOGGER.info("Start stock queries");
        LOGGER.debug("Top 3 by volume: {}", stockService.getTop3ByVolume());
        LOGGER.info("End");
    }
}
