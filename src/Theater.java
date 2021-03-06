import java.util.Scanner;

public class Theater {
    private String name;
    private int row;
    private int seat;
    private char[][] hall;
    private final char  EMPTY_SEAT = 'o';
    private final char OCCUPIED_SEAT = 'x';
    private boolean adjoiningRequest;
    private Scanner scanner = new Scanner(System.in);

    public Theater(String name, int row, int seat){
        this.name = name;
        this.row = row;
        this.seat = seat;
        initHall();
    }

    public void chooseSeat(){
        int x,y;
        System.out.println("Choose the row.");
        x = scanner.nextInt() - 1;
        System.out.println("Choose the seat. Free seats are marked with 'o'.");
        y = scanner.nextInt() - 1;
        if(seatIsAvailable(x, y)){
            hall[x][y] = OCCUPIED_SEAT;
        } else {
            System.out.println("This seat is not available.");
            chooseSeat();
        }
        System.out.println("You chose row: " +(x+1)+", seat: "+(y+1));
        displaySeatInfo();
    }

    public boolean seatIsAvailable(int x, int y){
        boolean result = true;
        if(x < 0 || x >= row || y < 0 || y >= seat || hall[x][y] != EMPTY_SEAT){
            result = false;
        }
        return result;
    }
    public void initHall(){
        hall = new char[row][seat];
        for(int i =0; i < row;i++){
            for (int j =0; j < seat;j++){
                hall[i][j] = EMPTY_SEAT;
            }
        }
    }
    public void displaySeatInfo(){
        for (int i = 0; i < hall.length; i++) {
            System.out.print(i+1+".ROW  ");
            for (int j = 0; j < hall[i].length; j++) {
                System.out.print(hall[i][j] + " ");
            }
            System.out.println();
        }
    }
    //getters
    public String getName(){
        return name;
    }
    public int getRow(){
        return row;
    }
    public int getSeat(){
        return seat;
    }

    /**
     * Takes number of seats as a parameter and allows user to choose multiple seats in a row.
     * @param num
     */
    public void chooseAdjoiningSeats(int num){
        int x,y;
        System.out.println("Choose the row.");
        x = scanner.nextInt() -1;
        for(int i=0; i<num; i++){
            System.out.println("Choose the seat.");
            y = scanner.nextInt() -1;
            if(seatIsAvailable(x,y)){
                hall[x][y] = OCCUPIED_SEAT;
            } else {
                System.out.println("This seat is not available.");
                chooseSeat();
            }
            System.out.println("you chose row: " + (x+1) + ", seat: " + (y+1));
            displaySeatInfo();}
    }

    /**
     * Asks user whether adjoining seats should be chosen. Assigns value to boolean "adjoiningRequest".
     */
    public void adjoining() {
        boolean adj = adjoiningRequest;
        boolean validAnswer = false;
        System.out.println("Do you want adjoining seats?");
        while (!validAnswer) {
            String answer = scanner.nextLine();
            if (answer.equals("yes") || answer.equals("Yes")) {
                adj = true;
                validAnswer = true;
            } else if (answer.equals("no") || answer.equals("No")) {
                adj = false;
                validAnswer = true; }
            if(validAnswer){
                break;
            }
            System.out.println("Please answer again.");
        }
    }

    /**
     * Reads user's input about number of seats.
     * @return number of seats the user wants to book.
     */
    public int howManySeats(){
        int num;
        System.out.println("How many Seats do you want to reserve?");
        num = scanner.nextInt();
        if(num<=0){
            System.out.println("That's not possible. Please choose at least 1 seat.");
            howManySeats();
        }
        scanner.nextLine();
        return num;
    }

    public void chooseMultiSeatNotAdj(int num){
        for(int i=0; i<num; i++){
            chooseSeat();}
    }

    /**
     * Accomplishes the whole process of booking seat.
     */
    public void bookSeat() {
        int num = howManySeats();
        if (num == 1) {
            chooseSeat();
        } else {
            adjoiningRequest = true;
            adjoining();
            if (adjoiningRequest) {
                chooseAdjoiningSeats(num);
            } else {
                chooseMultiSeatNotAdj(num);
            }
        }
    }
    }