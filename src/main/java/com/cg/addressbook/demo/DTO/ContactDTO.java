package com.cg.addressbook.demo.DTO;


import com.cg.addressbook.demo.Model.Contact;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContactDTO {

        Long id;
        @NotNull(message = "Please enter valid name")
        @NotEmpty(message = "Please enter valid name")
        @Pattern(regexp = "^[A-Za-z]{3,}$", message = "Please enter valid name")
        String name;
        String city;
        String state;
        String phone;
        String email;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    public ContactDTO(Long id, String name, String city, String state, String phone, String email) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.email = email;
    }

    public ContactDTO(Contact contact){
        this.id = contact.getId();
        this.name = contact.getName();
        this.city = contact.getCity();
        this.state = contact.getState();
        this.phone = contact.getPhone();
        this.email = contact.getEmail();

    }

    public String toString(){
        return "Name: " + name + ", City: " + city + ", State: " + state + ", Phone: " + phone + ", Email: " + email ;
    }
}

