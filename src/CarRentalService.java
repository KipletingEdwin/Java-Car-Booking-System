import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CarRentalService {

    private List<Car> cars;
    private  List<Customer> customers;

    public CarRentalService() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public  void  bookedCar(){

    }

    public  void  addCars(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer cust){
        customers.add(cust);
    }

    public  void  options(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("=== Welcome to our Car Rental System ===");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a car");
            System.out.println("3. Available Car");
            System.out.println("Exit");

            System.out.println("Enter your choice: ");

            int userChoice = sc.nextInt();
            sc.nextLine();

            if(userChoice == 1){
                System.out.println("==  For renting a car, please provide below details ==");
                System.out.println(" Enter your name: ");
                String customerName = sc.nextLine();

                System.out.println("Enter the Car ID you want to rent: ");
                String carID = sc.nextLine();

                System.out.println("Enter the number of days for rental");
                int days = sc.nextInt();

                Customer customer = new Customer("CUSTOMER-" + (customers.size() + 1), customerName);
                addCustomer(customer);

                        Optional<Car> optionalCar = cars.stream()
                        .filter(c -> c.getCarID().equalsIgnoreCase(carID) && c.getNoOfAvailableCars() > 0)
                        .findAny();

                        if(optionalCar.isEmpty()){
                            System.out.println("Car is not available. Please try to book another car");
                            options();
                            return;
                        }

                        Car selectedCar = optionalCar.get();

                System.out.println("=== Bill Receipt ==");
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Customer ID: " + customer.getId());
                System.out.println("Car Brand: " + selectedCar.getBrand() + "Model: " + selectedCar.getModel());

                System.out.println("Rental Days: " + days);
                System.out.println("Total Price: " + selectedCar.calculatePrice(days));

                System.out.println("Confirm rental (Y/N: " );
                String confirmation = sc.next();

                if (confirmation.equalsIgnoreCase("Y")){
                    //Book a Car
                    System.out.println("Car booking is successful");

                } else{
                    System.out.println("Car booking is cancelled");
                }



            }
        }
    }
}
