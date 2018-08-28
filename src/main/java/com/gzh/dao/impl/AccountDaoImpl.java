package com.gzh.dao.impl;

import com.gzh.dao.IAccountDao;
import com.gzh.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 账号的业务层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Account findAccountById(Long accountId) {
        List<Account> accouts= jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accouts.isEmpty()?null: accouts.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts= jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if(accounts.isEmpty())
            return null;
        if(accounts.size()>1){
            //结果集不唯一，不符合我们的约定
            throw new RuntimeException("结果集不唯一，不符合我们的约定");
        }
        return accounts.get(0);
    }

    @Override
    public void update(Account account) {
        //UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
        jdbcTemplate.update("update account set name=?,money=? where id =? ",account.getName(),account.getMoney(),account.getId());
    }


}
