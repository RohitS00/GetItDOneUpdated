package com.SpringBoot.service;

import com.SpringBoot.entities.Zipcode;

public interface ZipcodeService {
    Zipcode findViaZipcode(int zipcode);

    Zipcode add(Zipcode zipcode);
}
