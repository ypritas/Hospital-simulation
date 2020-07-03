# Hospital Simulator

This is a small Java project made for a code challenge.

## Problem description

You were asked by a doctor friend to prepare for her a “Hospital simulator”, which can simulate the future patients’ state, based on their current state and a list of drugs they take.

Patients can have one of these states:
- F: Fever
- H: Healthy
- D: Diabetes
- T: Tuberculosis
- X: Dead

In the “Hospital simulator” drugs are provided to all patients. It is not possible to target a specific patient. This is the list of available drugs:
- As: Aspirin
- An: Antibiotic
- I: Insulin
- P: Paracetamol

Drugs can change patients’ states. They can cure, cause side effects or even kill a patient if not properly prescribed.
Drugs effects are described by the following rules:
- Aspirin cures Fever;
- Antibiotic cures Tuberculosis;
- A sick patient not receiving the right medicines remains sick, if not explicitly mentioned otherwise;
- Insulin prevents diabetic subject from dying, does not cure Diabetes;
- If insulin is mixed with antibiotic, healthy people catch Fever;
- Paracetamol cures Fever;
- Paracetamol kills subject if mixed with aspirin;
- With a probability of 1/1,000,000 the Flying Spaghetti Monster shows his noodly power and resurrects a dead patient (Dead becomes Healthy).

While applying the rules, please keep in mind that:
- During one simulation a patient can change his state only once (only one rule can be applied).
- Rules causing Death take precedence over others.