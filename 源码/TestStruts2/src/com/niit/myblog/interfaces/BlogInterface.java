
package com.niit.myblog.interfaces;
import com.niit.myblog.model.BlogBean;
import java.util.List;

public interface BlogInterface {
    public void insert(BlogBean blog);
    public void update(BlogBean blog);
    public void delete(BlogBean blog);
    public void updateLD(BlogBean blog);
    public void updateTag(BlogBean blog);
    public List<BlogBean> findByArticle(String Article);
    public List<BlogBean> findByUser_Name(String User_Name);
    public List<BlogBean> findByCategory(String Category);
    public List<BlogBean> findAll();
}
