package com.holyviastores.model;


import com.holyviastores.enums.Certification;
import com.holyviastores.enums.Gender;
import com.holyviastores.enums.Qualification;

public class Cashier extends Person {
    private Qualification qualification;
    private Certification certification;

    public Cashier(Integer id, String firstName, String lastName, Long phoneNo, Gender gender, String email, Qualification qualification, Certification certification) {
        super(id, firstName, lastName, phoneNo, gender, email);
        this.qualification = qualification;
        this.certification = certification;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "qualification=" + qualification +
                ", certification=" + certification +
                '}';
    }
}
