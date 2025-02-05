//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Car hondaCar = new Car();
        hondaCar.setModel("Vitz");
        hondaCar.setBrand("Honda");
        hondaCar.setCarID("CAR-1");
        hondaCar.setPricePerDay(500);
        hondaCar.setNoOfAvailableCars(2);

        Car toyotaCar = new Car();
        toyotaCar.setModel("Harrier");
        toyotaCar.setBrand("Toyota");
        toyotaCar.setCarID("CAR-2");
        toyotaCar.setPricePerDay(700);
        toyotaCar.setNoOfAvailableCars(5);

        Car nissanCar = new Car();
        nissanCar.setModel("Xtrail");
        nissanCar.setBrand("Nissan");
        nissanCar.setCarID("CAR-3");
        nissanCar.setPricePerDay(500);
        nissanCar.setNoOfAvailableCars(3);

        CarRentalService carRentalService = new CarRentalService();
        carRentalService.addCars(hondaCar);
        carRentalService.addCars(toyotaCar);
        carRentalService.addCars(nissanCar);



    }
}