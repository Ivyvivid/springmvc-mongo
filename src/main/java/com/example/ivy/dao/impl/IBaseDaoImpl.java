package com.example.ivy.dao.impl;

import com.example.ivy.entity.User;
import com.example.ivy.dao.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "iBaseDaoImpl")
public class IBaseDaoImpl implements IBaseDao {
    //MongoTemplate是数据库和代码之间的接口，对数据库的操作都在它里面
    @Resource
    private MongoTemplate mongoTemplate;
    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class,"user");
    }

    @Override
    public User findOne(int id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query,User.class);
    }

    @Override
    public void update(User user) {
        Update update = new Update();
        Query query = new Query();
        update.set("name", user.getName());
        update.set("password", user.getPassword());
        mongoTemplate.updateFirst(query.addCriteria(Criteria.where("_id").is(user.getId())), update, User.class);
    }

    @Override
    public void delete(int id) {
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), User.class);
    }

    @Override
    public void add(User user) {
        mongoTemplate.insert(user, "user");
    }

    @Override
    public void save(User user) {
        mongoTemplate.save(user);
    }
}
