package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.CategorieRepository;
import fr.epsi.turlutte.common.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/categorie")
public class CategorieController {

    @Autowired
    CategorieRepository categorieRepository;

    @PostMapping(path= "/createCategorie")
    public Long create(@RequestBody() Categorie categorie) {
        categorieRepository.save(categorie);
        Long response = categorieRepository.count();
        return response;
    }

    @DeleteMapping(path = "/deleteCategorie")
    public boolean delete(@RequestParam Long id) {
        Optional<Categorie> response = categorieRepository.findById(id);
        if(response.isPresent()) {
            Categorie categorie = response.get();
            categorieRepository.delete(categorie);
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
