import java.util.Locale;

public class Checker {

    /**
     * Перевіряє - існує така група чи ні
     * @param findGroup - ім'я групи, яке перевіряємо
     * @return
     */
    public static boolean groupIsExist(String findGroup) {
        for (Groups gr : Groups.productGroupsList) {
            if (gr.getName().toLowerCase(Locale.ROOT).equals(findGroup.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Перевіряє - існує такий продукт чи ні
     * @param findProduct - ім'я продукта, яке перевіряємо
     * @return
     */
    public static boolean productIsExist(String findProduct){
        for(Products pr : Products.productsList){
            if(pr.getName().equals(findProduct)){
                return true;
            }
        }
        return false;
    }

    /**
     * Перевіряє строку, чи складається вона тільки з десяткових чисел чи ні
     * @param str
     * @return
     */
    public static boolean isNumberDouble(String str){
        int k = 0;
        for(int i = 0; i < str.length(); i++){

            if(str.charAt(i) == '1' && k == 0) {
                k++;
                continue;
            } else if(str.charAt(i) == '2' && k == 0){
                k++;
                continue;
            } else if(str.charAt(i) == '3' && k == 0){
                k++;
                continue;
            } else if(str.charAt(i) == '4' && k == 0){
                k++;
                continue;
            } else if(str.charAt(i) == '5' && k == 0){
                k++;
                continue;
            } else if(str.charAt(i) == '6' && k == 0){
                k++;
                continue;
            } else if(str.charAt(i) == '7' && k == 0){
                k++;
                continue;
            } else if(str.charAt(i) == '8' && k == 0){
                k++;
                continue;
            } else if(str.charAt(i) == '9' && k == 0){
                k++;
                continue;
            } else if(str.charAt(i) == '0' && k == 0) {
                k++;
                continue;
            }


            if(str.charAt(i) == '1' && k == 1) {
                continue;
            } else if(str.charAt(i) == '2' && k == 1){
                continue;
            } else if(str.charAt(i) == '3' && k == 1){
                continue;
            } else if(str.charAt(i) == '4' && k == 1){
                continue;
            } else if(str.charAt(i) == '5' && k == 1){
                continue;
            } else if(str.charAt(i) == '6' && k == 1){
                continue;
            } else if(str.charAt(i) == '7' && k == 1){
                continue;
            } else if(str.charAt(i) == '8' && k == 1){
                continue;
            } else if(str.charAt(i) == '9' && k == 1){
                continue;
            } else if(str.charAt(i) == '0' && k == 1){
                continue;
            } else if(str.charAt(i) == '.' && k == 1) {
                k++;
                i++;
            } else {
                return false;
            }

            if(str.charAt(i) == '1' && k == 2) {
                continue;
            } else if(str.charAt(i) == '2' && k == 2){
                continue;
            } else if(str.charAt(i) == '3' && k == 2){
                continue;
            } else if(str.charAt(i) == '4' && k == 2){
                continue;
            } else if(str.charAt(i) == '5' && k == 2){
                continue;
            } else if(str.charAt(i) == '6' && k == 2){
                continue;
            } else if(str.charAt(i) == '7' && k == 2){
                continue;
            } else if(str.charAt(i) == '8' && k == 2){
                continue;
            } else if(str.charAt(i) == '9' && k == 2){
                continue;
            } else if(str.charAt(i) == '0' && k == 2){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * Перевіряє число, чи є воно цілим
     * @param str
     * @return
     */
    public static boolean isNumberInteger(String str){
        for(int i = 0; i < str.length(); i++){

            if(str.charAt(i) == '1') {
                continue;
            } else if(str.charAt(i) == '2'){
                continue;
            } else if(str.charAt(i) == '3'){
                continue;
            } else if(str.charAt(i) == '4'){
                continue;
            } else if(str.charAt(i) == '5'){
                continue;
            } else if(str.charAt(i) == '6'){
                continue;
            } else if(str.charAt(i) == '7'){
                continue;
            } else if(str.charAt(i) == '8'){
                continue;
            } else if(str.charAt(i) == '9'){
                continue;
            } else if(str.charAt(i) == '0'){
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

}
