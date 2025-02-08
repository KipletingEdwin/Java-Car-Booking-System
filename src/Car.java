public class Car {

    private String model;
    private String brand;
    private String carID;
    private double pricePerDay;
    private int noOfAvailableCars;

    // Default Constructor
    public Car() {}

    // Parameterized Constructor
    public Car(String model, String brand, String carID, double pricePerDay, int noOfAvailableCars) {
        this.model = model;
        this.brand = brand;
        this.carID = carID;
        this.pricePerDay = pricePerDay;
        this.noOfAvailableCars = noOfAvailableCars;
    }

    // Getters
    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarID() {
        return carID;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNoOfAvailableCars() {
        return noOfAvailableCars;
    }

    // Setters
    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setNoOfAvailableCars(int noOfAvailableCars) {
        this.noOfAvailableCars = noOfAvailableCars;
    }

    // Calculate total rental price
    public double calculatePrice(int days) {
        return pricePerDay * days;
    }

    // toString() method for easy debugging
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", carID='" + carID + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", noOfAvailableCars=" + noOfAvailableCars +
                '}';
    }
}
