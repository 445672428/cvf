package com.mybatis.pojo;

public class SysRoleMenu {
    private Integer id;

    private Integer roleid;

    private Integer menuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    @Override
	public String toString() {
		return "SysRoleMenu [id=" + id + ", roleid=" + roleid + ", menuid="
				+ menuid + "]";
	}

	public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
}