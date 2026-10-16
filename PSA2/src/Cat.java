//Cat class inherits from animal (gets name,age,colour,weight)
public class Cat extends Animal {

    //extra property for cats only
    private String furType;

    //constructor used to create a new cat obj
    public Cat(String name, int age, String colour, double weight, String furType) {
       // call the parent constructor to get all the shared properties
        super(name, age, colour, weight);
        //set the cats fur type
        this.furType = furType;
    }


    // this method overrides  the makesound() method in animal
    @Override
    public String makeSound() {
        return "Meow! I am " + getName() + ", a " + getAge() + " year old cat.";
    }

    // getter method to return the fur type of the cat
    public String getFurType() {
        return furType;
    }
}