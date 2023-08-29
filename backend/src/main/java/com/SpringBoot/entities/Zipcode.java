package com.SpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Embeddable
public class Zipcode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int zipcode;
    @ManyToMany(mappedBy = "zipcodesList")
    @JsonIgnore
    private List<Services> servicesList;
}
