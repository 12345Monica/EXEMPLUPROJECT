package org.example.mockito.service;


import org.example.mockito.model.Animal;
import org.example.mockito.repository.AnimalRepo;
import org.example.mockito.repository.AnimalRepoImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/* Lipiciul dintre JUnit 4 si Mockito JUnit
 initializarea atnotatiile de mocking -> @Mock,@InjecteMocks
 @Mocks creeaza o copie FALSA  a yegarului

 */

@ExtendWith(MockitoExtension.class)
class AnimalsServiceTest {

    @Mock
    private AnimalRepo animalRepo;

    @InjectMocks
    private AnimalRepoImpl animalService;

    @Test
    void test_saveAnimal() {
        Animal animal = new Animal("Lion"," Mammal");

        animalService.save(animal);

        verify(animalRepo, times(1)).save(animal);
    }

     @Test
    void test_getAnimalById() {
        Animal animal = new Animal("Elephant", "Mammal");
        when(animalRepo.getById(1L))
                .thenReturn(animal);
        Animal result =animalService.getById(1L);

        assertThat(result)
                .isNotNull()
                .isEqualTo(animal);
        verify(animalRepo,times(1)).getById(1L);
     }

     @ParameterizedTest
    @ValueSource(longs = {1L,2L,33L})
    void  test_deleteById(long id) {
        animalService.deleteById(id);

        verify(animalRepo,times(1)).deleteById(id);
     }
}
