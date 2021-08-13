package com.pro5.distributorv3.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "main_distributor")
public class DataMainDistrib {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "mainDistribName")
    private String mainDistribName;
    private String mainDistribLoc;
    private String email;
    private Integer stockMainDistrib;

}
