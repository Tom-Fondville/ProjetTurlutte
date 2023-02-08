package fr.epsi.turlutte.Service;

import fr.epsi.turlutte.Repository.ProductRepository;
import fr.epsi.turlutte.common.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Iterable<Product> getAllProduct() { return productRepository.findAll(); }
}
