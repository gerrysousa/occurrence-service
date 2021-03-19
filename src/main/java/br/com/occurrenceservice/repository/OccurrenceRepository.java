package br.com.occurrenceservice.repository;

import br.com.occurrenceservice.model.Occurrence;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OccurrenceRepository extends
    PagingAndSortingRepository<Occurrence, Long> {
    List<Occurrence> findByOccurrenceTypeIdIgnoreCaseContaining(String occurrenceTypeId);

    List<Occurrence> findByUserIdIgnoreCaseContaining(String userId);

  }
