package com.holyviastores.model;

import com.holyviastores.enums.Certification;
import com.holyviastores.enums.Qualification;
import lombok.*;

@AllArgsConstructor
@Getter
public class Applicant extends Person {
    private double testScore;
    private Qualification qualification;
    private Certification certification;

    @Override
    public String toString() {
        return "Applicant{" +
                "testScore=" + testScore +
                ", qualification=" + qualification +
                ", certification=" + certification +
                '}';
    }
}
