package com.example.registerform.dto;

import com.example.registerform.contant.Role;

public class UserDto {

    private String name;

    private String email;

    private String country;

    private Role role;

    public UserDto(){

    }

    public UserDto(String name, String email, String country, Role role) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
