package com.gzh.dao;

import com.gzh.domain.Account;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    /**
     * 根据ID号查账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Long accountId);

    /**
     * 根据姓名查账户信息
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新对象
     * @param account
     */
    void update(Account account);

}
