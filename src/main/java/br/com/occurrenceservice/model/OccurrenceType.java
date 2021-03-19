package br.com.occurrenceservice.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class OccurrenceType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long occurrenceTypeId;

  @NotEmpty(message = "Category is mandatory!")
  private String category;

  @NotEmpty private String subcategory;

  private String status;

  private Date createDate;

  public Long getOccurrenceTypeId() {
    return occurrenceTypeId;
  }

  public void setOccurrenceTypeId(Long occurrenceTypeId) {
    this.occurrenceTypeId = occurrenceTypeId;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getSubcategory() {
    return subcategory;
  }

  public void setSubcategory(String subcategory) {
    this.subcategory = subcategory;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
}