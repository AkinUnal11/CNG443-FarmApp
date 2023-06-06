//cleaning treatment class is a child class of treatment class
/**
 * Cleaning treatment class is a child class of treatment class
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 * @see Treatment class
 */

import java.time.LocalDate;

public class CleaningTreatment extends Treatment {
    private String materialused;
    FarmWorker cgivenby;

    /**
     * Constructor of cleaning treatment class
     * @param dateOfTreatment
     * @param materialused
     * @param cgivenby
     */
    public CleaningTreatment(LocalDate dateOfTreatment, String materialused, FarmWorker cgivenby) {
        super(dateOfTreatment);
        this.materialused = materialused;
        this.cgivenby = cgivenby;
    }

    public String getMaterialused() {
        return materialused;
    }

    public void setMaterialused(String materialused) {
        this.materialused = materialused;
    }
}


