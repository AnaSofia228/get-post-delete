package com.example.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.models.Personal;
import com.example.api.repository.PersonalRepository;

@Service
public class PersonalServices {
    @Autowired
    private PersonalRepository personalRepository;

    public List<Personal> findAll() {
        List<Personal> personalToReturn = new ArrayList<>();
        personalToReturn = personalRepository.findAll();
        return personalToReturn;
    }
}
