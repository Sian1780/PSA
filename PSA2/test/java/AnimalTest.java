import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AnimalTest {

    @Test
    void testAddAnimal() {
        // Arrange
        Zoo zoo = new Zoo("Test Zoo");
        Dog dog = new Dog("Rex", 5, "Brown", 20.0, "Labrador");

        // Act
        zoo.addAnimal(dog);

        // Assert
        assertEquals(1, zoo.getAnimals().size());
    }

    @Test
    void testSearchAnimalFound() {
        //Arrange
        Zoo zoo = new Zoo("Test Zoo");
        zoo.addAnimal(new Dog("Rex", 5, "Brown", 20.0, "Labrador"));

        //Act
        Animal result = zoo.searchAnimal("Rex");

        //Assert
        assertNotNull(result);
        assertEquals("Rex", result.getName());
    }

    @Test
    void testInvalidWeight() {
        //Arrange
        Dog dog = new Dog("Rex", 5, "Brown", 20.0, "Labrador");
        //Act
        dog.setWeight(-5);
        //Assert
        assertEquals(20.0, dog.getWeight());
    }

    @Test
    void testSetAgeBoundary() {
        //Arrange
        Dog dog = new Dog("Rex", 5, "Brown", 20.0, "Labrador");
        //Act
        dog.setAge(0);
        //Assera
        assertEquals(0, dog.getAge());
    }

    @Test
    void testSearchAnimalNotFound() {
        //Arrange
        Zoo zoo = new Zoo("Test Zoo");
        //Act
        Animal result = zoo.searchAnimal("Rubble");
        //Assert
        assertNull(result);
    }
    @Test
    void testRemoveAnimal() {
        //Assertt
        Zoo zoo = new Zoo("Test Zoo");
        zoo.addAnimal(new Dog("Rex", 5, "Brown", 20.0, "Labrador"));

        //Act
        boolean removed = zoo.removeAnimal("Rex");

        //Assert
        assertTrue(removed);
        assertEquals(0, zoo.getAnimals().size());
    }


}


