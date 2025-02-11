import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CarRentalService {

    private List<Car> cars;
    private List<Customer> customers;
    private List<BookedCarInformation> bookedCarInformations;

    public CarRentalService() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        bookedCarInformations = new ArrayList<>();
    }

    public void bookCar(Car car, Customer customer, int days) {
        if (car.getNoOfAvailableCars() > 0) {
            car.setNoOfAvailableCars(car.getNoOfAvailableCars() - 1);
            bookedCarInformations.add(new BookedCarInformation(car, customer, days));
        } else {
            System.out.println("Car is not available for rent");
        }
    }

    public void returnCar(Car car, BookedCarInformation bookedCarInformation) {
        car.setNoOfAvailableCars(car.getNoOfAvailableCars() + 1);
        bookedCarInformations.remove(bookedCarInformation);
    }

    public void addCars(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer cust) {
        customers.add(cust);
    }

    public void options() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== Welcome to our Car Rental System ===");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Available Cars");
            System.out.println("4. Exit");

            System.out.println("Enter your choice: ");
            int userChoice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (userChoice == 1) {
                System.out.println("== For renting a car, please provide the details ==");
                System.out.println("Enter your name: ");
                String customerName = sc.nextLine();

                System.out.println("Enter the Car ID you want to rent: ");
                String carID = sc.nextLine();

                System.out.println("Enter the number of days for rental: ");
                int days = sc.nextInt();
                sc.nextLine(); // Consume newline

                Customer customer = new Customer("CUSTOMER-" + (customers.size() + 1), customerName);
                addCustomer(customer);

                Optional<Car> optionalCar = cars.stream()
                        .filter(c -> c.getCarID().equalsIgnoreCase(carID) && c.getNoOfAvailableCars() > 0)
                        .findAny();

                if (optionalCar.isEmpty()) {
                    System.out.println("Car is not available. Please try another car.");
                    continue;
                }

                Car selectedCar = optionalCar.get();

                System.out.println("=== Bill Receipt ===");
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Car Brand: " + selectedCar.getBrand() + " Model: " + selectedCar.getModel());
                System.out.println("Rental Days: " + days);
                System.out.println("Total Price: " + selectedCar.calculatePrice(days));

                System.out.println("Confirm rental (Y/N): ");
                String confirmation = sc.next();

                if (confirmation.equalsIgnoreCase("Y")) {
                    bookCar(selectedCar, customer, days);
                    System.out.println("Car booking is successful.");
                } else {
                    System.out.println("Car booking is cancelled.");
                }

            } else if (userChoice == 2) {
                System.out.println("== Return a Car ==");
                System.out.println("Enter the Car ID you want to return: ");
                String carID = sc.nextLine();

                Optional<Car> optionalCar = cars.stream()
                        .filter(c -> c.getCarID().equals(carID))
                        .findAny();

                if (optionalCar.isEmpty()) {
                    System.out.println("Please provide valid car details.");
                    continue;
                }

                Car carToReturn = optionalCar.get();

                BookedCarInformation bookedCarInformation = bookedCarInformations.stream()
                        .filter(b -> b.getCar().equals(carToReturn))
                        .findFirst()
                        .orElse(null);

                if (bookedCarInformation == null) {
                    System.out.println("Car information not available. Please provide valid details.");
                    continue;
                }

                Customer cust = bookedCarInformation.getCustomer();
                returnCar(carToReturn, bookedCarInformation);
                System.out.println("Car returned successfully by " + cust.getName());

            } else if (userChoice == 3) {
                System.out.println("== Available Cars ==");
                cars.stream()
                        .filter(c -> c.getNoOfAvailableCars() > 0)
                        .forEach(car -> System.out.println(car.getCarID() + " - " + car.getBrand() + " " + car.getModel() + " " + car.getNoOfAvailableCars()));

            } else if (userChoice == 4) {
                System.out.println("Thank you for choosing us!");
                break;
            } else {
                System.out.println("Please provide a valid option.");
            }
        }
    }
}
