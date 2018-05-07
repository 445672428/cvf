package com.hibernate.pojo;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private UserId id;
	private String password;
	private String selectPriv;
	private String insertPriv;
	private String updatePriv;
	private String deletePriv;
	private String createPriv;
	private String dropPriv;
	private String reloadPriv;
	private String shutdownPriv;
	private String processPriv;
	private String filePriv;
	private String grantPriv;
	private String referencesPriv;
	private String indexPriv;
	private String alterPriv;
	private String showDbPriv;
	private String superPriv;
	private String createTmpTablePriv;
	private String lockTablesPriv;
	private String executePriv;
	private String replSlavePriv;
	private String replClientPriv;
	private String createViewPriv;
	private String showViewPriv;
	private String createRoutinePriv;
	private String alterRoutinePriv;
	private String createUserPriv;
	private String eventPriv;
	private String triggerPriv;
	private String createTablespacePriv;
	private String sslType;
	private String sslCipher;
	private String x509Issuer;
	private String x509Subject;
	private Integer maxQuestions;
	private Integer maxUpdates;
	private Integer maxConnections;
	private Integer maxUserConnections;
	private String plugin;
	private String authenticationString;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(UserId id, String password, String selectPriv,
			String insertPriv, String updatePriv, String deletePriv,
			String createPriv, String dropPriv, String reloadPriv,
			String shutdownPriv, String processPriv, String filePriv,
			String grantPriv, String referencesPriv, String indexPriv,
			String alterPriv, String showDbPriv, String superPriv,
			String createTmpTablePriv, String lockTablesPriv,
			String executePriv, String replSlavePriv, String replClientPriv,
			String createViewPriv, String showViewPriv,
			String createRoutinePriv, String alterRoutinePriv,
			String createUserPriv, String eventPriv, String triggerPriv,
			String createTablespacePriv, String sslType, String sslCipher,
			String x509Issuer, String x509Subject, Integer maxQuestions,
			Integer maxUpdates, Integer maxConnections,
			Integer maxUserConnections) {
		this.id = id;
		this.password = password;
		this.selectPriv = selectPriv;
		this.insertPriv = insertPriv;
		this.updatePriv = updatePriv;
		this.deletePriv = deletePriv;
		this.createPriv = createPriv;
		this.dropPriv = dropPriv;
		this.reloadPriv = reloadPriv;
		this.shutdownPriv = shutdownPriv;
		this.processPriv = processPriv;
		this.filePriv = filePriv;
		this.grantPriv = grantPriv;
		this.referencesPriv = referencesPriv;
		this.indexPriv = indexPriv;
		this.alterPriv = alterPriv;
		this.showDbPriv = showDbPriv;
		this.superPriv = superPriv;
		this.createTmpTablePriv = createTmpTablePriv;
		this.lockTablesPriv = lockTablesPriv;
		this.executePriv = executePriv;
		this.replSlavePriv = replSlavePriv;
		this.replClientPriv = replClientPriv;
		this.createViewPriv = createViewPriv;
		this.showViewPriv = showViewPriv;
		this.createRoutinePriv = createRoutinePriv;
		this.alterRoutinePriv = alterRoutinePriv;
		this.createUserPriv = createUserPriv;
		this.eventPriv = eventPriv;
		this.triggerPriv = triggerPriv;
		this.createTablespacePriv = createTablespacePriv;
		this.sslType = sslType;
		this.sslCipher = sslCipher;
		this.x509Issuer = x509Issuer;
		this.x509Subject = x509Subject;
		this.maxQuestions = maxQuestions;
		this.maxUpdates = maxUpdates;
		this.maxConnections = maxConnections;
		this.maxUserConnections = maxUserConnections;
	}

	/** full constructor */
	public User(UserId id, String password, String selectPriv,
			String insertPriv, String updatePriv, String deletePriv,
			String createPriv, String dropPriv, String reloadPriv,
			String shutdownPriv, String processPriv, String filePriv,
			String grantPriv, String referencesPriv, String indexPriv,
			String alterPriv, String showDbPriv, String superPriv,
			String createTmpTablePriv, String lockTablesPriv,
			String executePriv, String replSlavePriv, String replClientPriv,
			String createViewPriv, String showViewPriv,
			String createRoutinePriv, String alterRoutinePriv,
			String createUserPriv, String eventPriv, String triggerPriv,
			String createTablespacePriv, String sslType, String sslCipher,
			String x509Issuer, String x509Subject, Integer maxQuestions,
			Integer maxUpdates, Integer maxConnections,
			Integer maxUserConnections, String plugin,
			String authenticationString) {
		this.id = id;
		this.password = password;
		this.selectPriv = selectPriv;
		this.insertPriv = insertPriv;
		this.updatePriv = updatePriv;
		this.deletePriv = deletePriv;
		this.createPriv = createPriv;
		this.dropPriv = dropPriv;
		this.reloadPriv = reloadPriv;
		this.shutdownPriv = shutdownPriv;
		this.processPriv = processPriv;
		this.filePriv = filePriv;
		this.grantPriv = grantPriv;
		this.referencesPriv = referencesPriv;
		this.indexPriv = indexPriv;
		this.alterPriv = alterPriv;
		this.showDbPriv = showDbPriv;
		this.superPriv = superPriv;
		this.createTmpTablePriv = createTmpTablePriv;
		this.lockTablesPriv = lockTablesPriv;
		this.executePriv = executePriv;
		this.replSlavePriv = replSlavePriv;
		this.replClientPriv = replClientPriv;
		this.createViewPriv = createViewPriv;
		this.showViewPriv = showViewPriv;
		this.createRoutinePriv = createRoutinePriv;
		this.alterRoutinePriv = alterRoutinePriv;
		this.createUserPriv = createUserPriv;
		this.eventPriv = eventPriv;
		this.triggerPriv = triggerPriv;
		this.createTablespacePriv = createTablespacePriv;
		this.sslType = sslType;
		this.sslCipher = sslCipher;
		this.x509Issuer = x509Issuer;
		this.x509Subject = x509Subject;
		this.maxQuestions = maxQuestions;
		this.maxUpdates = maxUpdates;
		this.maxConnections = maxConnections;
		this.maxUserConnections = maxUserConnections;
		this.plugin = plugin;
		this.authenticationString = authenticationString;
	}

	// Property accessors

	public UserId getId() {
		return this.id;
	}

	public void setId(UserId id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getReloadPriv() {
		return this.reloadPriv;
	}

	public void setReloadPriv(String reloadPriv) {
		this.reloadPriv = reloadPriv;
	}

	public String getShutdownPriv() {
		return this.shutdownPriv;
	}

	public void setShutdownPriv(String shutdownPriv) {
		this.shutdownPriv = shutdownPriv;
	}

	public String getProcessPriv() {
		return this.processPriv;
	}

	public void setProcessPriv(String processPriv) {
		this.processPriv = processPriv;
	}

	public String getFilePriv() {
		return this.filePriv;
	}

	public void setFilePriv(String filePriv) {
		this.filePriv = filePriv;
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

	public String getShowDbPriv() {
		return this.showDbPriv;
	}

	public void setShowDbPriv(String showDbPriv) {
		this.showDbPriv = showDbPriv;
	}

	public String getSuperPriv() {
		return this.superPriv;
	}

	public void setSuperPriv(String superPriv) {
		this.superPriv = superPriv;
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

	public String getExecutePriv() {
		return this.executePriv;
	}

	public void setExecutePriv(String executePriv) {
		this.executePriv = executePriv;
	}

	public String getReplSlavePriv() {
		return this.replSlavePriv;
	}

	public void setReplSlavePriv(String replSlavePriv) {
		this.replSlavePriv = replSlavePriv;
	}

	public String getReplClientPriv() {
		return this.replClientPriv;
	}

	public void setReplClientPriv(String replClientPriv) {
		this.replClientPriv = replClientPriv;
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

	public String getCreateUserPriv() {
		return this.createUserPriv;
	}

	public void setCreateUserPriv(String createUserPriv) {
		this.createUserPriv = createUserPriv;
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

	public String getCreateTablespacePriv() {
		return this.createTablespacePriv;
	}

	public void setCreateTablespacePriv(String createTablespacePriv) {
		this.createTablespacePriv = createTablespacePriv;
	}

	public String getSslType() {
		return this.sslType;
	}

	public void setSslType(String sslType) {
		this.sslType = sslType;
	}

	public String getSslCipher() {
		return this.sslCipher;
	}

	public void setSslCipher(String sslCipher) {
		this.sslCipher = sslCipher;
	}

	public String getX509Issuer() {
		return this.x509Issuer;
	}

	public void setX509Issuer(String x509Issuer) {
		this.x509Issuer = x509Issuer;
	}

	public String getX509Subject() {
		return this.x509Subject;
	}

	public void setX509Subject(String x509Subject) {
		this.x509Subject = x509Subject;
	}

	public Integer getMaxQuestions() {
		return this.maxQuestions;
	}

	public void setMaxQuestions(Integer maxQuestions) {
		this.maxQuestions = maxQuestions;
	}

	public Integer getMaxUpdates() {
		return this.maxUpdates;
	}

	public void setMaxUpdates(Integer maxUpdates) {
		this.maxUpdates = maxUpdates;
	}

	public Integer getMaxConnections() {
		return this.maxConnections;
	}

	public void setMaxConnections(Integer maxConnections) {
		this.maxConnections = maxConnections;
	}

	public Integer getMaxUserConnections() {
		return this.maxUserConnections;
	}

	public void setMaxUserConnections(Integer maxUserConnections) {
		this.maxUserConnections = maxUserConnections;
	}

	public String getPlugin() {
		return this.plugin;
	}

	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}

	public String getAuthenticationString() {
		return this.authenticationString;
	}

	public void setAuthenticationString(String authenticationString) {
		this.authenticationString = authenticationString;
	}

}