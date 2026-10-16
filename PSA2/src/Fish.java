// Fish class extends Animal
// and implements Swimmable
public class Fish extends Animal implements Swimmable {

    //Extra property specific to fish
    private String waterType;

    //Constructor used to create a Fish object
    public Fish(String name, int age, String colour, double weight, String waterType) {
        //Call the parent animal constructor
        super(name, age, colour, weight);

        //Set the type of water the fish lives in
        this.waterType = waterType;
    }

    //Override the makeSound method from Animal
    @Override
    public String makeSound() {
        //Returns the fish "sound" with some details
        return "Pop! I am " + getName() + ", a " + getAge() + " year old fish.";
    }

    //Method from Swimmable interface
    @Override
    public void swim() {
        //Shows that the fish is swimming
        System.out.println(getName() + " is swimming.");
    }

    //Method from Swimmable interface
    @Override
    public void checkWaterHealth() {
        //Simulates checking the water condition
        System.out.println("Checking water for " + getName());
    }

    //Getter returns the water type
    public String getWaterType() {
        return waterType;
    }

    //Setter updates water type
    public void setWaterType(String waterType) {
        //Only update if not empty
        if (!waterType.isEmpty()) {
            this.waterType = waterType;
        }
    }
}