package com.av.biv.persintance.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
  @PrePersist
  protected void onCreate() {
    setUuidId(java.util.UUID.randomUUID());
    setEntityType("user");
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "uuid_id")
  private UUID uuidId;

  private String name;

  @Column(name = "last_name")
  private String lastName;

  private String username;

  private String email;

  private String password;

  @Column(name = "birthdate")
  private Date birthDate;

  @Column(name = "entity_type")
  private String entityType;

  @OneToMany(mappedBy = "user")
  private List<TravelEntity> travels;

  @OneToMany(mappedBy = "target")
  private List<NoteEntity> notes;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UUID getUuidId() {
    return uuidId;
  }

  public void setUuidId(UUID uuidId) {
    this.uuidId = uuidId;
  }

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

  public List<TravelEntity> getTravels() {
    return travels;
  }

  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public void setTravels(List<TravelEntity> travels) {
    this.travels = travels;
  }

  public List<NoteEntity> getNotes() {
    return notes;
  }

  public void setNotes(List<NoteEntity> notes) {
    this.notes = notes;
  }
}
