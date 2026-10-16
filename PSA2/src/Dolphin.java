// dolphin extends animal, inherits shared proerties
// implaments swimable
public class Dolphin extends Animal implements Swimmable {

    // extra property specific to dolphihns
    private double swimSpeed;

    // constructor used to create dolphin objects
    public Dolphin(String name, int age, String colour, double weight, double swimSpeed) {
        //call the parent
        super(name, age, colour, weight);
        this.swimSpeed = swimSpeed;
    }


    //override the sound method from animal
    @Override
    public String makeSound() {
        //returns the dolphin sound
        return "Dit-dit-dit! I am " + getName() + ", a " + getAge() + " year old dolphin.";
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming.");
    }

    @Override
    public void checkWaterHealth() {
        System.out.println("Checking the water conditions for " + getName());
    }


    public double getSwimSpeed() {
        return swimSpeed;
    }
    //swim validation
    public void setSwimSpeed(double swimSpeed) {
        if(swimSpeed > 0 && swimSpeed <= 40) {
            this.swimSpeed = swimSpeed;
        }
        else {
            System.out.println("Invalid swim speed");
        }
    }
}


