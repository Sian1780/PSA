/*import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Zoo zoo = new Zoo("ZooMore");
        zoo.loadAnimalsFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n   Main Menu   ");
            System.out.println("1) Add Animal");
            System.out.println("2) View Animals");
            System.out.println("3) Remove Animal");
            System.out.println("4) Search Animal");
            System.out.println("5) Make All Sounds");
            System.out.println("6) Edit Animal");
            System.out.println("7) Perform Daily Care");
            System.out.println("8) Generate Report");
            System.out.println("9) Exit");

            System.out.print("Enter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number:");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("1) Dog  2) Bird  3) Fish  4) Cat  5) Dolphin");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid choice. Enter a number:");
                        scanner.next();
                    }
                    int animalType = scanner.nextInt();
                    scanner.nextLine();

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

                    System.out.print("Colour: ");
                    String colour = scanner.nextLine();

                    // Validation before adding
                    if (name.isEmpty() || colour.isEmpty() || age <= 0 || weight <= 0) {
                        System.out.println("Invalid animal. Not added.");
                        break;
                    }

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

                    System.out.println("The animal has been added!");

                    zoo.saveAnimalsToFile();
                    zoo.saveZooDetails();
                    break;

                case 2:
                    zoo.displayAnimals();
                    break;

                case 3:
                    System.out.print("Enter the name to remove: ");
                    String removeName = scanner.nextLine();

                    if (zoo.removeAnimal(removeName)) {
                        System.out.println("Animal removed");
                    } else {
                        System.out.println("Animal not found");
                    }
                    break;

                case 4:
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
                    zoo.makeAllSounds();
                    break;

                case 6:
                    System.out.print("Enter the animal name to modify: ");
                    String modifyName = scanner.nextLine();

                    if (zoo.modifyAnimal(modifyName, scanner)) {
                        System.out.println("Animal updated");
                    } else {
                        System.out.println("Animal not found");
                    }
                    break;

                case 7:
                    zoo.performDailyCare();
                    break;

                case 8:
                    zoo.generateReport();
                    break;

                case 9:
                    zoo.saveAnimalsToFile();
                    zoo.saveZooDetails();
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 9);

        scanner.close();
    }
}

*/
