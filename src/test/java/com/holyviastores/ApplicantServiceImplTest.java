package com.holyviastores;

import com.holyviastores.enums.Certification;
import com.holyviastores.enums.Qualification;
import com.holyviastores.exceptions.NotQualifiedException;
import com.holyviastores.model.Applicant;
import com.holyviastores.model.Store;
import com.holyviastores.service.ApplicantService;
import com.holyviastores.service.serviceImpl.ApplicantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicantServiceImplTest {

    private Applicant applicant;
    private ApplicantService applicantService;
    private Store store;


    @BeforeEach
    void setup(){
        store = new Store();
        applicantService = new ApplicantServiceImpl();
        applicant = new Applicant( 90, Qualification.BSC, Certification.ICAN);
    }

    @Test
    void ApplyShouldReturnApplicationSuccessfulWithRequiredQualificationAndScore() {
        Assertions.assertEquals("Application Successful", applicantService.apply(applicant, store));
    }

    @Test
    void ApplyShouldThrowExceptionWithWrongQualification() {
        applicant = new Applicant(70, Qualification.MSC, Certification.ICAN);
        Assertions.assertThrows(NotQualifiedException.class, () -> applicantService.apply(applicant, store),
                "You need a BSC to apply to this job");
    }
}