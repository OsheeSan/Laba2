import java.util.*;

public class Groups {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name_) {
        this.name = name_;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description_) {
        this.description = description_;
    }

    Groups(String name_, String description_){
        this.name = name_;
        this.description = description_;
    }

    public void coastProduct(){
        for(Products pr : Products.productsList){
            pr.setCost(pr.getPriceForOne() * pr.getQuantity());
        }
    }

    public static HashSet<Groups> productGroupsList = new HashSet<>();

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int price = 0;
        coastProduct();
        for (Products e : Products.productsList){
            if (e.getWhichGroup().equals(Display.groupName)){
                price +=e.getCost();
            }
        }
        str.append("Name: " + name).append(";\nDescription: " + description).append(";\nGroup price: $"+(double)price+"\n\nProducts list:");
        for (Products e : Products.productsList){
            if (e.getWhichGroup().equals(Display.groupName))
            str.append("\n\n"+e.toString());
        }
        return str.toString();
    }
}
