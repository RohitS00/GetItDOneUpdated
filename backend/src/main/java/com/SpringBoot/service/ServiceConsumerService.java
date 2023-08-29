package com.SpringBoot.service;

import com.SpringBoot.entities.ServiceConsumer;

import java.util.UUID;

public interface ServiceConsumerService {
//    ServiceConsumer register(ServiceConsumer serviceConsumer) throws Exception;
//    ServiceConsumer login(ServiceConsumer serviceConsumer) throws Exception;

    void selectPrefferedService(int scId, int id);

    ServiceConsumer getServiceConsumer(int id);
}
