package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.CategoryRepository;
import fr.epsi.turlutte.common.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/categorie")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping(path= "/createCategorie")
    public Long create(@RequestBody() Category category) {
        categoryRepository.save(category);
        Long response = categoryRepository.count();
        return response;
    }

    @DeleteMapping(path = "/deleteCategorie")
    public boolean delete(@RequestParam Long id) {
        Optional<Category> response = categoryRepository.findById(id);
        if(response.isPresent()) {
            Category category = response.get();
            categoryRepository.delete(category);
            return true;
        }
        return false;
    }

    /*@RequestMapping(path= "/getCategorie")
    public Categorie get(@RequestParam() Long id) {
        Optional<Categorie> response = categorieRepository.findById(id);
        if(response.isPresent()) {
            Categorie categorie = response.get();
            return categorie;
        }
        return null;
    }

    @RequestMapping(path= "/getAllCategorie")
    public Iterable<Categorie> getALL() {
        Iterable<Categorie> response = categorieRepository.findAll();
        return response;
    }*/

}
