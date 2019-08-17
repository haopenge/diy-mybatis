package com.uu.mybatis.official;


public interface UserDao {
    User selectByPrimaryKey(Integer userId);
}