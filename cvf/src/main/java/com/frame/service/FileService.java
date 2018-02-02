package com.frame.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.BaseService;
import com.entities.FileInfo;

@Service
public class FileService extends BaseService{
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
    public boolean isMd5Exist(String md5) {
    	String sql = "select * from fileinfo where md5 = '"+md5+"'";
    	List<Map<String, Object>> result = mysqlJdbcTemplate.queryForList(sql);
        return !result.isEmpty();
    }
    @Transactional
	public void save(FileInfo fileInfo) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(new Date());
		Timestamp timestamp = Timestamp.valueOf(time);
    	fileInfo.setUploadDate(timestamp);
		String sql = "insert into fileInfo (fileName,md5,uploadDate) values('"+fileInfo.getFileName()+"','"+fileInfo.getMD5()+"','"+fileInfo.getUploadDate()+"')";
		logger.info(sql);
		mysqlJdbcTemplate.update(sql);
	}
    
    
}