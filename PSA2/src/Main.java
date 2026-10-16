import java.util.ArrayList;
import java.util.Scanner;

//My main class where program starts
public class Main {

    public static void main(String[] args) {

        //creates an object of Zoo and loads all the saved animals from filer
        Zoo zoo = new Zoo("ZooMore");
        zoo.loadAnimalsFromFile();

        //scanner used to get user inout
        Scanner scanner = new Scanner(System.in);
        int choice;

        //loop runs until user chooses to exit
        do {
            //show all menu options
            System.out.println("\n   Main Menu   ");
            System.out.println("1) Add Animal");
            System.out.println("2) View Animals");
            System.out.println("3) Remove Animal");
            System.out.println("4) Search Animal by Name");
            System.out.println("5) Search Animal by Colour");
            System.out.println("6) Make All Sounds");
            System.out.println("7) Edit Animal");
            System.out.println("8) Perform Daily Care");
            System.out.println("9) Generate Report");
            System.out.println("10) Show Oldest Animal");
            System.out.println("11) Exit");

            System.out.print("Enter choice: ");

            //makes sure a number is entered
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number:");
                scanner.next();
                //clears wrong inout
            }
            choice = scanner.nextInt();
            scanner.nextLine();


            //checking which option was selected
            switch (choice) {

                case 1:
                    System.out.println("1) Dog  2) Bird  3) Fish  4) Cat  5) Dolphin");

                    //validate the input
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid choice. Enter a number:");
                        scanner.next();
                    }
                    int animalType = scanner.nextInt();
                    scanner.nextLine();

                    // get the basic animals details
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid age. Enter a number:");
                        scanner.next();
                    }
                    int age = scanner.nextInt();

                    System.out.print("Weight (kg): ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid weight. Enter a number:");
                        scanner.next();
                    }

                    double weight = scanner.nextDouble();
                    scanner.nextLine();

                    //make sure weight is>0
                    while (weight <= 0) {
                        System.out.println("Weight must be greater than 0. Try again:");

                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid weight. Enter a number:");
                            scanner.next();
                        }

                        weight = scanner.nextDouble();
                        scanner.nextLine();
                    }

                    System.out.print("Colour: ");
                    String colour = scanner.nextLine();

                    if (name.isEmpty() || colour.isEmpty() || age <= 0 || weight <= 0) {
                        System.out.println("Invalid animal. Not added.");
                        break;
                    }

                    // create the correct animal type based on uiser choice
                    if (animalType == 1) {
                        System.out.print("Breed: ");
                        String breed = scanner.nextLine();
                        zoo.addAnimal(new Dog(name, age, colour, weight, breed));
                    }

                    else if (animalType == 2) {
                        System.out.print("Wingspan (mm): ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid wingspan. Enter a number:");
                            scanner.next();
                        }
                        double wingSpan = scanner.nextDouble();
                        scanner.nextLine();
                        zoo.addAnimal(new Bird(name, age, colour, weight, wingSpan));
                    }

                    else if (animalType == 3) {
                        System.out.print("Water type: ");
                        String waterType = scanner.nextLine();
                        zoo.addAnimal(new Fish(name, age, colour, weight, waterType));
                    }

                    else if (animalType == 4) {
                        System.out.print("Fur type: ");
                        String furType = scanner.nextLine();
                        zoo.addAnimal(new Cat(name, age, colour, weight, furType));
                    }

                    else if (animalType == 5) {
                        System.out.print("Swim speed (mph): ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid speed. Enter a number:");
                            scanner.next();
                        }
                        double swimSpeed = scanner.nextDouble();
                        scanner.nextLine();
                        zoo.addAnimal(new Dolphin(name, age, colour, weight, swimSpeed));
                    }

                    else {
                        System.out.println("Invalid animal type.");
                        break;
                    }

                    // confirm the animal was added to the file
                    System.out.println("The animal has been added!");

                    zoo.saveAnimalsToFile();
                    zoo.saveZooDetails();
                    break;

                case 2:
                    //show all animals in the zoo
                    zoo.displayAnimals();
                    break;

                case 3:
                    //remove animal by its name
                    System.out.print("Enter the name to remove: ");
                    String removeName = scanner.nextLine();

                    if (zoo.removeAnimal(removeName)) {
                        System.out.println("Animal removed");
                    } else {
                        System.out.println("Animal not found");
                    }
                    break;

                case 4:
                    //search animal by name
                    System.out.print("Enter the name to search: ");
                    String searchName = scanner.nextLine();

                    Animal found = zoo.searchAnimal(searchName);

                    if (found != null) {
                        System.out.println(found.getDetails());
                        System.out.println(found.makeSound());
                    } else {
                        System.out.println("Animal not found");
                    }
                    break;

                case 5:
                    //search by colour
                    System.out.print("Enter colour to search: ");
                    String searchColour = scanner.nextLine();

                    ArrayList<Animal> results = zoo.searchByColour(searchColour);

                    if (results.isEmpty()) {
                        System.out.println("No animals found.");
                    } else {
                        //loop thriugh the animlas and print each one found
                        for (Animal a : results) {
                            System.out.println(a.getDetails());
                            System.out.println(a.makeSound());
                        }
                    }
                    break;

                case 6:
                    // animals make their sound
                    zoo.makeAllSounds();
                    break;

                case 7:
                    //edit an animal that already exist
                    System.out.print("Enter the animal name to modify: ");
                    String modifyName = scanner.nextLine();

                    if (zoo.modifyAnimal(modifyName, scanner)) {
                        System.out.println("Animal updated");
                    } else {
                        System.out.println("Animal not found");
                    }
                    break;

                case 8:
                    //perform the daily tasks
                    zoo.performDailyCare();
                    break;

                case 9:
                    // report generated about the zoo
                    zoo.generateReport();
                    break;

                case 10:
                    // show the oldest animal
                    zoo.showOldestAnimal();
                    break;

                case 11:
                    //save the data and exit
                    zoo.saveAnimalsToFile();
                    zoo.saveZooDetails();
                    System.out.println("Exiting...");
                    break;

                default:
                    // user enters an invalid input
                    System.out.println("Invalid choice");
            }

        } while (choice != 11);
        //loop until user exits

        //close the scanner
        scanner.close();
    }
}