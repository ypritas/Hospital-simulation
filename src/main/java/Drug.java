public interface Drug {
    String getDrugCode();
    Patient apply(Patient patient);
     class Aspirin implements Drug{
        private final static String code = "As";

        @Override
        public String getDrugCode() {
            return code;
        }

        @Override
        public Patient apply(Patient patient) {
            if (patient instanceof Patient.Fever) {
                return new Patient.Healthy();
            }
            return patient;
        }
    }
     class Antibiotic implements Drug {
        private final static String code = "An";

        @Override
        public String getDrugCode() {
            return code;
        }

        @Override
        public Patient apply(Patient patient) {
            if (patient instanceof Patient.Tuberculosis) {
                return new Patient.Healthy();
            }
            if (patient instanceof Patient.Healthy) {
                ((Patient.Healthy) patient).GotAntibiotics();
                if (((Patient.Healthy) patient).checkInsulin()) {
                    return new Patient.Fever();
                }
            }
            return patient;
        }
    }
     class Insulin implements Drug {
        private final static String code = "I";

        @Override
        public String getDrugCode() {
            return code;
        }

        @Override
        public Patient apply(Patient patient) {
            if (patient instanceof Patient.Diabetes) {
                ((Patient.Diabetes) patient).GotInsulin();
                return patient;
            }
            if (patient instanceof Patient.Healthy) {
                ((Patient.Healthy) patient).GotInsulin();
                if (((Patient.Healthy) patient).checkAntibiotics()) {
                    return new Patient.Fever();
                }
            }
            return patient;
        }
    }
     class Paracetamol implements Drug {
        private final static String code = "P";

        @Override
        public String getDrugCode() {
            return code;
        }

        @Override
        public Patient apply(Patient patient) {
            if (patient instanceof Patient.Fever) {
                return new Patient.Healthy();
            }
            return patient;
        }
    }

    class FlyingSpaghetti implements Drug {
        private final static String code = "FS";

        @Override
        public String getDrugCode() {
            return code;
        }

        @Override
        public Patient apply(Patient patient) {
            if (patient instanceof Patient.Dead) {
                return new Patient.Healthy();
            }
            return patient;
        }
    }
}