package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.OrderFormRepository;
import fr.epsi.turlutte.common.model.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orderForm")
public class OrderFormController {

    @Autowired
    OrderFormRepository orderFormRepository;

    @PostMapping(path = "/createorderForm")
    public Long create(@RequestBody() OrderForm orderForm) {
        orderFormRepository.save(orderForm);
        Long response = orderFormRepository.count();
        return response;
    }

}