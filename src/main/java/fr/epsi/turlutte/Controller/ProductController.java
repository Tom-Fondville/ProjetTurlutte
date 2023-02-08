package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.CategorieRepository;
import fr.epsi.turlutte.Repository.ProductRepository;
import fr.epsi.turlutte.Service.ProductService;
import fr.epsi.turlutte.common.enums.Qualite;
import fr.epsi.turlutte.common.model.Categorie;
import fr.epsi.turlutte.common.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping(path="/admin/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;
    @Autowired
    CategorieRepository categorieRepository;


    @GetMapping(path = "/get")
    public ModelAndView getProducts() {
        ModelAndView mav = new ModelAndView("product_template");
        mav.addObject("products", productService.getAllProduct());
        return mav;
    }

    @GetMapping(path = "/add")
    public ModelAndView addProductPage() {
        ModelAndView mav = new ModelAndView("productAdd_template");
        mav.addObject("product", new Product());
        mav.addObject("categories", categorieRepository.findAll());
        return mav;
    }

    @PostMapping(path = "/add")
    public ModelAndView addOneProduct(@ModelAttribute("product") Product product,
                                @RequestParam("id") Long id,
                                @RequestParam("name") String name,
                                @RequestParam("categorie") Long categorieID,
                                @RequestParam("image") String image,
                                @RequestParam("price") double price,
                                @RequestParam("description") String description) {
        Categorie categorie = categorieRepository.findById(categorieID).orElse(null);
        Product newProduct = Product.builder()
                .id(id)
                .image(image)
                .categorie(categorie)
                .price(price)
                .description(description)
                .name(name)
                .build();
        productRepository.save(newProduct);
        return new ModelAndView("redirect:/admin/product/get");
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView deleteProductId(@PathVariable Long id) {
        productRepository.deleteById(id);
        return new ModelAndView("redirect:/admin/product/get");
    }
    @GetMapping(path = "/update/{id}")
    public ModelAndView updateProductId(@PathVariable Long id) {
        Product existingProduct = productRepository.findById(id).get();

        ModelAndView mav = new ModelAndView("productUpdate_template");
        mav.addObject("product", existingProduct);
        mav.addObject("categories", categorieRepository.findAll());
        return mav;
    }

    @PostMapping(path = "/update")
    public ModelAndView updateOneProduct(@ModelAttribute("product") Product product,
                                      @RequestParam("id") Long id,
                                      @RequestParam("name") String name,
                                      @RequestParam("categorie") Long categorieID,
                                      @RequestParam("image") String image,
                                      @RequestParam("price") double price,
                                      @RequestParam("description") String description) {
        Categorie categorie = categorieRepository.findById(categorieID).orElse(null);
        Product newProduct = productRepository.findById(id).orElse(null);
        newProduct.setCategorie(categorie);
        newProduct.setImage(image);
        newProduct.setPrice(price);
        newProduct.setDescription(description);
        newProduct.setName(name);

        productRepository.save(newProduct);
        return new ModelAndView("redirect:/admin/product/get");
    }

}
