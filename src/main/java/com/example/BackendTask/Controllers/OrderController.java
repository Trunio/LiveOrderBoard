package com.example.BackendTask.Controllers;
import com.example.BackendTask.Models.Order;
import com.example.BackendTask.ModelsDTO.OrderDTO;
import com.example.BackendTask.Repositories.OrderRepository;
import com.example.BackendTask.Repositories.UserRepository;
import com.example.BackendTask.Services.Interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @RequestMapping(value = "/registerOrder", method = { RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerOrder(@RequestBody OrderDTO orderDTO){
        try {
            return ResponseEntity.ok(orderService.registerOrder(orderDTO));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/deleteOrder", method = { RequestMethod.DELETE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteOrder(@RequestBody Integer id){
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/orders", method = { RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOrders(){
        try {
            return ResponseEntity.ok(orderService.getOrders());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/liveOrderBoard", method = { RequestMethod.GET})
    public ResponseEntity<?> getLiveOrderBoard(){
        try {
            return ResponseEntity.ok(orderService.getLiveOrdersBoard());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
