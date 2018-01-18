package db.handler.manager;

import java.util.Map;

public abstract class DBPartitionHelper {
	/**
	 * 根据内容进行解析 创建表的分区信息
	 * @param tableLogicName
	 * @param map
	 * @return
	 */
	public abstract PartitionTableInfo parse(String tableLogicName,Map<String, Object> map);
}
