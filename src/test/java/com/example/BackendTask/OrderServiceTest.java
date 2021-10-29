package com.example.BackendTask;

import com.example.BackendTask.Models.Order;
import com.example.BackendTask.Models.User;
import com.example.BackendTask.ModelsDTO.OrderDTO;
import com.example.BackendTask.Repositories.OrderRepository;
import com.example.BackendTask.Repositories.UserRepository;
import com.example.BackendTask.Services.Implementations.OrderServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

   @Mock
   OrderRepository orderRepository;

   @Mock
   UserRepository userRepository;

   @InjectMocks
   OrderServiceImpl orderService;

   @Test
   public void registerOrderShouldReturnNewOrderType(){
       OrderDTO orderDTO = new OrderDTO(0,0,"SELL",1);
       when(orderRepository.save(any(Order.class))).thenReturn(new Order());
       Order created = orderService.registerOrder(orderDTO);
       Assert.assertEquals(created.getPrice(), orderDTO.getPrice(), 0.0);
   }

}


