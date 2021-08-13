package com.pro5.distributorv3.repository;

import com.pro5.distributorv3.model.entities.DataSecDistrib;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecDistribRepo extends CrudRepository<DataSecDistrib, Long> {
    @Query (
            value = "SELECT second_distributor.sec_distrib_name, main_distributor.main_distrib_name, " +
                    "second_distributor.stock_sec_distrib,second_distributor.id_main_distrib, main_distributor.id " +
                    "FROM second_distributor " +
                    "INNER JOIN main_distributor " +
                    "ON main_distributor.id = second_distributor.id_main_distrib " +
                    "WHERE second_distributor.id_main_distrib = :idMainDistrib"
                    ,nativeQuery = true
    )
    List<DataSecDistrib> findSecDistribByMainDistrib(@Param("idMainDistrib") Long idMainDistrib);
}
