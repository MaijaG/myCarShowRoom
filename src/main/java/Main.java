import cars.Car;
import cars.ShowRoom;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
//create cars, view cars, view a specific car, remove car


public class Main {
    ShowRoom showRoom = new ShowRoom();
    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
    void showMenu() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        do {
            System.out.println("Welcome to the showroom, please choose the activity: ");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3. View Single car");
            System.out.println("4. Remove car");
            System.out.println("\nEnter Quit to end program...");
            System.out.println("Choose a number: ");
            userInput = scanner.nextLine();
            switch (userInput){
                case "Quit":
                    System.out.println("Exit application");
                    break;
                case "1":
                    addCar();
                    break;
                case "2":
                    viewAllCars();
                    break;
                case "3":
                    viewSingleCar();
                    break;
                case "4":
                    removeCar();
                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("Quit"));

        return;
    }
    void addCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add car");

        Car car = new Car();

        System.out.println("Enter name: ");
        car.name = scanner.nextLine();

        System.out.println("Enter manufacturer: ");
        car.manufacturer = scanner.nextLine();

        System.out.println("Enter Type");
        car.type = scanner.nextLine();

        car.id = UUID.randomUUID();

        String message = showRoom.addCar(car);

        System.out.println(message);
    }
    void viewAllCars() {
        ArrayList<Car> allCars = showRoom.getAllCars();
        System.out.println("All Available Cars");
        System.out.println("Car Name\t Manufacturer\t car Type");
        for (Car car: allCars){
            System.out.println(car.name + "\t"+ car.manufacturer + "\t" + car.type+ ". \nThe ID is: " + car.id);
        }

    }
    void viewSingleCar() {
        System.out.println("View Car");
        System.out.println("Please provide a car ID: ");
        Scanner scanner = new Scanner(System.in);
        int carId = scanner.nextInt();

//        Car car = showRoom.getSingleCar(carId);
//        System.out.println("Car Number: " + car.id);
//        System.out.println("Car Name: " + car.name);
//        System.out.println("Car Manufacturer: " + car.manufacturer);
//        System.out.println("Car Type: " + car.type);
        String message = showRoom.getSingleCar(carId);
        System.out.println(message);

    }

void removeCar() {
    System.out.println("Remove car");
    System.out.println("Please provide a car ID to be removed: ");
    Scanner scanner = new Scanner(System.in);
    int carID = scanner.nextInt();

    String remove = showRoom.removeCar(carID);
    System.out.println(remove);

    }
    //Change made on the remote server, and isnt yet on my maschine
    }
