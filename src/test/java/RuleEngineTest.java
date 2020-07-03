import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class RuleEngineTest {

    @Test
    public void ruleEngineFeverTest () {
        RuleEngine ruleEngine = new RuleEngine();
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient.Diabetes());
        patients.add(new Patient.Fever());
        List<Drug> drugs = new ArrayList<>();
        drugs.add(new Drug.Paracetamol());
        drugs.add(new Drug.Insulin());
        List<Patient> patientList = ruleEngine.checkPatientState(patients, drugs);
        Map<String, Long> treatedPatients = patientList.stream()
                .collect(groupingBy(Patient::getCurrentState,  Collectors.counting()));
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String,Long> entry : treatedPatients.entrySet())
            result.append(entry.getKey() +
                    ":" + entry.getValue() + ",");
        result.deleteCharAt(result.length()-1);
        System.out.println(result);
        Assert.assertEquals("D:1,H:1", result.toString());
    }

    @Test
    public void ruleEngineDiabetesDeadTest () {
        RuleEngine ruleEngine = new RuleEngine();
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient.Diabetes());
        patients.add(new Patient.Fever());
        List<Drug> drugs = new ArrayList<>();
        drugs.add(new Drug.Paracetamol());
        drugs.add(new Drug.Aspirin());
        List<Patient> patientList = ruleEngine.checkPatientState(patients, drugs);
        Map<String, Long> treatedPatients = patientList.stream()
                .collect(groupingBy(Patient::getCurrentState,  Collectors.counting()));
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String,Long> entry : treatedPatients.entrySet())
            result.append(entry.getKey() +
                    ":" + entry.getValue() + ",");
        result.deleteCharAt(result.length()-1);
        System.out.println(result);
        Assert.assertEquals("H:1,X:1", result.toString());
    }
}
