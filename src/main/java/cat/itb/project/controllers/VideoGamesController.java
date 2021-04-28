package cat.itb.project.controllers;

import cat.itb.project.Services.VideogameServices;
import cat.itb.project.model.Videogames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VideoGamesController {
    @Autowired
    private VideogameServices services;
    @GetMapping("/Videogames/list")
    public String list(Model m){
        m.addAttribute("listGames",services.listAll());
        return "list";
    }

    @GetMapping("/new")
    public String addGame(Model m){
        m.addAttribute("gameform",new Videogames());
        return "add";
    }

    @PostMapping("/new/submit")
    public String addGameSubmit(@ModelAttribute("gameform")Videogames game){
        services.add(game);
        return "redirect:/Videogames/list";
    }

    @GetMapping("/edit/{id}")
    public String editEmpleat(@PathVariable("id")int id, Model m){
        Videogames v=services.consultaPerId(id);
        m.addAttribute("gameform",v);
        return "add";
    }

    @PostMapping("/edit/submit")
    public String editSubmit(@ModelAttribute("gameform") Videogames game){
        services.substituir(game);
        return "redirect:/Videogames/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id")int id){
        services.eliminarPerId(id);
        return "redirect:/Videogames/list";
    }

}
