package CrudOperation.service.Impl;

import CrudOperation.entity.Registration;
import CrudOperation.repository.RegistrationRepository;
import CrudOperation.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {


    @Autowired
    private RegistrationRepository registrationRepository;
    @Override
    public void createRegistration(Registration registration) {
        registrationRepository.save(registration);
    }

    @Override
    public List<Registration> getRegistrations() {
        List<Registration> registrations = registrationRepository.findAll();
        return registrations;

    }

    @Override
    public void updateRegistration(long id, Registration reg) {
        Registration registration = registrationRepository.findById(id).get();
        registration.setName(reg.getName());
        registration.setEmail(reg.getEmail());
        registration.setEmail(reg.getEmail());
        registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(long id) {
        registrationRepository.deleteById(3L);
    }

    @Override
    public void partialUpdate(long id, Map<String, Object> fields) {
        Optional<Registration> byId = registrationRepository.findById(id);
        if (byId.isPresent()){
            fields.forEach((key,value)->{
                Registration registration = byId.get();
                Field field = ReflectionUtils.findField(Registration.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,registration,value);
                registrationRepository.save(registration);
            });
        }else {
            System.out.println("record not found");
        }

    }
}
