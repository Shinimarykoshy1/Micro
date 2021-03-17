package com.example.department.repository;

import com.example.department.entity.AgentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentRepository extends JpaRepository<AgentInfo,Long> {
    @Query("select a from AgentInfo a where a.status = :status ")
    List<AgentInfo> findByStatus(@Param("status")boolean status);

    AgentInfo findByOrderId(Long id);
}
