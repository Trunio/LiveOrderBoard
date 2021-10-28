package com.example.BackendTask.Repositories;

import com.example.BackendTask.Models.Order;
import com.example.BackendTask.ModelsDTO.LiveOrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT quantity, sum(price) as price from ORDERS WHERE type = 'SELL' group by quantity order by sum(price) desc", nativeQuery = true)
    List<LiveOrderDTO> findLiveOrderBoardSells();
}
