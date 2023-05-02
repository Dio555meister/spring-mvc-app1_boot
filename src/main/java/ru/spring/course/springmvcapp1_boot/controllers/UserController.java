package ru.spring.course.springmvcapp1_boot.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.spring.course.springmvcapp1_boot.models.User;
import ru.spring.course.springmvcapp1_boot.services.UserServiceImp;


@Controller
@RequestMapping("/")

public class UserController {

    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userRepository) {
        this.userServiceImp = userRepository;
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userServiceImp.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServiceImp.show(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String creat(@ModelAttribute("user")
                        @Valid User person, //
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";
        userServiceImp.save(person);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")

    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServiceImp.show(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")
                         @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id) {

        if (bindingResult.hasErrors())
            return "users/edit";
        userServiceImp.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) {
        userServiceImp.delete(id);
        return "redirect:/";
    }
}
