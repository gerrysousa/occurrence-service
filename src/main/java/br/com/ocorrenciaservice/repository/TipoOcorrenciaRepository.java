package br.com.ocorrenciaservice.repository;

import br.com.ocorrenciaservice.model.TipoOcorrencia;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TipoOcorrenciaRepository extends PagingAndSortingRepository<TipoOcorrencia, Long> {
  List<TipoOcorrencia> findByCategoriaIgnoreCaseContaining(String categoria);

}
