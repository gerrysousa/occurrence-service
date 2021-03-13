package br.com.ocorrenciaservice.endpoint;

import br.com.ocorrenciaservice.error.ResourceNotFoundException;
import br.com.ocorrenciaservice.model.RegistroOcorrencia;
import br.com.ocorrenciaservice.repository.RegistroOcorrenciaRepository;
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
@RequestMapping("registro_ocorrencias")
public class RegistroOcorrenciaEndpoints {
  private final RegistroOcorrenciaRepository registroOcorrenciaDAO;

  @Autowired
  public RegistroOcorrenciaEndpoints(RegistroOcorrenciaRepository registroOcorrenciaDAO) {
    this.registroOcorrenciaDAO = registroOcorrenciaDAO;
  }

  @GetMapping
  public ResponseEntity<?> listAll(Pageable pageable) {
    return new ResponseEntity<>(registroOcorrenciaDAO.findAll(pageable), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<?> getRegistroOcorrenciaById(@PathVariable("id") Long id,
      @AuthenticationPrincipal UserDetails userDetails) {
    System.out.println(userDetails);
    verificarSeRegistroOcorrenciaExiste(id);
    RegistroOcorrencia registroOcorrencia = registroOcorrenciaDAO.findById(id).get();
    return new ResponseEntity<>(registroOcorrencia, HttpStatus.OK);
  }

  @GetMapping(path = "/findByOcorrenciaId/{ocorrenciaId}")
  public ResponseEntity<?> findByOcorrenciaId(@PathVariable String ocorrenciaId) {
    return new ResponseEntity<>(registroOcorrenciaDAO.findByOcorrenciaIdIgnoreCaseContaining(ocorrenciaId), HttpStatus.OK);
  }

  @PostMapping
  @Transactional(rollbackFor = Exception.class)
  public ResponseEntity<?> save(@Valid @RequestBody RegistroOcorrencia registroOcorrencia) {
    return new ResponseEntity<>(registroOcorrenciaDAO.save(registroOcorrencia), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    verificarSeRegistroOcorrenciaExiste(id);
    registroOcorrenciaDAO.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody RegistroOcorrencia registroOcorrencia) {
    verificarSeRegistroOcorrenciaExiste(registroOcorrencia.getId());
    registroOcorrenciaDAO.save(registroOcorrencia);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void verificarSeRegistroOcorrenciaExiste(Long id){
    if (!registroOcorrenciaDAO.findById(id).isPresent()){
      throw new ResourceNotFoundException("registro ocorrencia not found for ID: "+id);
    }
  }
}