package com.example.department.controller;


import com.example.department.entity.AgentInfo;
import com.example.department.entity.OrderStatus;
import com.example.department.repository.AgentRepository;
import com.example.department.repository.OrderStatusRepository;
import com.example.department.vo.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private  OrderStatusRepository orderStatusRepository;

    @PostMapping("/create")
    public AgentInfo saveDep(@RequestBody AgentInfo department){
     return   agentRepository.save(department);
    }

    @GetMapping("/getall")
    public List<AgentInfo> getInfo(){
        return     agentRepository.findAll();

    }

    @PostMapping("/assign")
    public OrderInfoVO assignOrder(@RequestBody OrderInfoVO order){
        AgentInfo agentInfo =agentRepository.findByStatus(true).stream().findFirst().get();//TODO AI model
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatus("InProgress");
        orderStatus.setOrderId(order.getId());
        orderStatus.setAgentId(agentInfo.getId());
        orderStatusRepository.save(orderStatus);
        agentInfo.setStatus(false);
        agentInfo.setOrderId(order.getId());
        agentRepository.save(agentInfo);
        return order;

    }
    @PostMapping("/complete")
    public OrderInfoVO complete(@RequestBody OrderInfoVO order){
        AgentInfo agentInfo=agentRepository.findByOrderId(order.getId());
        agentInfo.setOrderId(null);
        agentInfo.setStatus(true);
        agentRepository.save(agentInfo);
        return order;

    }
}
