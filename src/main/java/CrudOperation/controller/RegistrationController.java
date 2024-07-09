package CrudOperation.controller;

import CrudOperation.entity.Registration;
import CrudOperation.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/crud")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<String> createRegistration(@RequestBody Registration registration){
        registrationService.createRegistration(registration);
        return new ResponseEntity<>("Registration is done", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Registration>> getRegistrations(){
        List<Registration> registrations = registrationService.getRegistrations();
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRegistraion(@PathVariable long id, @RequestBody Registration registration){
        registrationService.updateRegistration(id,registration);
        return new ResponseEntity<>("registration is updated", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable long id){
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Registration is deleted", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields){
        registrationService.partialUpdate(id,fields);
        return new ResponseEntity<>("Partial updation is done", HttpStatus.CREATED);
    }
}
