package fr.epsi.turlutte.Controller;

import fr.epsi.turlutte.Repository.UserRepository;
import fr.epsi.turlutte.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "user/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "register")
    public ResponseEntity<String> register(@RequestBody User user){
        //TODO faire une requête where email = user.mail
        var users = userRepository.findAll();
        for (var u: users) {
            if (Objects.equals(u.mail, user.mail)) return new ResponseEntity<String>("Account already exist", HttpStatus.EXPECTATION_FAILED);
        }

        //TODO need to hash password
        userRepository.save(user);
        return new ResponseEntity<>("User created", HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping(path = "login")
    public boolean login(@RequestParam String mail, @RequestParam String pwd){
        var user = findUserByMail(mail);
        return user != null && user.password.equals(pwd);
    }



    @GetMapping(path = "get/{id}")
    public User getUser(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }

    private User findUserByMail(String mail){
        //TODO faire une requête where email = user.mail
        var users = userRepository.findAll();
        for (var u: users) {
            if (u.mail.equals(mail)) return u;
        }
        return null;
    }
}
