
package com.niit.myblog.jdbcdao;

import com.niit.myblog.interfaces.UserInfoInterface;
import com.niit.myblog.model.UserInfoBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;


public class JdbcUserInfoDao implements UserInfoInterface{
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource){
        this.dataSource=dataSource;
    }

    @Override
    public void insert(UserInfoBean userinfo) {
        String sql="insert into UserInfo values(?,?,?,0,?,100,?,0)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{userinfo.getUser_Name(),userinfo.getUser_Icon(),userinfo.getArticle(),userinfo.getMy_Focus(),userinfo.getMessage()});
    }

    @Override
    public void update(UserInfoBean userinfo) {
        String sql="update UserInfo set User_Icon=?,C_Number=?,My_Focus=?,Account_Balance=?,Message=?,Counter=? where User_Name=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[]{userinfo.getUser_Icon(),userinfo.getC_Number(),userinfo.getMy_Focus(),userinfo.getAccount_Balance(),userinfo.getMessage(),userinfo.getCounter(),userinfo.getUser_Name()});
        
    }

    @Override
    public UserInfoBean findByUser_Name(String User_Name) {
        String sql="select *from UserInfo where User_Name=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        final UserInfoBean userinfo = new UserInfoBean();
        
        jdbcTemplate.query(sql, new Object[]{ User_Name },new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                userinfo.setUser_Name(rs.getString("User_Name"));
                userinfo.setUser_Icon(rs.getString("User_Icon"));
                userinfo.setArticle(rs.getString("Article"));
                userinfo.setC_Number(rs.getInt("C_Number"));
                userinfo.setMy_Focus(rs.getString("My_Focus"));
                userinfo.setAccount_Balance(rs.getInt("Account_Balance"));
                userinfo.setMessage(rs.getString("Message"));
                userinfo.setCounter(rs.getInt("Counter"));
            }
        });
        return userinfo;
    }
    
    

    @Override
    public List<UserInfoBean> findAll() {
        String sql="select *from UserInfo";
        
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        List<UserInfoBean> userinfo=new ArrayList<UserInfoBean>();
        List<Map<String,Object>> rows=jdbcTemplate.queryForList(sql);
        for (Map<String,Object> row: rows){
            UserInfoBean userInfoBean=new UserInfoBean();
            userInfoBean.setUser_Name((String) row.get("User_Name"));
            userInfoBean.setUser_Icon((String) row.get("User_Icon"));
            userInfoBean.setC_Number((Integer) row.get("C_Number"));
            userInfoBean.setMy_Focus((String) row.get("My_Focus"));
            userInfoBean.setAccount_Balance((Integer) row.get("Account_Balance"));
            userInfoBean.setMessage((String) row.get("Message"));
            userInfoBean.setCounter((Integer) row.get("Counter"));
            userinfo.add(userInfoBean);
        }
        return userinfo;               
    }
}
