package com.av.biv.domain;

import java.sql.Date;
import java.util.List;

public class User {
  private String name;
  private int id;
  private String email;
  private String username;
  private String lastName;
  private String password;
  private Date birthDate;

  private List<Travel> userTravels;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public List<Travel> getUserTravels() {
    return userTravels;
  }

  public void setUserTravels(List<Travel> userTravels) {
    this.userTravels = userTravels;
  }
}
