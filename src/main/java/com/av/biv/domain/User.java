package com.av.biv.domain;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class User {
  private int id;
  private UUID uuidId;
  private String name;
  private String lastName;
  private String username;
  private String email;
  private String password;
  private Date birthDate;
  private String entityType;

  private List<Travel> travels;

  private List<Note> notes;

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

  public UUID getUuidId() {
    return uuidId;
  }

  public void setUuidId(UUID uuidId) {
    this.uuidId = uuidId;
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

  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public List<Travel> getTravels() {
    return travels;
  }

  public void setTravels(List<Travel> travels) {
    this.travels = travels;
  }

  public List<Note> getNotes() {
    return notes;
  }

  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }
}
