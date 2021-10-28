package com.example.BackendTask.Services.Implementations;

import com.example.BackendTask.Models.Order;
import com.example.BackendTask.Models.User;
import com.example.BackendTask.ModelsDTO.OrderDTO;
import com.example.BackendTask.Repositories.OrderRepository;
import com.example.BackendTask.Repositories.UserRepository;
import com.example.BackendTask.Services.Interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public String getLiveOrdersBoard() {
        return orderRepository.findLiveOrderBoardSells().stream()
                .map(e -> e.getQuantity() + " kg for £" + e.getPrice() + "\n")
                .reduce("\n", String::concat);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order registerOrder(OrderDTO newOrder) {
        User user = userRepository.findById(newOrder.getUser_id()).orElse(new User());
        Order order = new Order(newOrder.getQuantity(), newOrder.getPrice(), newOrder.getType(), user);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
