package br.com.ocorrenciaservice.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class RegistroOcorrencia extends AbstractEntity{
  @NotEmpty(message = "O campo usuarioId é obrigatório!")
  private  String usuarioId;
  @NotEmpty(message = "O campo ocorrenciaId é obrigatório!")
  private String ocorrenciaId;

  private String status;

  private Date dataCadastro;

  private double latitude;

  private double longitude;

  public String getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(String usuarioId) {
    this.usuarioId = usuarioId;
  }

  public String getOcorrenciaId() {
    return ocorrenciaId;
  }

  public void setOcorrenciaId(String ocorrenciaId) {
    this.ocorrenciaId = ocorrenciaId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(Date dataCadastro) {
    this.dataCadastro = dataCadastro;
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
