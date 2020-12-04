package frogger.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

public class TestAnimal {
    @Test

    public void testFocus() {
        ArrayList<Animal> animals = new ArrayList<>();
        for(int i=0;i<4;i++) {
            Animal animal = new Animal("", null);
            animals.add(animal);
        }
        assertEquals(Animal.getInstance(), null);
        animals.get(2).focus();
        assertEquals(Animal.getInstance(), animals.get(2));
    }
}