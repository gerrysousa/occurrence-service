package br.com.occurrenceservice.repository;

import br.com.occurrenceservice.model.OccurrenceType;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OccurrenceTypeRepository extends PagingAndSortingRepository<OccurrenceType, Long> {
  List<OccurrenceType> findByCategoryIgnoreCaseContaining(String category);

}
