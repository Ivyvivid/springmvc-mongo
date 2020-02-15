package com.example.ivy.dao.impl;

import com.example.ivy.dao.IBaseDao;
import com.example.ivy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:mongodb-context.xml"})
public class IBaseDaoImplTest {
    @Resource
    private IBaseDaoImpl baseDao ;

    @Test
    public void testMongo(){
        for (int i = 0; i < 10; i++) {
            User user = new User(i,"李丹" + i,"123");
            baseDao.save(user);
        }
    }

    @Test
    public void findAll() {
        List<User> users = new ArrayList<>();
        users = baseDao.findAll();
        for (User user :
                users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void findOne() {
        User user = new User();
        user = baseDao.findOne(2);
        System.out.println(user.toString());
    }

    @Test
    public void update() {
        User user = new User(7,"七宝","mamababa");
        baseDao.update(user);
        System.out.println(baseDao.findOne(7).toString());
    }

    @Test
    public void delete() {
        baseDao.delete(5);
        if (null == baseDao.findOne(5)){
            System.out.println("success");
        }
    }

    @Test
    public void add() {
        User user = new User(15,"ivy","ivy");
        baseDao.add(user);
        System.out.println(baseDao.findOne(15).toString());
    }


}
