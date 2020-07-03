import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Hospital {

    private static final Logger LOG = LogManager.getLogger(Hospital.class.getName());
    private static final RuleEngine hospitalSimulator = new RuleEngine();

    public static void main(String[] args) {

        List<Drug> drugs = new ArrayList<>();
        List<Patient> patients = new ArrayList<>();

        if (args.length == 0) {
            LOG.error("Please provide patients list e.g: \"X,D,T,X,H,F\"");
            return;
        }

        if (args.length == 2) {
            Arrays.asList(args[1].split(",")).forEach(p -> {
                switch (p) {
                    case "P":
                        drugs.add(new Drug.Paracetamol());
                        break;
                    case "As":
                        drugs.add(new Drug.Aspirin());
                        break;
                    case "I":
                        drugs.add(new Drug.Insulin());
                        break;
                    case "An":
                        drugs.add(new Drug.Antibiotic());
                        break;
                }
            });
        }

        if (args.length > 2) {
            LOG.warn("You have provided to much arguments!!");
        }

        Arrays.asList(args[0].split(",")).forEach(p -> {
            switch (p) {
                case "D":
                    patients.add(new Patient.Diabetes());
                    break;
                case "F":
                    patients.add(new Patient.Fever());
                    break;
                case "X":
                    patients.add(new Patient.Dead());
                    break;
                case "T":
                    patients.add(new Patient.Tuberculosis());
                    break;
                case "H":
                    patients.add(new Patient.Healthy());
                    break;
            }
        });
        Map<String, Long> treatedPatients = hospitalSimulator.checkPatientState(patients, drugs).stream()
                .collect(groupingBy(Patient::getCurrentState,  Collectors.counting()));
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String,Long> entry : treatedPatients.entrySet())
            result.append(entry.getKey() +
                    ":" + entry.getValue() + ",");
        result.deleteCharAt(result.length()-1);
        System.out.println(result);
    }
}
