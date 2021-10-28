package com.example.BackendTask.Services.Interfaces;

import com.example.BackendTask.Models.Order;
import com.example.BackendTask.ModelsDTO.OrderDTO;

import java.util.List;

public interface OrderService {
    public abstract String getLiveOrdersBoard();
    public abstract List<Order> getOrders();
    public abstract Order registerOrder(OrderDTO newOrder);
    public abstract void deleteOrder(Integer id);
}
