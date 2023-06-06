import java.time.LocalDate;
/**
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 */
public class Veterinary extends Employee{
    private boolean BScDegree;
    private LocalDate dateOfGraduation;
    private int expertiseLevel;

    /**
     * Constructor for objects of class Veterinary
     * @param empID
     * @param gender
     * @param dateOfBirth
     * @param BScDegree
     * @param dateOfGraduation
     * @param expertiseLevel
     */
    public Veterinary(int empID, String gender, LocalDate dateOfBirth, boolean BScDegree, LocalDate dateOfGraduation, int expertiseLevel) {
        super(empID, gender, dateOfBirth);
        this.BScDegree = BScDegree;
        this.dateOfGraduation = dateOfGraduation;
        this.expertiseLevel = expertiseLevel;
    }


    public Veterinary(int empID, String gender, LocalDate date)
    {
        super(empID, gender, date);
    }

    public boolean isBScDegree() {
        return BScDegree;
    }

    public void setBScDegree(boolean BScDegree) {
        this.BScDegree = BScDegree;
    }

    public LocalDate getDateOfGraduation() {
        return dateOfGraduation;
    }

    public void setDateOfGraduation(LocalDate dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }

    public int getExpertiseLevel() {
        return expertiseLevel;
    }

    public void setExpertiseLevel(int expertiseLevel) {
        this.expertiseLevel = expertiseLevel;
    }
    //methods

    /**
     * This method is used to return the number of years since the employee graduated.
     * @return
     */
    public int noOfYearsSinceGraduation(){
        LocalDate today = LocalDate.now();
        int years = today.getYear() - dateOfGraduation.getYear();
        return years;
    }
}
