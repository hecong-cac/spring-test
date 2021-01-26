package com.example.springtest.dao.entity;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User(String name, String password, Long userId) {
        this.name = name;
        this.password = password;
        this.userId = userId;
    }
}
