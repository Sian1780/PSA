// Abstract class means cannot create objects from this directly
// It is a base class for all animal types
public abstract class Animal {

    // Common properties shared by all animals
    private String name;
    private int age;
    private String colour;
    private double weight;


    //Constructor sets up the basic animal details
    public Animal(String name, int age, String colour, double weight) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.weight = weight;
    }

    //Abstract method every animal MUST have its own sound
    public abstract String makeSound();

    //Getter for name
    public String getName() {
        return name;
    }

    //Setter for name with validation
    public void setName(String name) {
        // Check name is not null or empty
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name");
        }
    }

    //Getter for age
    public int getAge() {
        return age;
    }

    //Setter for age with limits
    public void setAge(int age) {
        // nly allow realistic ages
        if (age >= 0 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    //Getter for colour
    public String getColour() {
        return colour;
    }

    //Setter for colour with validation
    public void setColour(String colour) {
        if (colour != null && !colour.trim().isEmpty()) {
            this.colour = colour;
        } else {
            System.out.println("Invalid colour");
        }
    }

    //Getter for weight
    public double getWeight() {
        return weight;
    }

    //setter for weight with validation
    public void setWeight(double weight) {
        // Weight must be greater than 0
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Invalid weight");
        }
    }

    //Returns a simple description of the animal
    public String getDetails() {
        return name + ", Age: " + age + ", Colour: " + colour + ", Weight: " + weight;
    }
}