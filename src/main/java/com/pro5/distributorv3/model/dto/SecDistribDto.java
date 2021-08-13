package com.pro5.distributorv3.model.dto;

import lombok.Data;

@Data
public class SecDistribDto {
    private Long id;
    private String secDistribName;
    private String secDistribLoc;
    private Long idMainDistrib;
    private Integer stockSecDistrib;
}
