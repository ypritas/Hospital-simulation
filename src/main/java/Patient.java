import java.util.List;

public interface Patient {
    String getCurrentState();
    Patient giveDrugs(List<Drug> drugs);

     class Diabetes implements Patient {
        private String state = "D";
        private Patient patient = null;
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

         public boolean checkInsulin() {
             return gotInsulin;
         }

        @Override
        public Patient giveDrugs(List<Drug> drugs) {
            Patient patient = this;
            for (Drug drug: drugs) {
                patient = drug.apply(patient);
            };
            return patient;
        }
    }
     class Fever implements Patient {
        private String state = "F";
        @Override
        public String getCurrentState() {
            return state;
        }
        @Override
        public Patient giveDrugs(List<Drug> drugs) {
            Patient patient = this;
            for (Drug drug: drugs) {
                patient = drug.apply(patient);
            };
            return patient;
        }
     }
     class Healthy implements Patient {
        private String state = "H";
        private boolean gotInsulin = false;
        private boolean gotAntibiotics = false;
        @Override
        public String getCurrentState() {
            return state;
        }
        @Override
        public Patient giveDrugs(List<Drug> drugs) {
            Patient patient = this;
            for (Drug drug: drugs) {
                patient = drug.apply(patient);
            };
            return patient;
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
         };
    }
     class Tuberculosis implements Patient {
        private String state = "T";
        @Override
        public String getCurrentState() {
            return state;
        }
        @Override
        public Patient giveDrugs(List<Drug> drugs) {
            Patient patient = this;
            for (Drug drug: drugs) {
                patient = drug.apply(patient);
            };
            return patient;
        }
    }
     class Dead implements Patient {
        private String state = "X";
        @Override
        public String getCurrentState() {
            return state;
        }
        @Override
        public Patient giveDrugs(List<Drug> drugs) {
            Patient patient = this;
            for (Drug drug: drugs) {
                patient = drug.apply(patient);
            };
            return patient;
        }
    }
}

