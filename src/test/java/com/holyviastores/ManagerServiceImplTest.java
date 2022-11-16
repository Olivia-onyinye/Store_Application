package com.holyviastores;
import com.holyviastores.enums.Certification;
import com.holyviastores.enums.Gender;
import com.holyviastores.enums.Qualification;
import com.holyviastores.exceptions.NotQualifiedException;
import com.holyviastores.model.Store;
import org.junit.jupiter.api.Assertions;
import com.holyviastores.model.Applicant;
import com.holyviastores.model.Manager;
import com.holyviastores.service.ApplicantService;
import com.holyviastores.service.ManagerService;
import com.holyviastores.service.serviceImpl.ApplicantServiceImpl;
import com.holyviastores.service.serviceImpl.ManagerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerServiceImplTest {
    private Store store;
    private Applicant olivia;
    private Manager mrJohn;
    private  ManagerService managerService;

    @BeforeEach
    void setup(){
        store = new Store();
        mrJohn = new Manager(1001, "John", "Simeon",
                0703135606L, Gender.MALE, "simeonjohn@gmail.com");
        managerService = new ManagerServiceImpl();
    }


    @Test
    void hireShouldThrowExceptionWithWrongCertificationAndLowTestScore() {
        olivia = setUpApplicant(1002, "Olivia", "Joe",
                07023457L, Gender.FEMALE, "mag@gmail.com", 60, Qualification.MSC, Certification.ICAN);
        Assertions.assertThrows(NotQualifiedException.class, () -> managerService.hire(mrJohn, olivia, store),
                "Applicant is not qualified");
    }

    @Test
    void hireShouldReturnNewCashierThatWouldBeAddedToStaffList(){
        olivia = setUpApplicant(1002, "Olivia", "Joe",
                07023457L, Gender.FEMALE, "mag@gmail.com", 90, Qualification.BSC, Certification.ICAN);
        String managerAction = managerService.hire(mrJohn, olivia, store);
        Assertions.assertEquals("Congratulations, you have been hired", managerAction);
    }
    private Applicant setUpApplicant(Integer id, String firstName, String lastName, Long phoneNo, Gender gender, String email,
                                     double testScore, Qualification qualification, Certification certification){
            return new Applicant(testScore, qualification, certification);
    }
}
