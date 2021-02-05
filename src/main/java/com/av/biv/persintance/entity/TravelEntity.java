package com.av.biv.persintance.entity;

import javax.persistence.*;

@Entity
@Table(name = "travels")
public class TravelEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "general_location")
  private String generalLocation;

  private String description;

  private Boolean status;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getGeneralLocation() {
    return generalLocation;
  }

  public void setGeneralLocation(String generalLocation) {
    this.generalLocation = generalLocation;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
