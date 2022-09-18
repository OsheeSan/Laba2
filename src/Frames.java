import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.Locale;

public class Frames {

    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public static String productName = null;

    /**
     * Вікно додавання нової групи
     */
    public static void addGroupWindow(){
        JFrame addGroupFrame = new JFrame("Add group");
        JPanel addGroupPanel = new JPanel(new BorderLayout());
        JButton saveButton = new JButton("Confirm");
        saveButton.setFont(new Font("Arial",Font.BOLD,20));
        JTextArea addGroupTextArea = new JTextArea("Description :");
        addGroupTextArea.setFont(new Font("Arial",Font.BOLD,20));
        JTextField addGroupTextField = new JTextField("Name :");
        addGroupTextField.setFont(new Font("Arial",Font.BOLD,20));
        addGroupTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (addGroupTextField.getText().equals("Name :"))
                addGroupTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (addGroupTextField.getText().equals(""))
                addGroupTextField.setText("Name :");
            }
        });
        addGroupTextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (addGroupTextArea.getText().equals("Description :"))
                    addGroupTextArea.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (addGroupTextArea.getText().equals(""))
                    addGroupTextArea.setText("Description :");
            }
        });
        addGroupTextArea.setPreferredSize(new Dimension(300, 50));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = addGroupTextField.getText();
                String description = addGroupTextArea.getText();
                if (name.equals("Name :") || description.equals("Description :")){
                    JOptionPane.showMessageDialog(null,
                            "Name or description is empty!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else if (Checker.groupIsExist(name)) {
                    JOptionPane.showMessageDialog(null,
                            "Group is already exist!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Groups.productGroupsList.add(new Groups(name, description));
                    addGroupFrame.dispose();
                    Display.x = Display.mainMenuFrame.getX();
                    Display.y = Display.mainMenuFrame.getY();
                    Display.mainMenuFrame.dispose();
                    Display.mainMenu();
                }
            }
        });
        addGroupPanel.add(addGroupTextField, "North");
        addGroupPanel.add(addGroupTextArea, "West");
        addGroupPanel.add(saveButton, "Center");
        addGroupFrame.setSize(500, 200);
        addGroupFrame.setLocation(dim.width/2-addGroupFrame.getSize().width/2, dim.height/2-addGroupFrame.getSize().height/2);
        addGroupFrame.setVisible(true);
        addGroupFrame.add(addGroupPanel);
        addGroupPanel.requestFocus();
    }

    /**
     * Вікно додавання нового продукту
     */
    public static void addProductWindow(){
        JFrame addProductFrame = new JFrame("Add product");
        JPanel addProductPanel = new JPanel(new BorderLayout());

        JPanel TextsPanel = new JPanel(new GridLayout(4,1));

        JButton saveButton = new JButton("Confirm");
        saveButton.setFont(new Font("Arial",Font.BOLD,24));
        JTextField nameTextField = new JTextField("Name :");
        nameTextField.setFont(new Font("Arial",Font.BOLD,24));
        JTextField priceForOneTextField = new JTextField("Price :");
        priceForOneTextField.setFont(new Font("Arial",Font.BOLD,24));
        JTextField quantityTextField = new JTextField("Quantity :");
        quantityTextField.setFont(new Font("Arial",Font.BOLD,24));
        JTextField producerTextField = new JTextField("Producer :");
        producerTextField.setFont(new Font("Arial",Font.BOLD,24));
        priceForOneTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (priceForOneTextField.getText().equals("Price :"))
                    priceForOneTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (priceForOneTextField.getText().equals(""))
                    priceForOneTextField.setText("Price :");
            }
        });

        nameTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nameTextField.getText().equals("Name :"))
                    nameTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (nameTextField.getText().equals(""))
                    nameTextField.setText("Name :");
            }
        });

        quantityTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (quantityTextField.getText().equals("Quantity :"))
                    quantityTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (quantityTextField.getText().equals(""))
                    quantityTextField.setText("Quantity :");
            }
        });
        producerTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (producerTextField.getText().equals("Producer :"))
                    producerTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (producerTextField.getText().equals(""))
                    producerTextField.setText("Producer :");
            }
        });



        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String price =priceForOneTextField.getText().trim();
                String quantity = quantityTextField.getText().trim();
                String producer = producerTextField.getText();
                if (name.equals("Name :")){
                    JOptionPane.showMessageDialog(null,
                            "Name is empty!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }else if (price.equals("Price :")) {
                    JOptionPane.showMessageDialog(null,
                            "Price is empty!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }  else if (Checker.isNumberDouble(price) == false){ // price.matches("^\\d+$")
                    JOptionPane.showMessageDialog(null,
                            "Wrong price format!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }else if (quantity.equals("Quantity :")) {
                    JOptionPane.showMessageDialog(null,
                            "Quantity is empty!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }   else if (Checker.isNumberInteger(quantity) == false){ // !quantity.matches("^\\d+$")
                    JOptionPane.showMessageDialog(null,
                            "Wrong quantity format!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }else if (producer.equals("Producer :")) {
                    JOptionPane.showMessageDialog(null,
                            "Producer is empty!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }  else if (Checker.groupIsExist(name)) {
                    JOptionPane.showMessageDialog(null,
                            "Group is already exist!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    addProductPanel.removeAll();
                    addProductPanel.repaint();
                    addProductPanel.revalidate();
                    addProductPanel.setLayout(new GridLayout(2,1));
                    JTextArea descriptionTextArea = new JTextArea("Description :");
                    descriptionTextArea.setFont(new Font("Arial",Font.BOLD,24));
                    descriptionTextArea.setLineWrap(true);
                    JScrollPane scroll = new JScrollPane();
                    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    scroll.getViewport().setBackground(Color.WHITE);
                    scroll.getViewport().add(descriptionTextArea);
                    descriptionTextArea.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            if (descriptionTextArea.getText().equals("Description :"))
                                descriptionTextArea.setText("");
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            if (descriptionTextArea.getText().equals(""))
                                descriptionTextArea.setText("Description :");
                        }
                    });
                    addProductPanel.add(descriptionTextArea);
                    addProductPanel.add(saveButton);
                    saveButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String description = descriptionTextArea.getText();
                            if (description.equals("Description :")){
                                JOptionPane.showMessageDialog(null,
                                        "Description is empty!",
                                        "Error!",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            Products.productsList.add(new Products(name, Double.parseDouble(price), Integer.parseInt(quantity), description, producer, Display.groupName));
                            Display.x = Display.mainMenuFrame.getX();
                            Display.y = Display.mainMenuFrame.getY();
                            mainMenuFrame.dispose();
                            addProductFrame.dispose();
                            ProductsMenu();
                        }
                    });


                }
            }
        });

        JTextField def = new JTextField();



        TextsPanel.add(nameTextField);
        TextsPanel.add(priceForOneTextField);
        TextsPanel.add(quantityTextField);
        TextsPanel.add(producerTextField);
        addProductPanel.add(TextsPanel, "Center");
        addProductPanel.add(saveButton, "East");
        addProductFrame.setSize(1000, 400);
        addProductFrame.setLocation(dim.width/2-addProductFrame.getSize().width/2, dim.height/2-addProductFrame.getSize().height/2);
        addProductFrame.setVisible(true);
        addProductFrame.add(addProductPanel);
        saveButton.grabFocus();
        addProductPanel.requestFocus();
    }

    private static String name_ = "";
    private static String description_ = "";
    private static double priceForOne_;
    private static int quantity_;
    private static String producer_ = "";

    /**
     * Вікно редагування групи
     */
    public static void editGroupWindow(){
        JFrame editGroupFrame = new JFrame("Edit group");
        JPanel editGroupButton = new JPanel(new BorderLayout());
        JButton saveButton = new JButton("Confirm");
        saveButton.setFont(new Font("Arial",Font.BOLD,20));
        for (Groups e : Groups.productGroupsList){
            if (e.getName().equals(Display.groupName)){
                name_ = e.getName();
                description_ = e.getDescription();
            }
        }
        JTextArea editGroupTextArea = new JTextArea(description_);
        editGroupTextArea.setFont(new Font("Arial",Font.BOLD,20));
        JTextField editGroupTextField = new JTextField(name_);
        editGroupTextField.setFont(new Font("Arial",Font.BOLD,20));
        editGroupTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (editGroupTextField.getText().equals("Name :"))
                    editGroupTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (editGroupTextField.getText().equals(""))
                    editGroupTextField.setText("Name :");
            }
        });
        editGroupTextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (editGroupTextArea.getText().equals("Description :"))
                    editGroupTextArea.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (editGroupTextArea.getText().equals(""))
                    editGroupTextArea.setText("Description :");
            }
        });
        editGroupTextArea.setPreferredSize(new Dimension(300, 50));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = editGroupTextField.getText();
                String description = editGroupTextArea.getText();
                if (name.equals("Name :") || description.equals("Description :")){
                    JOptionPane.showMessageDialog(null,
                            "Name or description is empty!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else if (Checker.groupIsExist(name) && !name.equals(Display.groupName)) {
                    JOptionPane.showMessageDialog(null,
                            "Group is already exist!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    int action = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit " + Display.groupName+" ?", "Confirm action", JOptionPane.YES_NO_OPTION);
                    if (action == 0){
                        Buttons.editPolesGroups(name_, name, description);
                        editGroupFrame.dispose();
                        Display.x = Display.mainMenuFrame.getX();
                        Display.y = Display.mainMenuFrame.getY();
                        Display.mainMenuFrame.dispose();
                        Display.mainMenu();
                    }

                }
            }
        });
        editGroupButton.add(editGroupTextField, "North");
        editGroupButton.add(editGroupTextArea, "West");
        editGroupButton.add(saveButton, "Center");
        editGroupFrame.setSize(500, 200);
        editGroupFrame.setLocation(dim.width/2-editGroupFrame.getSize().width/2, dim.height/2-editGroupFrame.getSize().height/2);
        editGroupFrame.setVisible(true);
        editGroupFrame.add(editGroupButton);
        editGroupButton.requestFocus();
    }

    /**
     * Вікно редагування продукту
     */
    public static void editProductWindow(){
        JFrame editProductFrame = new JFrame("Edit product");
        JPanel editProductPanel = new JPanel(new BorderLayout());
        for (Products e : Products.productsList){
            if (e.getName().equals(productName)){
                name_ = e.getName();
                description_ = e.getDescription();
                priceForOne_ = e.getPriceForOne();
                quantity_ = e.getQuantity();
                producer_ = e.getProducer();
            }
        }
        JPanel TextsPanel = new JPanel(new GridLayout(4,1));

        JButton saveButton = new JButton("Confirm");
        saveButton.setFont(new Font("Arial",Font.BOLD,24));
        JTextField nameTextField = new JTextField(name_);
        nameTextField.setFont(new Font("Arial",Font.BOLD,24));
        JTextField priceForOneTextField = new JTextField(String.valueOf(priceForOne_));
        priceForOneTextField.setFont(new Font("Arial",Font.BOLD,24));
        JTextField quantityTextField = new JTextField(String.valueOf(quantity_));
        quantityTextField.setFont(new Font("Arial",Font.BOLD,24));
        JTextField producerTextField = new JTextField(producer_);
        producerTextField.setFont(new Font("Arial",Font.BOLD,24));
        priceForOneTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (priceForOneTextField.getText().equals("Price :"))
                    priceForOneTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (priceForOneTextField.getText().equals(""))
                    priceForOneTextField.setText("Price :");
            }
        });

        nameTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nameTextField.getText().equals("Name :"))
                    nameTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (nameTextField.getText().equals(""))
                    nameTextField.setText("Name :");
            }
        });

        quantityTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (quantityTextField.getText().equals("Quantity :"))
                    quantityTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (quantityTextField.getText().equals(""))
                    quantityTextField.setText("Quantity :");
            }
        });
        producerTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (producerTextField.getText().equals("Producer :"))
                    producerTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (producerTextField.getText().equals(""))
                    producerTextField.setText("Producer :");
            }
        });



        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String price = priceForOneTextField.getText().trim();
                String quantity = quantityTextField.getText().trim();
                String producer = producerTextField.getText();
                if (name.equals("Name :")){
                    JOptionPane.showMessageDialog(null,
                            "Name is empty!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else if (Checker.productIsExist(name) && !name.equals(productName)) {
                    JOptionPane.showMessageDialog(null,
                            "Product is already exist!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }
                else if (price.equals("Price :")) {
                    JOptionPane.showMessageDialog(null,
                            "Price is empty!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }  else if (!Checker.isNumberDouble(price)){
                    JOptionPane.showMessageDialog(null,
                            "Wrong price format!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }else if (quantity.equals("Quantity :")) {
                    JOptionPane.showMessageDialog(null,
                            "Quantity is empty!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }   else if (!Checker.isNumberInteger(quantity)){
                    JOptionPane.showMessageDialog(null,
                            "Wrong quantity format!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }else if (producer.equals("Producer :")) {
                    JOptionPane.showMessageDialog(null,
                            "Producer is empty!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }  else if (Checker.groupIsExist(name)) {
                    JOptionPane.showMessageDialog(null,
                            "Group is already exist!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    editProductPanel.removeAll();
                    editProductPanel.repaint();
                    editProductPanel.revalidate();
                    editProductPanel.setLayout(new GridLayout(2,1));
                    JTextArea descriptionTextArea = new JTextArea(description_);
                    descriptionTextArea.setFont(new Font("Arial",Font.BOLD,24));
                    descriptionTextArea.setLineWrap(true);
                    JScrollPane scroll = new JScrollPane();
                    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    scroll.getViewport().setBackground(Color.WHITE);
                    scroll.getViewport().add(descriptionTextArea);
                    descriptionTextArea.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            if (descriptionTextArea.getText().equals("Description :"))
                                descriptionTextArea.setText("");
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            if (descriptionTextArea.getText().equals(""))
                                descriptionTextArea.setText("Description :");
                        }
                    });
                    editProductPanel.add(descriptionTextArea);
                    editProductPanel.add(saveButton);
                    saveButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String description = descriptionTextArea.getText();
                            if (description.equals("Description :")){
                                JOptionPane.showMessageDialog(null,
                                        "Description is empty!",
                                        "Error!",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            int action = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit "+productName+"?", "Confirm action", JOptionPane.YES_NO_OPTION);
                            if (action == 0){
                                Buttons.editPolesProducts(name, price, quantity, String.valueOf(Double.parseDouble(price)*Integer.parseInt(quantity)), description, producer, Display.groupName, name_);
                                Display.x = Display.mainMenuFrame.getX();
                                Display.y = Display.mainMenuFrame.getY();
                                mainMenuFrame.dispose();
                                editProductFrame.dispose();
                                ProductsMenu();
                            }

                        }
                    });


                }
            }
        });

        JTextField def = new JTextField();



        TextsPanel.add(nameTextField);
        TextsPanel.add(priceForOneTextField);
        TextsPanel.add(quantityTextField);
        TextsPanel.add(producerTextField);
        editProductPanel.add(TextsPanel, "Center");
        editProductPanel.add(saveButton, "East");
        editProductFrame.setSize(1000, 400);
        editProductFrame.setLocation(dim.width/2-editProductFrame.getSize().width/2, dim.height/2-editProductFrame.getSize().height/2);
        editProductFrame.setVisible(true);
        editProductFrame.add(editProductPanel);
        saveButton.grabFocus();
        editProductPanel.requestFocus();
    }

    public static JFrame mainMenuFrame;

    public static JPanel mainMenuPanel;
    public static JPanel mainMenuButtonsPanel;

    public static JPanel mainMenuComboPanel;

    public static JButton findGroupButton;
    public static JButton findProductButton;
    public static JButton BackButton;
    public static JButton addProductButton;
    public static JButton editProductButton;
    public static JButton deleteProductButton;
    public static JButton addSomeProducts;

    public static JButton showProductInfo;

    private static int addSomeInt;

    /**
     * Головне меню для продуктів певної групи
     */
    public static void ProductsMenu(){

        mainMenuPanel = new JPanel(new BorderLayout());
        mainMenuButtonsPanel = new JPanel(new GridLayout(3, 2));
        mainMenuComboPanel = new JPanel(new GridLayout(1, 2));
        JComboBox comboBox2 = new JComboBox();
        comboBox2.setFont(new Font("Arial",Font.BOLD,24));
        mainMenuComboPanel.add(comboBox2);
        for (Products x : Products.productsList){
            if (x.getWhichGroup().equals(Display.groupName))
                comboBox2.addItem(x.getName());
        }
        comboBox2.setSelectedItem(productName);

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox2.getSelectedItem() != null)
                    productName = comboBox2.getSelectedItem().toString();
            }
        });
        mainMenuPanel.add(mainMenuComboPanel, "North");
        // Find group button
        findGroupButton = new JButton("Save!");
        findGroupButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(findGroupButton);
        findGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Outputs.saveAllGroupsFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    Outputs.saveAllProductsFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        addProductButton = new JButton("Add new product!");
        addProductButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(addProductButton);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductWindow();
            }
        });

        // Add group button
        BackButton = new JButton("Back!");
        BackButton.setBackground(Color.YELLOW);
        BackButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuPanel.add(BackButton,"West");
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.x = Display.mainMenuFrame.getX();
                Display.y = Display.mainMenuFrame.getY();
                mainMenuFrame.dispose();
                Display.mainMenu();
            }
        });

        // Add product button
        findProductButton = new JButton("Find product");
        findProductButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(findProductButton);
        findProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchProduct();
                comboBox2.setSelectedItem(productName);
            }
        });
        mainMenuPanel.add(mainMenuButtonsPanel, "Center");

        deleteProductButton = new JButton("Delete product");
        deleteProductButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(deleteProductButton);
        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productName == null){
                    JOptionPane.showMessageDialog(null,
                            "Product is not chosen",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    int action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+productName+"?", "Confirm action", JOptionPane.YES_NO_OPTION);
                    if (action == 0){
                        Buttons.deleteProduct(productName);
                        productName = null;
                        mainMenuFrame.dispose();
                        ProductsMenu();
                    }
                }
            }
        });

        editProductButton = new JButton("Edit product");
        editProductButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(editProductButton);
        editProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productName == null){
                    JOptionPane.showMessageDialog(null,
                            "Product is not chosen",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    editProductWindow();
                }
            }
        });

        addSomeProducts = new JButton("Add(del) some product");
        addSomeProducts.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(addSomeProducts);
        addSomeProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productName == null){
                    JOptionPane.showMessageDialog(null,
                            "Product is not chosen",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String addSome = JOptionPane.showInputDialog(null, "Add ... products");
                    try {
                        addSomeInt = Integer.parseInt(addSome);
                    }catch (NumberFormatException x){
                        JOptionPane.showMessageDialog(null,
                                "Wrong number format!",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                        for (Products p : Products.productsList){
                            if (p.getName().equals(productName)){
                                if (p.getQuantity() > Math.abs(addSomeInt)) {
                                    p.setQuantity(p.getQuantity() + addSomeInt);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "Input modulo mast be less than quantity!",
                                            "Error!",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                }
            }
        });

        showProductInfo = new JButton("Show product info");
        showProductInfo.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuPanel.add(showProductInfo, "South");
        showProductInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productName == null){
                    JOptionPane.showMessageDialog(null,
                            "Product is not chosen",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    showProductInfo();
                }
            }
        });

        mainMenuFrame = new JFrame("Magazine");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(600, 300);
        mainMenuFrame.setLocation(Display.x, Display.y);
        mainMenuFrame.setVisible(true);
        mainMenuFrame.add(mainMenuPanel);

    }

    /**
     * Вікно пошуку групи
     */
    public static void  searchGroup(){
        JFrame searchFrame = new JFrame("Search");
        JPanel searchPanel = new JPanel(new BorderLayout());
        JTextField searchTextField = new JTextField();
        searchTextField.setFont(new Font("Arial",Font.BOLD,24));
        JButton findButton = new JButton("Find");
        findButton.setFont(new Font("Arial",Font.BOLD,24));
        findButton.addActionListener(new ActionListener() {
            boolean error = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Groups gr : Groups.productGroupsList) {
                    if (gr.getName().toLowerCase(Locale.ROOT).equals(searchTextField.getText().toLowerCase(Locale.ROOT))) {
                        Display.x = Display.mainMenuFrame.getX();
                        Display.y = Display.mainMenuFrame.getY();
                        Display.mainMenuFrame.dispose();
                        Display.groupName = gr.getName();
                        Display.mainMenu();
                        error = false;
                        searchFrame.dispose();
                    }
                }
                if (error == true){
                    JOptionPane.showMessageDialog(null,
                            "Group not found!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        searchPanel.add(searchTextField, "North");
        searchPanel.add(findButton, "Center");
        searchFrame.setSize(500, 300);
        searchFrame.setLocation(dim.width/2-searchFrame.getSize().width/2, dim.height/2-searchFrame.getSize().height/2);
        searchFrame.setVisible(true);
        searchFrame.add(searchPanel);
    }

    /**
     * Вікно пошуку продукту
     */
    public static void  searchProduct(){
        JFrame searchFrame = new JFrame("Search");
        JPanel searchPanel = new JPanel(new BorderLayout());
        JTextField searchTextField = new JTextField();
        searchTextField.setFont(new Font("Arial",Font.BOLD,24));
        JButton findButton = new JButton("Find");
        findButton.setFont(new Font("Arial",Font.BOLD,24));
        findButton.addActionListener(new ActionListener() {
            boolean error = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Products gr : Products.productsList) {
                    if (gr.getName().toLowerCase(Locale.ROOT).equals(searchTextField.getText().toLowerCase(Locale.ROOT))) {
                        Display.x = Display.mainMenuFrame.getX();
                        Display.y = Display.mainMenuFrame.getY();
                        mainMenuFrame.dispose();
                        if (!Display.groupName.equals(gr.getWhichGroup())){
                            JOptionPane.showMessageDialog(null,
                                    "Group was changed to "+gr.getWhichGroup(),
                                    "Error!",
                                    JOptionPane.INFORMATION_MESSAGE);
                            Display.groupName= gr.getWhichGroup();
                        }
                        productName = gr.getName();
                        ProductsMenu();
                        error = false;
                        searchFrame.dispose();
                        break;
                    }
                }
                if (error == true){
                    JOptionPane.showMessageDialog(null,
                            "Product not found!",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        searchPanel.add(searchTextField, "North");
        searchPanel.add(findButton, "Center");
        searchFrame.setSize(500, 300);
        searchFrame.setLocation(dim.width/2-searchFrame.getSize().width/2, dim.height/2-searchFrame.getSize().height/2);
        searchFrame.setVisible(true);
        searchFrame.add(searchPanel);
    }

    /**
     * Вікно інформації про групу
     */
    public static void showGroupInfo(){
        JFrame showFrame = new JFrame("Group information");
        JTextArea showTextArea = new JTextArea(Buttons.showGroup(Display.groupName));
        showTextArea.setEditable(false);
        showTextArea.setFont(new Font("Arial",Font.BOLD,20));
        showTextArea.setLineWrap(true);
        showTextArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(showTextArea);
        showFrame.add(scroll);
        showFrame.setSize(600, 600);
        showFrame.setLocation(dim.width/2-showFrame.getSize().width/2, dim.height/2-showFrame.getSize().height/2);
        showFrame.setVisible(true);
    }

    /**
     * Вікно інформації про продукт
     */
    public static void showProductInfo(){
        JFrame showFrame = new JFrame("Product information");
        JTextArea showTextArea = new JTextArea(Buttons.showProduct(productName));
        showTextArea.setEditable(false);
        showTextArea.setLineWrap(true);
        showTextArea.setWrapStyleWord(true);
        showTextArea.setFont(new Font("Arial",Font.BOLD,20));
        JScrollPane scroll = new JScrollPane(showTextArea);
        showFrame.add(scroll);
        showFrame.setSize(600, 600);
        showFrame.setLocation(dim.width/2-showFrame.getSize().width/2, dim.height/2-showFrame.getSize().height/2);
        showFrame.setVisible(true);
    }
}
