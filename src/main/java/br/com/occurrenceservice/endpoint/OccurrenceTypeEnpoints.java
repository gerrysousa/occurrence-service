package br.com.occurrenceservice.endpoint;

import br.com.occurrenceservice.error.ResourceNotFoundException;
import br.com.occurrenceservice.model.OccurrenceType;
import br.com.occurrenceservice.repository.OccurrenceTypeRepository;
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
@RequestMapping("occurrenceTypes")
public class OccurrenceTypeEnpoints {
  private final OccurrenceTypeRepository occurrenceTypeDAO;

  @Autowired
  public OccurrenceTypeEnpoints(OccurrenceTypeRepository occurrenceTypeDAO) {
    this.occurrenceTypeDAO = occurrenceTypeDAO;
  }

  @GetMapping
  public ResponseEntity<?> listAll(Pageable pageable) {
    return new ResponseEntity<>(occurrenceTypeDAO.findAll(pageable), HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<?> getOccurrenceTypeById(@PathVariable("id") Long id,
      @AuthenticationPrincipal UserDetails userDetails) {
    System.out.println(userDetails);
    verifyIfOccurrenceTypeExists(id);
    OccurrenceType occurrenceType = occurrenceTypeDAO.findById(id).get();
    return new ResponseEntity<>(occurrenceType, HttpStatus.OK);
  }

  @GetMapping(path = "/findByCategory/{category}")
  public ResponseEntity<?> findByCategory(@PathVariable String category) {
    return new ResponseEntity<>(occurrenceTypeDAO.findByCategoryIgnoreCaseContaining(category), HttpStatus.OK);
  }

  @PostMapping
  @Transactional(rollbackFor = Exception.class)
  public ResponseEntity<?> save(@Valid @RequestBody OccurrenceType occurrenceType) {
    return new ResponseEntity<>(occurrenceTypeDAO.save(occurrenceType), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    verifyIfOccurrenceTypeExists(id);
    occurrenceTypeDAO.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody OccurrenceType occurrenceType) {
    verifyIfOccurrenceTypeExists(occurrenceType.getOccurrenceTypeId());
    occurrenceTypeDAO.save(occurrenceType);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void verifyIfOccurrenceTypeExists(Long id){
    if (!occurrenceTypeDAO.findById(id).isPresent()){
      throw new ResourceNotFoundException("OccurrenceType not found for ID: "+id);
    }
  }
}