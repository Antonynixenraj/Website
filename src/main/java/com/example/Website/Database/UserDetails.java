package com.example.Website.Database;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
// This are the Table and Columns going to create inside Database
public class UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String dob;

    @Column(nullable = false,unique = true)
    private Long phoneNumber;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String password;

    public UserDetails(String firstname, String lastname, String email, String dob, Long phoneNumber, String gender, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.password = password;
    }
}
