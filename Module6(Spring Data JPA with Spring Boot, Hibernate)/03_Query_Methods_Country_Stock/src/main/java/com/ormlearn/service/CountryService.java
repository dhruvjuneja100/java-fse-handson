package com.ormlearn.service;

import com.ormlearn.model.Country;
import com.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> searchByNameContaining(String text) {
        return countryRepository.findByNameContaining(text);
    }

    @Transactional
    public List<Country> searchByNameContainingSorted(String text) {
        return countryRepository.findByNameContainingOrderByName(text);
    }

    @Transactional
    public List<Country> searchByNameStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}
