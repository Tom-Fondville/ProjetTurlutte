package fr.epsi.turlutte.Controller;


import fr.epsi.turlutte.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BaseController {

    @Autowired
    ProductService productService;


    @GetMapping(path = "/")
    public ModelAndView getProducts() {
        ModelAndView mav = new ModelAndView("index_template");
        mav.addObject("products", productService.getAllProduct());
        return mav;
    }
}
