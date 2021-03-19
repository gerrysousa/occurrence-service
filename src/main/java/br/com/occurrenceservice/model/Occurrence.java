package br.com.occurrenceservice.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Occurrence {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long occurrenceId;

  @NotEmpty(message = "UserId is mandatory!")
  private String userId;

  @NotEmpty(message = "OccurrenceTypeId is mandatory!")
  private String occurrenceTypeId;

  private String status;

  private Date createData;

  private double latitude;

  private double longitude;

  private String description;

  public Long getOccurrenceId() {
    return occurrenceId;
  }

  public void setOccurrenceId(Long occurrenceId) {
    this.occurrenceId = occurrenceId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getOccurrenceTypeId() {
    return occurrenceTypeId;
  }

  public void setOccurrenceTypeId(String occurrenceTypeId) {
    this.occurrenceTypeId = occurrenceTypeId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getCreateData() {
    return createData;
  }

  public void setCreateData(Date createData) {
    this.createData = createData;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}
