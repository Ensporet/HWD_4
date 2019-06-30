package com.entity;

import lombok.Data;

@Data
public class User {

    private Long id;
    private
    String
            username,
            firstName,
            lastName,
            email,
            password,
            phone;
    private Long userStatus;

    public User() {
    }

    public User(Long id, String username, String firstName, String lastName, String email, String password, String phone, Long userStatus) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
