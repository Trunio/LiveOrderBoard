package com.example.BackendTask.controllers;

import com.example.BackendTask.models.Order;
import com.example.BackendTask.modelsDTO.OrderDTO;
import com.example.BackendTask.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/registerOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> registerOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.registerOrder(orderDTO));
    }

    @DeleteMapping(value = "/deleteOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteOrder(@RequestBody Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping(value = "/liveOrderBoard")
    public ResponseEntity<String> getLiveOrderBoard() {
        return ResponseEntity.ok(orderService.getLiveOrdersBoard());
    }

}
