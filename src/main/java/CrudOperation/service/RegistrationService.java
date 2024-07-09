package CrudOperation.service;

import CrudOperation.entity.Registration;

import java.util.List;
import java.util.Map;

public interface RegistrationService {
    void createRegistration(Registration registration);

    List<Registration> getRegistrations();

    void updateRegistration(long id, Registration registration);

    void deleteRegistration(long id);

    void partialUpdate(long id, Map<String, Object> fields);
}
