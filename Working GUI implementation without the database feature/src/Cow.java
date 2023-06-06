import java.time.LocalDate;
import java.util.HashMap;
/**
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 */
public class Cow extends Animal{
    private double weight;

    /**
     * This is the constructor of the Cow class.
     * @param tagNo
     * @param gender
     * @param dob
     * @param purchased
     * @param weight
     */
    public Cow(int tagNo, String gender, LocalDate dob, boolean purchased, double weight) {
        super(tagNo, gender, dob, purchased);
        this.weight = weight;
    }
    public Cow(int tagNo, String gender, LocalDate dob, boolean purchased)
    {
        super(tagNo, gender, dob, purchased);
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
    public double getWeight() {
        return weight;
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
    public void setWeight(double weight) {
        this.weight = weight;
    }
    //methods

    /**
     * This method is used to return feeding details of the cow.
     */
    public String feeding(){
        if(getAge()<3) {
            return "Only grass.";
        }
        else if(getAge()>5 && getWeight()<500) {
            return "Total mixed ration (TMR) diet.";
        }
        else if (getAge()>10)
        {
            return "Grains and oilseed meals.";
        }
        else {
            return "Grass and grains.";
        }
    }
}
