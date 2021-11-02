package com.example.BackendTask.repositories;

import com.example.BackendTask.models.Order;
import com.example.BackendTask.modelsDTO.LiveOrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT quantity, sum(price) as price from ORDERS WHERE type = 'SELL' group by quantity order by sum(price) desc", nativeQuery = true)
    List<LiveOrderDTO> findLiveOrderBoardSells();
}
