package br.com.occurrenceservice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OccurrenceTest extends Occurrence{

  @Test
  void getDescricaoTest() {
    Occurrence occurrence = new Occurrence();
    occurrence.setDescription("Destrição testes");

    assertEquals("Destrição testes",occurrence.getDescription());
  }

  @Test
  void setDescricaoTest() {
    Occurrence occurrence = new Occurrence();
    occurrence.setDescription("Destrição testes");

    assertEquals("Destrição testes",occurrence.getDescription());
  }

  @Test
  void setUsuarioIdTest() {
    Occurrence occurrence = new Occurrence();
    occurrence.setUserId("123456789");

    assertEquals("123456789",occurrence.getUserId());
  }

  @Test
  void getOccurrenceTypeIdTest() {
    Occurrence occurrence = new Occurrence();
    occurrence.setOccurrenceTypeId("1");

    assertEquals("1",occurrence.getOccurrenceTypeId());
  }

  @Test
  void setOccurrenceTypeIdTest() {
    Occurrence occurrence = new Occurrence();
    occurrence.setOccurrenceTypeId("1");

    assertEquals("1",occurrence.getOccurrenceTypeId());
  }

  @Test
  void getStatusTest() {
    Occurrence occurrence = new Occurrence();
    occurrence.setStatus("ativo");

    assertEquals("ativo", occurrence.getStatus());
  }

  @Test
  void setStatusTest() {
    Occurrence occurrence = new Occurrence();
    occurrence.setStatus("ativo");

    assertEquals("ativo", occurrence.getStatus());
  }


}