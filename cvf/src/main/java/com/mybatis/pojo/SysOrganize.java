package com.mybatis.pojo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.base.DataEntity;
import com.data.DBUtils;

public class SysOrganize extends DataEntity<SysOrganize>{
    private String id;

    private String name;

    private String code;

    private String brief;

    private Date createtime;

    private String parentid;

    private String instruction;
    
    @Override
	public String toString() {
		return "SysOrganize [id=" + id + ", name=" + name + ", code=" + code
				+ ", brief=" + brief + ", createtime=" + createtime
				+ ", parentid=" + parentid + ", instruction=" + instruction
				+ ", icon=" + icon + "]";
	}

	private String icon;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction == null ? null : instruction.trim();
    }

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public static void main(String[] args) {
		SysOrganize sysOrganize = new SysOrganize();
		sysOrganize.setId("1");
		sysOrganize.setName("中国");
		sysOrganize.setParentid("0");
		
		String sql = "select name,code id,parentcode parentid from china"; 
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			Statement statement =connection.createStatement();
			statement.execute(sql);
			ResultSet resultSet = statement.getResultSet();
			List<SysOrganize> list = new ArrayList<SysOrganize>();
			while(resultSet.next()){
				String name = resultSet.getString("name");
				String code = resultSet.getString("id");
				String parentcode = resultSet.getString("parentid");
				SysOrganize s = new SysOrganize();
				s.setId(code);
				s.setParentid(parentcode);
				s.setName(name);
				list.add(s);
			}
			Map<String, String> filter = new HashMap<String, String>();
			filter.put("id", "id");
			filter.put("pid", "parentid");
			filter.put("text", "name");
			
			sysOrganize.setDatas(list,sysOrganize,filter);
			DataEntity<SysOrganize> d = sysOrganize.getDatas();
			
			System.out.println(d);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(connection, null, null);
		}

		
	}
}