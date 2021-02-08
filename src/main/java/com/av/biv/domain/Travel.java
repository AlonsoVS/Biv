package com.av.biv.domain;

import java.util.List;

public class Travel {

  private int id;

  private int userId;

  private String generalLocation;

  private String description;

  private boolean status;

  private List<TravelLocation> locations;

  public int getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getUserId() {
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

  public boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public List<TravelLocation> getLocations() {
    return locations;
  }

  public void setLocations(List<TravelLocation> locations) {
    this.locations = locations;
  }
}
