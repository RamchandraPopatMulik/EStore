package com.lcwd.electronic.store.ElectronicStore1.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;


    @Column(name="user_name")
    private String name;


    @Column(name="user_email",unique = true)
    private String email;


    @Column(name="user_password",length = 100,nullable = false)
    private String password;

    private String gender;

    @Column(length = 1000)
    private String about;

    @Column(name = "user_img_name")
    private String imgName;
}
