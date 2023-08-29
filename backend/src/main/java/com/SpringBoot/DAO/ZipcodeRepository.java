package com.SpringBoot.DAO;

import com.SpringBoot.entities.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodeRepository extends JpaRepository<Zipcode, Integer> {
    Zipcode findByZipcode(Integer zipcode);
}
