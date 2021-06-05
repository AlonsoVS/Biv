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
}
