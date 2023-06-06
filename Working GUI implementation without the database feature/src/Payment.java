/**
 * This is the Payment class. It is used to store the grossSalary information and it's inheritors will use the getSalary method to calculate the netSalary.
 */
public interface Payment {
    double grossSalary = 10000;
    double getSalary();
}
