package com.hibernate.pojo;

/**
 * Db entity. @author MyEclipse Persistence Tools
 */

public class Db implements java.io.Serializable {

	// Fields

	private DbId id;
	private String selectPriv;
	private String insertPriv;
	private String updatePriv;
	private String deletePriv;
	private String createPriv;
	private String dropPriv;
	private String grantPriv;
	private String referencesPriv;
	private String indexPriv;
	private String alterPriv;
	private String createTmpTablePriv;
	private String lockTablesPriv;
	private String createViewPriv;
	private String showViewPriv;
	private String createRoutinePriv;
	private String alterRoutinePriv;
	private String executePriv;
	private String eventPriv;
	private String triggerPriv;

	// Constructors

	/** default constructor */
	public Db() {
	}

	/** full constructor */
	public Db(DbId id, String selectPriv, String insertPriv, String updatePriv,
			String deletePriv, String createPriv, String dropPriv,
			String grantPriv, String referencesPriv, String indexPriv,
			String alterPriv, String createTmpTablePriv, String lockTablesPriv,
			String createViewPriv, String showViewPriv,
			String createRoutinePriv, String alterRoutinePriv,
			String executePriv, String eventPriv, String triggerPriv) {
		this.id = id;
		this.selectPriv = selectPriv;
		this.insertPriv = insertPriv;
		this.updatePriv = updatePriv;
		this.deletePriv = deletePriv;
		this.createPriv = createPriv;
		this.dropPriv = dropPriv;
		this.grantPriv = grantPriv;
		this.referencesPriv = referencesPriv;
		this.indexPriv = indexPriv;
		this.alterPriv = alterPriv;
		this.createTmpTablePriv = createTmpTablePriv;
		this.lockTablesPriv = lockTablesPriv;
		this.createViewPriv = createViewPriv;
		this.showViewPriv = showViewPriv;
		this.createRoutinePriv = createRoutinePriv;
		this.alterRoutinePriv = alterRoutinePriv;
		this.executePriv = executePriv;
		this.eventPriv = eventPriv;
		this.triggerPriv = triggerPriv;
	}

	// Property accessors

	public DbId getId() {
		return this.id;
	}

	public void setId(DbId id) {
		this.id = id;
	}

	public String getSelectPriv() {
		return this.selectPriv;
	}

	public void setSelectPriv(String selectPriv) {
		this.selectPriv = selectPriv;
	}

	public String getInsertPriv() {
		return this.insertPriv;
	}

	public void setInsertPriv(String insertPriv) {
		this.insertPriv = insertPriv;
	}

	public String getUpdatePriv() {
		return this.updatePriv;
	}

	public void setUpdatePriv(String updatePriv) {
		this.updatePriv = updatePriv;
	}

	public String getDeletePriv() {
		return this.deletePriv;
	}

	public void setDeletePriv(String deletePriv) {
		this.deletePriv = deletePriv;
	}

	public String getCreatePriv() {
		return this.createPriv;
	}

	public void setCreatePriv(String createPriv) {
		this.createPriv = createPriv;
	}

	public String getDropPriv() {
		return this.dropPriv;
	}

	public void setDropPriv(String dropPriv) {
		this.dropPriv = dropPriv;
	}

	public String getGrantPriv() {
		return this.grantPriv;
	}

	public void setGrantPriv(String grantPriv) {
		this.grantPriv = grantPriv;
	}

	public String getReferencesPriv() {
		return this.referencesPriv;
	}

	public void setReferencesPriv(String referencesPriv) {
		this.referencesPriv = referencesPriv;
	}

	public String getIndexPriv() {
		return this.indexPriv;
	}

	public void setIndexPriv(String indexPriv) {
		this.indexPriv = indexPriv;
	}

	public String getAlterPriv() {
		return this.alterPriv;
	}

	public void setAlterPriv(String alterPriv) {
		this.alterPriv = alterPriv;
	}

	public String getCreateTmpTablePriv() {
		return this.createTmpTablePriv;
	}

	public void setCreateTmpTablePriv(String createTmpTablePriv) {
		this.createTmpTablePriv = createTmpTablePriv;
	}

	public String getLockTablesPriv() {
		return this.lockTablesPriv;
	}

	public void setLockTablesPriv(String lockTablesPriv) {
		this.lockTablesPriv = lockTablesPriv;
	}

	public String getCreateViewPriv() {
		return this.createViewPriv;
	}

	public void setCreateViewPriv(String createViewPriv) {
		this.createViewPriv = createViewPriv;
	}

	public String getShowViewPriv() {
		return this.showViewPriv;
	}

	public void setShowViewPriv(String showViewPriv) {
		this.showViewPriv = showViewPriv;
	}

	public String getCreateRoutinePriv() {
		return this.createRoutinePriv;
	}

	public void setCreateRoutinePriv(String createRoutinePriv) {
		this.createRoutinePriv = createRoutinePriv;
	}

	public String getAlterRoutinePriv() {
		return this.alterRoutinePriv;
	}

	public void setAlterRoutinePriv(String alterRoutinePriv) {
		this.alterRoutinePriv = alterRoutinePriv;
	}

	public String getExecutePriv() {
		return this.executePriv;
	}

	public void setExecutePriv(String executePriv) {
		this.executePriv = executePriv;
	}

	public String getEventPriv() {
		return this.eventPriv;
	}

	public void setEventPriv(String eventPriv) {
		this.eventPriv = eventPriv;
	}

	public String getTriggerPriv() {
		return this.triggerPriv;
	}

	public void setTriggerPriv(String triggerPriv) {
		this.triggerPriv = triggerPriv;
	}

}