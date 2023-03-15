package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.OrderRepository;
import fr.epsi.turlutte.common.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @PostMapping(path = "/createorder")
    public Long create(@RequestBody() Order order) {
        orderRepository.save(order);
        Long response = orderRepository.count();
        return response;
    }

}