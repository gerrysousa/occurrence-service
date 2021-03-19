package br.com.occurrenceservice.endpoint;

import br.com.occurrenceservice.error.ResourceNotFoundException;

import br.com.occurrenceservice.model.Occurrence;
import br.com.occurrenceservice.repository.OccurrenceRepository;
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
@RequestMapping("occurrences")
public class OccurrenceEndpoints {
  private final OccurrenceRepository occurrenceDAO;

  @Autowired
  public OccurrenceEndpoints(OccurrenceRepository occurrenceDAO) {
    this.occurrenceDAO = occurrenceDAO;
  }

  @GetMapping
  public ResponseEntity<?> listAll(Pageable pageable) {
    return new ResponseEntity<>(occurrenceDAO.findAll(pageable), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<?> getOccurrenceById(@PathVariable("id") Long id,
      @AuthenticationPrincipal UserDetails userDetails) {
    System.out.println(userDetails);
    verificarSeOccurrenceExiste(id);
    Occurrence occurrence = occurrenceDAO.findById(id).get();
    return new ResponseEntity<>(occurrence, HttpStatus.OK);
  }

  @GetMapping(path = "/findByOccurrenceTypeId/{occurrenceTypeId}")
  public ResponseEntity<?> findByOccurrenceTypeId(@PathVariable String occurrenceTypeId) {
    return new ResponseEntity<>(occurrenceDAO.findByOccurrenceTypeIdIgnoreCaseContaining(occurrenceTypeId), HttpStatus.OK);
  }

  @GetMapping(path = "/findByUserId/{userId}")
  public ResponseEntity<?> findByUserId(@PathVariable String userId) {
    return new ResponseEntity<>(occurrenceDAO.findByUserIdIgnoreCaseContaining(userId), HttpStatus.OK);
  }

  @PostMapping
  @Transactional(rollbackFor = Exception.class)
  public ResponseEntity<?> save(@Valid @RequestBody Occurrence occurrence) {
    return new ResponseEntity<>(occurrenceDAO.save(occurrence), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    verificarSeOccurrenceExiste(id);
    occurrenceDAO.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody Occurrence occurrence) {
    verificarSeOccurrenceExiste(occurrence.getOccurrenceId());
    occurrenceDAO.save(occurrence);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void verificarSeOccurrenceExiste(Long id){
    if (!occurrenceDAO.findById(id).isPresent()){
      throw new ResourceNotFoundException("Cccurrence not found for ID: "+id);
    }
  }
}