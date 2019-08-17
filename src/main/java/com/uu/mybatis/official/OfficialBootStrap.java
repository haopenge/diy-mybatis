package com.uu.mybatis.official;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @desc mybatis 连接正确姿势
 * @author liuph
 * @date 2019/08/11 15:55
 */
public class OfficialBootStrap {


    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectByPrimaryKey(1);
        System.out.println(user.toString());
    }

    /**
     * @desc 获取连接会话
     * @author liuph
     * @date  2019/08/11 15:56
     * @return sqlSession
     */
    public static SqlSession getSqlSession() {
        InputStream inputStream = OfficialBootStrap.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession(true);
    }
}
