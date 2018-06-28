package com.frame.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.annotation.SysLogColumn;
import com.base.BaseService;
import com.entities.FileInfo;
import com.utils.ComUtils;

import contant.Contant;

@Service
public class FileService extends BaseService{
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
    @SysLogColumn(operationName="进行MD5进行文件校验是否存在")
    public boolean isMd5Exist(String md5) {
    	String sql = "select * from fileinfo where md5 = '"+md5+"'";
    	List<Map<String, Object>> result = mysqlJdbcTemplate.queryForList(sql);
        return !result.isEmpty();
    }
    @Transactional
    @SysLogColumn(operationName="保存上传文件信息")
	public void save(FileInfo fileInfo) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(new Date());
		Timestamp timestamp = Timestamp.valueOf(time);
    	fileInfo.setUploadDate(timestamp);
		String sql = "insert into fileInfo (fileName,md5,uploadDate) values('"+fileInfo.getFileName()+"','"+fileInfo.getMD5()+"','"+fileInfo.getUploadDate()+"')";
		logger.info(sql);
		mysqlJdbcTemplate.update(sql);
	}
    
    @Transactional
    @SysLogColumn(operationName="保存文件信息")
	public JSONObject saveFileName(String userid, String filename, String parentid,Integer level,String uuid) {
		String sql = "insert into filetable (id,userid,filename,level,ishidden,parentid,description,subName,createtime) values (?,?,?,?,?,?,?,?,?)";
		logger.info(sql);
		mysqlJdbcTemplate.update(sql, new Object[]{uuid,userid,filename,level,false,parentid,null,null,ComUtils.getTimestamp()});
		JSONObject object = new JSONObject();
		object.put("id", uuid);
		object.put("userid", userid);
		object.put("filename", filename);
		object.put("level", level);
		object.put("ishidden", false);
		object.put("parentid", parentid);
		return object;
	}

	/**
	 * 查询当前 用户所有目录文件
	 * @param userid
	 * @param parentid
	 * @param level
	 * @return
	 */
	@SysLogColumn(operationName="查询当前 用户目录文件")
	public JSONObject queryFileByUUid(String userid, String parentid,Integer level) {
		if (level==null) {
			level = 0;
		}
		if (parentid==null) {
			parentid = Contant.DEFAULT_USER;
		}
		if (userid==null) {
			userid = Contant.DEFAULT_USER;
		}
		String sql = "select id,userid,filename,level,ishidden,createtime from filetable where userid='"+userid+"' and parentid = '"+parentid+"' and level = "+level+"";
		logger.info(sql);
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		JSONObject object = new JSONObject();
		object.put("list", list);
		return object;
	}
	/**
	 * 删除当前文件
	 * @param userid
	 * @param parentid
	 * @param level
	 * @return
	 */
	@Transactional
	@SysLogColumn(operationName="删除当前用户指定的文件或目录")
	public JSONObject deleteFileByUUid(String userid, String parentid,Integer level) {
		String sql = "delete from filetable where ";
		String condition = "";
		List<String> list = new ArrayList<String>();
		list = queryForChilds(parentid,list);
		list.add(parentid);
		System.out.println(list.toString());
		condition = createOrCondition(list,"id");
		sql = sql + condition;
		mysqlJdbcTemplate.execute(sql);
		JSONObject object = new JSONObject();
		object.put("succ", list);
		return object;
	}
	
	
	@SysLogColumn(operationName="查询中国所有省市街道")
	public List<String> queryForChilds(String id,List<String> list) {
		String sql = "SELECT id,userid,filename,level,ishidden,parentid FROM filetable where parentid='"+id+"'";
		List<Map<String, Object>> result = mysqlJdbcTemplate.queryForList(sql);
		if (result!=null&&result.size()>0) {
			for (Map<String, Object> map : result) {
				String _id = StringUtils.trim((String)map.get("id"));
				String _userid = StringUtils.trim((String)map.get("userid"));
				String _name = StringUtils.trim((String)map.get("filename"));
				int _level = (Integer)map.get("level");
				Boolean _is = (Boolean)map.get("ishidden");
				String _parentid = StringUtils.trim((String)map.get("parentid"));
				if (!_is) {
					list.add(_id);
					queryForChilds(_id,list);
				}
			}
		}
		return list;
	}
	@Transactional
	@SysLogColumn(operationName="更新文件信息")
	public int updateFileNameById(String id, String name) {
		String sql = "update filetable set filename = '"+name+"' where id = '"+id+"'";
		int count = mysqlJdbcTemplate.update(sql);
		return count;
	}
}