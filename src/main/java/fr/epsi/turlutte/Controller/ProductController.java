package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.ProductRepository;
import fr.epsi.turlutte.Service.ProductService;
import fr.epsi.turlutte.common.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping(path="/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping(path = "/get/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping(path = "/add")
    public boolean addProduct(@RequestBody Product product) {
        Iterable<Product> products = productRepository.findAll();
        for (var p: products) {
            if (p.getName() == product.getName()) {
                return false;
            }
        }
        productRepository.save(product);
        return true;
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping(path = "/list")
    public ModelAndView listProduct() {
        ModelAndView mav = new ModelAndView("product_template");
        Iterable<Product> productList = productRepository.findAll();
        mav.addObject("products", productList);
        return mav;
    }

    @GetMapping(path = "/tyme/all")
    public ModelAndView getAllProduct(Model model) {
        ModelAndView mav = new ModelAndView("product_template");
        mav.addObject("products", productService.getAllProduct());
        return mav;
    }

    @GetMapping(path = "/tyme/add")
    public ModelAndView addProductPage(Model model) {
        ModelAndView mav = new ModelAndView("productAdd_template");
        mav.addObject("product", new Product());
        return mav;
    }

    @PostMapping(path = "/tyme/add")
    public ModelAndView addOneProduct(@ModelAttribute("product") Product product,
                                @RequestParam("name") String name,
                                @RequestParam("image") String image,
                                @RequestParam("description") String description) {
        ModelAndView mav = new ModelAndView("redirect:/product/tyme/all");
        Product newProduct = Product.builder().image(image).description(description).name(name).build();
        productRepository.save(newProduct);
        return mav;
    }


}
