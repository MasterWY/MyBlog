
package com.niit.myblog.interfaces;
import com.niit.myblog.model.AccountBean;

public interface AccountInterface {
    public void insert(AccountBean account);
    public void update(AccountBean account);
    public void delete(AccountBean account);
    public AccountBean findByAccountNo(String User_Name);
}
