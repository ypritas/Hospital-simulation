import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    public static final int ONE_IN_MILLION = 1000000;
    private List<Patient> affectedPatients = new ArrayList<>();
    private int counter = 0;
    public List<Patient> checkPatientState(List<Patient> patients, List<Drug> drugs) {
        miracleCurring(patients, drugs);
        patients.forEach(p -> {
            affectedPatients.add(p.giveDrugs(drugs));
        });
     return affectedPatients;
    }

    private void miracleCurring(List<Patient> patients, List<Drug> drugs) {
        counter = counter + patients.size();
        while (counter > ONE_IN_MILLION) {
            counter = counter-ONE_IN_MILLION;
            drugs.add(new Drug.FlyingSpaghetti());
        }
    }
}
