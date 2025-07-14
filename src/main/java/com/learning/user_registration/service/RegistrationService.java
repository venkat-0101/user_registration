package com.learning.user_registration.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.user_registration.enums.Role;
import com.learning.user_registration.model.Registration;
import com.learning.user_registration.repository.RegistrationRepository;

@Service
public class RegistrationService {

    /**
     * Service layer classes acts as a bridge between the controller layer and the Repository layer and holds the business logics 
     */

    @Autowired
    private RegistrationRepository registrationRepository;
    
    public void registerUser(Registration user){
        user.setLocalDateTime(LocalDateTime.now());
        user.setRole(Role.USER.getRole());
        //TODO: encrypt the password
        registrationRepository.save(user);
    }


    public Boolean isUserAvailable(String email){
        Optional<Registration> user = registrationRepository.findByEmail(email);
        return user.isPresent();
    
    }
    
    public Registration getUser(String email) throws Exception{
        Optional<Registration> user = registrationRepository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        else{
            throw new Exception("user not found");
        }
    }
}
