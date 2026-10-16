// Import all the needed classes
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

// Zoo class manages all animals and actions
public class Zoo {

    //Name of the zoo
    private String zooName;

    // List to store all animals
    private ArrayList<Animal> animals;

    // Constructor creates a zoo and empty animal list
    public Zoo(String zooName) {
        this.zooName = zooName;
        animals = new ArrayList<>();
    }

    // Performs daily care tasks for all animals
    public void performDailyCare() {
        for (Animal a : animals) {

            // Show which animal is being cared for
            System.out.println("Caring for " + a.getName());

            // If animal can fly, check its wings
            if (a instanceof Flyable) {
                ((Flyable) a).fly();
                ((Flyable) a).checkWings();
            }

            // If animal can swim, check water conditions
            if (a instanceof Swimmable) {
                ((Swimmable) a).swim();
                ((Swimmable) a).checkWaterHealth();
            }
        }
    }

    // Save all animals to a file
    public void saveAnimalsToFile() {

        try (FileWriter writer = new FileWriter("AnimalDetails.txt")) {

            for (Animal a : animals) {

                // Skip invalid animals
                if (a.getName() == null || a.getName().isEmpty() ||
                        a.getColour() == null || a.getColour().isEmpty() ||
                        a.getAge() <= 0 || a.getWeight() <= 0) {
                    continue;
                }

                String line = "";

                // Save each animal type in a specific format
                if (a instanceof Dog) {
                    Dog d = (Dog) a;
                    line = "Dog," + d.getName() + "," + d.getAge() + "," +
                            d.getColour() + "," + d.getWeight() + "," + d.getBreed();
                }
                else if (a instanceof Bird) {
                    Bird b = (Bird) a;
                    line = "Bird," + b.getName() + "," + b.getAge() + "," +
                            b.getColour() + "," + b.getWeight() + "," + b.getWingSpan();
                }
                else if (a instanceof Fish) {
                    Fish f = (Fish) a;
                    line = "Fish," + f.getName() + "," + f.getAge() + "," +
                            f.getColour() + "," + f.getWeight() + "," + f.getWaterType();
                }
                else if (a instanceof Cat) {
                    Cat c = (Cat) a;
                    line = "Cat," + c.getName() + "," + c.getAge() + "," +
                            c.getColour() + "," + c.getWeight() + "," + c.getFurType();
                }
                else if (a instanceof Dolphin) {
                    Dolphin d = (Dolphin) a;
                    line = "Dolphin," + d.getName() + "," + d.getAge() + "," +
                            d.getColour() + "," + d.getWeight() + "," + d.getSwimSpeed();
                }

                // Write the animal to file
                writer.write(line + "\n");
            }

            System.out.println("Animals saved to file.");

        } catch (IOException e) {
            System.out.println("Error saving animals.");
        }
    }

    // Load animals from file
    public void loadAnimalsFromFile() {

        try (Scanner fileScanner = new Scanner(new File("AnimalDetails.txt"))) {

            while (fileScanner.hasNextLine()) {

                // Read a line and split by commas
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                // Skip bad lines
                if (parts.length < 6) continue;

                // Read common values
                String type = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String colour = parts[3];
                double weight = Double.parseDouble(parts[4]);

                // Create correct object based on type
                if (type.equals("Dog")) {
                    String breed = parts[5];
                    animals.add(new Dog(name, age, colour, weight, breed));
                }
                else if (type.equals("Bird")) {
                    double wingSpan = Double.parseDouble(parts[5]);
                    animals.add(new Bird(name, age, colour, weight, wingSpan));
                }
                else if (type.equals("Fish")) {
                    String waterType = parts[5];
                    animals.add(new Fish(name, age, colour, weight, waterType));
                }
                else if (type.equals("Cat")) {
                    String furType = parts[5];
                    animals.add(new Cat(name, age, colour, weight, furType));
                }
                else if (type.equals("Dolphin")) {
                    double swimSpeed = Double.parseDouble(parts[5]);
                    animals.add(new Dolphin(name, age, colour, weight, swimSpeed));
                }
            }

            System.out.println("Animals loaded from file.");

        } catch (Exception e) {
            // Happens if file doesn't exist yet
            System.out.println("No previous data found.");
        }
    }

