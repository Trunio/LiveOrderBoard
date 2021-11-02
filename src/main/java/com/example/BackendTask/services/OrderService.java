package com.example.BackendTask.services;

import com.example.BackendTask.models.Order;
import com.example.BackendTask.models.User;
import com.example.BackendTask.modelsDTO.OrderDTO;
import com.example.BackendTask.repositories.OrderRepository;
import com.example.BackendTask.repositories.UserRepository;
import com.example.BackendTask.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderService{

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public String getLiveOrdersBoard() {
        return orderRepository.findLiveOrderBoardSells().stream()
                .map(e -> e.getQuantity() + " kg for £" + e.getPrice() + "\n")
                .reduce("\n", String::concat);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order registerOrder(OrderDTO newOrder) {
        User user = userRepository.findById(newOrder.getId_user()).orElse(new User());
        Order order = new Order(newOrder.getQuantity(), newOrder.getPrice(), newOrder.getType(), user);
        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
