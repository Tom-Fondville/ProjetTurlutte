package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.CartRepository;
import fr.epsi.turlutte.common.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cart")
public class CartController {

    @Autowired
    CartRepository orderRepository;

    @PostMapping(path = "/createcart")
    public Long create(@RequestBody() Cart cart) {
        orderRepository.save(cart);
        Long response = orderRepository.count();
        return response;
    }

}