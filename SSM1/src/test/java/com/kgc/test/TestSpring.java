package com.kgc.test;


import com.kgc.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void test(){
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService accountService = (IAccountService) factory.getBean("accountService");
        accountService.findAll();
    }
}
