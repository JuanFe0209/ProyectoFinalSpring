package co.edu.cue.tiendaRojas.controllers;

import co.edu.cue.tiendaRojas.domain.entities.User;
import co.edu.cue.tiendaRojas.mapping.dtos.UserDto;
import co.edu.cue.tiendaRojas.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService service;


    @GetMapping("/list")
    public String listAllUser(Model model){
        List<UserDto> userList = service.list();
        model.addAttribute("userList", userList);
        return "home";
    }

    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "form";
    }
}