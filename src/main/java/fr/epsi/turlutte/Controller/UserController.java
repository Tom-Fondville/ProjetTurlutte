package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.UserRepository;
import fr.epsi.turlutte.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    //    @PostMapping(path = "register")
//    public ResponseEntity<String> register(@RequestBody User user){
//        //TODO faire une requête where email = user.mail
//        var users = userRepository.findAll();
//        for (var u: users) {
//            if (Objects.equals(u.mail, user.mail)) return new ResponseEntity<String>("Account already exist", HttpStatus.EXPECTATION_FAILED);
//        }
//
//        //TODO need to hash password
//        userRepository.save(user);
//        return new ResponseEntity<>("User created", HttpStatus.EXPECTATION_FAILED);
//    }
//
//    @GetMapping(path = "login")
//    public boolean login(@RequestParam String mail, @RequestParam String pwd){
//        var user = findUserByMail(mail);
//        return user != null && user.password.equals(pwd);
//    }
//
//
//
//    @GetMapping(path = "get/{id}")
//    public User getUser(@PathVariable Long id){
//        return userRepository.findById(id).orElse(null);
//    }
//
    private User findUserByMail(String mail) {
        //TODO faire une requête where email = user.mail
        var users = userRepository.findAll();
        for (var u : users) {
            if (u.mail.equals(mail)) return u;
        }
        return null;
    }

    @GetMapping(path = "/login")
    public ModelAndView getLoginPage(Model model) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping(path = "/login")
    public ModelAndView login(@ModelAttribute("user") User user,
                              @RequestParam("mail") String mail,
                              @RequestParam("pwd") String pwd) {
        var client = findUserByMail(mail);
        if (client != null && client.pwd.equals(pwd)) {
            return new ModelAndView("redirect:/product/tyme/all");
        } else {
            return new ModelAndView("login");
        }
    }

    @GetMapping(path = "/register")
    public ModelAndView GetRegisterPage(Model model) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping(path = "/register")
    public ModelAndView register(@ModelAttribute("user") User user,
                                 @RequestParam("nom") String nom,
                                 @RequestParam("prenom") String prenom,
                                 @RequestParam("adresse") String adresse,
                                 @RequestParam("carteBancaire") String carteBancaire,
                                 @RequestParam("telephone") String telephone,
                                 @RequestParam("mail") String mail,
                                 @RequestParam("pwd") String pwd) {
        var client = findUserByMail(mail);
        if (client == null) {
            var u = User.builder()
                    .nom(nom)
                    .prenom(prenom)
                    .adresse(adresse)
                    .telephone(telephone)
                    .carteBancaire(carteBancaire)
                    .mail(mail)
                    .pwd(pwd)
                    .build();
            userRepository.save(u);
            return new ModelAndView("redirect:/product/tyme/all");
        } else {
            return new ModelAndView("register");
        }
    }
}
