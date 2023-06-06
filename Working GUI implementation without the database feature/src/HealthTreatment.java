import java.time.LocalDate;
import java.util.ArrayList;
/**
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 */
public class HealthTreatment extends Treatment {
    boolean emergency;
    Veterinary hgivenby;
     ArrayList<Medication> medications = new ArrayList<>();

    /**
     * Constructor for objects of class HealthTreatment
     * @param dateOfTreatment
     * @param emergency
     * @param hgivenby
     * @param medications
     */
    public HealthTreatment(LocalDate dateOfTreatment, boolean emergency, Veterinary hgivenby, ArrayList<Medication> medications) {
        super(dateOfTreatment);
        this.emergency = emergency;
        this.hgivenby = hgivenby;
        this.medications = medications;
    }
    public HealthTreatment(LocalDate date) {
        super(date);
    }
    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
}
