public class BookedCarInformation {
    private Car car;
    private Customer customer;
    private int days;

    public BookedCarInformation(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public int getDays() {
        return days;
    }

    @Override
    public String toString() {
        return "BookedCarInformation{" +
                "Car='" + car.getBrand() + " " + car.getModel() + '\'' +
                ", Customer='" + customer.getName() + '\'' +
                ", Days=" + days +
                '}';
    }
}
