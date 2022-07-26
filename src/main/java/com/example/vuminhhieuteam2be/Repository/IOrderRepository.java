package com.example.vuminhhieuteam2be.Repository;

import com.example.vuminhhieuteam2be.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {
}
