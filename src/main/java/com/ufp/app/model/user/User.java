package com.ufp.app.model.user;

import com.ufp.app.model.user.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int    id ;
    @Column(name = "first_name",nullable = false)
    private String firstname;
    @Column(name = "last_name",nullable = false)
    private String lastname;
    @Column(name = "role", nullable = false)
    private String role;
    @Column(name = "age",nullable = false)
    private int    age;
    @Column(name = "image",nullable = false)
    private String image;
    @Column (name = "gender",nullable = false)
    private Gender gender ;
}
