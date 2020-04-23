import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaSystem {
    private ArrayList<Theater> theaters;
    private ArrayList<Customer> customers;
    private ArrayList<Show> shows;
    private ArrayList<Booking> bookings;
    private Scanner scanner = new Scanner(System.in);
    public CinemaSystem() {
        createTheaters();
        createShows();
    }

    /**
     * Main method of the cinema system. Makes the whole interaction with a customer
     */
    public void cinemaInterface(){
        System.out.println("Welcome to the cinema system interface!" +
                "\n Please enter:" +
                "\n 1 to make a reservation" +
                "\n 2 to cancel it.");
        int choice = scanner.nextInt();
        if(choice == 1){
            bookTicket();
        } else if (choice == 2){
            cancelReservation();
        } else {
            System.out.println("You entered incorrect value");
        }
    }

    /**
     *  Creates id for each show in the collection. Reads user's input and provides theater for the chosen show.
     *  Reserves seats for the show. Makes booking for a customer.
     */
    public void bookTicket(){
    for(int i = 0; i<shows.size();i++){
        int showId = i+1;
        System.out.println("Show id: "+showId+"\n"+"Show: "+shows.get(i).getTitle()+"\n"+
                "Date: "+shows.get(i).getDate()+"\n"+"Time: "+shows.get(i).getTime());
        }
        System.out.println("Enter id of the show you want to book.");
        int showId = scanner.nextInt();
        System.out.println("Now you can choose the seats in "+shows.get(showId-1).getTheater().getName());
        shows.get(showId-1).getTheater().displaySeatInfo();
        shows.get(showId-1).getTheater().bookSeat();

        //creates customers
        customers = new ArrayList<>();

        System.out.println("Enter your name");
        scanner.nextLine();
        String customName = scanner.nextLine();
        System.out.println("Enter your phone number");
        String phone = scanner.nextLine();

        Customer customer = new Customer(customName, phone);
        customers.add(customer);

        //creates bookings
        bookings = new ArrayList<>();
        Booking booking = new Booking(shows.get(showId-1), customer);
        bookings.add(booking);

        System.out.println("You booked ticket for the movie: "+ booking.getShow().getTitle()+" for "+ booking.getCustomer().customerToString());
    }

    /**
     * Searches a booking by customer's name and removes it from a collection.
     */
    public void cancelReservation(){
        //collect delete candidate
        System.out.println("Enter the name you made booking for.");
        String customName = scanner.nextLine();
        List<Booking> deleteCandidates = new ArrayList<>();
        for(Booking candidate: bookings) {
            if (customName.equals(candidate.getCustomer().getName())) {
                deleteCandidates.add(candidate);
            }
        }
        //delete
        for(Booking eToDelete : deleteCandidates){
            System.out.println("Your reservation:"+
                    "\n"+eToDelete.bookingToString()+"\nis now cancelled.");
            bookings.remove(eToDelete);
        }
    }
    /**
     *  Reads user's input about how many tickets should be booked;
     * @return number of tickets the user wants to book;
     */
    public int howManyTickets(){
        int num;
        System.out.println("How many tickets do you want to reserve?");
        num = scanner.nextInt();
        if(num<=0){
            System.out.println("Enter correct number.");
            howManyTickets();
        }
        return num;
    }
    public void createTheaters() {
        theaters = new ArrayList<>();
        Theater theater1 = new Theater("Theater 1", 5, 4);
        Theater theater2 = new Theater("Theater 2", 4, 5);
        Theater theater3 = new Theater("Theater 3", 6, 6);
        theaters.add(theater1);
        theaters.add(theater2);
        theaters.add(theater3);
    }
    public void createShows(){
        shows = new ArrayList<>();
        Show show1 = new Show("Inception", "10.04", "12:15", 10, theaters.get(0));
        Show show2 = new Show("Parasites", "10.04", "10:00", 12, theaters.get(1));
        Show show3 = new Show("Once upon in Hollywood", "15.04", "10:00", 8, theaters.get(2));
        shows.add(show1);
        shows.add(show2);
        shows.add(show3);
    }
}
