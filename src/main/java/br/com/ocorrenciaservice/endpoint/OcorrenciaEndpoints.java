package br.com.ocorrenciaservice.endpoint;

import br.com.ocorrenciaservice.error.ResourceNotFoundException;

import br.com.ocorrenciaservice.model.Ocorrencia;
import br.com.ocorrenciaservice.repository.OcorrenciaRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ocorrencias")
public class OcorrenciaEndpoints {
  private final OcorrenciaRepository ocorrenciaDAO;

  @Autowired
  public OcorrenciaEndpoints(OcorrenciaRepository ocorrenciaDAO) {
    this.ocorrenciaDAO = ocorrenciaDAO;
  }

  @GetMapping
  public ResponseEntity<?> listAll(Pageable pageable) {
    return new ResponseEntity<>(ocorrenciaDAO.findAll(pageable), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<?> getOcorrenciaById(@PathVariable("id") Long id,
      @AuthenticationPrincipal UserDetails userDetails) {
    System.out.println(userDetails);
    verificarSeOcorrenciaExiste(id);
    Ocorrencia ocorrencia = ocorrenciaDAO.findById(id).get();
    return new ResponseEntity<>(ocorrencia, HttpStatus.OK);
  }

  @GetMapping(path = "/findByTipoOcorrenciaId/{tipoOcorrenciaId}")
  public ResponseEntity<?> findByTipoOcorrenciaId(@PathVariable String tipoOcorrenciaId) {
    return new ResponseEntity<>(ocorrenciaDAO.findByTipoOcorrenciaIdIgnoreCaseContaining(tipoOcorrenciaId), HttpStatus.OK);
  }

  @PostMapping
  @Transactional(rollbackFor = Exception.class)
  public ResponseEntity<?> save(@Valid @RequestBody Ocorrencia ocorrencia) {
    return new ResponseEntity<>(ocorrenciaDAO.save(ocorrencia), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    verificarSeOcorrenciaExiste(id);
    ocorrenciaDAO.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody Ocorrencia ocorrencia) {
    verificarSeOcorrenciaExiste(ocorrencia.getId());
    ocorrenciaDAO.save(ocorrencia);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void verificarSeOcorrenciaExiste(Long id){
    if (!ocorrenciaDAO.findById(id).isPresent()){
      throw new ResourceNotFoundException("registro ocorrencia not found for ID: "+id);
    }
  }
}