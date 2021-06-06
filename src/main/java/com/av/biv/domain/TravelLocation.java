package com.av.biv.domain;

import java.sql.Date;
import java.util.List;

public class TravelLocation {

  private int id;
  private String name;
  private Date entryDate;
  private Date departureDate;
  private int travelId;
  private int userId;
  private String address;
  private boolean status;
  private String entityType;
  private List<Note> notes;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Date getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  public Date getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(Date departureDate) {
    this.departureDate = departureDate;
  }

  public int getTravelId() {
    return travelId;
  }

  public void setTravelId(int travelId) {
    this.travelId = travelId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public List<Note> getNotes() {
    return notes;
  }

  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }
}
