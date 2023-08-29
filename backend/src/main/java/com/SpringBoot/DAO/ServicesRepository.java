package com.SpringBoot.DAO;

import com.SpringBoot.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {
//    List<Services> findByZipCode(Integer zipCode);
}
