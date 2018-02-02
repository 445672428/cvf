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
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	public List<Map<String, Object>> queryForPageImages(int index,int size) {
		String sql = "select name,url,oldurl,width,height from images where appname='webapp' limit "+index+" ,"+size;
		return multilJdbcTemplate.queryForList(sql);
	}
	public List<Map<String, Object>> queryForYourMemory(String year, String user) {
		String sql = "select id,data_scale,data_y,data_x,tag,time,item_title1,item_title2,show_img1,show_img2,music,show_p from memory "
				+ "where year = '"+year+"' and user = '"+user+"' order by time";
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		int datax = 0;
		for(Map<String, Object> map : list){
			map.put("data_scale", map.get("data_scale")==null?"1":map.get("data_scale"));
			map.put("data_y",0);
			map.put("data_x",datax);
			map.put("tag",(datax/200+1));
			map.put("music", "resources/netlib/music/music.mp3");
			datax += 200;
		}
		return list;
	}
}