    // Save zoo name to file
    public void saveZooDetails() {
        try (FileWriter writer = new FileWriter("ZooDetails.txt")) {
            writer.write(zooName);
        } catch (IOException e) {
            System.out.println("Error saving zoo details.");
        }
    }

    // Add a new animal to the list
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    //remove animal by name
    public boolean removeAnimal(String name) {
        return animals.removeIf(a -> a.getName() != null &&
                a.getName().equalsIgnoreCase(name));
    }

    // Display all animals
    public void displayAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the zoo.");
            return;
        }

        for (Animal a : animals) {
            System.out.println(a.getDetails());
        }
    }

    // Make all animals make their sound
    public void makeAllSounds() {
        for (Animal a : animals) {
            System.out.println(a.makeSound());
        }
    }

    //sSearch for animal by name
    public Animal searchAnimal(String name) {
        for (Animal a : animals) {
            if (a.getName() != null &&
                    a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }

    //search animals by colour
    public ArrayList<Animal> searchByColour(String colour) {
        ArrayList<Animal> results = new ArrayList<>();

        for (Animal a : animals) {
            if (a.getColour() != null &&
                    a.getColour().equalsIgnoreCase(colour)) {
                results.add(a);
            }
        }

        return results;
    }

    //Returns list of animals
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    //modify animal details
    public boolean modifyAnimal(String name, Scanner scanner) {

        // Find the animal
        Animal a = searchAnimal(name);

        if (a == null) {
            return false;
        }

        int choice;

        do {
            //Menu for editing
            System.out.println("\nEditing: " + a.getName());
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Colour");
            System.out.println("4. Weight");
            System.out.println("5. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter new name: ");
                    a.setName(scanner.nextLine());
                    break;

                case 2:
                    System.out.print("Enter new age: ");
                    a.setAge(scanner.nextInt());
                    break;

                case 3:
                    System.out.print("Enter new colour: ");
                    scanner.nextLine();
                    a.setColour(scanner.nextLine());
                    break;

                case 4:
                    System.out.print("Enter new weight: ");
                    a.setWeight(scanner.nextDouble());
                    break;

                case 5:
                    System.out.println("Finished editing.");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        return true;
    }

    // Generate a report about the zoo
    public void generateReport() {

        System.out.println("\nZoo Name: " + zooName);

        int dogs = 0, birds = 0, fish = 0, cats = 0, dolphins = 0;

        ArrayList<String> colours = new ArrayList<>();

        for (Animal a : animals) {

            //Collect colours
            if (a.getColour() != null && !a.getColour().isEmpty()) {
                colours.add(a.getColour().toLowerCase());
            }

            // Count all the  animal types
            if (a instanceof Dog)
                dogs++;
            else if (a instanceof Bird)
                birds++;
            else if (a instanceof Fish)
                fish++;
            else if (a instanceof Cat)
                cats++;
            else if (a instanceof Dolphin)
                dolphins++;
        }

        //Print totals
        System.out.println("Dogs: " + dogs);
        System.out.println("Birds: " + birds);
        System.out.println("Fish: " + fish);
        System.out.println("Cats: " + cats);
        System.out.println("Dolphins: " + dolphins);

        //Find most common colour
        String dominant = "";
        int maxCount = 0;

        for (String c : colours) {
            int count = 0;
            for (String x : colours) {
                if (x.equals(c)) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                dominant = c;
            }
        }

        System.out.println("Dominant Colour: " + dominant);
    }

    //show the oldest animal
    public void showOldestAnimal() {

        if (animals.isEmpty()) {
            System.out.println("No animals available.");
            return;
        }

        //Start with first animal
        Animal oldest = animals.get(0);

        //Compare the  ages
        for (Animal a : animals) {
            if (a.getAge() > oldest.getAge()) {
                oldest = a;
            }
        }

        //print result
        System.out.println("Oldest Animal: " + oldest.getDetails());
    }
}