package com.SpringBoot.service;

import com.SpringBoot.entities.ServiceConsumer;
import com.SpringBoot.entities.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {
    ServiceProvider findProvider(int id);

    ServiceProvider saveServiceProvider(ServiceProvider serviceProvider);

//    ServiceProvider register(ServiceProvider sp) throws Exception;
//
//    ServiceProvider login(ServiceProvider sp) throws Exception;
    List<ServiceConsumer> getServiceConsumersByProviderId(int providerId);
}
