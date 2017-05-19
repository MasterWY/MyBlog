
package com.niit.myblog.jdbcdao;

import com.niit.myblog.interfaces.BlogInterface;
import com.niit.myblog.model.BlogBean;
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

public class JdbcBlogDao implements BlogInterface{
     @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;   

    public void setDataSource(DataSource dataSource){
        this.dataSource=dataSource;
    }
    @Override
    public void insert(BlogBean blog) {
        String sql="insert into Blog values(?,?,?,?,?,0,0,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{blog.getArticle(),blog.getUser_Name(),blog.getCategory(),blog.getContent(),blog.getComments(),blog.getPub_Date(),blog.getTag()});
    }

    @Override
    public void update(BlogBean blog) {
        String sql="update Blog set Article=?,Category=?,Content=? where User_Name=? and Pub_Date=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{blog.getArticle(),blog.getCategory(),blog.getContent(),blog.getUser_Name(),blog.getPub_Date()});
    }

    @Override
    public void delete(BlogBean blog) {
        String sql="delete from Blog where Article=? and User_Name=? and Pub_Date=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{blog.getArticle(),blog.getUser_Name(),blog.getPub_Date()});
    }

    @Override
    public List<BlogBean> findByArticle(String Article) {
        String sql="select *from Blog where Article='"+Article+"'";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        List<BlogBean> blogBeans=new ArrayList<BlogBean>();
        List<Map<String,Object>> rows=jdbcTemplate.queryForList(sql);
        for(Map<String,Object> row:rows){
            BlogBean blog=new BlogBean();
                    blog.setArticle((String) row.get("Article"));
                    blog.setUser_Name((String) row.get("User_Name"));
                    blog.setCategory((String) row.get("Category"));
                    blog.setContent((String) row.get("Content"));
                    blog.setComments((String) row.get("Comments"));
                    blog.setLikes((Integer) row.get("Likes"));
                    blog.setDislikes((Integer) row.get("Dislikes"));
                    blog.setPub_Date((String) row.get("Pub_Date"));
                    blog.setTag((String) row.get("Tag"));
                    blogBeans.add(blog);
        }
        return blogBeans;
    }

    @Override
    public List<BlogBean> findByUser_Name(String User_Name) {
        String sql="select *from Blog where User_Name='"+User_Name+"'";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        List<BlogBean> blogBeans=new ArrayList<BlogBean>();
        List<Map<String,Object>> rows=jdbcTemplate.queryForList(sql);
        for(Map<String,Object> row:rows){
            BlogBean blog=new BlogBean();
                    blog.setArticle((String) row.get("Article"));
                    blog.setUser_Name((String) row.get("User_Name"));
                    blog.setCategory((String) row.get("Category"));
                    blog.setContent((String) row.get("Content"));
                    blog.setComments((String) row.get("Comments"));
                    blog.setLikes((Integer) row.get("Likes"));
                    blog.setDislikes((Integer) row.get("Dislikes"));
                    blog.setPub_Date((String) row.get("Pub_Date"));
                    blog.setTag((String) row.get("Tag"));
                    blogBeans.add(blog);
        }
        return blogBeans;
    }

    @Override
    public List<BlogBean> findByCategory(String Category) {
        String sql="select *from Blog where Category='"+Category+"'";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        List<BlogBean> blogBeans=new ArrayList<BlogBean>();
        List<Map<String,Object>> rows=jdbcTemplate.queryForList(sql);
        for(Map<String,Object> row:rows){
            BlogBean blog=new BlogBean();
                    blog.setArticle((String) row.get("Article"));
                    blog.setUser_Name((String) row.get("User_Name"));
                    blog.setCategory((String) row.get("Category"));
                    blog.setContent((String) row.get("Content"));
                    blog.setComments((String) row.get("Comments"));
                    blog.setLikes((Integer) row.get("Likes"));
                    blog.setDislikes((Integer) row.get("Dislikes"));
                    blog.setPub_Date((String) row.get("Pub_Date"));
                    blog.setTag((String) row.get("Tag"));
                    blogBeans.add(blog);
        }
        return blogBeans;
    }

    @Override
    public List<BlogBean> findAll() {
        String sql="select *from Blog order by Pub_Date desc";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        List<BlogBean> blogBeans=new ArrayList<BlogBean>();
        List<Map<String,Object>> rows=jdbcTemplate.queryForList(sql);
        for(Map<String,Object> row:rows){
            BlogBean blog=new BlogBean();
                    blog.setArticle((String) row.get("Article"));
                    blog.setUser_Name((String) row.get("User_Name"));
                    blog.setCategory((String) row.get("Category"));
                    blog.setContent((String) row.get("Content"));
                    blog.setComments((String) row.get("Comments"));
                    blog.setLikes((Integer) row.get("Likes"));
                    blog.setDislikes((Integer) row.get("Dislikes"));
                    blog.setPub_Date((String) row.get("Pub_Date"));
                    blog.setTag((String) row.get("Tag"));
                    blogBeans.add(blog);
        }
        return blogBeans;
    }
    @Override
    public void updateLD(BlogBean blog){
    	String sql="update Blog set Likes=?,Dislikes=? where User_Name=? and Pub_Date=?";
    	JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
    	jdbcTemplate.update(sql,new Object[]{blog.getLikes(),blog.getDislikes(),blog.getUser_Name(),blog.getPub_Date()});
    }
    @Override
    public void updateTag(BlogBean blog){
    	String sql="update Blog set Tag=? where User_Name=? and Pub_Date=?";
    	JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
    	jdbcTemplate.update(sql,new Object[]{blog.getTag(),blog.getUser_Name(),blog.getPub_Date()});
    }
}
