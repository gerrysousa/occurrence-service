package br.com.occurrenceservice.repository;

import br.com.occurrenceservice.model.Occurrence;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OccurrenceRepository extends
        JpaRepository<Occurrence, Long> {
    List<Occurrence> findByOccurrenceTypeIdIgnoreCaseContaining(String occurrenceTypeId);

    List<Occurrence> findByUserIdIgnoreCaseContaining(String userId);

  }
