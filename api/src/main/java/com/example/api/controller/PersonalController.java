package com.example.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.models.Personal;
import com.example.api.services.PersonalServices;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personal")

public class PersonalController {
    @Autowired
    private PersonalServices personalPostServices;

    // @GetMapping
    // public String hello_world() {
    //     return "Hello World";
    // }
    
    // @GetMapping("/holamundo")
    // public String hello_world_2() {
    //     return "Hello world from other path";
    // }

    // @GetMapping("/holamundo/{name}")
    // public String hello_world_3(@PathVariable String name) {
    //     return "Hello World "+name;
    // }

    // @GetMapping("/holamundo/{name}/{lastname}/{age}")
    // public String hello_world_3(@PathVariable String name, @PathVariable String lastname, @PathVariable int age) {
    //     return "Hello World "+name+ " "+ lastname+ " "+ age;
    // }
    
    // @GetMapping("/holamundo2")
    // public String hello_world_4(@RequestParam String name, @RequestParam String lastname, @RequestParam int age) {
    //     return "Hello World "+name+ " "+ lastname+ " "+ age;
    // }

    @GetMapping
    public List<Personal> getAllPersonal() {
        return personalPostServices.findAll();
    }
}
