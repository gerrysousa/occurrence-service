package br.com.ocorrenciaservice.repository;

import br.com.ocorrenciaservice.model.Ocorrencia;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OcorrenciaRepository extends
    PagingAndSortingRepository<Ocorrencia, Long> {
    List<Ocorrencia> findByTipoOcorrenciaIdIgnoreCaseContaining(String tipoOcorrenciaId);

  List<Ocorrencia> findByUsuarioIdIgnoreCaseContaining(String usuarioId);

  }
