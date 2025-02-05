import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalService {

    private List<Car> cars;

    public CarRentalService() {
        cars = new ArrayList<>();
    }

    public  void  addCars(Car car){
        cars.add(car);
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

            }

            



        }
    }
}
