package br.com.ocorrenciaservice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OcorrenciaTest extends Ocorrencia{

  @Test
  void getDescricaoTest() {
    Ocorrencia ocorrencia = new Ocorrencia();
    ocorrencia.setDescricao("Destrição testes");

    assertEquals("Destrição testes",ocorrencia.getDescricao());
  }

  @Test
  void setDescricaoTest() {
    Ocorrencia ocorrencia = new Ocorrencia();
    ocorrencia.setDescricao("Destrição testes");

    assertEquals("Destrição testes",ocorrencia.getDescricao());
  }

  @Test
  void setUsuarioIdTest() {
    Ocorrencia ocorrencia = new Ocorrencia();
    ocorrencia.setUsuarioId("123456789");

    assertEquals("123456789",ocorrencia.getOcorrenciaId());
  }

  @Test
  void getTipoOcorrenciaIdTest() {
    Ocorrencia ocorrencia = new Ocorrencia();
    ocorrencia.setTipoOcorrenciaId("1");

    assertEquals("1",ocorrencia.getTipoOcorrenciaId());
  }

  @Test
  void setTipoOcorrenciaIdTest() {
    Ocorrencia ocorrencia = new Ocorrencia();
    ocorrencia.setTipoOcorrenciaId("1");

    assertEquals("1",ocorrencia.getTipoOcorrenciaId());
  }

  @Test
  void getStatusTest() {
    Ocorrencia ocorrencia = new Ocorrencia();
    ocorrencia.setStatus("ativo");

    assertEquals("ativo", ocorrencia.getStatus());
  }

  @Test
  void setStatusTest() {
    Ocorrencia ocorrencia = new Ocorrencia();
    ocorrencia.setStatus("ativo");

    assertEquals("ativo", ocorrencia.getStatus());
  }


}