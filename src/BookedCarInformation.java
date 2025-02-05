public class BookedCarInformation {

    private  Customer customer;
    private  Car car;
    private  int days;

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public int getDays() {
        return days;
    }

    public BookedCarInformation(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.days = days;
    }

}
