package com.av.biv.persintance.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "travel_locations")
public class TravelLocationEntity implements Serializable {
  @PrePersist
  protected void onCreate() {
    setEntityType("location");
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  private String name;

  @Column(name = "travel_id")
  private int travelId;

  @Column(name = "user_id")
  private int userId;

  @Column(name = "entry_date")
  private Date entryDate;

  @Column(name = "departure_date")
  private Date departureDate;

  private String address;

  private boolean status;

  @Column(name = "entity_type")
  private String entityType;

  @ManyToOne
  @JoinColumn(name = "travel_id", insertable = false, updatable = false)
  private TravelEntity travel;

  @OneToMany(mappedBy = "locationTarget")
  private List<NoteEntity> notes;

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

  public TravelEntity getTravel() {
    return travel;
  }

  public void setTravel(TravelEntity travel) {
    this.travel = travel;
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

  public List<NoteEntity> getNotes() {
    return notes;
  }

  public void setNotes(List<NoteEntity> notes) {
    this.notes = notes;
  }
}
