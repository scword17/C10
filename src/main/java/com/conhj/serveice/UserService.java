package com.conhj.serveice;

import com.conhj.dao.UserImpl;
import com.conhj.po.UserEntity;

import java.util.List;

public class UserService {
      private UserImpl dao;
      public UserService(){
          dao=new UserImpl();
      }
    public List<UserEntity> queryAll(){
        return dao.queryAll();
    }
    public boolean addUser(UserEntity user){
        return dao.addUser(user);
    }
    public boolean delUser(UserEntity user){
        return dao.delUser(user);
    }
    public UserEntity queryOne(UserEntity user){
        return dao.queryOne(user);
    }
    public boolean updateUser(UserEntity user){
        return dao.updateUser(user);
    }


}
