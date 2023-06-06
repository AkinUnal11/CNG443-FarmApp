import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

/**
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 * This abstract class represents an animal in the farm.
 * The subclases are Cow and Sheep.
 */

public abstract class Animal {
    int tagNo;
    String gender;
    //date of birth
    LocalDate dob;
    boolean purchased;
    HashMap<LocalDate, Double> milking = new HashMap<>();

    ArrayList<Treatment> treatments = new ArrayList<>();

    /**
     * Constructor for objects of class Animal
     * @param tagNo
     * @param gender
     * @param dob
     * @param purchased
     */
    public Animal(int tagNo, String gender, LocalDate dob, boolean purchased) {
        this.tagNo = tagNo;
        this.gender = gender;
        this.dob = dob;
        this.purchased = purchased;
    }

    public Animal() {
        //putting random values to the animal
        this.tagNo = 4;
        this.gender = "male";
        this.dob = LocalDate.of(2021, 11, 23);
        this.purchased = true;
    }

    public int getTagNo() {
        return tagNo;
    }

    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public HashMap<LocalDate, Double> getMilking() {
        return milking;
    }

    public void setMilking(HashMap<LocalDate, Double> milking) {
        this.milking = milking;
    }

    public ArrayList<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(ArrayList<Treatment> treatments) {
        this.treatments = treatments;
    }

    //methods
    public int getAge() {
        return LocalDate.now().getYear() - dob.getYear();
    }
    //abstract methods
    public abstract String feeding();
}



