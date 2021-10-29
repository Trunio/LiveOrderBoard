package com.example.BackendTask;

import com.example.BackendTask.Controllers.OrderController;
import com.example.BackendTask.Models.Order;
import com.example.BackendTask.Models.User;
import com.example.BackendTask.ModelsDTO.OrderDTO;
import com.example.BackendTask.Services.Interfaces.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @MockBean
    OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnNewOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        Order order = new Order();
        when(orderService.registerOrder(any(OrderDTO.class))).thenReturn(order);
        mockMvc.perform(post("/registerOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(orderDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':0,'quantity':0, 'price': 0.0, 'type': null, 'user':null}"));
    }

    @Test
    public void shouldFailReturnNewOrder() throws Exception {
        mockMvc.perform(post("/registerOrder")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldFailDeleteOrder() throws Exception {
        mockMvc.perform(delete("/deleteOrder")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldDeleteOrder() throws Exception {
        mockMvc.perform(delete("/deleteOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(1)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAllOrders() throws Exception {
        List<Order> orderList = Arrays.asList(new Order());
        when(orderService.getOrders()).thenReturn(orderList);
        mockMvc.perform(get("/orders")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':0,'quantity':0, 'price': 0.0, 'type': null, 'user':null}]"));
    }

    @Test
    public void shouldReturnLiveOrdersBoard() throws Exception {
        String expected = "5.5 kg for £306";
        when(orderService.getLiveOrdersBoard()).thenReturn(expected);
        mockMvc.perform(get("/liveOrderBoard")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

}
