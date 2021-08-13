package com.pro5.distributorv3.service;

import com.pro5.distributorv3.model.entities.DataSecDistrib;
import com.pro5.distributorv3.model.entities.DataMainDistrib;

import java.util.List;

public interface DistributorService {
    //------------------------- Service Main Distributor ----------------------------
    public List<DataMainDistrib> getAllMainDistrib();
    public DataMainDistrib insertMainDistrib(DataMainDistrib dataMainDistrib);
//    public DataMainDistrib deleteMainDistribById(Long id);
    //------------------------- Service Second Distributor ----------------------
    public DataSecDistrib insertSecDistrib(DataSecDistrib dataSecDistrib);
    public List<DataSecDistrib> getAllSecDistrib();
    public List<DataSecDistrib> getSecDistribByMainDistrib(Long idMainDistrib);


}
