package com.av.biv.persintance.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "travels")
public class TravelEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "user_uuid_id")
  private UUID userUUIDId;

  @Column(name = "general_location")
  private String generalLocation;

  private String description;

  private Boolean status;

  @ManyToOne
  @JoinColumns({
          @JoinColumn(name = "user_uuid_id", referencedColumnName="uuid_id", insertable = false, updatable = false)
  })
  private UserEntity user;

  @OneToMany(mappedBy = "travel")
  private List<TravelLocationEntity> locations;

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

  public UUID getUserUUIDId() {
    return userUUIDId;
  }

  public void setUserUUIDId(UUID userUUIDId) {
    this.userUUIDId = userUUIDId;
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

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public List<TravelLocationEntity> getLocations() {
    return locations;
  }

  public void setLocations(List<TravelLocationEntity> locations) {
    this.locations = locations;
  }
}
