package com.example.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.models.Personal;
import com.example.api.repository.PersonalRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonalServices {
    @Autowired
    private PersonalRepository personalRepository;

    public List<Personal> findAll() {
        List<Personal> personalToReturn = new ArrayList<>();
        personalToReturn = personalRepository.findAll();
        return personalToReturn;
    }

    /**
     * Deletes a Personal by its ID.
     * First, checks if the Personal exists in the database.
     * If it does not exist, throws an EntityNotFoundException.
     * 
     * @param id The ID of the Personal to delete.
     * @throws EntityNotFoundException if the Personal does not exist.
     */

    public void deletePersonalById(Long id) {
        if (!personalRepository.existsById(id)) {
            throw new EntityNotFoundException("Staff not found");
        }
        personalRepository.deleteById(id);
    }

    /*
     * a function is created that returns a Personal object, it receives 
     *  an object of type Personal as a parameter
     * 
     * return personalRepository.save(personal);
     *  
     * Calls the save method of the repository PersonalRepository
     * save the object to the database returns the saved object with 
     * the id assigned by the database
     * 
     */
    public Personal createPersonal (Personal personal){

        return personalRepository.save(personal);
    }
}
