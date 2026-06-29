package com.ormlearn;

import com.ormlearn.model.Country;
import com.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        testFindByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
    }

    private static void testFindByCode() {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country:{}", country);
        LOGGER.info("End");
    }

    private static void testAddCountry() {
        LOGGER.info("Start");
        Country country = new Country("ZZ", "Test Country");
        countryService.addCountry(country);
        LOGGER.debug("Added: {}", countryService.findCountryByCode("ZZ"));
        LOGGER.info("End");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start");
        countryService.updateCountry("ZZ", "Updated Country");
        LOGGER.debug("Updated: {}", countryService.findCountryByCode("ZZ"));
        LOGGER.info("End");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("ZZ");
        LOGGER.info("Deleted ZZ. End");
    }
}
