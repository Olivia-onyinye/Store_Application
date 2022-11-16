package com.holyviastores.service.serviceImpl;

import com.holyviastores.enums.Certification;
import com.holyviastores.exceptions.NotQualifiedException;
import com.holyviastores.model.Applicant;
import com.holyviastores.model.Cashier;
import com.holyviastores.model.Manager;
import com.holyviastores.model.Store;
import com.holyviastores.service.ManagerService;



public class ManagerServiceImpl implements ManagerService {

    @Override
    public String hire(Manager manager, Applicant applicant, Store store) {
        if (applicant.getCertification().equals(Certification.ICAN) && applicant.getTestScore() >= 90) {
            Cashier cashier = new Cashier (
                    applicant.getId(),
                    applicant.getFirstName(),
                    applicant.getLastName(),
                    applicant.getPhoneNo(),
                    applicant.getGender(),
                    applicant.getEmail(),
                    applicant.getQualification(),
                    applicant.getCertification());
            store.getStaffList().add(cashier);
            }else {
                throw new NotQualifiedException("Applicant is not qualified");
        }
        return "Congratulations, you have been hired";
    }
}
