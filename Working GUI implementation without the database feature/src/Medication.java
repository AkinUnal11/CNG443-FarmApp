import java.time.LocalDate;
/**
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 */
public class Medication{
    private String details;
    private int duration;
    private LocalDate startDate;
    private double Dosage;
    private String notes;

    /**
     * Constructor for objects of class Medication
     * @param details
     * @param duration
     * @param startDate
     * @param dosage
     * @param notes
     */
    public Medication(String details, int duration, LocalDate startDate, double dosage, String notes) {
        this.details = details;
        this.duration = duration;
        this.startDate = startDate;
        Dosage = dosage;
        this.notes = notes;
    }
    public Medication() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getDosage() {
        return Dosage;
    }

    public void setDosage(double dosage) {
        Dosage = dosage;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
