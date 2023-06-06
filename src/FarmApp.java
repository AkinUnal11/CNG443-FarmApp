import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *                         FarmMe is a farm management system that allows the user to add cows and vets to a farm and keep track of their health and treatments.
 *                         This class is the main class of the program.
 *                         It contains the main method and the menu of the program along with the methods that are called from the menu.
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 *
 */
public class FarmApp{

    static ArrayList<Animal> animals = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();

    /**
     * This is the main method of the program.
     * It calls the GUI method of GUI class, to display the menu of the program.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Farm App");
        GUI FarmAppGUI = new GUI();
    }
    /**
     * This method is used to add a cow to the farm.
     * @param tagNoString String of the tag number of the cow, which is going to be converted inside the method to integer.
     * @param gender String of the gender of the cow.
     * @param dobString String of the date of birth of the cow, which is going to be converted inside the method to LocalDate.
     * @param weightString String of the weight of the cow, which is going to be converted inside the method to double.
     * @param isPurchased String of the boolean value of whether the cow is purchased or not, which is going to be converted inside the method to boolean.
     * @return A string to be displayed to the user.
     */
    static String addCow(String tagNoString, String gender, String dobString, String weightString, String isPurchased) {
        //convert the given strings
        int tagNo = Integer.parseInt(tagNoString);
        LocalDate dob = LocalDate.parse(dobString);
        double weight = Double.parseDouble(weightString);
        boolean purchased = Boolean.parseBoolean(isPurchased);
        //create a string to show the result
        String result = "";
        try {
            //check if animal already exists
            for (Animal animal : animals) {
                if (animal.getTagNo() == tagNo) {
                    return "Animals need to have unique tag numbers";
                }
            }
            Cow cow = new Cow(tagNo, gender, dob, purchased, weight);
            animals.add(cow);
            result = "Cow with tag number " + tagNo + " has been added to the farm.";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    /**
     * This method is used to delete cows from the farm.
     * It is used to delete the cow from the arraylist.
     * @param tagNoString The tag number of the cow that is going to be deleted, which is going to be converted inside the method to integer.
     * @return A string to be displayed to the user.
     */
    static String deleteCow(String tagNoString) {
        //convert tagNoString to int
        int tagNo = Integer.parseInt(tagNoString);
        //create a string to return the result
        String result = "";
        try {
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getTagNo() == tagNo && animals.get(i) instanceof Cow) {
                    animals.remove(i);
                    result = "Cow deleted successfully";
                }
            }
            if(result.equals("")){
                result = "Cow not found";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method is used to add a sheep to the farm.
     * @param tagNoString String of the tag number of the sheep, which is going to be converted inside the method to integer.
     * @param gender String of the gender of the sheep.
     * @param dobString String of the date of birth of the sheep, which is going to be converted inside the method to LocalDate.
     * @param isPurchased String of the boolean value of whether the sheep is purchased or not, which is going to be converted inside the method to boolean.
     * @return A string to be displayed to the user.
     */
    static String addSheep(String tagNoString, String gender, String dobString, String isPurchased) {
        //convert the given strings
        int tagNo = Integer.parseInt(tagNoString);
        LocalDate dob = LocalDate.parse(dobString);
        boolean purchased = Boolean.parseBoolean(isPurchased);
        //create a string to show the result
        String result = "";
        try {
            //check if animal already exists
            for (Animal animal : animals) {
                if (animal.getTagNo() == tagNo) {
                    return "Animals need to have unique tag numbers";
                }
            }
            Sheep sheep = new Sheep(tagNo, gender, dob, purchased);
            animals.add(sheep);
            result = "Sheep with tag number " + tagNo + " has been added to the farm.";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }

    /**
     * This method is used to delete sheep from the farm.
     * @param tagNoString The tag number of the sheep that is going to be deleted, which is going to be converted inside the method to integer.
     * @return A string to be displayed to the user.
     */
    static String deleteSheep(String tagNoString) {
        //conver tagno to int
        int tagNo = Integer.parseInt(tagNoString);
        //create a string to show the result
        String result = "";
        try {
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getTagNo() == tagNo && animals.get(i) instanceof Sheep) {
                    animals.remove(i);
                    result = "Sheep deleted successfully";
                }
            }
            if(result.equals("")){
                result = "Sheep not found";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method is used to get the details of the cow or the sheep with the given tag no from the user through the GUI.
     * @param tagNo The tag number of the cow or the sheep.
     * @param animalType The type of the animal, which is either cow or sheep.
     * @return A string to be displayed to the user.
     */
    static String getAnimalDetails(String tagNo, String animalType) {
            //create a string to store details
            String details = "";
            //conver tagNo to integer
            int tagNoInt = Integer.parseInt(tagNo);
            //if animal type is cow then get the details of the cow
            if (animalType.equals("Cow")) {
                for (int i = 0; i < animals.size(); i++) {
                    if (animals.get(i).getTagNo() == tagNoInt && animals.get(i) instanceof Cow) {
                        Cow cow = (Cow) animals.get(i);
                        details = "Tag Number: " + cow.getTagNo() + "\nGender: " + cow.getGender() + "\nDate of Birth: " + cow.getDateOfBirth() + "\nPurchased: " + cow.isPurchased() + "\nWeight: " + cow.getWeight();
                    }
                }
                if(details.equals("")) {
                    details = "Animal not found";
                }
            }
            //if animal type is sheep then get the details of the sheep
            else if (animalType.equals("Sheep")) {
                for (int i = 0; i < animals.size(); i++) {
                    if (animals.get(i).getTagNo() == tagNoInt && animals.get(i) instanceof Sheep) {
                        Sheep sheep = (Sheep) animals.get(i);
                        details = "Tag Number: " + sheep.getTagNo() + "\nGender: " + sheep.getGender() + "\nDate of Birth: " + sheep.getDateOfBirth() + "\nPurchased: " + sheep.isPurchased();
                    }
                }
                if(details.equals("")){
                    details = "Animal not found";
                }
            }
            return details;
    }


    /**
     * This method is used to add a vet to the farm.
     * @param empIDString The employee ID of the employee which is going to be converted inside the method to integer.
     * @param gender The gender of the employee.
     * @param dateOfBirthString The date of birth of the employee which is going to be converted inside the method to LocalDate.
     * @param bscDegreeString The boolean value of whether the employee has a bsc degree or not which is going to be converted inside the method to boolean.
     * @param dateOfGraduationString The date of graduation of the employee which is going to be converted inside the method to LocalDate.
     * @param expertiseLevelString The expertise level of the employee which is going to be converted inside the method to integer.
     * @return A string to be displayed to the user.
     */
    static String addVet(String empIDString,String gender, String dateOfBirthString, String bscDegreeString, String dateOfGraduationString, String expertiseLevelString) {
        //convert the given strings
        int empID = Integer.parseInt(empIDString);
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
        LocalDate dateOfGraduation = LocalDate.parse(dateOfGraduationString);
        int expertiseLevel = Integer.parseInt(expertiseLevelString);
        boolean bscDegree = Boolean.parseBoolean(bscDegreeString);
        //create a string to show the result
        String result = "";
        try {
            Veterinary vet = new Veterinary(empID, gender, dateOfBirth, bscDegree, dateOfGraduation, expertiseLevel);
            //check if employee already exists
            for (Employee employee : employees) {
                if (employee.getEmpID() == empID) {
                    return "Employees need to have unique employee IDs";
                }
            }
            employees.add(vet);
            result = "Vet with employee ID " + empID + " has been added to the farm.";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }

    /**
     * This method is used to delete a vet from the farm.
     * @param empIDString The employee ID of the employee which is going to be converted inside the method to integer.
     * @return A string to be displayed to the user.
     */
    static String deleteVet(String empIDString) {
        //conver empID to int
        int empID = Integer.parseInt(empIDString);
        //create a string to show the result
        String result = "";
        try {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmpID() == empID && employees.get(i) instanceof Veterinary) {
                    employees.remove(i);
                    result = "Vet deleted successfully";
                }
            }
            if(result.equals("")){
                result = "Vet not found";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method is used to get the details of the vet with the given employee ID from the user through the GUI.
     * @param empIDString The employee ID of the vet which is going to be converted inside the method to integer.
     * @return A string to be displayed to the user.
     */
    static String getVetDetails(String empIDString) {
        //create a string to store details
        String details = "";
        //conver empID to integer
        int empID = Integer.parseInt(empIDString);
        try {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmpID() == empID && employees.get(i) instanceof Veterinary) {
                    details = "Employee ID: " + employees.get(i).getEmpID() +
                            "\nGender: " + employees.get(i).getGender() +
                            "\nDate of Birth: " + employees.get(i).getDateOfBirth() +
                            "\nBSc Degree: " + ((Veterinary) employees.get(i)).isBScDegree()
                            + "\nDate of Graduation: " + ((Veterinary) employees.get(i)).getDateOfGraduation()
                            + "\nExpertise Level: " + ((Veterinary) employees.get(i)).getExpertiseLevel()
                            + "\nSalary: " + getEmpSalary(empID);
                }
            }
            if(details.equals("")){
                details = "Vet not found";
            }
        } catch (Exception e) {
            details = "Invalid input";
        }
        return details;
    }

    /**
     * This method is used to add a farm worker to the farm.
     * @param EmpIDString The employee ID of the employee which is going to be converted inside the method to integer.
     * @param gender  The gender of the employee.
     * @param dateOfBirthString The date of birth of the employee which is going to be converted inside the method to LocalDate.
     * @param previousWorkedFarm The boolean value of whether the employee has previous worked on a farm or not which is going to be converted inside the method to boolean.
     * @param yearsOfExperienceString The years of experience of the employee which is going to be converted inside the method to integer.
     * @return A string to be displayed to the user.
     */
    static String addFarmWorker(String EmpIDString, String gender, String dateOfBirthString, String previousWorkedFarm, String yearsOfExperienceString) {
        //convert the given strings
        int empID = Integer.parseInt(EmpIDString);
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
        int experience = Integer.parseInt(yearsOfExperienceString);
        //create a string to show the result
        String result = "";
        try {
            FarmWorker farmWorker = new FarmWorker(empID, gender, dateOfBirth, previousWorkedFarm, experience);
            //check if employee already exists
            for (Employee employee : employees) {
                if (employee.getEmpID() == empID) {
                    return "Employees need to have unique employee IDs";
                }
            }
            employees.add(farmWorker);
            result = "Farm worker with employee ID " + empID + " has been added to the farm.";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }

    /**
     * This method is used to delete a farm worker from the farm.
     * @param empIDString The employee ID of the employee which is going to be converted inside the method to integer.
     * @return A string to be displayed to the user.
     */
    static String deleteFarmWorker(String empIDString) {
        //convert empID to int
        int empID = Integer.parseInt(empIDString);
        //create a string to show the result
        String result = "";
        try {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmpID() == empID && employees.get(i) instanceof FarmWorker) {
                    employees.remove(i);
                    result = "Farm worker deleted successfully";
                }
            }
            if(result.equals("")){
                result = "Farm worker not found";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method is used to get the details of the farm worker with the given employee ID from the user through the GUI.
     * @param empIDString
     * @return A string to be displayed to the user.
     */
    static String getFarmWorkerDetails(String empIDString) {
        //convert empID to int
        int empID = Integer.parseInt(empIDString);
        //create a string to show the result
        String result = "";
        try {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmpID() == empID && employees.get(i) instanceof FarmWorker) {
                    result = "Employee ID: " + employees.get(i).getEmpID() + " \n"+
                            "Employee Gender: " + employees.get(i).getGender() + " \n"+
                            "Employee Date of birth: " + employees.get(i).getDateOfBirth() + " \n"+
                            "Employee Previous worked farm: " + ((FarmWorker) employees.get(i)).getPreviousFarmName() + " \n"+
                            "Employee Years of experience: " + ((FarmWorker) employees.get(i)).getWorkExperience() + " \n"+
                            "Employee Salary: " + getEmpSalary(empID);
                    }
                }
            if(result.equals("")){
                result = "Farm worker not found";
            }
            }
            catch (Exception e) {
            result = "Invalid input";
            }
        return result;
        }

    /**
     * This method is used to add a treatment whether it is a health treatment or a cleaning treatment.
     * @param treatmentDateString The date of treatment of the animal which is going to be converted inside the method to LocalDate.
     * @param treatmentType The type of treatment of the animal.
     * @param isEmergencyString The boolean value of whether the treatment is an emergency or not which is going to be converted inside the method to boolean.
     * @param medications The medications of the treatment.
     * @param cleaningmaterial The cleaning material of the treatment.
     * @param tagNo The tag number of the animal which is going to be converted inside the method to integer.
     * @param empID The employee ID of the employee which is going to be converted inside the method to integer.
     * @return A string to be displayed to the user.
     */
    static String addTreatment(String treatmentDateString, String treatmentType, String isEmergencyString, ArrayList<Medication> medications, String cleaningmaterial, int tagNo, int empID) {
        //convert the given strings
        LocalDate treatmentDate = LocalDate.parse(treatmentDateString);
        boolean isEmergency = Boolean.parseBoolean(isEmergencyString);
        //create a string to show the result
        String result = "";
        try {
            //find the employee
            if(treatmentType.equals("health")) {
                Employee employee = null;
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i).getEmpID() == empID) {
                        employee = employees.get(i);
                    }
                    if (employee == null) {
                        result = "Employee not found";
                    }
                    if (employee instanceof Veterinary) {
                        //find the animal
                        Animal animal = null;
                        for (int j = 0; j < animals.size(); j++) {
                            if (animals.get(j).getTagNo() == tagNo) {
                                animal = animals.get(j);
                            }
                        }
                        if (animal == null) {
                            result = "Animal not found";
                        }
                        //create a treatment object
                        HealthTreatment healthTreatment = new HealthTreatment(treatmentDate, isEmergency, (Veterinary) employee, medications);
                        //add the treatment to the animal
                        animal.treatments.add(healthTreatment);
                        result = "Treatment added successfully";
                    } else {
                        result = "Employee is not a vet";
                    }
                }
            }
            else if (treatmentType.equals("cleaning")) {
                Employee employee = null;
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i).getEmpID() == empID) {
                        employee = employees.get(i);
                    }
                    if (employee == null) {
                        result = "Employee not found";
                    }
                    if (employee instanceof FarmWorker) {
                        //find the animal
                        Animal animal = null;
                        for (int j = 0; j < animals.size(); j++) {
                            if (animals.get(j).getTagNo() == tagNo) {
                                animal = animals.get(j);
                            }
                        }
                        if (animal == null) {
                            result = "Animal not found";
                        }
                        //create a treatment object
                        //public CleaningTreatment(LocalDate dateOfTreatment, String materialused, FarmWorker cgivenby)
                        CleaningTreatment cleaningTreatment = new CleaningTreatment(treatmentDate, cleaningmaterial, (FarmWorker) employee);
                        //add the treatment to the animal
                        animal.treatments.add(cleaningTreatment);
                        result = "Treatment added successfully";
                    } else {
                        result = "Employee is not a farm worker";
                    }
                }
            }
            else {
                result = "Invalid treatment type";
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        return result;
    }

    /**
     * This method is used to get the details of the treatment with the given treatment ID from the user through the GUI.
     * @param tagNo The tag number of the animal.
     * @return A string to be displayed to the user.
     */
    static String getTreatmentDetails(int tagNo) {
        //create a string to show the result
        String result = "";
        try {
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getTagNo() == tagNo) {
                    if (animals.get(i) instanceof Cow) {
                        result = result + "Animal type: Cow \n";
                    } else if (animals.get(i) instanceof Sheep) {
                        result = result + "Animal type: Sheep \n";
                    }
                    for (int j = 0; j < animals.get(i).treatments.size(); j++) {
                        //System.out.println("Treatment date: " + animals.get(i).treatments.get(j).getDateOfTreatment());
                        result = result + "Treatment date: " + animals.get(i).treatments.get(j).getDateOfTreatment() + " \n";
                        if (animals.get(i).treatments.get(j) instanceof HealthTreatment) {
                            //System.out.println("Treatment" + (j + 1) + ":\n");
                            result = result + "Treatment" + (j + 1) + ":\n";
                            //System.out.println("Treatment type: Health treatment");
                            result = result + "Treatment type: Health treatment \n";
                            //System.out.println("Emergency: " + ((HealthTreatment) animals.get(i).treatments.get(j)).isEmergency());
                            result = result + "Emergency: " + ((HealthTreatment) animals.get(i).treatments.get(j)).isEmergency() + " \n";
                            //System.out.println("Medications: ");
                            result = result + "Medications: \n\n";
                            for (int k = 0; k < ((HealthTreatment) animals.get(i).treatments.get(j)).medications.size(); k++) {
                                //System.out.println("Medication " + (k + 1) + ": \n");
                                result = result + "Medication " + (k + 1) + ": \n";
                                //System.out.println("Details: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getDetails());
                                result = result + "Details: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getDetails() + " \n";
                                //System.out.println("Dosage: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getDosage());
                                result = result + "Dosage: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getDosage() + " \n";
                                //System.out.println("Duration: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getDuration());
                                result = result + "Duration: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getDuration() + " \n";
                                //System.out.println("Start date: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getStartDate());
                                result = result + "Start date: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getStartDate() + " \n";
                                //System.out.println("Notes: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getNotes()+"\n");
                                result = result + "Notes: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getNotes() + " \n\n";
                            }
                        } else if (animals.get(i).treatments.get(j) instanceof CleaningTreatment) {
                            //System.out.println("Treatment" + (j + 1) + ":\n");
                            result = result + "Treatment" + (j + 1) + ":\n";
                            //System.out.println("Treatment type: Cleaning treatment");
                            result = result + "Treatment type: Cleaning treatment \n";
                            //System.out.println("Material used: \n" + ((CleaningTreatment) animals.get(i).treatments.get(j)).getMaterialused());
                            result = result + "Material used: \n" + ((CleaningTreatment) animals.get(i).treatments.get(j)).getMaterialused() + " \n\n";
                        }
                    }
                }
            }
            if(result.equals("")){
                result = "Animal not found";
            }
        } catch (Exception e) {
           // System.out.println("Invalid input");
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method is used to get the treatment details of the animals in the farm on a specific date.
     * @param tagNo The tag number of the animal.
     * @param date The date of the treatment.
     * @return A string to be displayed to the user.
     */
    static String getTreatmentDetails(int tagNo, LocalDate date) {
        //create a string to show the result
        String result = "";
        try {
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getTagNo() == tagNo) {
                    if (animals.get(i) instanceof Cow) {
                        result = result + "Animal type: Cow \n";
                    }
                    else if (animals.get(i) instanceof Sheep) {
                        result = result + "Animal type: Sheep \n";
                    }
                }
                for (int j = 0; j < animals.get(i).treatments.size(); j++) {
                    if (animals.get(i).treatments.get(j).getDateOfTreatment().equals(date)) {
                        result = result + "Treatment date: " + animals.get(i).treatments.get(j).getDateOfTreatment() + " \n";
                        if (animals.get(i).treatments.get(j) instanceof HealthTreatment) {
                            result = result + "Treatment" + (j + 1) + ":\n";
                            result = result + "Treatment type: Health treatment \n";
                            result = result + "Emergency: " + ((HealthTreatment) animals.get(i).treatments.get(j)).isEmergency() + " \n";
                            result = result + "Medications: \n\n";
                            for (int k = 0; k < ((HealthTreatment) animals.get(i).treatments.get(j)).medications.size(); k++) {
                                result = result + "Medication " + (k + 1) + ": \n";
                                result = result + "Details: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getDetails() + " \n";
                                result = result + "Dosage: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getDosage() + " \n";
                                result = result + "Duration: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getDuration() + " \n";
                                result = result + "Start date: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getStartDate() + " \n";
                                result = result + "Notes: " + ((HealthTreatment) animals.get(i).treatments.get(j)).medications.get(k).getNotes() + " \n\n";
                            }
                        } else if (animals.get(i).treatments.get(j) instanceof CleaningTreatment) {
                            result = result + "Treatment" + (j + 1) + ":\n";
                            result = result + "Treatment type: Cleaning treatment \n";
                        }
                    }
                }
            }
            if (result.equals("")) {
                result = "Animal not found";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method is used to simplify the process of getting lists of the employees or animals in the farm.
     * @param type The type of the list to be returned.
     * @return A string to be displayed to the user.
     */
    static String getList(String type)
    {
        String result = "";
        try{
            if(type.equals("Cows")){
                result = listCow();
            }
            else if(type.equals("Sheeps")){
                result = listSheep();
            }
            else if(type.equals("Vets"))
            {
                result = listVet();
            }
            else if(type.equals("FarmWorkers"))
            {
                result = listFarmWorker();
            }

        }
        catch(Exception e){
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method lists the cows in the farm.
     * @return A string to be displayed to the user.
     */
    static String listCow() {
        String result = "";
        try {
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i) instanceof Cow) {
                    result = result + "Cow details: \n";
                    result = result + "Tag number: " + animals.get(i).getTagNo() + " \n";
                    result = result + "Gender: " + animals.get(i).getGender() + " \n";
                    result = result + "Date of birth: " + animals.get(i).getDob() + " \n";
                    result = result + "Weight: " + ((Cow) animals.get(i)).getWeight() + " \n";
                    result = result + "Is purchased: \n" + animals.get(i).isPurchased() + " \n";
                }
            }
            if (result.equals("")) {
                result = "No cow in the farm";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method lists the sheep in the farm.
     * @return A string to be displayed to the user
     */
    static String listSheep() {
        String result = "";
        try {
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i) instanceof Sheep) {
                    //System.out.println("\nSheep details: ");
                    result = result + "Sheep details: \n";
                    result = result + "Tag number: " + animals.get(i).getTagNo() + " \n";
                    result = result + "Gender" + animals.get(i).getGender() + " \n";
                    result = result + "Date of birth: " + animals.get(i).getDob() + " \n";
                    result = result + "Is purchased: \n" + animals.get(i).isPurchased() + " \n";
                }
            }
            if (result.equals("")) {
                result = "No sheep in the farm";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method lists the vets in the farm.
     * @return A string to be displayed to the user.
     */
    static String listVet() {
        String result = "";
        try {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i) instanceof Veterinary) {
                    result = result + "Vet details: \n";
                    result = result + "Employee ID: " + employees.get(i).getEmpID() + " \n";
                    result = result + "Gender" + employees.get(i).getGender() + " \n";
                    result = result + "Date of birth: " + employees.get(i).getDateOfBirth() + " \n";
                    result = result + "BSc Degree: " + ((Veterinary) employees.get(i)).isBScDegree() + " \n";
                    result = result + "Date of graduation: " + ((Veterinary) employees.get(i)).getDateOfGraduation() + " \n";
                    result = result + "Expertise level: \n" + ((Veterinary) employees.get(i)).getExpertiseLevel() + " \n";
                    result = result + "Salary:" + getEmpSalary(employees.get(i).getEmpID()) + " \n";
                }
            }
            if (result.equals("")) {
                result = "No vet in the farm";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method lists the farmworkers in the farm.
     * @return A string to be displayed to the user.
     */
    static String listFarmWorker() {
        String result = "";
        try {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i) instanceof FarmWorker) {
                    result = result + "Farm worker details: \n";
                    result = result + "Employee ID: " + employees.get(i).getEmpID() + " \n";
                    result = result + "Gender" + employees.get(i).getGender() + " \n";
                    result = result + "Date of birth: " + employees.get(i).getDateOfBirth() + " \n";
                    result = result + "Years of experience: " + ((FarmWorker) employees.get(i)).getWorkExperience() + " \n";
                    result = result + "Previous employer: \n" + ((FarmWorker) employees.get(i)).getPreviousFarmName() + " \n";
                    result = result + "Salary:" + getEmpSalary(employees.get(i).getEmpID()) + " \n";
                }
            }
            if (result.equals("")) {
                result = "No farm worker in the farm";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This methods tells the user how an animal should be fed.
     * @param tagNo The tag number of the animal.
     * @return A string to be displayed to the user.
     */
    static String feedingAnimal(int tagNo) {
        String result = "";
        try {
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getTagNo() == tagNo) {
                    if (animals.get(i) instanceof Cow) {
                        result = result + "Cow feeding details: \n";
                        //animals.get(i).feeding();
                        result = result + "Cow tag number: " + animals.get(i).feeding() + " \n";
                    } else if (animals.get(i) instanceof Sheep) {
                        result = result + "Sheep feeding details: \n";
                        //animals.get(i).feeding();
                        result = result + "Sheep tag number: " + animals.get(i).feeding() + " \n";
                    }
                }
            }
            if(result.equals("")){
                result = "No animal with this tag number";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method returns the net salary of the employee.
     * @param empID The employee ID of the employee.
     * @return The net salary of the employee.
     */
    static double getEmpSalary(int empID) {
        try {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmpID() == empID) {
                    if (employees.get(i) instanceof FarmWorker) {
                        double grossSalary = employees.get(i).getSalary();
                        return grossSalary + grossSalary * 0.02 * ((FarmWorker) employees.get(i)).getWorkExperience();
                    } else if (employees.get(i) instanceof Veterinary) {
                        double grossSalary = employees.get(i).getSalary();
                        double netSalary = grossSalary + grossSalary * 0.1 * ((Veterinary) employees.get(i)).noOfYearsSinceGraduation();
                        return netSalary;
                    }
                }
            }
            return 0;
        } catch (Exception e) {
            System.out.println("Invalid input");
            return 0;
        }
    }

    /**
     * This method adds a milking measurement to the animal.
     * @param tagNo The tag number of the animal.
     * @param amount The amount of milk produced.
     * @return A string to be displayed to the user.
     */
    static String addMilkingMeasurement(int tagNo, double amount) {
        String result = "";
        try {
            HashMap<LocalDate, Double> milkProduced = new HashMap<>();
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getTagNo() == tagNo) {
                    milkProduced.put(LocalDate.now(), amount);
                    animals.get(i).setMilking(milkProduced);
                    result = result + "Milking measurement added";
                }
            }
            if(result.equals("")){
                result = "No animal with this tag number";
            }
        } catch (Exception e) {
            result = "Invalid input";
        }
        return result;
    }

    /**
     * This method is used to exit the program.
     */
    static void exit() {
        try {
            System.out.println("Thank you for using the system.");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }



}