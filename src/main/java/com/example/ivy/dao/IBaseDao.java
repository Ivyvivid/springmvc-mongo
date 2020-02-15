package com.example.ivy.dao;

import com.example.ivy.entity.User;

import java.util.List;

public interface IBaseDao{
    List<User> findAll();

    User findOne(int id);

    void update(User user);

    void delete(int id);

    void add(User user);

    void save(User user);
}
