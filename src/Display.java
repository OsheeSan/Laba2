// Java Program to illustrate the GroupLayout class
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

// creating a class GroupLayoutDemo
public class Display {
    /**
     * Головний метод
     */
    public static void main(String[] args) {
        try {
            Outputs.readInformationGroup();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Outputs.readInformationProduct();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainMenu();
    }

    public static JFrame mainMenuFrame;
    public static int x = 20;
    public static int y = 20;
    public static JPanel mainMenuPanel;
    public static JPanel mainMenuButtonsPanel;
    public static JPanel mainMenuComboPanel;
    public static JButton SaveButton;
    public static JButton showProductsProductButton;
    public static JButton addGroupButton;
    public static JButton FindGroupButton;
    public static JButton DeleteGroupButton;
    public static JButton editGroupButton;
    public static JButton showGroupInfo;
    public static String groupName = null;

    /**
     * Вікно головного меню для груп
     */
    public static void mainMenu(){

        mainMenuPanel = new JPanel(new BorderLayout());
        mainMenuButtonsPanel = new JPanel(new GridLayout(3, 2));
        mainMenuComboPanel = new JPanel(new GridLayout(1, 2));

        JComboBox comboBox1 = new JComboBox();
        for (Groups e : Groups.productGroupsList){
            comboBox1.addItem(e.getName());
        }
        comboBox1.setSelectedItem(groupName);
        comboBox1.setFont(new Font("Arial",Font.BOLD,24));

        mainMenuComboPanel.add(comboBox1);

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedItem() != null)
                groupName = comboBox1.getSelectedItem().toString();
            }
        });
        mainMenuPanel.add(mainMenuComboPanel, "North");

        // Find group button
        SaveButton = new JButton("Save!");
        SaveButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(SaveButton);
        SaveButton.addActionListener(new ActionListener() {
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

        // Find product button
        showProductsProductButton = new JButton("Show products!");
        showProductsProductButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(showProductsProductButton);
        showProductsProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (groupName != null) {
                    x = mainMenuFrame.getX();
                    y = mainMenuFrame.getY();
                    mainMenuFrame.dispose();
                    Frames.ProductsMenu();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Group is not chosen",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add group button
        addGroupButton = new JButton("Add group!");
        addGroupButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(addGroupButton);
        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frames.addGroupWindow();
            }
        });

        // Add product button
        FindGroupButton = new JButton("Find group!");
        FindGroupButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(FindGroupButton);
        FindGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frames.searchGroup();
                comboBox1.setSelectedItem(groupName);
            }
        });


        DeleteGroupButton = new JButton("Delete group");
        DeleteGroupButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(DeleteGroupButton);
        DeleteGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (groupName == null){
                    JOptionPane.showMessageDialog(null,
                            "Group is not chosen",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    int action = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+groupName+"?", "Confirm action", JOptionPane.YES_NO_OPTION);
                    if (action == 0){
                        Buttons.deleteGroup(groupName);
                        groupName = null;
                        mainMenuFrame.dispose();
                        mainMenu();
                    }
                }
            }
        });
        editGroupButton = new JButton("Edit group");
        editGroupButton.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuButtonsPanel.add(editGroupButton);
        editGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (groupName == null){
                    JOptionPane.showMessageDialog(null,
                            "Group is not chosen",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Frames.editGroupWindow();
                }
            }
        });
        mainMenuPanel.add(mainMenuButtonsPanel, "Center");
        showGroupInfo = new JButton("Show group info");
        showGroupInfo.setFont(new Font("Arial",Font.BOLD,18));
        mainMenuPanel.add(showGroupInfo, "South");
        showGroupInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (groupName == null){
                    JOptionPane.showMessageDialog(null,
                            "Group is not chosen",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Frames.showGroupInfo();
                }
            }
        });
        mainMenuFrame = new JFrame("Shop");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(500, 300);
        mainMenuFrame.setLocation(x, y);
        mainMenuFrame.setVisible(true);
        mainMenuFrame.add(mainMenuPanel);

    }
}