package cat.itb.project.controllers;

import cat.itb.project.Services.UserService;
import cat.itb.project.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
    @Autowired
    private UserService service;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String logged(){
        return "redirect:/Videogames/list";
    }


    @GetMapping("/registration")
    public String registration(Model model){
        UserModel u=new UserModel();
        model.addAttribute("user",u);
        return "registration";
    }
    @PostMapping("/registration")
    public String resgisterUser(@ModelAttribute("user") UserModel user){
        user.setRole("user");
        service.addUser(user);
        return "redirect:/login";
    }
}
