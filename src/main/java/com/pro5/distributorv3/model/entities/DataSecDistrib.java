package com.pro5.distributorv3.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "second_distributor")
public class DataSecDistrib {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "secDistribName")
    private String secDistribName;

//    @Column(name = "stockSecDistrib")
    private Integer stockSecDistrib;

//    @Column(name = "idMainDistrib")
    private Long idMainDistrib;
    @ManyToOne
    @JoinColumn(name = "idMainDistrib", insertable = false, updatable = false)
    private DataMainDistrib dataMainDistrib;

}
