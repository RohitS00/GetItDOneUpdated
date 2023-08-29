package com.SpringBoot.DAO;

import com.SpringBoot.entities.ServiceConsumer;
import com.SpringBoot.entities.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceConsumerRepository extends JpaRepository<ServiceConsumer, Integer> {
//    ServiceConsumer findByEmail(String email);
}
