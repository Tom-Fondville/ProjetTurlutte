package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.CommandeRepository;
import fr.epsi.turlutte.common.model.Category;
import fr.epsi.turlutte.common.model.Commande;
import fr.epsi.turlutte.common.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class CommandeController {

    @Autowired
    CommandeRepository commandeRepository;

    @PostMapping(path = "/commande/save")
    public void saveCommande(@RequestBody Commande commande){
        commandeRepository.save(commande);
    }

    @GetMapping(path = "/commande/save")
    public ModelAndView commander(){
        ModelAndView mav = new ModelAndView("commande_template");
        mav.addObject("commande", new Commande());
        return mav;
    }

    @GetMapping(path = "/admin/commande/")
    public ModelAndView getCommandes() {
        ModelAndView mav = new ModelAndView("admin_commande_template");
        mav.addObject("commandes", commandeRepository.findAll());
        return mav;
    }
    @GetMapping(path = "/admin/commande/detail/{id}")
    public ModelAndView getCommandeDetail(@PathVariable Long id) {
        var existingCommande = commandeRepository.findById(id).get();

        ModelAndView mav = new ModelAndView("admin_commande_detail");
        mav.addObject("commande", existingCommande);
        return mav;
    }

    @GetMapping(path = "/admin/commande/delete/{id}")
    public ModelAndView deleteCommandeById(@PathVariable Long id) {
        commandeRepository.deleteById(id);
        return new ModelAndView("redirect:/admin/commande/");
    }

}
