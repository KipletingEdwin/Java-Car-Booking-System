public class Car {

    private  String model;
    private  String brand;
    private  String carID;
    private  double pricePerDay;
    private  int noOfAvailableCars;

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

    public  double calculatePrice(int days){
        return  pricePerDay * days;

    }

    // Constructor
    public Car() {

    }


}
