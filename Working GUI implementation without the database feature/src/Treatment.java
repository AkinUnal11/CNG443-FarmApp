import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represents a treatment in the farm.
 * A treatment has a date of treatment, treatment details, medication, and a vet.
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 */
public class Treatment{
    private LocalDate dateOfTreatment;
    //constructor
    public Treatment(LocalDate dateOfTreatment)
    {
        this.dateOfTreatment = dateOfTreatment;
    }

    public Treatment() {
    }

    //getters
    public LocalDate getDateOfTreatment() {
        return dateOfTreatment;
    }
    //setters
    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }
}
