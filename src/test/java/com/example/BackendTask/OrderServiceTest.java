package com.example.BackendTask;

import com.example.BackendTask.models.Order;
import com.example.BackendTask.modelsDTO.OrderDTO;
import com.example.BackendTask.repositories.OrderRepository;
import com.example.BackendTask.repositories.UserRepository;
import com.example.BackendTask.services.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

   @Mock
   OrderRepository orderRepository;

   @Mock
   UserRepository userRepository;

   @InjectMocks
   OrderService orderService;

   @Test
   public void registerOrderShouldReturnNewOrderType(){
       OrderDTO orderDTO = new OrderDTO(0,0,"SELL",1);
       when(orderRepository.save(any(Order.class))).thenReturn(new Order());
       Order created = orderService.registerOrder(orderDTO);
       Assert.assertEquals(created.getPrice(), orderDTO.getPrice(), 0.0);
   }

}


