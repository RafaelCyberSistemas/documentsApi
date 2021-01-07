package com.accenture.documentsApi.domain.repository;

import com.accenture.documentsApi.domain.models.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentoRepository extends JpaRepository<Documento, Integer> {
}
