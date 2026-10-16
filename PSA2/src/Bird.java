// Bird class extends Animal inherits shared properties
// and implements Flyable
public class Bird extends Animal implements Flyable {

    //Extra property specific to birds
    private double wingSpan;

    //Constructor used to create a Bird object
    public Bird(String name, int age, String colour, double weight, double wingSpan) {
        // Call the parent animal constructor
        super(name, age, colour, weight);

        //Set the bird's wingspan
        this.wingSpan = wingSpan;
    }

    //Override the makeSound method from Animal
    @Override
    public String makeSound() {
        //Returns the birds sound with some details
        return "Chirp! I am " + getName() + ", a " + getAge() + " year old bird.";
    }

    //Method from Flyable interface
    @Override
    public void fly() {
        //Shows that the bird is flying
        System.out.println(getName() + " is flying.");
    }

    //Method from Flyable interface
    @Override
    public void checkWings() {
        //Simulates checking the bird's wings
        System.out.println("Checking wings of " + getName());
    }

    //Getter returns the wingspan
    public double getWingSpan() {
        return wingSpan;
    }

    //Setter updates wingspan with validation
    public void setWingSpan(double wingSpan) {
        //Only allow positive values
        if (wingSpan > 0) {
            this.wingSpan = wingSpan;
        }
    }
}