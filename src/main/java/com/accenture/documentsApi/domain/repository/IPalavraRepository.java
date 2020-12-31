package com.accenture.documentsApi.domain.repository;

import com.accenture.documentsApi.domain.models.Palavra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPalavraRepository extends JpaRepository<Palavra, Integer> {
}
