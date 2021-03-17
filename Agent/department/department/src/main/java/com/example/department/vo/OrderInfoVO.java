package com.example.department.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderInfoVO {

    private Long id;
    private String name;
    private String sourceAddress;
    private String destinationAddress;
    private String pincode;
    private String parelType;
    private String mode;
    private int totalWorth;
}
