package com.av.biv.persintance.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "notes")
public class NoteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "user_id")
  Integer userId;

  @Column(name = "target_id")
  Integer targetId;

  String content;

  @Column(name = "create_date")
    Date createDate;
  
  @Column(name = "target_type")
  String targetType;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName="id", insertable = false, updatable = false)
  private UserEntity user;

  @ManyToOne
  @JoinColumns({
          @JoinColumn(name = "target_id", referencedColumnName="id", insertable = false, updatable = false),
          @JoinColumn(name = "target_type", referencedColumnName="entity_type", insertable = false, updatable = false)
  })
  private TravelEntity travelTarget;

  @ManyToOne
  @JoinColumns({
          @JoinColumn(name = "target_id", referencedColumnName="id", insertable = false, updatable = false),
          @JoinColumn(name = "target_type", referencedColumnName="entity_type", insertable = false, updatable = false)
  })
  private TravelLocationEntity locationTarget;

  public Integer getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Integer getTargetId() {
    return targetId;
  }

  public void setTargetId(int targetId) {
    this.targetId = targetId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getTargetType() {
    return targetType;
  }

  public void setTargetType(String targetType) {
    this.targetType = targetType;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public TravelEntity getTravelTarget() {
    return travelTarget;
  }

  public void setTravelTarget(TravelEntity travelTarget) {
    this.travelTarget = travelTarget;
  }

  public TravelLocationEntity getLocationTarget() {
    return locationTarget;
  }

  public void setLocationTarget(TravelLocationEntity locationTarget) {
    this.locationTarget = locationTarget;
  }
}
