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

    public void displayCustomerInfo(){
        System.out.println("Name: " + name + ", Telephone: " + telNum);
    }

}
