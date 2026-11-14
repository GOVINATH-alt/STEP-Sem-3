public class CampusParkingCalculator {

    public abstract static class Vehicle {
        String type;
        int hours;

        public Vehicle(String type, int hours) {
            this.type = type;
            this.hours = hours;
        }

        public abstract double calculateCharge();
    }

    public static class Bike extends Vehicle {
        public Bike(int hours) { super("BIKE", hours); }
        @Override
        public double calculateCharge() {
            return hours * 10.0;
        }
    }

    public static class Car extends Vehicle {
        public Car(int hours) { super("CAR", hours); }
        @Override
        public double calculateCharge() {
            return 30.0 + (Math.max(0, hours - 1) * 20.0);
        }
    }

    public static class Truck extends Vehicle {
        public Truck(int hours) { super("TRUCK", hours); }
        @Override
        public double calculateCharge() {
            return Math.max(100.0, hours * 50.0);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 2: The Campus Parking Charge Calculator ===");
        Vehicle[] vehicles = {
            new Bike(3),
            new Car(4),
            new Truck(1),
            new Car(1)
        };

        double grandTotal = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f%n", v.type, charge);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
