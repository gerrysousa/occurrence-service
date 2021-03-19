package br.com.occurrenceservice.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity implements Serializable {
//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private  Long id;
//
//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    AbstractEntity that = (AbstractEntity) o;
//    return id == that.id;
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(id);
//  }
}
