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
}
