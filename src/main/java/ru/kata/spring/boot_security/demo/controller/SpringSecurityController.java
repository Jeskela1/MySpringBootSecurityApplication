package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Service.RoleService;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class SpringSecurityController {


    private UserService userService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public SpringSecurityController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String userPage(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);

        return "user-list-for-admin";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/new")
    public String createUserPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRole());
        return "user-create";
    }
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addUser")
    public String createUserPage(@ModelAttribute("user") @Validated User user,
                                BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            model.addAttribute("roles", roleService.getAllRole());
            return "user-create";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/users";

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit")
    public String editUserByid(@RequestParam(value = "id") Long id, Model model){
        Optional<User> userById = userService.findUserById(id);
        if (userById.isPresent()) {
            model.addAttribute("user", userById.get());
            model.addAttribute("roles", roleService.getAllRole());
            return "edit-user";
        } else {
            return "redirect:/users";
        }

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/editUser")
    public String editUserById(@ModelAttribute("user") @Validated User user,
                               BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "edit-user";

        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.updateUser(user);
        return "redirect:/users";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/delete")
    public String deleteUserById(@RequestParam("id") Long id){
        userService.deleteUserById(id);
        return "redirect:/users";
    }




//    @GetMapping("/edit")
//    public String editUserPage(@RequestParam("id") Long id, Model model) {
//        Optional<User> userById = userService.getUserById(id);
//
//        if (userById.isPresent()) {
//            model.addAttribute("user", userById.get());
//            return "edit-user";
//        } else {
//            return "redirect:/users";
//        }
//    }
//
//    @PostMapping("/edit")
//    public String editUser(@ModelAttribute("user") @Validated User user,
//                           BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "edit-user";
//        }
//
//        userService.updateUser(user);
//        return "redirect:/users";
//    }
//
//    @PostMapping("/delete")
//    public String deleteUser(@RequestParam("id") Long id) {
//        userService.deleteById(id);
//        return "redirect:/users";
//    }
}
