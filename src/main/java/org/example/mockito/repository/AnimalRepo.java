package org.example.mockito.repository;

import org.example.mockito.model.Animal;

import java.util.List;

public interface AnimalRepo {
    void save(Animal animal);

    Animal findById(Long id);


    void  deleteById(Long id);

    List<Animal> findAll();
}
