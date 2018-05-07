package com.hibernate.pojo;

/**
 * NdbBinlogIndex entity. @author MyEclipse Persistence Tools
 */

public class NdbBinlogIndex implements java.io.Serializable {

	// Fields

	private Long epoch;
	private Long position;
	private String file;
	private Long inserts;
	private Long updates;
	private Long deletes;
	private Long schemaops;

	// Constructors

	/** default constructor */
	public NdbBinlogIndex() {
	}

	/** full constructor */
	public NdbBinlogIndex(Long epoch, Long position, String file, Long inserts,
			Long updates, Long deletes, Long schemaops) {
		this.epoch = epoch;
		this.position = position;
		this.file = file;
		this.inserts = inserts;
		this.updates = updates;
		this.deletes = deletes;
		this.schemaops = schemaops;
	}

	// Property accessors

	public Long getEpoch() {
		return this.epoch;
	}

	public void setEpoch(Long epoch) {
		this.epoch = epoch;
	}

	public Long getPosition() {
		return this.position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Long getInserts() {
		return this.inserts;
	}

	public void setInserts(Long inserts) {
		this.inserts = inserts;
	}

	public Long getUpdates() {
		return this.updates;
	}

	public void setUpdates(Long updates) {
		this.updates = updates;
	}

	public Long getDeletes() {
		return this.deletes;
	}

	public void setDeletes(Long deletes) {
		this.deletes = deletes;
	}

	public Long getSchemaops() {
		return this.schemaops;
	}

	public void setSchemaops(Long schemaops) {
		this.schemaops = schemaops;
	}

}