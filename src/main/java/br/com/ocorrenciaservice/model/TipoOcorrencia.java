package br.com.ocorrenciaservice.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class TipoOcorrencia {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long tipoOcorrenciaId;

  @NotEmpty(message = "O campo categoria é obrigatório!")
  private String categoria;

  @NotEmpty private String subcategoria;

  private String status;

  private Date dataCadastro;

  public Long getTipoOcorrenciaId() {
    return tipoOcorrenciaId;
  }

  public void setTipoOcorrenciaId(Long tipoOcorrenciaId) {
    this.tipoOcorrenciaId = tipoOcorrenciaId;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getSubcategoria() {
    return subcategoria;
  }

  public void setSubcategoria(String subcategoria) {
    this.subcategoria = subcategoria;
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
}