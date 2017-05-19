
package com.niit.myblog.interfaces;
import com.niit.myblog.model.UserInfoBean;
import java.util.List;

public interface UserInfoInterface {
    public void insert(UserInfoBean userinfo);
    public void update(UserInfoBean userinfo);    
    public UserInfoBean findByUser_Name(String User_Name);
    public List<UserInfoBean> findAll();
}
