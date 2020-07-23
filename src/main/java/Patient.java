import java.util.List;

public interface Patient {
    String getCurrentState();
    default Patient giveDrugs(List<Drug> drugs) {
        Patient patient = this;
        for (Drug drug: drugs) {
            patient = drug.apply(patient);
        }
        return patient;
    }

     class Diabetes implements Patient {
        private static final String state = "D";
        private boolean gotInsulin = false;
        @Override
        public String getCurrentState() {
            if (gotInsulin) {
                return state;
            } else {
                return "X";
            }
        }
        public void GotInsulin() {
            gotInsulin = true;
        }
    }
     class Fever implements Patient {
        private final String state = "F";
        @Override
        public String getCurrentState() {
            return state;
        }
     }
     class Healthy implements Patient {
        private final String state = "H";
        private boolean gotInsulin = false;
        private boolean gotAntibiotics = false;
        @Override
        public String getCurrentState() {
            return state;
        }

         public void GotInsulin() {
             gotInsulin = true;
         }
         public boolean checkInsulin() {
             return gotInsulin;
         }
         public void GotAntibiotics() {
             gotAntibiotics = true;
         }
         public boolean checkAntibiotics() {
             return gotAntibiotics;
         }
    }
     class Tuberculosis implements Patient {
        private static final String state = "T";
        @Override
        public String getCurrentState() {
            return state;
        }
    }
     class Dead implements Patient {
        private static final String state = "X";
        @Override
        public String getCurrentState() {
            return state;
        }
    }
}


