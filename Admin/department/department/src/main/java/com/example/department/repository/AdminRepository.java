package com.example.department.repository;

import com.example.department.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<OrderInfo,Long> {
}
