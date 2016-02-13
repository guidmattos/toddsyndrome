package com.mozio.toddsyndrome.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by guilhermeduartemattos on 2/13/16.
 */

@Table(name = "Patients")
public class Patient extends Model {

    @Column(name = "Name")
    private String name;
    @Column(name = "Age")
    private int age;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Migraines")
    private boolean migraines;
    @Column(name = "Drugs")
    private boolean usedDrugs;


    public Patient() {}

    public Patient(String name, int age, String gender, boolean migraines, boolean usedDrugs) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.migraines = migraines;
        this.usedDrugs = usedDrugs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean hasMigraines() {
        return migraines;
    }

    public void setMigraines(boolean migraines) {
        this.migraines = migraines;
    }

    public boolean usedDrugs() {
        return usedDrugs;
    }

    public void setUsedDrugs(boolean usedDrugs) {
        this.usedDrugs = usedDrugs;
    }

    public static List<Patient> getPatients() {
        return new Select().from(Patient.class).execute();
    }


}
