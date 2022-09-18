import javax.swing.*;
import java.util.ArrayList;

public class Buttons {

    /**
     * Кнопка для редагування полей будь-якої групи продуктів
     * @param nameGr - обраний елемент, який буде змінений
     * @param name
     * @param description
     */
    public static void editPolesGroups(String nameGr, String name, String description) {
        for (Groups groups : Groups.productGroupsList) {
            if (groups.getName().equals(nameGr)) {

                if (!groups.getName().equals(name)) {
                    groups.setName(name);
                }
                if (!groups.getDescription().equals(description)) {
                    groups.setDescription(description);
                }

            }
        }

        for (Products product : Products.productsList){
            if (product.getWhichGroup().equals(nameGr)){
                product.setWhichGroup(name);
            }
        }
    }

    /**
     * Кнопка для редагування полей будь-якого продукту
     * @param name
     * @param priceForOne
     * @param quantity
     * @param cost
     * @param description
     * @param producer
     * @param whichGroup
     * @param namePr - обраний елемент, який буде змінений
     */
    public static void editPolesProducts(String name, String priceForOne, String quantity, String cost, String description, String producer, String whichGroup, String namePr) {
        for (Products product : Products.productsList) {
            if (product.getName().equals(namePr)) {

                if (!product.getName().equals(name)) {
                    product.setName(name);
                }
                if (product.getPriceForOne() != Double.parseDouble(priceForOne)) {
                    product.setPriceForOne(Double.parseDouble(priceForOne));
                }
                if (product.getQuantity() != Integer.parseInt(quantity)) {
                    product.setQuantity(Integer.parseInt(quantity));
                }
                if (product.getCost() != Double.parseDouble(cost)) {
                    product.setCost(Double.parseDouble(cost));
                }
                if (!product.getDescription().equals(description)) {
                    product.setDescription(description);
                }
                if (!product.getProducer().equals(producer)) {
                    product.setProducer(producer);
                }
                //Возможна ошибка. Не знаю точно, что оно возрощает
                if (!product.getWhichGroup().equals(String.valueOf(whichGroup))) {
                    product.setWhichGroup(String.valueOf(whichGroup));
                }

            }
        }
    }

    /**
     * Кнопка для видалення групи продуктів
     * Зразу видаляє усі продукті, які зв'язані з цією групою
     *
     * @param groupName - ім'я групи, яку видаляємо
     */
    public static void deleteGroup(String groupName) {
        ArrayList<Groups> groupList = new ArrayList<>();
        for (Groups gr : Groups.productGroupsList) {
            groupList.add(gr);
        }
        Groups.productGroupsList.removeAll(Groups.productGroupsList);
        for(int i = 0; i < groupList.size(); i++){
            if (groupList.get(i).getName().equals(groupName)) {
                groupList.remove(i);
                break;
            }
        }
        for(Groups gr : groupList){
            Groups.productGroupsList.add(gr);
        }

        ArrayList<Products> prodList = new ArrayList<>();
        for(Products prod : Products.productsList){
            prodList.add(prod);
        }
        Products.productsList.removeAll(Products.productsList);
        for(int i = 0; i < prodList.size(); i++){
            if(prodList.get(i).getWhichGroup().equals(groupName)){
                prodList.remove(i);
            }
        }
        for(Products pr : prodList){
            Products.productsList.add(pr);
        }
    }

    /**
     * Кнопка для видалення продукта
     * @param productName - ім'я групи, яку видаляємо
     */
    public static void deleteProduct(String productName){
        ArrayList<Products> prodList = new ArrayList<>();
        for(Products prod : Products.productsList){
            prodList.add(prod);
        }
        Products.productsList.removeAll(Products.productsList);
        for(int i = 0; i < prodList.size(); i++){
            if(prodList.get(i).getName().equals(productName)){
                prodList.remove(i);
            }
        }
        for(Products pr : prodList){
            Products.productsList.add(pr);
        }
    }

    /**
     * Пошук групи, повертає загальну інформацію
     * @param nameGroup
     */
    public static String showGroup(String nameGroup){
        for(Groups gr : Groups.productGroupsList){
            if(gr.getName().equals(nameGroup)){
                return (gr.toString());
            }
        }
        return "No information :(";
    }

    /**
     * Пошук продукта, повертає загальну інформацію
     * @param nameProduct
     */
    public static String showProduct(String nameProduct){
        for(Products pr : Products.productsList){
            if(pr.getName().equals(nameProduct)){
                return pr.toString();
            }
        }
        return "No information :(";
    }
}
