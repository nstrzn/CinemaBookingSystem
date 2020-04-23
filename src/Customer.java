public class Customer {
    private String name;
    private String telNum;

    public Customer(String name, String telNum){
        this.name = name;
        this.telNum = telNum;
    }

    //getters
    public String getName(){
        return name;
    }

    public String getTelNum(){
        return telNum;
    }

    public String customerToString(){
        return "Name: " + name + ", Telephone: " + telNum;
    }

}
