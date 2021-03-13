package br.com.ocorrenciaservice.endpoint;

import br.com.ocorrenciaservice.error.ResourceNotFoundException;
import br.com.ocorrenciaservice.model.TipoOcorrencia;
import br.com.ocorrenciaservice.repository.TipoOcorrenciaRepository;
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
@RequestMapping("tipoOcorrencias")
public class TipoOcorrenciaEnpoints {
  private final TipoOcorrenciaRepository tipoOcorrenciaDAO;

  @Autowired
  public TipoOcorrenciaEnpoints(TipoOcorrenciaRepository tipoOcorrenciaDAO) {
    this.tipoOcorrenciaDAO = tipoOcorrenciaDAO;
  }

  @GetMapping
  public ResponseEntity<?> listAll(Pageable pageable) {
    return new ResponseEntity<>(tipoOcorrenciaDAO.findAll(pageable), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<?> getTipoOcorrenciaById(@PathVariable("id") Long id,
      @AuthenticationPrincipal UserDetails userDetails) {
    System.out.println(userDetails);
    verificarSeTipoOcorrenciaExiste(id);
    TipoOcorrencia tipoOcorrencia = tipoOcorrenciaDAO.findById(id).get();
    return new ResponseEntity<>(tipoOcorrencia, HttpStatus.OK);
  }

  @GetMapping(path = "/findByCategoria/{categoria}")
  public ResponseEntity<?> findByCategoria(@PathVariable String categoria) {
    return new ResponseEntity<>(tipoOcorrenciaDAO.findByCategoriaIgnoreCaseContaining(categoria), HttpStatus.OK);
  }

  @PostMapping
  @Transactional(rollbackFor = Exception.class)
  public ResponseEntity<?> save(@Valid @RequestBody TipoOcorrencia tipoOcorrencia) {
    return new ResponseEntity<>(tipoOcorrenciaDAO.save(tipoOcorrencia), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    verificarSeTipoOcorrenciaExiste(id);
    tipoOcorrenciaDAO.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody TipoOcorrencia tipoOcorrencia) {
    verificarSeTipoOcorrenciaExiste(tipoOcorrencia.getId());
    tipoOcorrenciaDAO.save(tipoOcorrencia);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void verificarSeTipoOcorrenciaExiste(Long id){
    if (!tipoOcorrenciaDAO.findById(id).isPresent()){
      throw new ResourceNotFoundException("TipoOcorrencia not found for ID: "+id);
    }
  }
}