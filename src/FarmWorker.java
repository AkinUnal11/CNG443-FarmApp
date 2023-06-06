import java.time.LocalDate;

/**
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 * @see Employee class
 */
public class FarmWorker extends Employee{
    String previousFarmName;
    int workExperience;

    /**
     * FarmWorker constructor.
     * @param empID
     * @param gender
     * @param dateOfBirth
     * @param previousFarmName
     * @param workExperience
     */
    public FarmWorker(int empID, String gender, LocalDate dateOfBirth, String previousFarmName, int workExperience) {
        super(empID, gender, dateOfBirth);
        this.previousFarmName = previousFarmName;
        this.workExperience = workExperience;
    }

    /**
     * FarmWorker second constructor.
     * @param empID
     * @param gender
     * @param dateOfBirth
     */
    public FarmWorker(int empID, String gender, LocalDate dateOfBirth) {
        super(empID, gender, dateOfBirth);
    }

    /**
     * @return the previousFarmName
     */

    public String getPreviousFarmName() {
        return previousFarmName;
    }



    public void setPreviousFarmName(String previousFarmName) {
        this.previousFarmName = previousFarmName;
    }
    /**
     * @return the workExperience
    */
    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
}
