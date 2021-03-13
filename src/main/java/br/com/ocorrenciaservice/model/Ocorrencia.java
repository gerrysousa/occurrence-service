package br.com.ocorrenciaservice.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Ocorrencia extends AbstractEntity{
  @NotEmpty(message = "O campo usuarioId é obrigatório!")
  private  String usuarioId;
  @NotEmpty(message = "O campo tipoOcorrenciaId é obrigatório!")
  private String tipoOcorrenciaId;

  private String status;

  private Date dataCadastro;

  private double latitude;

  private double longitude;

  private String descricao;

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(String usuarioId) {
    this.usuarioId = usuarioId;
  }

  public String getTipoOcorrenciaId() {
    return tipoOcorrenciaId;
  }

  public void setTipoOcorrenciaId(String tipoOcorrenciaId) {
    this.tipoOcorrenciaId = tipoOcorrenciaId;
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
