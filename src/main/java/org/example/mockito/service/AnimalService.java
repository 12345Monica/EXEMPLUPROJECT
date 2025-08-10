package org.example.mockito.service;

import org.example.mockito.model.Animal;

import java.util.List;

public interface AnimalService {

    void saveAnimal(Animal animal);
    Animal getById(Long id);
    List<Animal> getAllAnimals();
    void deleteById(Long id);
}
