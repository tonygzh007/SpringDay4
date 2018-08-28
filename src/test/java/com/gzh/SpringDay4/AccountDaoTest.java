package com.gzh.SpringDay4;

import com.gzh.dao.IAccountDao;
import com.gzh.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountDaoTest {
    @Test
    public void test1() {

        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao=(IAccountDao) ac.getBean("accountDaoImple");
        Account account = accountDao.findAccountById(1L);
        if(account!=null)
            System.out.println(account);

    }
}
