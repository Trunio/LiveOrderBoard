package com.example.BackendTask;

import com.example.BackendTask.models.Order;
import com.example.BackendTask.models.User;
import com.example.BackendTask.modelsDTO.LiveOrderDTO;
import com.example.BackendTask.repositories.OrderRepository;
import com.example.BackendTask.repositories.UserRepository;
import com.example.BackendTask.services.UserService;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.junit.Test;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void findLiveOrdersBoardShouldReturnCorrectQuantityOnSuccess() {
        orderRepository.save(new Order(10,10,"SELL", new User("nickname")));
        Assert.assertEquals(orderRepository.findLiveOrderBoardSells().get(0).getQuantity(), 10);
    }

    @Test
    public void findLiveOrdersBoardShouldReturnEmpyList() {
        orderRepository.save(new Order(10,10,"BUY", new User("nickname")));
        Assert.assertTrue(orderRepository.findLiveOrderBoardSells().isEmpty());
    }
}
