package com.learning.user_registration.enums;

public enum Role {

    USER("ROLE_USER"),

    ADMIN("ROLE_ADMIN");


    private String role;

    private Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
