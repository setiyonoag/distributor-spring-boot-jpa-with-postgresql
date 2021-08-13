package com.pro5.distributorv3.service;


import com.pro5.distributorv3.model.entities.DataSecDistrib;
import com.pro5.distributorv3.model.entities.DataMainDistrib;

import com.pro5.distributorv3.repository.SecDistribRepo;
import com.pro5.distributorv3.repository.MainDistribRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DistributorServiceImpl implements DistributorService {

    @Autowired
    public MainDistribRepo mainDistribRepo;

    @Autowired
    public SecDistribRepo secDistribRepo;


    //------------------------- Service Main Distributor ----------------------------
    @Override
    public List<DataMainDistrib> getAllMainDistrib(){
        List<DataMainDistrib> dataMainDistribs = new ArrayList<>();
        mainDistribRepo.findAll().forEach(dataMainDistribs::add);
        return dataMainDistribs;
    }

    @Override
    public DataMainDistrib insertMainDistrib(DataMainDistrib dataMainDistrib){
        return mainDistribRepo.save(dataMainDistrib);
    }

//    @Override
//    public void deleteMainDistribById(Long id){
//        mainDistribRepo.deleteById(id);
//    }

    //------------------------- Service Second Distributor ----------------------
    @Override
    public List<DataSecDistrib> getAllSecDistrib(){
        List<DataSecDistrib> dataSecDistribs = new ArrayList<>();
        secDistribRepo.findAll().forEach(dataSecDistribs::add);
        return dataSecDistribs;
    }

    @Override
    public DataSecDistrib insertSecDistrib(DataSecDistrib dataSecDistrib){
        return secDistribRepo.save(dataSecDistrib);
    }

    @Override
    public List<DataSecDistrib> getSecDistribByMainDistrib(Long idMainDistrib){
        List<DataSecDistrib> dataSecDistribs = new ArrayList<>();
        secDistribRepo.findSecDistribByMainDistrib(idMainDistrib).forEach(dataSecDistribs::add);
        return dataSecDistribs;
    }

}
