package com.SpringBoot.service;

import com.SpringBoot.DAO.ZipcodeRepository;
import com.SpringBoot.entities.Zipcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZipcodeServiceIMPL implements ZipcodeService{
    @Autowired
    ZipcodeRepository zipcodeRepository;
    @Override
    public Zipcode findViaZipcode(int zipcode) {
        return zipcodeRepository.findByZipcode(zipcode);

    }

    @Override
    public Zipcode add(Zipcode zipcode) {
        return zipcodeRepository.save(zipcode);
    }
}
