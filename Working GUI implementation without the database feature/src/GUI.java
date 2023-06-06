import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *  This class is the GUI of the FarmApp.
 */
public class GUI {

    public GUI() {
        //creating the frame
        frame farmAppFrame = new frame();
        farmAppFrame.setSize(1600, 1000);
        farmAppFrame.setLayout(null);
        //create homepanel
        JPanel homePanel = new homePanel();
        homePanel.setBounds(0, 0, 1600, 1000);
        //refresh button
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBounds(0, 0, 100, 50);
        /**
         *  This method is the action listener for the refresh button.
         *  It refreshes the table.
         *  @param e is the action event.
         *           It is the action of clicking the refresh button.
         *  @return void
         */
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.repaint();
            }
        });
        //exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 0, 100, 50);
        /**
         * This method is the action listener for the exit button.
         * It exits the program.
         * @param e is the action event.
         *          It is the action of clicking the exit button.
         * @return void
         */
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FarmApp.exit();
            }
        });
        //add components to panel
        homePanel.add(refreshButton);
        homePanel.add(exitButton);
        farmAppFrame.add(homePanel);
        //create an addAnimalPanel
        addAnimalPanel addAnimalPanel = new addAnimalPanel();
        addAnimalPanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(addAnimalPanel);
        //create a deleteAnimalPanel
        deleteAnimalPanel deleteAnimalPanel = new deleteAnimalPanel();
        deleteAnimalPanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(deleteAnimalPanel);
        //create a getAnimalDetailsPanel
        getAnimalDetailsPanel getAnimalDetailsPanel = new getAnimalDetailsPanel();
        getAnimalDetailsPanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(getAnimalDetailsPanel);
        //create a addEmployeePanel
        addEmployeePanel addEmployeePanel = new addEmployeePanel();
        addEmployeePanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(addEmployeePanel);
        //create a deleteEmployeePanel
        deleteEmployeePanel deleteEmployeePanel = new deleteEmployeePanel();
        deleteEmployeePanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(deleteEmployeePanel);
        //create a getEmployeeDetailsPanel
        getEmployeeDetailsPanel getEmployeeDetailsPanel = new getEmployeeDetailsPanel();
        getEmployeeDetailsPanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(getEmployeeDetailsPanel);
        //create a addTreatmentPanel
        addTreatmentPanel addTreatmentPanel = new addTreatmentPanel();
        addTreatmentPanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(addTreatmentPanel);
        //create a getAnimalTreatmentPanel
        getAnimalTreatmentPanel getAnimalTreatmentPanel = new getAnimalTreatmentPanel();
        getAnimalTreatmentPanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(getAnimalTreatmentPanel);
        //create a listPanel
        listPanel listPanel = new listPanel();
        listPanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(listPanel);
        //create animalFeedingPanel
        animalFeedingPanel animalFeedingPanel = new animalFeedingPanel();
        animalFeedingPanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(animalFeedingPanel);
        //create an addMilkingMeasurementPanel
        addMilkingMeasurementPanel addMilkingMeasurementPanel = new addMilkingMeasurementPanel();
        addMilkingMeasurementPanel.setBounds(0, 0, 1600, 1000);
        farmAppFrame.add(addMilkingMeasurementPanel);
        //create a binary file on the program start up if it doesn't exist, use dataOutputstream
        File binaryFile = new File("FarmApp.bin");
        if (!binaryFile.exists()) {
            try {
                binaryFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //tell the user that the program is initiated an the data is going to be read and loaded using a binary file named FarmApp.bin by default, but the user can change it
        JOptionPane.showMessageDialog(null, "The program is initiated and a file named FarmApp.bin is created or exists, the data is going to be read and loaded from the file. If you want to create a new file, please do it on the menu");
        //read the data from the binary file and load it into the program
        FarmApp.read(binaryFile);
        //create a menubar to hold the JMenu
        JMenuBar menuBar = new JMenuBar();
        //create the JMenu
        JMenu menu = new JMenu("Menu");
        //create menu items
        //file
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        //seperator
        JSeparator seperator = new JSeparator();
        JMenuItem home = new JMenuItem("Home");
        JMenuItem addAnimal = new JMenuItem("Add Animal");
        JMenuItem deleteAnimal = new JMenuItem("Delete Animal");
        JMenuItem getAnimalDetails = new JMenuItem("Get Animal Details");
        JMenuItem addEmployee = new JMenuItem("Add Employee");
        JMenuItem deleteEmployee = new JMenuItem("Delete Employee");
        JMenuItem getEmployeeDetails = new JMenuItem("Get Employee Details");
        JMenuItem addTreatment = new JMenuItem("Add Treatment");
        JMenuItem getAnimalTreatment = new JMenuItem("Get Animal Treatment");
        JMenuItem listCows = new JMenuItem("List Animals or Employees");
        JMenuItem feedingDetails = new JMenuItem("Get feeding details for an animal");
        JMenuItem addMilkingMeasurement = new JMenuItem("Add milking measurement");
        //seperator
        JSeparator seperator2 = new JSeparator();
        JMenuItem exit = new JMenuItem("Exit");
        //add menu items to the menu
        menu.add(open);
        menu.add(save);
        menu.add(seperator);
        menu.add(home);
        menu.add(addAnimal);
        menu.add(deleteAnimal);
        menu.add(getAnimalDetails);
        menu.add(addEmployee);
        menu.add(deleteEmployee);
        menu.add(getEmployeeDetails);
        menu.add(addTreatment);
        menu.add(getAnimalTreatment);
        menu.add(listCows);
        menu.add(feedingDetails);
        menu.add(addMilkingMeasurement);
        menu.add(seperator2);
        menu.add(exit);
        //add the menu to the menu bar
        menuBar.add(menu);
        //add the menu bar to the frame
        farmAppFrame.setJMenuBar(menuBar);
        //add action listeners to the menu items

        //file
        /**
         * @param e
         *         It is the action of clicking the open on menu.
         *         It opens a file chooser and lets the user choose a file to open.
         *         It reads the data from the file and loads it into the program.
         *
         */
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //file chooser to read the binary file
                JFileChooser fileChooser = new JFileChooser(binaryFile.getAbsolutePath());
                fileChooser.setFileFilter(new FileNameExtensionFilter("Binary files", "bin"));
                fileChooser.setDialogTitle("Choose a binary file");
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    //read the binary file and load the data
                    FarmApp.read(selectedFile);
                }
            }
        });
        /**
         * @param e
         *        It is the action of clicking the save on menu.
         *        It opens a file chooser and lets the user choose a file to save.
         *        It saves the data from the program into the file.
         */
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //file chooser to write the binary file
                JFileChooser fileChooser2 = new JFileChooser(binaryFile.getAbsolutePath());
                fileChooser2.setFileFilter(new FileNameExtensionFilter("Binary files", "bin"));
                fileChooser2.setDialogTitle("Choose a binary file");
                int returnValue = fileChooser2.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser2.getSelectedFile();
                    //write the binary file and save the data
                    FarmApp.write(selectedFile);
                }
            }
        });
        /**
         * @param e
         *       It is the action of clicking the home on menu.
         *       It shows the homePanel.
         */
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(true);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *      It is the action of clicking the add animal on menu.
         *      It shows the addAnimalPanel.
         */
        addAnimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(true);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *     It is the action of clicking the delete animal on menu.
         *     It shows the deleteAnimalPanel.
         */
        deleteAnimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(true);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *    It is the action of clicking the get animal details on menu.
         *    It shows the getAnimalDetailsPanel.
         */
        getAnimalDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(true);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *  It is the action of clicking the add employee on menu.
         *  It shows the addEmployeePanel.
         */
        addEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(true);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *  It is the action of clicking the delete employee on menu.
         *  It shows the deleteEmployeePanel.
         */
        deleteEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(true);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *  It is the action of clicking the get employee details on menu.
         *  It shows the getEmployeeDetailsPanel.
         */
        getEmployeeDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(true);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *  It is the action of clicking the add treatment on menu.
         *  It shows the addTreatmentPanel.
         */
        addTreatment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(true);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *  It is the action of clicking the get animal treatment on menu.
         *  It shows the getAnimalTreatmentPanel.
         */
        getAnimalTreatment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(true);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *  It is the action of clicking the list on menu.
         *  It shows the listPanel.
         */
        listCows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(true);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *  It is the action of clicking the animal feeding on menu.
         *  It shows the animalFeedingPanel.
         */
        feedingDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(true);
                addMilkingMeasurementPanel.setVisible(false);
            }
        });
        /**
         * @param e
         *  It is the action of clicking the add milking measurement on menu.
         *  It shows the addMilkingMeasurementPanel.
         */
        addMilkingMeasurement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homePanel.setVisible(false);
                addAnimalPanel.setVisible(false);
                deleteAnimalPanel.setVisible(false);
                getAnimalDetailsPanel.setVisible(false);
                addEmployeePanel.setVisible(false);
                deleteEmployeePanel.setVisible(false);
                getEmployeeDetailsPanel.setVisible(false);
                addTreatmentPanel.setVisible(false);
                getAnimalTreatmentPanel.setVisible(false);
                listPanel.setVisible(false);
                animalFeedingPanel.setVisible(false);
                addMilkingMeasurementPanel.setVisible(true);
            }
        });
        /**
         * @param e
         *  It is the action of clicking the exit on menu.
         *  It closes the application.
         *  It shows a dialog box to ask the user if they want to save the data to a file.
         */
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //ask the user if they want to save the data to a file
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to save the data to a file?", "Save", JOptionPane.YES_NO_OPTION);
                //write the data using write method in FarmApp class
                if (choice == JOptionPane.YES_OPTION) {
                    //let the user select the file to save the data
                    JFileChooser fileChooser = new JFileChooser(binaryFile.getAbsolutePath());
                    fileChooser.setDialogTitle("Specify a file to save");
                    int userSelection = fileChooser.showSaveDialog(null);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        //write the data to the file
                        FarmApp.write(fileToSave);
                    }
                }
                //exit the program
                FarmApp.exit();
            }
        });
        //change default close operation to ask the user
        //if they want to save the data to a file
        //before exiting the program
        farmAppFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        /**
         * @param e
         * It is the action of clicking the close button on the frame.
         * It closes the application.
         * It shows a dialog box to ask the user if they want to save the data to a file.
         */
        farmAppFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //ask the user if they want to save the data to a file
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to save the data to a file?", "Save", JOptionPane.YES_NO_OPTION);
                //write the data using write method in FarmApp class
                if (choice == JOptionPane.YES_OPTION) {
                    //let the user select the file to save the data
                    JFileChooser fileChooser = new JFileChooser(binaryFile.getAbsolutePath());
                    fileChooser.setDialogTitle("Specify a file to save");
                    int userSelection = fileChooser.showSaveDialog(null);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        //write the data to the file
                        FarmApp.write(fileToSave);
                    }
                }
                //exit the program
                FarmApp.exit();
            }
        });

        homePanel.setVisible(true);
        addAnimalPanel.setVisible(false);
        deleteAnimalPanel.setVisible(false);
        getAnimalDetailsPanel.setVisible(false);
        addEmployeePanel.setVisible(false);
        deleteEmployeePanel.setVisible(false);
        getEmployeeDetailsPanel.setVisible(false);
        addTreatmentPanel.setVisible(false);
        getAnimalTreatmentPanel.setVisible(false);
        listPanel.setVisible(false);
        animalFeedingPanel.setVisible(false);
        addMilkingMeasurementPanel.setVisible(false);
        farmAppFrame.setVisible(true);

    }

    static class frame extends JFrame {
        frame() {
            this.setTitle("FarmApp");
            ImageIcon image = new ImageIcon("Logo_of_METU.png");
            this.setIconImage(image.getImage());
            this.getContentPane().setBackground(Color.darkGray);
        }
    }

    static class homePanel extends JPanel {
        homePanel() {
            this.setBackground(Color.darkGray);
            this.setLayout(null);
            JLabel homeLabel = new JLabel("Welcome to FarmApp!");
            homeLabel.setBounds(700, 400, 500, 100);
            homeLabel.setFont(new Font("Serif", Font.BOLD, 50));
            homeLabel.setForeground(Color.white);
            this.add(homeLabel);
            JLabel refreshLabel = new JLabel("You can use the menu on the left to navigate through the app.");
            refreshLabel.setBounds(400, 500, 700, 100);
            refreshLabel.setFont(new Font("Serif", Font.BOLD, 20));
            refreshLabel.setForeground(Color.white);
            this.add(refreshLabel);
        }
    }

    static class addAnimalPanel extends JPanel {
        addAnimalPanel() {
            //create a panel that will use the addCow method in FarmApp main class
            this.setBackground(Color.darkGray);
            this.setBounds(0, 0, 1600, 850);
            this.setLayout(null);
            //create a label for the panel
            JLabel addAnimalLabel = new JLabel("Add Animal (Sheep or Cow)");
            addAnimalLabel.setBounds(500, 50, 500, 50);
            addAnimalLabel.setFont(new Font("Serif", Font.BOLD, 40));
            addAnimalLabel.setForeground(Color.white);
            this.add(addAnimalLabel);
            //create a label for the cow name
            JLabel animalNameLabel = new JLabel("Animal Tag Number:");
            animalNameLabel.setBounds(500, 150, 300, 50);
            animalNameLabel.setFont(new Font("Serif", Font.BOLD, 30));
            animalNameLabel.setForeground(Color.white);
            this.add(animalNameLabel);
            //create a text field for the cow name
            JTextField animalTagNoTextField = new JTextField("tagno");
            animalTagNoTextField.setBounds(1000, 150, 300, 50);
            animalTagNoTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(animalTagNoTextField);
            //create a label for the cow gender
            JLabel animalGenderLabel = new JLabel("Animal Gender:");
            animalGenderLabel.setBounds(500, 250, 600, 50);
            animalGenderLabel.setFont(new Font("Serif", Font.BOLD, 30));
            animalGenderLabel.setForeground(Color.white);
            this.add(animalGenderLabel);
            //create a label for the date of birth
            JLabel animalDOBLabel = new JLabel("Date of Birth (yyyy-mm-dd):");
            animalDOBLabel.setBounds(500, 350, 600, 50);
            animalDOBLabel.setFont(new Font("Serif", Font.BOLD, 30));
            animalDOBLabel.setForeground(Color.white);
            this.add(animalDOBLabel);
            //create a combo box for the date of birth
            JTextField animalDOBTextField = new JTextField("yyyy-mm-dd");
            animalDOBTextField.setBounds(1000, 350, 300, 50);
            animalDOBTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(animalDOBTextField);
            //create a label for the cow weight
            JLabel cowWeightLabel = new JLabel("Weight (only for cows):");
            cowWeightLabel.setBounds(500, 450, 700, 50);
            cowWeightLabel.setFont(new Font("Serif", Font.BOLD, 30));
            cowWeightLabel.setForeground(Color.white);
            this.add(cowWeightLabel);
            //create a text field for the cow weight
            JTextField cowWeightTextField = new JTextField("ex: 100.56");
            cowWeightTextField.setBounds(1000, 450, 300, 50);
            cowWeightTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(cowWeightTextField);
            //create a combo box for the gender of the animal
            String[] animalGender = {"Male", "Female"};
            JComboBox animalGenderComboBox = new JComboBox(animalGender);
            animalGenderComboBox.setBounds(1000, 250, 300, 50);
            animalGenderComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(animalGenderComboBox);
            //create a label and a combo box for if the animal is purchased or not
            JLabel cowPurchasedLabel = new JLabel("Purchased (true/false):");
            cowPurchasedLabel.setBounds(500, 550, 700, 50);
            cowPurchasedLabel.setFont(new Font("Serif", Font.BOLD, 30));
            cowPurchasedLabel.setForeground(Color.white);
            this.add(cowPurchasedLabel);
            String[] animalPurchased = {"true", "false"};
            JComboBox animalPurchasedComboBox = new JComboBox(animalPurchased);
            animalPurchasedComboBox.setBounds(1000, 550, 300, 50);
            animalPurchasedComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(animalPurchasedComboBox);
            //a label and a combo box for the type of animal
            JLabel cowTypeLabel = new JLabel("Animal Type:");
            cowTypeLabel.setBounds(500, 650, 700, 50);
            cowTypeLabel.setFont(new Font("Serif", Font.BOLD, 30));
            cowTypeLabel.setForeground(Color.white);
            this.add(cowTypeLabel);
            String[] animalType = {"Cow", "Sheep"};
            JComboBox animalTypeComboBox = new JComboBox(animalType);
            animalTypeComboBox.setBounds(700, 650, 300, 50);
            animalTypeComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(animalTypeComboBox);
            //create a button for adding the cow
            JButton addCowButton = new JButton("Add Animal");
            addCowButton.setBounds(700, 750, 300, 50);
            addCowButton.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(addCowButton);
            //create a text to show the result of the adding cow
            JTextArea addAnimalResultTextArea = new JTextArea();
            addAnimalResultTextArea.setBounds(10, 750, 700, 50);
            addAnimalResultTextArea.setFont(new Font("Serif", Font.BOLD, 30));
            addAnimalResultTextArea.setEditable(false);
            this.add(addAnimalResultTextArea);
            //method to disable cowWeightTextField if selected combo box is Sheep
            animalTypeComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (animalTypeComboBox.getSelectedItem().equals("Sheep")) {
                        cowWeightTextField.setEnabled(false);
                    } else {
                        cowWeightTextField.setEnabled(true);
                    }
                }
            });
            //use the addCow and addSheep methods in the FarmApp class to add the animals
            addCowButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (animalTypeComboBox.getSelectedItem().equals("Sheep")) {
                        addAnimalResultTextArea.setText(FarmApp.addSheep(animalTagNoTextField.getText(), animalGenderComboBox.getSelectedItem().toString(), animalDOBTextField.getText(), animalPurchasedComboBox.getSelectedItem().toString()));
                    } else {
                        addAnimalResultTextArea.setText(FarmApp.addCow(animalTagNoTextField.getText(), animalGenderComboBox.getSelectedItem().toString(), animalDOBTextField.getText(), cowWeightTextField.getText(), animalPurchasedComboBox.getSelectedItem().toString()));
                    }
                }
            });

            this.setVisible(true);
        }
    }

    static class deleteAnimalPanel extends JPanel {
        deleteAnimalPanel() {
            //create a panel that will use the deletecow method in farmapp class
            this.setLayout(null);
            this.setBackground(Color.black);
            //create a label for the delete cow panel
            JLabel deleteAnimalLabel = new JLabel("Delete Animal");
            deleteAnimalLabel.setBounds(500, 50, 600, 50);
            deleteAnimalLabel.setFont(new Font("Serif", Font.BOLD, 30));
            deleteAnimalLabel.setForeground(Color.white);
            this.add(deleteAnimalLabel);
            //create a label for the cow name
            JLabel animalTagLabel = new JLabel("Animal Tag No:");
            animalTagLabel.setBounds(500, 150, 600, 50);
            animalTagLabel.setFont(new Font("Serif", Font.BOLD, 30));
            animalTagLabel.setForeground(Color.white);
            this.add(animalTagLabel);
            //create a text field for the cow name
            JTextField animalTagTextField = new JTextField("ex: 123456");
            animalTagTextField.setBounds(700, 150, 300, 50);
            animalTagTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(animalTagTextField);
            //create a combo box to select the type of animal
            JLabel animalTypeLabel = new JLabel("Animal Type:");
            animalTypeLabel.setBounds(500, 250, 700, 50);
            animalTypeLabel.setFont(new Font("Serif", Font.BOLD, 30));
            animalTypeLabel.setForeground(Color.white);
            this.add(animalTypeLabel);
            String[] animalType = {"Cow", "Sheep"};
            JComboBox animalTypeComboBox = new JComboBox(animalType);
            animalTypeComboBox.setBounds(700, 250, 300, 50);
            animalTypeComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(animalTypeComboBox);
            //create a button for deleting the cow
            JButton deleteAnimalButton = new JButton("Delete Animal");
            deleteAnimalButton.setBounds(700, 350, 300, 50);
            deleteAnimalButton.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(deleteAnimalButton);
            //create a text to show the result of the deleting cow
            JTextArea deleteAnimalResultTextArea = new JTextArea();
            deleteAnimalResultTextArea.setBounds(100, 350, 400, 50);
            deleteAnimalResultTextArea.setFont(new Font("Serif", Font.BOLD, 30));
            deleteAnimalResultTextArea.setEditable(false);
            this.add(deleteAnimalResultTextArea);
            //use the deleteCow and deleteSheep methods in FarmApp class
            deleteAnimalButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (animalTypeComboBox.getSelectedItem().equals("Cow")) {
                        deleteAnimalResultTextArea.setText(FarmApp.deleteCow(animalTagTextField.getText()));
                    } else {
                        deleteAnimalResultTextArea.setText(FarmApp.deleteSheep(animalTagTextField.getText()));
                    }
                }
            });

            //finalize the panel
            this.setVisible(true);
        }
    }

    static class getAnimalDetailsPanel extends JPanel {
        getAnimalDetailsPanel() {
            //create a panel that will use the getcowdetails method in farmapp class
            this.setLayout(null);
            this.setBackground(Color.black);
            //create a label for the get cow details panel
            JLabel getAnimalDetailsLabel = new JLabel("Get Animal Details");
            getAnimalDetailsLabel.setBounds(500, 50, 600, 50);
            getAnimalDetailsLabel.setFont(new Font("Serif", Font.BOLD, 30));
            getAnimalDetailsLabel.setForeground(Color.white);
            this.add(getAnimalDetailsLabel);
            //create a label for the cow name
            JLabel animalTagLabel = new JLabel("Animal Tag No:");
            animalTagLabel.setBounds(500, 150, 600, 50);
            animalTagLabel.setFont(new Font("Serif", Font.BOLD, 30));
            animalTagLabel.setForeground(Color.white);
            this.add(animalTagLabel);
            //create a text field for the tagNo
            JTextField animalTagTextField = new JTextField("ex: 123456");
            animalTagTextField.setBounds(700, 150, 300, 50);
            animalTagTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(animalTagTextField);
            //create a combo box to select the type of animal
            JLabel animalTypeLabel = new JLabel("Animal Type:");
            animalTypeLabel.setBounds(500, 250, 700, 50);
            animalTypeLabel.setFont(new Font("Serif", Font.BOLD, 30));
            animalTypeLabel.setForeground(Color.white);
            this.add(animalTypeLabel);
            String[] animalType = {"Cow", "Sheep"};
            JComboBox animalTypeComboBox = new JComboBox(animalType);
            animalTypeComboBox.setBounds(700, 250, 300, 50);
            animalTypeComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(animalTypeComboBox);
            //button to get the cow details
            JButton getAnimalDetailsButton = new JButton("Get Animal Details");
            getAnimalDetailsButton.setBounds(700, 350, 300, 50);
            getAnimalDetailsButton.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(getAnimalDetailsButton);
            //create a text to show the result of the getting cow details
            JTextArea getAnimalDetailsResultTextArea = new JTextArea();
            getAnimalDetailsResultTextArea.setBounds(100, 350, 400, 300);
            getAnimalDetailsResultTextArea.setFont(new Font("Serif", Font.BOLD, 30));
            getAnimalDetailsResultTextArea.setEditable(false);
            this.add(getAnimalDetailsResultTextArea);
            //use the getcowdetails method in farmapp class
            getAnimalDetailsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //get the cow name from the text field
                    String tagNo = animalTagTextField.getText();
                    //get the cow type from the combo box
                    String animalType = (String) animalTypeComboBox.getSelectedItem();
                    //use the getcowdetails method in farmapp class
                    String result = FarmApp.getAnimalDetails(tagNo, animalType);
                    //show the result in the text area
                    getAnimalDetailsResultTextArea.setText(result);
                }
            });
            //finalize the panel
            this.setVisible(true);
        }
    }

    static class addEmployeePanel extends JPanel {
        addEmployeePanel() {
            //creating a panel that will ask the user to enter the employee details which are
            //For veterinaries: Employee ID, gender, dateofbirth, BSc Degree, dateofgraduation, expertiselevel
            //For farmworkers: Employee ID, gender, dateofbirth, previousfarm, years of experience

            this.setLayout(null);
            this.setBackground(Color.black);
            //create a label for the add employee panel
            JLabel addEmployeeLabel = new JLabel("Add Employee");
            addEmployeeLabel.setBounds(500, 50, 600, 50);
            addEmployeeLabel.setFont(new Font("Serif", Font.BOLD, 30));
            addEmployeeLabel.setForeground(Color.white);
            this.add(addEmployeeLabel);
            //create a label for the employee id
            JLabel employeeIDLabel = new JLabel("ID:");
            employeeIDLabel.setBounds(50, 100, 600, 50);
            employeeIDLabel.setFont(new Font("Serif", Font.BOLD, 30));
            employeeIDLabel.setForeground(Color.white);
            this.add(employeeIDLabel);
            //create a text field for the employee id
            JTextField employeeIDTextField = new JTextField("ex: 123456");
            employeeIDTextField.setBounds(150, 100, 150, 50);
            employeeIDTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(employeeIDTextField);
            //create a label for the employee gender
            JLabel employeeGenderLabel = new JLabel("Gender:");
            employeeGenderLabel.setBounds(50, 150, 600, 50);
            employeeGenderLabel.setFont(new Font("Serif", Font.BOLD, 30));
            employeeGenderLabel.setForeground(Color.white);
            this.add(employeeGenderLabel);
            //create a combobox for the employee gender
            String[] employeeGender = {"male", "female"};
            JComboBox employeeGenderComboBox = new JComboBox(employeeGender);
            employeeGenderComboBox.setBounds(150, 150, 150, 50);
            employeeGenderComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(employeeGenderComboBox);
            //create a label for the employee date of birth
            JLabel employeeDateOfBirthLabel = new JLabel("Date of Birth:");
            employeeDateOfBirthLabel.setBounds(50, 200, 600, 50);
            employeeDateOfBirthLabel.setFont(new Font("Serif", Font.BOLD, 30));
            employeeDateOfBirthLabel.setForeground(Color.white);
            this.add(employeeDateOfBirthLabel);
            //create a text field for the employee date of birth
            JTextField employeeDateOfBirthTextField = new JTextField("ex: 1999-01-01");
            employeeDateOfBirthTextField.setBounds(250, 200, 150, 50);
            employeeDateOfBirthTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(employeeDateOfBirthTextField);
            //create a label for the employee type
            JLabel employeeTypeLabel = new JLabel("Employee Type:");
            employeeTypeLabel.setBounds(50, 250, 600, 50);
            employeeTypeLabel.setFont(new Font("Serif", Font.BOLD, 30));
            employeeTypeLabel.setForeground(Color.white);
            this.add(employeeTypeLabel);
            //create a combobox for the employee type
            String[] employeeType = {"Veterinary", "Farmworker"};
            JComboBox employeeTypeComboBox = new JComboBox(employeeType);
            employeeTypeComboBox.setBounds(275, 250, 250, 50);
            employeeTypeComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(employeeTypeComboBox);
            //create a label saying "Veterinary Details"
            JLabel veterinaryDetailsLabel = new JLabel("Veterinary Details");
            veterinaryDetailsLabel.setBounds(50, 300, 600, 50);
            veterinaryDetailsLabel.setFont(new Font("Serif", Font.BOLD, 30));
            veterinaryDetailsLabel.setForeground(Color.white);
            this.add(veterinaryDetailsLabel);
            //create a label for the veterinary degree
            JLabel veterinaryDegreeLabel = new JLabel("Degree:");
            veterinaryDegreeLabel.setBounds(50, 350, 600, 50);
            veterinaryDegreeLabel.setFont(new Font("Serif", Font.BOLD, 30));
            veterinaryDegreeLabel.setForeground(Color.white);
            this.add(veterinaryDegreeLabel);
            //create a combobox for the veterinary degree
            String[] veterinaryDegree = {"true", "false"};
            JComboBox veterinaryDegreeComboBox = new JComboBox(veterinaryDegree);
            veterinaryDegreeComboBox.setBounds(150, 350, 150, 50);
            veterinaryDegreeComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(veterinaryDegreeComboBox);
            //create a label for the veterinary date of graduation
            JLabel veterinaryDateOfGraduationLabel = new JLabel("Date of Graduation:");
            veterinaryDateOfGraduationLabel.setBounds(50, 400, 600, 50);
            veterinaryDateOfGraduationLabel.setFont(new Font("Serif", Font.BOLD, 30));
            veterinaryDateOfGraduationLabel.setForeground(Color.white);
            this.add(veterinaryDateOfGraduationLabel);
            //create a text field for the veterinary date of graduation
            JTextField veterinaryDateOfGraduationTextField = new JTextField("ex: 2019-01-01");
            veterinaryDateOfGraduationTextField.setBounds(350, 400, 150, 50);
            veterinaryDateOfGraduationTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(veterinaryDateOfGraduationTextField);
            //create a label for the veterinary expertise level
            JLabel veterinaryExpertiseLevelLabel = new JLabel("Expertise Level:");
            veterinaryExpertiseLevelLabel.setBounds(50, 450, 600, 50);
            veterinaryExpertiseLevelLabel.setFont(new Font("Serif", Font.BOLD, 30));
            veterinaryExpertiseLevelLabel.setForeground(Color.white);
            this.add(veterinaryExpertiseLevelLabel);
            //create a combobox for the veterinary expertise level
            String[] veterinaryExpertiseLevel = {"1", "2", "3", "4", "5"};
            JComboBox veterinaryExpertiseLevelComboBox = new JComboBox(veterinaryExpertiseLevel);
            veterinaryExpertiseLevelComboBox.setBounds(275, 450, 250, 50);
            veterinaryExpertiseLevelComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(veterinaryExpertiseLevelComboBox);
            //create a label saying "Farmworker Details"
            JLabel farmworkerDetailsLabel = new JLabel("Farmworker Details");
            farmworkerDetailsLabel.setBounds(600, 300, 600, 50);
            farmworkerDetailsLabel.setFont(new Font("Serif", Font.BOLD, 30));
            farmworkerDetailsLabel.setForeground(Color.white);
            this.add(farmworkerDetailsLabel);
            //create a label for the farmworker previous farm name
            JLabel farmworkerPreviousFarmNameLabel = new JLabel("Previous Farm Name:");
            farmworkerPreviousFarmNameLabel.setBounds(600, 350, 600, 50);
            farmworkerPreviousFarmNameLabel.setFont(new Font("Serif", Font.BOLD, 30));
            farmworkerPreviousFarmNameLabel.setForeground(Color.white);
            this.add(farmworkerPreviousFarmNameLabel);
            //create a text field for the farmworker previous farm name
            JTextField farmworkerPreviousFarmNameTextField = new JTextField("ex: Farm 1");
            farmworkerPreviousFarmNameTextField.setBounds(900, 350, 150, 50);
            farmworkerPreviousFarmNameTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(farmworkerPreviousFarmNameTextField);
            //create a label for the farmworker years of experience
            JLabel farmworkerYearsOfExperienceLabel = new JLabel("Years of Experience:");
            farmworkerYearsOfExperienceLabel.setBounds(600, 400, 600, 50);
            farmworkerYearsOfExperienceLabel.setFont(new Font("Serif", Font.BOLD, 30));
            farmworkerYearsOfExperienceLabel.setForeground(Color.white);
            this.add(farmworkerYearsOfExperienceLabel);
            //create a text field for the farmworker years of experience
            JTextField farmworkerYearsOfExperienceTextField = new JTextField("ex: 5");
            farmworkerYearsOfExperienceTextField.setBounds(900, 400, 150, 50);
            farmworkerYearsOfExperienceTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(farmworkerYearsOfExperienceTextField);
            //add a button to add the employee
            JButton addEmployeeButton = new JButton("Add Employee");
            addEmployeeButton.setBounds(50, 550, 300, 50);
            addEmployeeButton.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(addEmployeeButton);
            //add a text area to display the results
            JTextArea resultsTextArea = new JTextArea();
            resultsTextArea.setBounds(50, 650, 1000, 200);
            resultsTextArea.setFont(new Font("Serif", Font.BOLD, 30));
            resultsTextArea.setEditable(false);
            this.add(resultsTextArea);
            //deactivate the veterinary details if the type is farmworker
            employeeTypeComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (employeeTypeComboBox.getSelectedItem().equals("Farmworker")) {
                        veterinaryDegreeComboBox.setEnabled(false);
                        veterinaryDateOfGraduationTextField.setEnabled(false);
                        veterinaryExpertiseLevelComboBox.setEnabled(false);
                        farmworkerPreviousFarmNameTextField.setEnabled(true);
                        farmworkerYearsOfExperienceTextField.setEnabled(true);
                    } else {
                        veterinaryDegreeComboBox.setEnabled(true);
                        veterinaryDateOfGraduationTextField.setEnabled(true);
                        veterinaryExpertiseLevelComboBox.setEnabled(true);
                        farmworkerPreviousFarmNameTextField.setEnabled(false);
                        farmworkerYearsOfExperienceTextField.setEnabled(false);
                    }
                }
            });
            //add an action listener to the add employee button
            addEmployeeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //get the employee type
                    String employeeType = (String) employeeTypeComboBox.getSelectedItem();
                    //get the employee name
                    String employeeID = employeeIDTextField.getText();
                    //get the employee gender
                    String employeeGender = (String) employeeGenderComboBox.getSelectedItem();
                    //get the employee date of birth
                    String employeeDateOfBirth = employeeDateOfBirthTextField.getText();
                    //if the employee type is a veterinary
                    if (employeeType.equals("Veterinary")) {
                        //get the veterinary degree
                        String veterinaryDegree = (String) veterinaryDegreeComboBox.getSelectedItem();
                        //get the veterinary date of graduation
                        String veterinaryDateOfGraduation = veterinaryDateOfGraduationTextField.getText();
                        //get the veterinary expertise level
                        String veterinaryExpertiseLevel = (String) veterinaryExpertiseLevelComboBox.getSelectedItem();
                        //use the addVet method in FarmApp class
                        resultsTextArea.setText(FarmApp.addVet(employeeID, employeeGender, employeeDateOfBirth, veterinaryDegree, veterinaryDateOfGraduation, veterinaryExpertiseLevel));
                    }
                    //if the employee type is a farmworker
                    else {
                        //get the farmworker previous farm name
                        String farmworkerPreviousFarmName = farmworkerPreviousFarmNameTextField.getText();
                        //get the farmworker years of experience
                        String farmworkerYearsOfExperience = farmworkerYearsOfExperienceTextField.getText();
                        //use the addFarmworker method in FarmApp class
                        resultsTextArea.setText(FarmApp.addFarmWorker(employeeID, employeeGender, employeeDateOfBirth, farmworkerPreviousFarmName, farmworkerYearsOfExperience));
                    }
                }
            });

            //finalize the panel
            this.setVisible(true);

        }
    }

    static class deleteEmployeePanel extends JPanel {
        deleteEmployeePanel() {
            //set the layout to null
            this.setLayout(null);
            //set the background color
            this.setBackground(Color.black);
            //create a label saying "Delete Employee"
            JLabel deleteEmployeeLabel = new JLabel("Delete Employee");
            deleteEmployeeLabel.setBounds(50, 50, 600, 50);
            deleteEmployeeLabel.setFont(new Font("Serif", Font.BOLD, 30));
            deleteEmployeeLabel.setForeground(Color.white);
            this.add(deleteEmployeeLabel);
            //create a label saying "Employee ID"
            JLabel employeeIDLabel = new JLabel("Employee ID:");
            employeeIDLabel.setBounds(50, 150, 600, 50);
            employeeIDLabel.setFont(new Font("Serif", Font.BOLD, 30));
            employeeIDLabel.setForeground(Color.white);
            this.add(employeeIDLabel);
            //create a text field for the employee ID
            JTextField employeeIDTextField = new JTextField("ex: 1");
            employeeIDTextField.setBounds(275, 150, 250, 50);
            employeeIDTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(employeeIDTextField);
            //create a combobox for the employee type
            String[] employeeTypeOptions = {"Veterinary", "Farmworker"};
            JComboBox employeeTypeComboBox = new JComboBox(employeeTypeOptions);
            employeeTypeComboBox.setBounds(50, 250, 300, 50);
            employeeTypeComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(employeeTypeComboBox);
            //add a button to delete the employee
            JButton deleteEmployeeButton = new JButton("Delete Employee");
            deleteEmployeeButton.setBounds(50, 350, 300, 50);
            deleteEmployeeButton.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(deleteEmployeeButton);
            //add a text area to display the results
            JTextArea resultsTextArea = new JTextArea();
            resultsTextArea.setBounds(50, 450, 1000, 200);
            resultsTextArea.setFont(new Font("Serif", Font.BOLD, 30));
            resultsTextArea.setEditable(false);
            this.add(resultsTextArea);
            //add an action listener to the delete employee button
            deleteEmployeeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //get the employee type
                    String employeeType = (String) employeeTypeComboBox.getSelectedItem();
                    //get the employee ID
                    String employeeID = employeeIDTextField.getText();
                    //if the employee type is a veterinary
                    if (employeeType.equals("Veterinary")) {
                        //use the deleteVet method in FarmApp class
                        resultsTextArea.setText(FarmApp.deleteVet(employeeID));
                    }
                    //if the employee type is a farmworker
                    else {
                        //use the deleteFarmworker method in FarmApp class
                        resultsTextArea.setText(FarmApp.deleteFarmWorker(employeeID));
                    }
                }
            });
            //finalize the panel
            this.setVisible(true);

        }
    }

    static class getEmployeeDetailsPanel extends JPanel {
        getEmployeeDetailsPanel() {
            //set the layout to null
            this.setLayout(null);
            //set the background color
            this.setBackground(Color.black);
            //create a label saying "Get Employee Details"
            JLabel getEmployeeDetailsLabel = new JLabel("Get Employee Details");
            getEmployeeDetailsLabel.setBounds(50, 50, 600, 50);
            getEmployeeDetailsLabel.setFont(new Font("Serif", Font.BOLD, 30));
            getEmployeeDetailsLabel.setForeground(Color.white);
            this.add(getEmployeeDetailsLabel);
            //create a label saying "Employee ID"
            JLabel employeeIDLabel = new JLabel("Employee ID:");
            employeeIDLabel.setBounds(50, 150, 600, 50);
            employeeIDLabel.setFont(new Font("Serif", Font.BOLD, 30));
            employeeIDLabel.setForeground(Color.white);
            this.add(employeeIDLabel);
            //create a text field for the employee ID
            JTextField employeeIDTextField = new JTextField("ex: 1");
            employeeIDTextField.setBounds(275, 150, 250, 50);
            employeeIDTextField.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(employeeIDTextField);
            //create a combobox for the employee type
            String[] employeeTypeOptions = {"Veterinary", "Farmworker"};
            JComboBox employeeTypeComboBox = new JComboBox(employeeTypeOptions);
            employeeTypeComboBox.setBounds(50, 250, 300, 50);
            employeeTypeComboBox.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(employeeTypeComboBox);
            //add a button to get the employee details
            JButton getEmployeeDetailsButton = new JButton("Get Employee Details");
            getEmployeeDetailsButton.setBounds(50, 350, 300, 50);
            getEmployeeDetailsButton.setFont(new Font("Serif", Font.BOLD, 30));
            this.add(getEmployeeDetailsButton);
            //add a text area to display the results
            JTextArea resultsTextArea = new JTextArea();
            resultsTextArea.setBounds(50, 450, 1000, 500);
            resultsTextArea.setFont(new Font("Serif", Font.BOLD, 30));
            resultsTextArea.setEditable(false);
            this.add(resultsTextArea);
            //add an action listener to the get employee details button
            getEmployeeDetailsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //get the employee type
                    String employeeType = (String) employeeTypeComboBox.getSelectedItem();
                    //get the employee ID
                    String employeeID = employeeIDTextField.getText();
                    //if the employee type is a veterinary
                    if (employeeType.equals("Veterinary")) {
                        //use the getVetDetails method in FarmApp class
                        resultsTextArea.setText(FarmApp.getVetDetails(employeeID));
                    }
                    //if the employee type is a farmworker
                    else {
                        //use the getFarmworkerDetails method in FarmApp class
                        resultsTextArea.setText(FarmApp.getFarmWorkerDetails(employeeID));
                    }
                }
            });
            //finalize the panel
            this.setVisible(true);
        }
    }

    static class addTreatmentPanel extends JPanel {
        addTreatmentPanel() {
            //set the layout to null
            this.setLayout(null);
            //set the background color
            this.setBackground(Color.black);
            //create a label saying "Add Treatment"
            JLabel addTreatmentLabel = new JLabel("Add Treatment");
            addTreatmentLabel.setBounds(25, 10, 600, 50);
            addTreatmentLabel.setFont(new Font("Serif", Font.BOLD, 20));
            addTreatmentLabel.setForeground(Color.white);
            this.add(addTreatmentLabel);
            //ask the user to enter the treatment date
            JLabel treatmentDateLabel = new JLabel("Treatment Date:");
            treatmentDateLabel.setBounds(25, 50, 600, 50);
            treatmentDateLabel.setFont(new Font("Serif", Font.BOLD, 20));
            treatmentDateLabel.setForeground(Color.white);
            this.add(treatmentDateLabel);
            //create a text field for the treatment date
            JTextField treatmentDateTextField = new JTextField("ex: 2020-01-01");
            treatmentDateTextField.setBounds(175, 60, 175, 30);
            treatmentDateTextField.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(treatmentDateTextField);
            //ask the user to enter the treatment type
            JLabel treatmentTypeLabel = new JLabel("Treatment Type:");
            treatmentTypeLabel.setBounds(25, 80, 600, 50);
            treatmentTypeLabel.setFont(new Font("Serif", Font.BOLD, 20));
            treatmentTypeLabel.setForeground(Color.white);
            this.add(treatmentTypeLabel);
            //create a combobox for the treatment type
            String[] treatmentTypeOptions = {"health", "cleaning"};
            JComboBox treatmentTypeComboBox = new JComboBox(treatmentTypeOptions);
            treatmentTypeComboBox.setBounds(175, 90, 175, 30);
            treatmentTypeComboBox.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(treatmentTypeComboBox);
            //if the treatment type is health:
            //ask the user if the treatment is an emergency
            JLabel emergencyLabel = new JLabel("Emergency:");
            emergencyLabel.setBounds(25, 110, 600, 50);
            emergencyLabel.setFont(new Font("Serif", Font.BOLD, 20));
            emergencyLabel.setForeground(Color.white);
            this.add(emergencyLabel);
            //create a combobox for the emergency type
            String[] emergencyOptions = {"true", "false"};
            JComboBox emergencyComboBox = new JComboBox(emergencyOptions);
            emergencyComboBox.setBounds(175, 120, 175, 30);
            emergencyComboBox.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(emergencyComboBox);
            //enter the number of medications
            JLabel numberOfMedicationsLabel = new JLabel("Number of Medications:");
            numberOfMedicationsLabel.setBounds(25, 140, 600, 50);
            numberOfMedicationsLabel.setFont(new Font("Serif", Font.BOLD, 20));
            numberOfMedicationsLabel.setForeground(Color.white);
            this.add(numberOfMedicationsLabel);
            //create a combobox for the number of medications
            String[] numberOfMedicationsOptions = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            JComboBox numberOfMedicationsComboBox = new JComboBox(numberOfMedicationsOptions);
            numberOfMedicationsComboBox.setBounds(275, 150, 75, 30);
            numberOfMedicationsComboBox.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(numberOfMedicationsComboBox);
            //enter the name of each medication
            JLabel medicationNameLabel = new JLabel("Medication Details:");
            medicationNameLabel.setBounds(25, 170, 600, 50);
            medicationNameLabel.setFont(new Font("Serif", Font.BOLD, 20));
            medicationNameLabel.setForeground(Color.white);
            this.add(medicationNameLabel);
            //create a table that has rows for each medication that the user enters
            String[] medicationNameColumnNames = {"Details", "Dosage", "Duration", "Start Date", "Notes"};
            DefaultTableModel medicationDetailsTableModel = new DefaultTableModel(medicationNameColumnNames, 0);
            JTable medicationDetailsTable = new JTable(medicationDetailsTableModel);
            medicationDetailsTable.setBounds(45, 230, 600, 200);
            medicationDetailsTable.setFont(new Font("Serif", Font.BOLD, 20));
            medicationDetailsTable.setRowHeight(30);
            medicationDetailsTable.setRowSelectionAllowed(false);
            medicationDetailsTable.setColumnSelectionAllowed(false);
            medicationDetailsTable.setCellSelectionEnabled(true);
            JScrollPane medicationNameScrollPane = new JScrollPane(medicationDetailsTable);
            medicationNameScrollPane.setBounds(45, 230, 600, 200);
            this.add(medicationNameScrollPane);
            //if the treatment type is cleaning:
            //enter the name of the cleaning material
            JLabel cleaningMaterialLabel = new JLabel("Cleaning Material:");
            cleaningMaterialLabel.setBounds(25, 450, 600, 50);
            cleaningMaterialLabel.setFont(new Font("Serif", Font.BOLD, 20));
            cleaningMaterialLabel.setForeground(Color.white);
            this.add(cleaningMaterialLabel);
            //create a text field for the cleaning material
            JTextField cleaningMaterialTextField = new JTextField("ex: brush");
            cleaningMaterialTextField.setBounds(200, 465, 175, 30);
            cleaningMaterialTextField.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(cleaningMaterialTextField);
            //ask for the ID of the animal that the treatment is for
            JLabel animalIDLabel = new JLabel("Animal ID:");
            animalIDLabel.setBounds(25, 550, 600, 50);
            animalIDLabel.setFont(new Font("Serif", Font.BOLD, 20));
            animalIDLabel.setForeground(Color.white);
            this.add(animalIDLabel);
            //create a text field for the animal ID
            JTextField animalIDTextField = new JTextField("ex: 1");
            animalIDTextField.setBounds(150, 565, 175, 30);
            animalIDTextField.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(animalIDTextField);
            //ask for the ID of the employee that is adding the treatment
            JLabel employeeIDLabel = new JLabel("Employee ID:");
            employeeIDLabel.setBounds(25, 595, 600, 50);
            employeeIDLabel.setFont(new Font("Serif", Font.BOLD, 20));
            employeeIDLabel.setForeground(Color.white);
            this.add(employeeIDLabel);
            //create a text field for the employee ID
            JTextField employeeIDTextField = new JTextField("ex: 1");
            employeeIDTextField.setBounds(175, 610, 175, 30);
            employeeIDTextField.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(employeeIDTextField);
            //button to add the treatment
            JButton addTreatmentButton = new JButton("Add Treatment");
            addTreatmentButton.setBounds(25, 650, 600, 50);
            addTreatmentButton.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(addTreatmentButton);
            //show the result using a text area
            JTextArea resultTextArea = new JTextArea();
            resultTextArea.setBounds(25, 700, 600, 50);
            resultTextArea.setFont(new Font("Serif", Font.BOLD, 20));
            resultTextArea.setEditable(false);
            this.add(resultTextArea);

            //disable the emergency combobox and medication table if the treatment type is cleaning using an action listener
            treatmentTypeComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (treatmentTypeComboBox.getSelectedItem().equals("cleaning")) {
                        emergencyComboBox.setEnabled(false);
                        numberOfMedicationsComboBox.setEnabled(false);
                        medicationDetailsTable.setEnabled(false);
                        cleaningMaterialTextField.setEnabled(true);
                    } else {
                        emergencyComboBox.setEnabled(true);
                        numberOfMedicationsComboBox.setEnabled(true);
                        medicationDetailsTable.setEnabled(true);
                        cleaningMaterialTextField.setEnabled(false);
                    }
                }
            });

            //change the number of rows in the table based on the number of medications entered
            numberOfMedicationsComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int numberOfMedications = Integer.parseInt((String) numberOfMedicationsComboBox.getSelectedItem());
                    medicationDetailsTableModel.setRowCount(numberOfMedications);
                }
            });
            //add an action listener to the add treatment button using the addTreatment method in FarmApp class
            addTreatmentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String treatmentDate = treatmentDateTextField.getText();
                    String treatmentType = (String) treatmentTypeComboBox.getSelectedItem();
                    String emergency = (String) emergencyComboBox.getSelectedItem();
                    ArrayList<Medication> Medications = new ArrayList<>();
                    for (int i = 0; i < medicationDetailsTable.getRowCount(); i++) {
                        String medicationDetails = (String) medicationDetailsTable.getValueAt(i, 0);
                        int medicationDosage = Integer.parseInt((String) medicationDetailsTable.getValueAt(i, 1));
                        int medicationDuration = Integer.parseInt((String) medicationDetailsTable.getValueAt(i, 2));
                        LocalDate medicationStartDate = LocalDate.parse((String) medicationDetailsTable.getValueAt(i, 3));
                        String medicationNotes = (String) medicationDetailsTable.getValueAt(i, 4);
                        Medications.add(new Medication(medicationDetails, medicationDuration, medicationStartDate, medicationDosage, medicationNotes));
                    }
                    String cleaningMaterial = cleaningMaterialTextField.getText();
                    int animalID = Integer.parseInt(animalIDTextField.getText());
                    int employeeID = Integer.parseInt(employeeIDTextField.getText());
                    String result = FarmApp.addTreatment(treatmentDate, treatmentType, emergency, Medications, cleaningMaterial, animalID, employeeID);
                    resultTextArea.setText(result);
                }
            });
            //finalize the panel
            this.setVisible(true);
        }
    }

    static class getAnimalTreatmentPanel extends JPanel {
        getAnimalTreatmentPanel() {
            //set the layout to null
            this.setLayout(null);
            //set the background color
            this.setBackground(Color.black);
            //get animal details header
            JLabel getAnimalDetailsHeader = new JLabel("Get Animal Details");
            getAnimalDetailsHeader.setBounds(25, 25, 600, 50);
            getAnimalDetailsHeader.setFont(new Font("Serif", Font.BOLD, 30));
            getAnimalDetailsHeader.setForeground(Color.white);
            this.add(getAnimalDetailsHeader);
            //ask for the ID of the animal
            JLabel animalIDLabel = new JLabel("Animal ID:");
            animalIDLabel.setBounds(25, 100, 600, 50);
            animalIDLabel.setFont(new Font("Serif", Font.BOLD, 20));
            animalIDLabel.setForeground(Color.white);
            this.add(animalIDLabel);
            //create a text field for the animal ID
            JTextField animalIDTextField = new JTextField("ex: 1");
            animalIDTextField.setBounds(150, 115, 175, 30);
            animalIDTextField.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(animalIDTextField);
            //Want to get treatments on a specific date?
            JLabel specificDateLabel = new JLabel("Want to get treatments on a specific date? If not leave blank");
            specificDateLabel.setBounds(25, 150, 600, 50);
            specificDateLabel.setFont(new Font("Serif", Font.BOLD, 20));
            specificDateLabel.setForeground(Color.white);
            this.add(specificDateLabel);
            //create a text field for the date
            JTextField specificDateTextField = new JTextField("ex: 2020-01-01");
            specificDateTextField.setBounds(800, 160, 300, 30);
            specificDateTextField.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(specificDateTextField);
            //button to get the animal details
            JButton getAnimalDetailsButton = new JButton("Get Animal Details");
            getAnimalDetailsButton.setBounds(25, 200, 600, 50);
            getAnimalDetailsButton.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(getAnimalDetailsButton);
            //show the result using a text area
            JTextArea resultTextArea = new JTextArea();
            resultTextArea.setBounds(25, 300, 900, 500);
            resultTextArea.setFont(new Font("Serif", Font.BOLD, 20));
            resultTextArea.setEditable(false);
            //add scroll bar to the text area
            this.add(resultTextArea);
            JScrollPane scrollPane = new JScrollPane(resultTextArea);
            scrollPane.setBounds(25, 300, 900, 500);
            this.add(scrollPane);
            //add an action listener to the get animal treatment details using the getTreatmentDetails method in FarmApp class
            getAnimalDetailsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (specificDateTextField.getText().equals("")) {
                        int animalID = Integer.parseInt(animalIDTextField.getText());
                        String result = FarmApp.getTreatmentDetails(animalID);
                        resultTextArea.setText(result);
                    } else {
                        int animalID = Integer.parseInt(animalIDTextField.getText());
                        LocalDate specificDate = LocalDate.parse(specificDateTextField.getText());
                        String result = FarmApp.getTreatmentDetails(animalID, specificDate);
                        resultTextArea.setText(result);
                    }
                }
            });


        }
    }

    static class listPanel extends JPanel {
        listPanel() {
            //set the layout to null
            this.setLayout(null);
            //set the background color
            this.setBackground(Color.black);
            //list cows header
            JLabel listCowsHeader = new JLabel("List Animals or Employees");
            listCowsHeader.setBounds(25, 25, 600, 50);
            listCowsHeader.setFont(new Font("Serif", Font.BOLD, 30));
            listCowsHeader.setForeground(Color.white);
            this.add(listCowsHeader);
            //ask for the type of list
            JLabel listTypeLabel = new JLabel("List Type:");
            listTypeLabel.setBounds(25, 100, 600, 50);
            listTypeLabel.setFont(new Font("Serif", Font.BOLD, 20));
            listTypeLabel.setForeground(Color.white);
            this.add(listTypeLabel);
            //create a combo box for the list type
            String[] listType = {"Cows", "Sheeps", "Vets", "FarmWorkers"};
            JComboBox listTypeComboBox = new JComboBox(listType);
            listTypeComboBox.setBounds(150, 115, 175, 30);
            listTypeComboBox.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(listTypeComboBox);
            //button to get the list
            JButton getListButton = new JButton("Get List");
            getListButton.setBounds(25, 200, 600, 50);
            getListButton.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(getListButton);
            //show the result using a text area
            JTextArea resultTextArea = new JTextArea();
            resultTextArea.setBounds(25, 300, 900, 500);
            resultTextArea.setFont(new Font("Serif", Font.BOLD, 20));
            resultTextArea.setEditable(false);
            //add scroll bar to the text area
            this.add(resultTextArea);
            JScrollPane scrollPane = new JScrollPane(resultTextArea);
            scrollPane.setBounds(25, 300, 900, 500);
            this.add(scrollPane);
            //add an action listener to the get list button using the getList method in FarmApp class
            getListButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String listType = (String) listTypeComboBox.getSelectedItem();
                    String result = FarmApp.getList(listType);
                    resultTextArea.setText(result);
                }
            });
            //finalize the panel
            this.setVisible(true);
        }
    }

    static class animalFeedingPanel extends JPanel {
        animalFeedingPanel() {
            //set the layout to null
            this.setLayout(null);
            //set the background color
            this.setBackground(Color.black);
            //animal feeding header
            JLabel animalFeedingHeader = new JLabel("Animal Feeding Details");
            animalFeedingHeader.setBounds(25, 25, 600, 50);
            animalFeedingHeader.setFont(new Font("Serif", Font.BOLD, 30));
            animalFeedingHeader.setForeground(Color.white);
            this.add(animalFeedingHeader);
            //ask for the animal tag no
            JLabel animalTagNoLabel = new JLabel("Animal Tag No:");
            animalTagNoLabel.setBounds(25, 100, 600, 50);
            animalTagNoLabel.setFont(new Font("Serif", Font.BOLD, 20));
            animalTagNoLabel.setForeground(Color.white);
            this.add(animalTagNoLabel);
            //create a text field for the animal tag no
            JTextField animalTagNoTextField = new JTextField();
            animalTagNoTextField.setBounds(200, 115, 175, 30);
            animalTagNoTextField.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(animalTagNoTextField);
            //add button to get the animal feeding details
            JButton getAnimalFeedingDetailsButton = new JButton("Get Animal Feeding Details");
            getAnimalFeedingDetailsButton.setBounds(25, 200, 600, 50);
            getAnimalFeedingDetailsButton.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(getAnimalFeedingDetailsButton);
            //show the result using a text area
            JTextArea resultTextArea = new JTextArea();
            resultTextArea.setBounds(25, 300, 900, 500);
            resultTextArea.setFont(new Font("Serif", Font.BOLD, 20));
            resultTextArea.setEditable(false);
            this.add(resultTextArea);
            //add action listener to the get animal feeding details button using the feedingAnimal method in FarmApp class
            getAnimalFeedingDetailsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int animalTagNo = Integer.parseInt(animalTagNoTextField.getText());
                    String result = FarmApp.feedingAnimal(animalTagNo);
                    resultTextArea.setText(result);
                }
            });

            //finalize the panel
            this.setVisible(true);
        }
    }

    static class addMilkingMeasurementPanel extends JPanel {
        addMilkingMeasurementPanel() {
            //set the layout to null
            this.setLayout(null);
            //set the background color
            this.setBackground(Color.black);
            //add milking measurement header
            JLabel addMilkingMeasurementHeader = new JLabel("Add Milking Measurement");
            addMilkingMeasurementHeader.setBounds(25, 25, 600, 50);
            addMilkingMeasurementHeader.setFont(new Font("Serif", Font.BOLD, 30));
            addMilkingMeasurementHeader.setForeground(Color.white);
            this.add(addMilkingMeasurementHeader);
            //ask for the animal tag no
            JLabel animalTagNoLabel = new JLabel("Animal Tag No:");
            animalTagNoLabel.setBounds(25, 100, 600, 50);
            animalTagNoLabel.setFont(new Font("Serif", Font.BOLD, 20));
            animalTagNoLabel.setForeground(Color.white);
            this.add(animalTagNoLabel);
            //create a text field for the animal tag no
            JTextField animalTagNoTextField = new JTextField();
            animalTagNoTextField.setBounds(200, 115, 175, 30);
            animalTagNoTextField.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(animalTagNoTextField);
            //ask for the milk amount
            JLabel milkAmountLabel = new JLabel("Milk Amount:");
            milkAmountLabel.setBounds(25, 150, 600, 50);
            milkAmountLabel.setFont(new Font("Serif", Font.BOLD, 20));
            milkAmountLabel.setForeground(Color.white);
            this.add(milkAmountLabel);
            //create a text field for the milk amount
            JTextField milkAmountTextField = new JTextField();
            milkAmountTextField.setBounds(200, 165, 175, 30);
            milkAmountTextField.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(milkAmountTextField);
            //add a button
            JButton addMilkingMeasurementButton = new JButton("Add Milking Measurement");
            addMilkingMeasurementButton.setBounds(25, 200, 600, 50);
            addMilkingMeasurementButton.setFont(new Font("Serif", Font.BOLD, 20));
            this.add(addMilkingMeasurementButton);
            //show the result using a text area
            JTextArea resultTextArea = new JTextArea();
            resultTextArea.setBounds(25, 300, 900, 500);
            resultTextArea.setFont(new Font("Serif", Font.BOLD, 20));
            resultTextArea.setEditable(false);
            this.add(resultTextArea);
            //add action listener to the add milking measurement button using the addMilkingMeasurement method in FarmApp class
            addMilkingMeasurementButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int animalTagNo = Integer.parseInt(animalTagNoTextField.getText());
                    double milkAmount = Double.parseDouble(milkAmountTextField.getText());
                    String result = FarmApp.addMilkingMeasurement(animalTagNo, milkAmount);
                    resultTextArea.setText(result);
                }
            });
        }
    }

}




