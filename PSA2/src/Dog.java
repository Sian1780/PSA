// Dog class extends Animal inherits name, age, colour, weight
public class Dog extends Animal {

    // Extra property specific to dogs
    private String breed;

    // Constructor: used to create a Dog object
    public Dog(String name, int age, String colour, double weight, String breed) {
        // Call the parent constructor
        super(name, age, colour, weight);

        // Set the dogs breed
        this.breed = breed;
    }

    // Override the makeSound method from Animal
    @Override
    public String makeSound() {
        // Returns the dog's sound with some details
        return "Woof! I am " + getName() + ", a " + getAge() + " year old dog.";
    }

    //getter returns the dog's breed
    public String getBreed() {
        return breed;
    }

    // setter updates the breed
    public void setBreed(String breed) {
        // Only update if the breed is not empty
        if (!breed.isEmpty()) {
            this.breed = breed;
        }
    }
}