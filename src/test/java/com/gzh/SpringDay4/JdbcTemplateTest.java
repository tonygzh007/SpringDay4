package com.gzh.SpringDay4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Unit test for simple App.
 */
public class JdbcTemplateTest
{
    @Test
    public void test1(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt= (JdbcTemplate) ac.getBean("jdbcTemplate");
        //新增数据
//        jt.update("insert into account (name ,money)VALUES (?,?)","abc",1001);
//        jt.update("insert into account (name ,money)VALUES (?,?)","tom",8000);
//        jt.update("insert into account (name ,money)VALUES (?,?)","tim",800);
//        jt.update("insert into account (name ,money)VALUES (?,?)","tony",3000);

//        //查找多个
//        List<Account> list= jt.query("select * from account where money> ?", new BeanPropertyRowMapper<Account>(Account.class),999);
//        for(Account model :list){
//            System.out.println(model.toString());
//        }
         //查找一个
//        List<Account> list= jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(list.isEmpty()?"没有结果集": list.get(0).toString());
        //返回一行一列
        Long count1= jt.queryForObject("select count(*) from account", Long.class, null);
        System.out.println(count1);


    }
}
