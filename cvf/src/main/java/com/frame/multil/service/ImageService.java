package com.frame.multil.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
/**
 * 图片显示
 * @author bobo
 *
 */
@Service("imageService")
public class ImageService {
	@Qualifier("multilJdbcTemplate")
	@Autowired
	private JdbcTemplate multilJdbcTemplate;
	public List<Map<String, Object>> queryForPageImages(int index,int size) {
		String sql = "select name,url,oldurl,width,height from images where appname='webapp' limit "+index+" ,"+size;
		return multilJdbcTemplate.queryForList(sql);
	}
}
