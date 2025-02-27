package com.example.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.models.Personal;
import com.example.api.services.PersonalServices;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/personal")

public class PersonalController {
    @Autowired
    private PersonalServices personalPostServices;

    @GetMapping
    public List<Personal> getAllPersonal() {
        return personalPostServices.findAll();
    }
    /**
     * Deletes a Personal by its ID.
     * If the Personal does not exist, returns a 404 Not Found response.
     * 
     * @param id The ID of the Personal to be deleted.
     * @return ResponseEntity with success or error message.
     */

    // It listens the DELETE request at "/api/personal/{id}" and executes the deletePersonal method
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deletePersonal(@PathVariable Long id) {
        try {
            personalPostServices.deletePersonalById(id);
            return ResponseEntity.ok("Staff with id "+ id + " successfully removed");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
        }
    }

/*
 * @PostMapping this annotation defines the endpoint to create a new record
 * 
 * a createPersonal function is created that receives a Personal object as a parameter
 * @RequestBody this annotation receives the JSON and converts it to a Java object
 * 
 * return personalPostServices.createPersonal(personal);  calls another function within 
 * the PersonalServices service to save the object to the database and returns the saved object
 */
    @PostMapping
    public Personal createPersonal(@RequestBody Personal personal){
        return  personalPostServices.createPersonal(personal);
    }
}
