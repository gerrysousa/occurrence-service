package br.com.ocorrenciaservice.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Ocorrencia extends AbstractEntity{
  @NotEmpty(message = "O campo categoria é obrigatório!")
  private  String categoria;
  @NotEmpty
  private String subcategoria;

  private String status;

  private Date dataCadastro;

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

/*
 `idocorrencias` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NOT NULL,
  `subcategoria` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NULL,
  `dataCadastro` DATETIME NULL,
 */