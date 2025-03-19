import java.util.*;

interface GPS {
    void getCurrentLocation();
    void updateLocation(String location);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Car is at the current location.");
    }

    @Override
    public void updateLocation(String location) {
        System.out.println("Car location updated to: " + location);
    }
}

class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Bike is at the current location.");
    }

    @Override
    public void updateLocation(String location) {
        System.out.println("Bike location updated to: " + location);
    }
}

class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Auto is at the current location.");
    }

    @Override
    public void updateLocation(String location) {
        System.out.println("Auto location updated to: " + location);
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C101", "John Doe", 10.0));
        vehicles.add(new Bike("B202", "Jane Smith", 5.0));
        vehicles.add(new Auto("A303", "Mike Johnson", 7.0));

        double distance = 15.0;
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            System.out.println("Estimated Fare: " + vehicle.calculateFare(distance));
            if (vehicle instanceof GPS) {
                ((GPS) vehicle).getCurrentLocation();
                ((GPS) vehicle).updateLocation("New Destination");
            }
            System.out.println();
        }
    }
}
