import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Outputs {

    /**
     * Зберігає у файл усю інформацію усіх груп
     *
     * @throws IOException
     */
    public static void saveAllGroupsFile() throws IOException {
        FileWriter fw = new FileWriter("Groups\\Groups.txt");
        for (Groups gr : Groups.productGroupsList) {
            fw.write("<" + gr.getName() + ">" + "\n");
            fw.write("<" + gr.getDescription() + ">" + "\n");
            fw.write("\n");
        }
        fw.close();
        JOptionPane.showMessageDialog(null,
                "Base was saved!",
                "Error!",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Зберігає в кожному окремому файлі усю інформацію о продуктах по групах
     *
     * @throws IOException
     */
    public static void saveAllProductsFile() throws IOException {
        for (Groups gr : Groups.productGroupsList) {
            FileWriter fw = new FileWriter("Products\\" + gr.getName() + ".txt");
            for (Products pr : Products.productsList) {
                if (pr.getWhichGroup().equals(gr.getName())) {
                    fw.write("<" + pr.getName() + ">" + "\n");
                    fw.write("<" + pr.getProducer() + ">" + "\n");
                    fw.write("<" + pr.getDescription() + ">" + "\n");
                    fw.write("<" + pr.getPriceForOne() + ">" + "\n");
                    fw.write("<" + pr.getQuantity() + ">" + "\n");
                    fw.write("<" + pr.getWhichGroup() + ">");
                }
            }
            fw.close();
        }
    }

    /**
     * Зчитує з усіх файлів інформацію о продуктах з корневої папки Products
     *
     * @throws IOException
     */
    public static void readInformationProduct() throws IOException {
        File mainFolder = new File("Products"); // путь главной корневой папки, де хранятся все продукты по категориям
        File[] allFiles = mainFolder.listFiles(); // сохраняет в массив все файлы главной папки mainFolder
        for (File f : allFiles) {
            Scanner scanner = new Scanner(f);
            String safe = "";
            while (scanner.hasNextLine()) {
                safe += scanner.nextLine();
            }
        /*
        1. name
        2. producer
        3. description
        4. price for one
        5. quantity
        6. which group
         */
            int k = 0;
            int ind1 = 0;
            int ind2;
            String name = "";
            double priceForOne = 0;
            int quantity = 0;
            String description = "";
            String producer = "";
            String whichGroup = "";
            for (int i = 0; i < safe.length(); i++) {
                if (safe.charAt(i) == '<') {
                    ind1 = i;
                    continue;
                }
                if (safe.charAt(i) == '>') {
                    k++;
                    ind2 = i;
                    if (k == 1)
                        name = safe.substring(ind1 + 1, ind2);
                    if (k == 2)
                        producer = safe.substring(ind1 + 1, ind2);
                    if (k == 3)
                        description = safe.substring(ind1 + 1, ind2);
                    if (k == 4)
                        priceForOne = Double.parseDouble(safe.substring(ind1 + 1, ind2));
                    if (k == 5)
                        quantity = Integer.parseInt(safe.substring(ind1 + 1, ind2));
                    if (k == 6) {
                        whichGroup = safe.substring(ind1 + 1, ind2);
                        Products.productsList.add(new Products(name, priceForOne, quantity, description, producer, whichGroup));
                        k = 0;
                    }
                    if (k == 7 && safe.substring(ind1 + 1, ind2).equals("Coast")) {
                        continue;
                    }
                    continue;
                }
            }

        }
    }

    /**
     * Зчитує з усіх файлів інформацію о продуктах з корневої папки Groups
     *
     * @throws IOException
     */
    public static void readInformationGroup() throws IOException {
        File mainFolder = new File("Groups"); // путь главной корневой папки, де хранятся все продукты по категориям
        File[] allFiles = mainFolder.listFiles(); // сохраняет в массив все файлы главной папки mainFolder
        for (File f : allFiles) {
            Scanner scanner = new Scanner(f);
            String safe = "";
            while (scanner.hasNextLine()) {
                safe += scanner.nextLine();
            }
            /*
            1. name
            2. description
             */
            int k = 0;
            int ind1 = 0;
            int ind2;
            String name = "";
            String description = "";
            for (int i = 0; i < safe.length(); i++) {
                if (safe.charAt(i) == '<') {
                    ind1 = i;
                    continue;
                }
                if (safe.charAt(i) == '>') {
                    k++;
                    ind2 = i;
                    if (k == 1)
                        name = safe.substring(ind1 + 1, ind2);
                    if (k == 2) {
                        description = safe.substring(ind1 + 1, ind2);
                        Groups.productGroupsList.add(new Groups(name, description));
                        k = 0;
                    }
                }
            }
        }
    }
}
