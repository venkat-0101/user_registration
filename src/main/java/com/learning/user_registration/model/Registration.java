package com.learning.user_registration.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "register")
public class Registration {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long user_id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private LocalDateTime localDateTime;

    private String role;
    
}
