package com.conhj.dao;

import com.conhj.po.UserEntity;

import com.conhj.serveice.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserImpl {
    private Configuration cfg=null;
    private SessionFactory sf=null;
    public UserImpl(){
        cfg=new Configuration().configure("hibernate.cfg.xml");
        sf=cfg.buildSessionFactory();
    }
    public boolean addUser(UserEntity user)  {;
        boolean flag=false;
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.save(user);
            transaction.commit();
            flag=true;
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();

        }
        return flag;
    }

    public boolean updateUser(UserEntity user)  {
       Session session=sf.openSession();
       Transaction transaction=session.beginTransaction();
        boolean flag=false;
        try{
            session.update(user);
            transaction.commit();
            flag=true;
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
   session.close();

        }
        return flag;
    }
    public boolean delUser(UserEntity user)  {
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();

        boolean flag=false;
        try{
            session.delete(user);
            transaction.commit();
            flag=true;
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag;
    }
    public List<UserEntity> queryAll() {
        Session session=sf.openSession();
        List<UserEntity>list=null;
        Query query=session.createQuery("from UserEntity as a order by a.id desc");
        query.setCacheable(true);
        list=query.list();
        session.close();
        return list;
    }

    public UserEntity queryOne(UserEntity userFromWeb) {
        Session session=sf.openSession();
        int xid= userFromWeb.getId();


//        UserEntity user =session.load(UserEntity.class,xid);
//        return user;
        UserEntity user =session.load(UserEntity.class,xid);
        UserEntity user2=new UserEntity();
        user2.setId(user.getId());
        user2.setUsername(user.getUsername());
        user2.setPassword(user.getPassword());
        session.close();
        return user2;
    }





}
