public class Booking {
    private Show show;
    private Customer customer;

    public Booking(Show show, Customer customer){
        this.show = show;
        this.customer = customer;
    }
    public Show getShow(){
        return show;
    }

    public Customer getCustomer(){
        return customer;
    }
    public String bookingToString(){
        return getCustomer().customerToString() + " " + getShow().showToString();
    }

}
