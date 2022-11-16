package com.holyviastores.service.serviceImpl;

import com.holyviastores.enums.Qualification;
import com.holyviastores.exceptions.NotQualifiedException;
import com.holyviastores.model.Applicant;
import com.holyviastores.model.Store;
import com.holyviastores.service.ApplicantService;


public class ApplicantServiceImpl implements ApplicantService {

    @Override
    public String apply(Applicant applicant, Store store) {
        if (!applicant.getQualification().equals(Qualification.BSC)) {
            throw new NotQualifiedException("You need a BSC to apply to this job");
        }else {
            store.getApplicantList().add(applicant);
            return "Application Successful";
        }
    }
}
