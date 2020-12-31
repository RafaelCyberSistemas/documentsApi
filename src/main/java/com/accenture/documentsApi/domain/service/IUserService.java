package com.accenture.documentsApi.domain.service;

import com.accenture.documentsApi.domain.models.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    User findById(Integer id);
    User save(User user);
    User edit(User user);
    void delete(User user);
}
