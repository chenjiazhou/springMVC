package com.kgc.test;

import com.kgc.dao.IAccountDao;
import com.kgc.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void test1() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = factoryBuilder.build(in);
        //通过工厂构建sqlSession
        SqlSession session = factory.openSession();
        //通过session获取dao的代理对象
        IAccountDao dao = session.getMapper(IAccountDao.class);
        //执行操作
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        //释放资源
        session.close();
        in.close();
    }

    @Test
    public void test2() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = factoryBuilder.build(in);
        //通过工厂构建sqlSession
        SqlSession session = factory.openSession();
        //通过session获取dao的代理对象
        IAccountDao dao = session.getMapper(IAccountDao.class);
        //执行操作
        Account account = new Account();
        account.setName("小姐姐");
        account.setMoney(5000);
        dao.saveAccount(account);
        session.commit();
        //释放资源
        session.close();
        in.close();
    }
}
