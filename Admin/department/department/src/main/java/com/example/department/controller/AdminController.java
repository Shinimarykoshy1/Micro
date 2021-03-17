package com.example.department.controller;


import com.example.department.entity.OrderInfo;
import com.example.department.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public OrderInfo saveDep(@RequestBody OrderInfo orderInfo){
        OrderInfo order = adminRepository.save(orderInfo);
        restTemplate.postForEntity("http://localhost:8081/agent/assign",order,OrderInfo.class);
        return orderInfo;

    }

    @GetMapping("/getall")
    public List<OrderInfo> getInfo(){
        return     adminRepository.findAll();

    }
}
