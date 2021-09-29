package cars;

import java.util.ArrayList;

public class ShowRoom {
    private ArrayList<Car> cars = new ArrayList<Car>();
    //1. addCar
    public String addCar(Car car) {
        this.cars.add(car);
        return car.name + "Added sucesfully";
    }
    //2. getAllCars
    public ArrayList<Car> getAllCars() {
        return cars;
    }

//    //3. getSingleCar
//    public Car getSingleCar (int carId) {
//        return this.cars.get(carId);
//    }

    // get single car
    public String getSingleCar (int carIndex) {
        try {
            Car car = this.cars.get(carIndex);
            return "Car number: " + car.id + "\nCar name: " + car.name + "\nCar Manufacturer: " + car.manufacturer + "\nCar type: " + car.type;
        } catch (Exception ex) {
            return "Unable to find a car. Please try again witha valid car index!";
        }
    }
    //4. removeCar
    public String removeCar (int carId) {
    try {
        cars.remove(carId);
    } catch (Exception ex) {
        return "Unable to remove speecified car";
    }
    return "car removed successfuly";
    }

    // find car by name
    public Car findByName(String name) {
        //loop over the cars in the showroom and chech each name equals to specified name
        //return the car if true
        for(Car car: cars){
            if (car.name.equals(name)){
                return car;

            }
        }
        return null;
    }
    // Wiew all cars , view single car

    public Car updateCar(int carIndex, Car car) {
        return cars.set(carIndex, car);
    }
    public Car findByType(String type) {
        for(Car car: cars){
            if (car.type.equals(type)){
                return car;

            }
        }
        return null;
    }
    public Car findByManufacturer(String manufacturer) {
        for(Car car: cars){
            if (car.manufacturer.equals(manufacturer)){
                return car;

            }
        }
        return null;
    }
}
