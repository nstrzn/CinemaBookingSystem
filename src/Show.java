public class Show {
    private String title;
    private String date;
    private String time;
    private int price;
    private Theater theater;

    public Show(String title, String date, String time, int price, Theater theater){
        this.title = title;
        this.date = date;
        this.time = time;
        this.price = price;
        this.theater = theater;
    }

    public String showToString(){
        return "Title: "+title+", Date: "+date+", Time: "+time+", Price per Ticket: "+price+", Theater: " + getTheater().getName();
    }

    //getters:
    public String getTitle(){
        return title;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public int getPrice(){
        return price;
    }

    public Theater getTheater(){
        return theater;
    }

}
