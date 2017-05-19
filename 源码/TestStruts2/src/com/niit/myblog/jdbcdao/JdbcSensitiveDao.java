
package com.niit.myblog.jdbcdao;

import com.niit.myblog.interfaces.SensitiveInterface;
import com.niit.myblog.model.SensitiveBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
public class JdbcSensitiveDao implements SensitiveInterface{
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource){
        this.dataSource=dataSource;
    }
    @Override
    public List<SensitiveBean> findAll() {
        String sql="select *from SensitiveInfo";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        List<SensitiveBean> sensitiveBeans=new ArrayList<SensitiveBean>();
        List<Map<String,Object>> rows=jdbcTemplate.queryForList(sql);
        for(Map<String,Object> row:rows){
            SensitiveBean sensitiveBean=new SensitiveBean();
            sensitiveBean.setS_Word((String) row.get("S_Word"));
            sensitiveBeans.add(sensitiveBean);
        }
        return sensitiveBeans;
    }
	
}
