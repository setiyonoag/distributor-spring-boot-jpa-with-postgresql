package com.pro5.distributorv3.controller;

import com.pro5.distributorv3.model.dto.MainDistribDto;
import com.pro5.distributorv3.model.entities.DataMainDistrib;
import com.pro5.distributorv3.service.DistributorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v3/maindistrib/")
public class MainDistribController {

    @Autowired
    public DistributorService distributorService;

    @Autowired
    ModelMapper modelMapper;

    private MainDistribDto convertToDto(DataMainDistrib dataMainDistrib){
        MainDistribDto mainDistribDto = modelMapper.map(dataMainDistrib, MainDistribDto.class);
        return mainDistribDto;
    }

    private DataMainDistrib convertToEntity(MainDistribDto mainDistribDto){
        DataMainDistrib dataMainDistrib = modelMapper.map(mainDistribDto, DataMainDistrib.class);
        return dataMainDistrib;
    }

    @GetMapping
    public List<MainDistribDto> showAllMainDistrib(){
        List<DataMainDistrib> dataMainDistribs = distributorService.getAllMainDistrib();
        return dataMainDistribs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @PostMapping
    public MainDistribDto insertMainDistrib(@RequestBody MainDistribDto mainDistribDto){
        DataMainDistrib dataMainDistrib = convertToEntity(mainDistribDto);
        DataMainDistrib mainDistribUpdate = distributorService.insertMainDistrib(dataMainDistrib);
        return convertToDto(mainDistribUpdate);
    }

//    @DeleteMapping(value = "/delete")
//    public void deleteMainDistribById(@RequestParam("id")Long id){
//        distributorService.deleteMainDistribById(id);
//    }


}
