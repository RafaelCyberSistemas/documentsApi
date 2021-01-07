package com.accenture.documentsApi.domain.repository;

import com.accenture.documentsApi.domain.models.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConfiguracaoRepository extends JpaRepository<Configuracao, Integer> {
}
