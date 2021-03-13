package br.com.ocorrenciaservice.repository;


import br.com.ocorrenciaservice.model.RegistroOcorrencia;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RegistroOcorrenciaRepository extends PagingAndSortingRepository<RegistroOcorrencia, Long> {
  List<RegistroOcorrencia> findByOcorrenciaIdIgnoreCaseContaining(String ocorrenciaId);

}
