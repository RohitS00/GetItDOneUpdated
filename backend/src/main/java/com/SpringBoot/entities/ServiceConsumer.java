package com.SpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity(name="ServiceConsumer")
@Data
//@Embeddable
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name")
public class ServiceConsumer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String info;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private User user;
    @ManyToMany
    private List<Services> servicesList ;

}
