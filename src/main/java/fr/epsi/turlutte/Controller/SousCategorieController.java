package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.CategorieRepository;
import fr.epsi.turlutte.Repository.SousCategorieRepository;
import fr.epsi.turlutte.common.model.Categorie;
import fr.epsi.turlutte.common.model.SousCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/categorie")
public class SousCategorieController {

    @Autowired
    SousCategorieRepository sousCategorieRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    @PostMapping(path= "/createSousCategorie")
    public Long create(@RequestBody() SousCategorie sousCategorie) {
        sousCategorieRepository.save(sousCategorie);
        Long response = sousCategorieRepository.count();
        return response;
    }

    @DeleteMapping(path = "/deleteSousCategorie")
    public boolean delete(@RequestParam Long id) {
        Optional<SousCategorie> response = sousCategorieRepository.findById(id);
        if(response.isPresent()) {
            SousCategorie sousCategorie = response.get();
            sousCategorieRepository.delete(sousCategorie);
            return true;
        }
        return false;
    }

    /*@RequestMapping(path= "/getSousCategorie")
    public SousCategorie get(@RequestParam() Long id) {
        Optional<SousCategorie> response = sousCategorieRepository.findById(id);
        if(response.isPresent()) {
            SousCategorie sousCategorie = response.get();
            return sousCategorie;
        }
        return null;
    }

    @RequestMapping(path= "/getAllSousCategorie")
    public Iterable<SousCategorie> getALL() {
        Iterable<SousCategorie> response = sousCategorieRepository.findAll();
        return response;
    }*/
}
