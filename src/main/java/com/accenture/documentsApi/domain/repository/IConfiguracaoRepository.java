package com.accenture.documentsApi.domain.repository;

import com.accenture.documentsApi.domain.models.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConfiguracaoRepository extends JpaRepository<Configuracao, Integer> {
}
