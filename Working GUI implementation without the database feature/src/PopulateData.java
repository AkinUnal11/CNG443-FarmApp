import java.time.LocalDate;
import java.util.ArrayList;


/**
 * @author Berke Diler
 * @version 1.0
 * @since 23-11-2022
 * This class has a function that populates the data.
 */
public class PopulateData {
    /**
     * This function populates the data.
     * @param animals
     * @param employees
     */
    public static void populateData(ArrayList<Animal> animals, ArrayList<Employee> employees)
    {
        //populate 3 cows and 3 sheep
        animals.add(new Cow(1,"male", LocalDate.of(2012,2,6),true,100.5));
        animals.add(new Cow(2,"male", LocalDate.of(2013,1,23),false,50.3));
        animals.add(new Cow(3,"female", LocalDate.of(2017,2,28),true,126.36));
        animals.add(new Sheep(4,"male", LocalDate.of(2018,3,12),true));
        animals.add(new Sheep(5,"female", LocalDate.of(2019,3,16),false));
        animals.add(new Sheep(6,"male", LocalDate.of(2022,1,13),false));
        //populate 2 vets
        employees.add(new Veterinary(1,"male",LocalDate.of(1990,1,1),true,LocalDate.of(2010,1,1),5));
        employees.add(new Veterinary(2,"female",LocalDate.of(1999,8,23),true,LocalDate.of(2019,8,23),3));
        //populate 2 farmers
        employees.add(new FarmWorker(3,"male",LocalDate.of(1990,1,1),"METU Farm",5));
        employees.add(new FarmWorker(4,"male",LocalDate.of(2000,3,31),"Kalkanli Farm",3));
        //add treatments to animals
        animals.get(0).treatments.add(new HealthTreatment(LocalDate.of(2021,1,14),true,(Veterinary)employees.get(0),new ArrayList<Medication>()));
        animals.get(0).treatments.add(new CleaningTreatment(LocalDate.of(2021,2,28),"Water",(FarmWorker)employees.get(2)));
        animals.get(1).treatments.add(new HealthTreatment(LocalDate.of(2018,1,1),false,(Veterinary)employees.get(1),new ArrayList<Medication>()));
        animals.get(1).treatments.add(new CleaningTreatment(LocalDate.of(2014,3,10),"Spray",(FarmWorker)employees.get(3)));
        animals.get(2).treatments.add(new HealthTreatment(LocalDate.of(2020,3,5),true,(Veterinary)employees.get(0),new ArrayList<Medication>()));
        animals.get(2).treatments.add(new CleaningTreatment(LocalDate.of(2020,3,5),"Water",(FarmWorker)employees.get(2)));
        animals.get(3).treatments.add(new HealthTreatment(LocalDate.of(2021,1,14),true,(Veterinary)employees.get(0),new ArrayList<Medication>()));
        animals.get(3).treatments.add(new CleaningTreatment(LocalDate.of(2021,2,28),"Water",(FarmWorker)employees.get(3)));
        animals.get(4).treatments.add(new HealthTreatment(LocalDate.of(2018,1,1),false,(Veterinary)employees.get(1),new ArrayList<Medication>()));
        animals.get(4).treatments.add(new CleaningTreatment(LocalDate.of(2014,3,10),"Spray",(FarmWorker)employees.get(2)));
        animals.get(5).treatments.add(new HealthTreatment(LocalDate.of(2020,3,5),true,(Veterinary)employees.get(0),new ArrayList<Medication>()));
        animals.get(5).treatments.add(new CleaningTreatment(LocalDate.of(2020,3,5),"Water",(FarmWorker)employees.get(3)));
        //add medications to treatments
        ((HealthTreatment)animals.get(0).treatments.get(0)).medications.add(new Medication("Paracetamol",1, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(0).treatments.get(0)).medications.add(new Medication("Ibuprofen",2, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(1).treatments.get(0)).medications.add(new Medication("Paracetamol",1, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(1).treatments.get(0)).medications.add(new Medication("Ibuprofen",2, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(2).treatments.get(0)).medications.add(new Medication("Paracetamol",1, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(2).treatments.get(0)).medications.add(new Medication("Ibuprofen",2, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(3).treatments.get(0)).medications.add(new Medication("Paracetamol",1, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(3).treatments.get(0)).medications.add(new Medication("Ibuprofen",2, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(4).treatments.get(0)).medications.add(new Medication("Paracetamol",1, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(4).treatments.get(0)).medications.add(new Medication("Ibuprofen",2, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(5).treatments.get(0)).medications.add(new Medication("Paracetamol",1, LocalDate.of(2020,8,23),2.5,"none"));
        ((HealthTreatment)animals.get(5).treatments.get(0)).medications.add(new Medication("Ibuprofen",2, LocalDate.of(2020,8,23),2.5,"none"));



    }
}
