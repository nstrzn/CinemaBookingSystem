import java.util.ArrayList;
import java.util.Scanner;

public class CinemaSystem {
    private ArrayList<Theater> theaters;
    private ArrayList<Customer> customers;
    private ArrayList<Show> shows;
    private Scanner scanner = new Scanner(System.in);
    public CinemaSystem() {

    }
    public void chooseMovie(){
    for(int i = 0; i<shows.size();i++){
        int showId = i+1;
        System.out.println("Show id: "+showId+"\n"+"Show: "+shows.get(i).getTitle()+"\n"+
                "Date: "+shows.get(i).getDate()+"\n"+"Time: "+shows.get(i).getTime());
    }
    System.out.println("Enter id of the show you want to book.");
    int showId = scanner.nextInt();
    System.out.println("Now you can choose the seats in "+shows.get(showId-1).getTheater().getName());
    shows.get(showId-1).getTheater().displaySeatInfo();
    shows.get(showId-1).getTheater().wholeReservation();
    }
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

        for(Show e: shows){
            e.displayShowInfo();
        }
    }
}
