import java.time.LocalDate;
import java.util.HashMap;
/**
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 */
public class Sheep extends Animal {
    //constructor

    /**
     * This is the constructor of the Sheep class.
     * @param tagNo
     * @param gender
     * @param dob
     * @param purchased
     */
    public Sheep(int tagNo, String gender, LocalDate dob, boolean purchased) {
        super(tagNo, gender, dob, purchased);
    }

    public Sheep() {
        super();
    }

    //getters
    public int getTagNo() {
        return tagNo;
    }
    public String getGender() {
        return gender;
    }
    public LocalDate getDateOfBirth() {
        return dob;
    }
    public boolean isPurchased() {
        return purchased;
    }
    //setters
    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setDateOfBirth(LocalDate dob) {
        this.dob = dob;
    }
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }
    //methods

    /**
     * This method is used to return feeding details of the sheep.
     */
    public String feeding() {
        if(gender.equals("Male")) {
            if (getAge() < 5) {
                return "Only grass.";
            }
            else {
                return "Total mixed ration (TMR) diet.";
            }
        }
        else {
            if (getAge() < 8) {
                return "Only grass.";
            }
            else {
                return "Total mixed ration (TMR) diet.";
            }
        }
        }
    }






