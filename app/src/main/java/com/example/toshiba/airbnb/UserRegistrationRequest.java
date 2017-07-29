package com.example.toshiba.airbnb;

/**
 * Created by TOSHIBA on 29/07/2017.
 */


public class UserRegistrationRequest {
    final String first_name;
    final String last_name;
    final String email;
    final String password;
    final int age;

    UserRegistrationRequest(String first_name, String last_name, String email, String password, int age ){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

}