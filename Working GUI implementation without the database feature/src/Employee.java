import java.time.LocalDate;
/**
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 */
public abstract class Employee implements Comparable<Employee>,Payment{
    int empID;
    String gender;
    LocalDate dateOfBirth;

    /**
     * Constructor for objects of class Employee
     * @param empID
     * @param gender
     * @param dateOfBirth
     */
    public Employee(int empID, String gender, LocalDate dateOfBirth) {
        this.empID = empID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    public Employee() {
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {
        return grossSalary;
    }

    public int compareTo(Employee o) {
        if (o.getEmpID() == this.empID) {
            return 0;
        } else if (o.getEmpID() > this.empID) {
            return -1;
        } else {
            return 1;
        }
    }
}