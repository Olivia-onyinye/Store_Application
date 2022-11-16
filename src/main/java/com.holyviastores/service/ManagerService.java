package com.holyviastores.service;

import com.holyviastores.model.Applicant;
import com.holyviastores.model.Manager;
import com.holyviastores.model.Store;

public interface ManagerService {
    String hire(Manager manager, Applicant applicant, Store store);
}
