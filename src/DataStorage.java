import javax.swing.*;
import java.io.*;
import java.security.MessageDigest;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 */
public class DataStorage {
    /**
     * This method is used to connect to the database.In order to read the data from the database.
     *
     */
    public static void readData() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Driver loaded");

        System.out.println("Establishing connection");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FarmAppDB", "cng443user", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connection established");

        System.out.println("Creating statement");
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Statement created");

        System.out.println("Reading data from the database");
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Animal");
            while (resultSet.next()) {
                int tagNo = resultSet.getInt("tagNo");
                //tagno to string
                String tagNoString = Integer.toString(tagNo);
                String gender = resultSet.getString("gender");
                LocalDate dob = resultSet.getDate("dateOfBirth").toLocalDate();
                //dob to string
                String dobString = dob.toString();
                boolean purchased = resultSet.getBoolean("purchased");
                //purchased to string
                String purchasedString = Boolean.toString(purchased);
                String type = resultSet.getString("type");
                if (type.equals("c")) {
                    double weight = resultSet.getDouble("Weight");
                    //weight to string
                    String weightString = Double.toString(weight);
                    if (gender.equals("m")) {
                        FarmApp.addCow(tagNoString, "male", dobString, weightString, purchasedString);
                    } else if (gender.equals("f")) {
                        FarmApp.addCow(tagNoString, "female", dobString, weightString, purchasedString);
                    }
                } else if (type.equals("s")) {
                    if (gender.equals("m")) {
                        FarmApp.addSheep(tagNoString, "male", dobString, purchasedString);
                    } else if (gender.equals("f")) {
                        FarmApp.addSheep(tagNoString, "female", dobString, purchasedString);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");
            while (resultSet.next()) {
                int id = resultSet.getInt("empID");
                //id to string
                String idString = Integer.toString(id);
                String gender = resultSet.getString("gender");
                LocalDate dob = resultSet.getDate("dateOfBirth").toLocalDate();
                //dob to string
                String dobString = dob.toString();
                String type = resultSet.getString("type");
                if (type.equals("v")) {
                    boolean BSCDegree = resultSet.getBoolean("BScDegree");
                    //BSCDegree to string
                    String BSCDegreeString = Boolean.toString(BSCDegree);
                    LocalDate dateofgraduation = resultSet.getDate("dateOfGraduation").toLocalDate();
                    //dateofgraduation to string
                    String dateofgraduationString = dateofgraduation.toString();
                    int expertiselevel = resultSet.getInt("expertiseLevel");
                    //expertiselevel to string
                    String expertiselevelString = Integer.toString(expertiselevel);
                    if (gender.equals("m")) {
                        FarmApp.addVet(idString, "male", dobString, BSCDegreeString, dateofgraduationString, expertiselevelString);
                    } else if (gender.equals("f")) {
                        FarmApp.addVet(idString, "female", dobString, BSCDegreeString, dateofgraduationString, expertiselevelString);
                    }
                }
                if (type.equals("f")) {
                    String previousfarmname = resultSet.getString("previousFarmName");
                    int workexperience = resultSet.getInt("workExperience");
                    //workexperience to string
                    String workexperienceString = Integer.toString(workexperience);
                    if (gender.equals("m")) {
                        FarmApp.addFarmWorker(idString, "male", dobString, previousfarmname, workexperienceString);
                    } else if (gender.equals("f")) {
                        FarmApp.addFarmWorker(idString, "female", dobString, previousfarmname, workexperienceString);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method is used to connect to the database.In order to write the data to the database.
     *
     * @return void
     */
    public static void writeData() {
        ArrayList<Animal> animalArrayList = FarmApp.animals;
        ArrayList<Employee> employeeArrayList = FarmApp.employees;
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Driver loaded");

        System.out.println("Establishing connection");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FarmAppDB", "cng443user", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connection established");

        System.out.println("Creating statement");
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Statement created");
        //delete all data from the database
        try {
            statement.executeUpdate("DELETE FROM Animal");
            statement.executeUpdate("DELETE FROM Employee");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Writing data to the database");
        try {
            for (Animal animal : animalArrayList) {
                //insert animal details if it is not in the database
                int tagNo = animal.getTagNo();
                //dob to string
                String dateOfBirth = animal.getDob().toString();
                boolean purchased = animal.isPurchased();

                if (animal.getClass().getName().equals("Cow")) {
                    double weight = ((Cow) animal).getWeight();
                    if (animal.getGender().equals("male")) {
                        String query = "INSERT IGNORE INTO Animal VALUES (" + tagNo + ", 'm', '" + dateOfBirth + "', " + purchased + ", 'c', " + weight + ")";
                        statement.executeUpdate(query);
                    }
                    if (animal.getGender().equals("female")) {
                        String query = "INSERT IGNORE INTO Animal VALUES (" + tagNo + ", 'f', '" + dateOfBirth + "', " + purchased + ", 'c', " + weight + ")";
                        statement.executeUpdate(query);
                    }
                }
                if (animal.getClass().getName().equals("Sheep")) {
                    double weight = 0.0;
                    if (animal.getGender().equals("male")) {
                        String query = "INSERT IGNORE INTO Animal VALUES (" + tagNo + ", 'm', '" + dateOfBirth + "', " + purchased + ", 's', " + null + ")";
                        statement.executeUpdate(query);
                    }
                    if (animal.getGender().equals("female")) {
                        String query = "INSERT IGNORE INTO Animal VALUES (" + tagNo + ", 'f', '" + dateOfBirth + "', " + purchased + ", 's', " + null + ")";
                        statement.executeUpdate(query);
                    }
                }
            }
            for (Employee employee : employeeArrayList) {
                int empID = employee.getEmpID();
                String dateOfBirth = employee.getDateOfBirth().toString();
                if (employee.getClass().getName().equals("Veterinary")) {
                    boolean BScDegree = ((Veterinary) employee).isBScDegree();
                    String dateOfGraduation = ((Veterinary) employee).getDateOfGraduation().toString();
                    int expertiseLevel = ((Veterinary) employee).getExpertiseLevel();
                    if (employee.getGender().equals("male")) {
                        String query = "INSERT IGNORE INTO Employee VALUES (" + empID + ", 'm', '" + dateOfBirth + "', 'v', " + BScDegree + ", '" + dateOfGraduation + "', " + expertiseLevel + ", " + null + ", " + null + ")";
                        statement.executeUpdate(query);
                    }
                    if (employee.getGender().equals("female")) {
                        String query = "INSERT IGNORE INTO Employee VALUES (" + empID + ", 'f', '" + dateOfBirth + "', 'v', " + BScDegree + ", '" + dateOfGraduation + "', " + expertiseLevel + ", " + null + ", " + null + ")";
                        statement.executeUpdate(query);
                    }
                }
                if (employee.getClass().getName().equals("FarmWorker")) {
                    String previousFarmName = ((FarmWorker) employee).getPreviousFarmName();
                    int workExperience = ((FarmWorker) employee).getWorkExperience();
                    if (employee.getGender().equals("male")) {
                        String query = "INSERT IGNORE INTO Employee VALUES (" + empID + ", 'm', '" + dateOfBirth + "', 'f', " + null + ", " + null + ", " + null + ", '" + previousFarmName + "', " + workExperience + ")";
                        statement.executeUpdate(query);
                    }
                    if (employee.getGender().equals("female")) {
                        String query = "INSERT IGNORE INTO Employee VALUES (" + empID + ", 'f', '" + dateOfBirth + "', 'f', " + null + ", " + null + ", " + null + ", '" + previousFarmName + "', " + workExperience + ")";
                        statement.executeUpdate(query);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //make Animal objects persistent to a file

    /**
     * This method is used to write the data to the file.
     * @return void
     * @throws IOException
     */
    public static void writeAnimalData() {
        ArrayList<Animal> animalArrayList = FarmApp.animals;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("animalData.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(animalArrayList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //deserialize Animal objects from a file

    /**
     * This method is used to read the data from the file.
     * @return void
     */
    public static void readAnimalData() {
        try {
            FileInputStream fileInputStream = new FileInputStream("animalData.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            FarmApp.animals = (ArrayList<Animal>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //print the animal objects
        for (Animal animal : FarmApp.animals) {
            System.out.println(animal);
        }
    }

    //generate an MD5 for animalData.ser and write it into an another external file

    /**
     * This method is used to generate the MD5 hash for the file.
     * @return void
     */
    public static void generateMD5() {
        try {
            FileInputStream fileInputStream = new FileInputStream("animalData.ser");
            byte[] bytes = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            int numRead = 0;
            while (numRead != -1) {
                numRead = fileInputStream.read(bytes);
                if (numRead > 0) {
                    messageDigest.update(bytes, 0, numRead);
                }
            }
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                System.out.println("digest is null");
            }
            String result = "";
            for (int i = 0; i < digest.length; i++) {
                result += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
            }
            //print the MD5
            System.out.println(result);
            //write the MD5 into a file
            FileWriter fileWriter = new FileWriter("MD5.txt");
            fileWriter.write(result);
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//create a thread that reads the serialized object file and regenerates the MD5 hash and compares it with the MD5 hash in the external file
//if the hashes are not equal, the program will print out the error message
//if the hashes are equal, the program will print out the success message

/**
 * This class is used to create a thread that reads the serialized object file and regenerates the MD5 hash and compares it with the MD5 hash in the external file.
 * If the hashes are not equal, the program will print out the error message.
 * If the hashes are equal, the program will print out the success message.
 * @author Berke Diler
 * @version 1.0
 */
class MD5Thread2 extends Thread {
    boolean result = false;
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String MD5 = "";
        try {
            FileReader fileReader = new FileReader("MD5.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            MD5 = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //print the MD5
        System.out.println(MD5);
        //generate the MD5
        try {
            FileInputStream fileInputStream = new FileInputStream("animalData.ser");
            byte[] bytes = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            int numRead = 0;
            while (numRead != -1) {
                numRead = fileInputStream.read(bytes);
                if (numRead > 0) {
                    messageDigest.update(bytes, 0, numRead);
                }
            }
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                System.out.println("digest is null");
            }
            String result = "";
            for (int i = 0; i < digest.length; i++) {
                result += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
            }
            //print the MD5
            System.out.println(result);
            //compare the MD5
            if (result.equals(MD5)) {
                System.out.println("Success!");
                this.result = false;
            }
            else {
                System.out.println("Error!");
                this.result = true;
            }
            //display a pop-up window on the GUI to show the result
            if (this.result) {
                JOptionPane.showMessageDialog(null, "WARNING: The MD5 hash of the serialized object file is not equal to the MD5 hash in the external file. The serialized object file may have been tampered with.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Success!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


