package com.example.ivy.dao;

import com.example.ivy.entity.User;

import java.util.List;

public interface IBaseDao{
    List<User> findAll();

    User findOne(String id);

    void update(User user);

    void delete(String id);

    void add(User user);

    void save(User user);
}
