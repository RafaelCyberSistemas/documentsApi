package com.accenture.documentsApi.domain.repository;

import com.accenture.documentsApi.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
