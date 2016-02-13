package com.mozio.toddsyndrome.logic;

import com.mozio.toddsyndrome.model.Patient;

/**
 * Created by guilhermeduartemattos on 2/13/16.
 */
public class ToddSyndromeModel {

    private static int migrainesWeight = 1;
    private static int fifteenOrYoungerWeight = 1;
    private static int genderMaleWeight = 1;
    private static int hallucinogicDrugsWeight = 1;

    public static double calculateProbability(Patient patient) {

        double score = 0;

        if (patient.hasMigraines())
            score += migrainesWeight;

        if (patient.getAge() <= 15)
            score += fifteenOrYoungerWeight;

        if (patient.getGender().equals("Male"))
            score += genderMaleWeight;

        if (patient.usedDrugs())
            score += hallucinogicDrugsWeight;

        return score / (migrainesWeight + fifteenOrYoungerWeight + genderMaleWeight + hallucinogicDrugsWeight);
    }
}

