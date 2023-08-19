package com.driver.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Userid;


    private String userName;
    private String password;

    private String firstName;

    private String lastName;

    public User(Integer userid, String userName, String password, String firstName, String lastName) {
        Userid = userid;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getUserid() {
        return Userid;
    }

    public void setUserid(Integer userid) {
        Userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User(String userName, String password, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    public List<Blog> getBlogList() {
        return BlogList;
    }

    public User(Integer userid, String userName, String password, String firstName, String lastName, List<Blog> blogList) {
        Userid = userid;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        BlogList = blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        BlogList = blogList;
    }

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
   private List<Blog> BlogList=new ArrayList<>();
}