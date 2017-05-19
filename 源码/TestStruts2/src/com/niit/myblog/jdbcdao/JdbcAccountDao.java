package com.niit.myblog.jdbcdao;

import com.niit.myblog.interfaces.AccountInterface;
import com.niit.myblog.model.AccountBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

public class JdbcAccountDao implements AccountInterface{
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource){    
        this.dataSource=dataSource;
    }
    @Override 
    public void insert(final AccountBean account) {       
        String sql="insert into Account values (?,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[] {
        account.getUser_Name(),account.getPassword(),account.getUserType()
        });
    }
    @Override
    public void update(AccountBean account) {
        String sql="update Account set Password=? where User_Name=?";
         JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
         jdbcTemplate.update(sql,new Object[]{account.getPassword(),account.getUser_Name()});
    }
    @Override
    public void delete(AccountBean account) {
        String sql="delete from Account where User_Name=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{account.getUser_Name()});
    }
    @Override
    public AccountBean findByAccountNo(String User_Name) {
        String sql="select *from Account where User_Name=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        final AccountBean accountBean=new AccountBean();
        jdbcTemplate.query(sql,new Object[]{User_Name},new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
            	accountBean.setUser_Name(rs.getString("User_Name"));
            	if(rs.getString("User_Name") != null){
            		accountBean.setFlag(true);
            	}
            	else{
            		accountBean.setFlag(false);
            	}
            	accountBean.setPassword(rs.getString("Password"));
            	accountBean.setUserType(rs.getString("UserType"));
            }
        });
        return accountBean;
        
    }
}