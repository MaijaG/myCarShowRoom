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
            System.out.println("5. Find car by name");
            System.out.println("6. Remove car by name");
            System.out.println("7. Update car by name, type, manufacturer");
            System.out.println("8. Search car by name, type, manufacturer");
            System.out.println("\nEnter Quit to end program...");
            System.out.println("Choose a number: ");
            userInput = scanner.nextLine();
            switch (userInput) {
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
                case "5":
                    findCarByName();
                    break;
                case "6":
                    removeCarByName();
                    break;
                case "7":
                    updateCar();
                    break;
                case "8":
                    searchCar();
                    break;
                default:
                    break;

            }
        } while (!userInput.equals("Quit"));

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
        for (Car car : allCars) {
            System.out.println(car.name + "\t" + car.manufacturer + "\t" + car.type + ". \nThe ID is: " + car.id);
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

    void findCarByName() {
        System.out.println("Find car by name..");
        System.out.println("Enter car name: ");

        Scanner scanner = new Scanner(System.in);
        String carName = scanner.nextLine();
        Car car = showRoom.findByName(carName);

        System.out.println("car ID" + car.id);
        System.out.println("car name: " + car.name);
        System.out.println("car manufacturer: " + car.manufacturer);
        System.out.println("car type: " + car.type);

    }

    void removeCarByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Remove car by name");
        System.out.println("Enter car name: ");
        String carName = scanner.nextLine();
        Car car = showRoom.findByName(carName);

        int carIndex = showRoom.getAllCars().indexOf(car);
        System.out.println(showRoom.removeCar(carIndex));
    }

    void updateCar() {
        System.out.println("Update car..");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the property you would like to change: ");
        String property = scanner.nextLine();

        Car car = null;

        switch (property) {
            case "name":
                System.out.println("Enter car name: ");
                String carName = scanner.nextLine();
                car = showRoom.findByName(carName);
                System.out.println("Enter the new value of: " + property);
                String value = scanner.nextLine();
                car.name = value;
                break;
            case "type":
                System.out.println("Enter car type: ");
                String type = scanner.nextLine();
                car = showRoom.findByType(type);
                String value1 = scanner.nextLine();
                System.out.println("Enter the new value: " + property);
                car.type = value1;
                break;
            case "manufacturer":
                System.out.println("Enter car manufacturer: ");
                String manufacturer = scanner.nextLine();
                car = showRoom.findByManufacturer(manufacturer);
                String value2 = scanner.nextLine();
                System.out.println("Enter the new value: " + property);
                car.manufacturer = value2;
                break;
            default:
                System.out.println("Cannot Update car");
        }
        int carIndex = showRoom.getAllCars().indexOf(car);
        showRoom.updateCar(carIndex, car);
        System.out.println(car.name + "updated sucesfully");

    }

    void searchCar() {
        System.out.println("Search  car..");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the property you would like to search for(name, type or manufacurer): ");
        //searchByType
        //searchByManufacturer
        //searchByName
        String property = scanner.nextLine();
        Car car = null;
        switch (property) {
            case "name":
                System.out.println("Enter car name: ");
                String carName = scanner.nextLine();
                car = showRoom.findByName(carName);

                break;
            case "type":
                System.out.println("Enter car type: ");
                String type = scanner.nextLine();
                car = showRoom.findByType(type);

                break;
            case "manufacturer":
                System.out.println("Enter car manufacturer: ");
                String manufacturer = scanner.nextLine();
                car = showRoom.findByManufacturer(manufacturer);

                break;
            default:
                System.out.println("Cannot find a car");
        }
        System.out.println("car ID" + car.id);
        System.out.println("car name: " + car.name);
        System.out.println("car manufacturer: " + car.manufacturer);
        System.out.println("car type: " + car.type);

        //searchByType
        //searchByManufacturer
        //searchByName

        //create a method to update by car type
        // create method to update by manufacturer

        //Asignment create search menu where user can select the property they want to search for. i.e "manufacturer" ask user to put in the property manufacturer i.e. volvo
        //
    }
}
