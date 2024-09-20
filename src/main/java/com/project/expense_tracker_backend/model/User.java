package com.project.expense_tracker_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.expense_tracker_backend.dto.UserRegistrationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_DETAILS", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    private String mobileNumber;

    public User(UserRegistrationDto userDetails) {

        this.name = userDetails.getName();
        this.email = userDetails.getEmail();
        this.password = userDetails.getPassword();
        this.mobileNumber = userDetails.getMobileNumber();
    }

}
