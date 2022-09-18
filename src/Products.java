import java.util.HashSet;

public class Products {
    public static Products pr;
    private String name; // ім'я товару            1
    private double priceForOne; //ціна за 1 товару 2
    private int quantity; //Кількість на складі    3
    private double cost; // вартість
    private String description;// опис             4
    private String producer;// виробник            5
    private String whichGroup;// група

    public String getWhichGroup() {
        return whichGroup;
    }

    public void setWhichGroup(String whichGroup) {
        this.whichGroup = whichGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceForOne() {
        return priceForOne;
    }

    public void setPriceForOne(double priceForOne) {
        this.priceForOne = priceForOne;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public static HashSet<Products> productsList = new HashSet<>();

    Products(String name, double priceForOne, int quantity, String description, String producer, String whichGroup_){
        this.name = name;
        this.priceForOne = priceForOne;
        this.quantity = quantity;
        cost = quantity * priceForOne;
        this.description = description;
        this.producer = producer;
        this.whichGroup = whichGroup_;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Name: " + name).append(";\nPrice: " + priceForOne + "$").append(";\nQuantity: " + quantity).append(";\nDescription: " + description).append(";\nCoast: " + cost + "$").append(";\nProducer: " + producer).append(";\nGroup: " + whichGroup);
        return str.toString();
    }
}
