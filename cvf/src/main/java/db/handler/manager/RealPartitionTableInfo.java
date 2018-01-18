package db.handler.manager;

import java.util.Map;

public class RealPartitionTableInfo extends DBPartitionHelper{
	/**
	 * 当dao层调用可以获取真实的表名称
	 */
	@Override
	public PartitionTableInfo parse(String tableLogicName,
			Map<String, Object> map) {
		String userId = (String)map.get("userId");
		String lastChar = "";//对关键字进行分析 最终获取真实操作的数据源key表名
		PartitionTableInfo partitionTableInfo = new PartitionTableInfo();
		partitionTableInfo.setAliasName(tableLogicName);
		partitionTableInfo.setTableName(lastChar);//获取真实表名
		//设置通过分析后的数据源key
		partitionTableInfo.setDsKey(lastChar);
		return partitionTableInfo;
	}

}
