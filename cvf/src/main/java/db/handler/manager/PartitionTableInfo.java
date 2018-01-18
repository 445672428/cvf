package db.handler.manager;

public class PartitionTableInfo {
	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 表别名
	 */
	private String aliasName;
	
	/**
	 * 数据源key
	 */
	private String dsKey;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getDsKey() {
		return dsKey;
	}

	public void setDsKey(String dsKey) {
		this.dsKey = dsKey;
	}

	public PartitionTableInfo(String tableName, String aliasName, String dsKey) {
		super();
		this.tableName = tableName;
		this.aliasName = aliasName;
		this.dsKey = dsKey;
	}
	public PartitionTableInfo(){}

	@Override
	public String toString() {
		return "PartitionTableInfo [tableName=" + tableName + ", aliasName="
				+ aliasName + ", dsKey=" + dsKey + "]";
	}
	
	
}
