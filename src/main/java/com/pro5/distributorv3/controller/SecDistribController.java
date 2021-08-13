package com.pro5.distributorv3.controller;

import com.pro5.distributorv3.model.dto.SecDistribDto;
import com.pro5.distributorv3.model.entities.DataSecDistrib;
import com.pro5.distributorv3.service.DistributorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v2/maindistrib/secdistrib")
public class SecDistribController {

    @Autowired
    public DistributorService distributorService;

    @Autowired
    ModelMapper modelMapper;

    private SecDistribDto convertToDto(DataSecDistrib dataSecDistrib){
        SecDistribDto secDistribDto = modelMapper.map(dataSecDistrib, SecDistribDto.class);
        return secDistribDto;
    }

    private DataSecDistrib convertToEntity(SecDistribDto secDistribDto){
        DataSecDistrib dataSecDistrib = modelMapper.map(secDistribDto, DataSecDistrib.class);
        return dataSecDistrib;
    }

    @PostMapping
    public SecDistribDto insertSecDistrib(@RequestBody SecDistribDto secDistribDto){
        DataSecDistrib dataSecDistrib = convertToEntity(secDistribDto);
        DataSecDistrib secDistribUpdate = distributorService.insertSecDistrib(dataSecDistrib);
        return convertToDto(secDistribUpdate);
    }

    @GetMapping
    public List<SecDistribDto> showAllSecDistrib(){
        List<DataSecDistrib> dataSecDistribs = distributorService.getAllSecDistrib();
        return dataSecDistribs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/idmaindistrib")
    public List<SecDistribDto> getSecDistribByMainDistrib(@RequestParam("id") Long id){
        List<DataSecDistrib> dataSecDistribs = distributorService.getSecDistribByMainDistrib(id);
        return dataSecDistribs.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
