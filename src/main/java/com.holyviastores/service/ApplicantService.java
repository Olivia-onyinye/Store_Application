package com.holyviastores.service;

import com.holyviastores.model.Applicant;
import com.holyviastores.model.Store;

public interface ApplicantService {
    String apply(Applicant applicant, Store store);
}
