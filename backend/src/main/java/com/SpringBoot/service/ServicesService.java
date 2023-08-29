package com.SpringBoot.service;

import com.SpringBoot.entities.Services;

import java.util.List;
import java.util.UUID;

public interface ServicesService {
    List<Services> getServices();

    Services saveService(int id, Services services);

    Services getServiceById(int id);
//
    List<Services> findServicesByZipCode(Integer zipCode);
}
