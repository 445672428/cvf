package com.hibernate.pojo;

import java.sql.Timestamp;

/**
 * Proc entity. @author MyEclipse Persistence Tools
 */

public class Proc implements java.io.Serializable {

	// Fields

	private ProcId id;
	private String specificName;
	private String language;
	private String sqlDataAccess;
	private String isDeterministic;
	private String securityType;
	private String paramList;
	private String returns;
	private String body;
	private String definer;
	private Timestamp created;
	private Timestamp modified;
	private String sqlMode;
	private String comment;
	private String characterSetClient;
	private String collationConnection;
	private String dbCollation;
	private String bodyUtf8;

	// Constructors

	/** default constructor */
	public Proc() {
	}

	/** minimal constructor */
	public Proc(ProcId id, String specificName, String language,
			String sqlDataAccess, String isDeterministic, String securityType,
			String paramList, String returns, String body, String definer,
			Timestamp created, Timestamp modified, String sqlMode,
			String comment) {
		this.id = id;
		this.specificName = specificName;
		this.language = language;
		this.sqlDataAccess = sqlDataAccess;
		this.isDeterministic = isDeterministic;
		this.securityType = securityType;
		this.paramList = paramList;
		this.returns = returns;
		this.body = body;
		this.definer = definer;
		this.created = created;
		this.modified = modified;
		this.sqlMode = sqlMode;
		this.comment = comment;
	}

	/** full constructor */
	public Proc(ProcId id, String specificName, String language,
			String sqlDataAccess, String isDeterministic, String securityType,
			String paramList, String returns, String body, String definer,
			Timestamp created, Timestamp modified, String sqlMode,
			String comment, String characterSetClient,
			String collationConnection, String dbCollation, String bodyUtf8) {
		this.id = id;
		this.specificName = specificName;
		this.language = language;
		this.sqlDataAccess = sqlDataAccess;
		this.isDeterministic = isDeterministic;
		this.securityType = securityType;
		this.paramList = paramList;
		this.returns = returns;
		this.body = body;
		this.definer = definer;
		this.created = created;
		this.modified = modified;
		this.sqlMode = sqlMode;
		this.comment = comment;
		this.characterSetClient = characterSetClient;
		this.collationConnection = collationConnection;
		this.dbCollation = dbCollation;
		this.bodyUtf8 = bodyUtf8;
	}

	// Property accessors

	public ProcId getId() {
		return this.id;
	}

	public void setId(ProcId id) {
		this.id = id;
	}

	public String getSpecificName() {
		return this.specificName;
	}

	public void setSpecificName(String specificName) {
		this.specificName = specificName;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSqlDataAccess() {
		return this.sqlDataAccess;
	}

	public void setSqlDataAccess(String sqlDataAccess) {
		this.sqlDataAccess = sqlDataAccess;
	}

	public String getIsDeterministic() {
		return this.isDeterministic;
	}

	public void setIsDeterministic(String isDeterministic) {
		this.isDeterministic = isDeterministic;
	}

	public String getSecurityType() {
		return this.securityType;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	public String getParamList() {
		return this.paramList;
	}

	public void setParamList(String paramList) {
		this.paramList = paramList;
	}

	public String getReturns() {
		return this.returns;
	}

	public void setReturns(String returns) {
		this.returns = returns;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDefiner() {
		return this.definer;
	}

	public void setDefiner(String definer) {
		this.definer = definer;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getSqlMode() {
		return this.sqlMode;
	}

	public void setSqlMode(String sqlMode) {
		this.sqlMode = sqlMode;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCharacterSetClient() {
		return this.characterSetClient;
	}

	public void setCharacterSetClient(String characterSetClient) {
		this.characterSetClient = characterSetClient;
	}

	public String getCollationConnection() {
		return this.collationConnection;
	}

	public void setCollationConnection(String collationConnection) {
		this.collationConnection = collationConnection;
	}

	public String getDbCollation() {
		return this.dbCollation;
	}

	public void setDbCollation(String dbCollation) {
		this.dbCollation = dbCollation;
	}

	public String getBodyUtf8() {
		return this.bodyUtf8;
	}

	public void setBodyUtf8(String bodyUtf8) {
		this.bodyUtf8 = bodyUtf8;
	}

}