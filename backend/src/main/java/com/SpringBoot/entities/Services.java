package com.SpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity(name="Services")
@Data
@Embeddable
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private int price;
    private String description;
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
    @ManyToOne
    @JsonIgnore
    private ServiceProvider serviceProvider;
    //@ManyToMany(mappedBy = "servicesList", fetch = FetchType.LAZY)
    @ManyToMany(mappedBy = "servicesList")
    @JsonIgnore
    private List<ServiceConsumer> serviceConsumerList;
    @ManyToMany
    private List<Zipcode> zipcodesList ;
}
