package com.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.frame.service.ConfigService;
import com.pojo.UpTable.Data;

public class BaseAction {
	protected static final Logger logger = LoggerFactory.getLogger(BaseAction.class);
	@Autowired
	protected ConfigService configService;
	
	
	
	protected void executeToTable(List<Data> datas,String tableName){
		StringBuilder builder = new StringBuilder("CREATE TABLE `");
		builder.append(tableName);
		builder.append("`(");
		List<String> primarys = new ArrayList<String>();
		List<String> keys = new ArrayList<String>();
		List<String> muls = new ArrayList<String>();
		
		String[] cols = new String[datas.size()];
		for(int i = 0; i < datas.size(); i ++){
			StringBuilder str = new StringBuilder();
			for(Data data : datas){
				int xh = data.getXh();
				String filed = data.getFiled();
				if(i + 1 == xh){
					String index = data.getIsIndex();
					
					switch (index) {
					case "":
						
						break;
					case "PRI":
						primarys.add(filed);
						break;
					case "UNI":
						keys.add(filed);
						break;
					case "MUL":
						muls.add(filed);
						break;
					default:
						break;
					}
					
					
					String commont = data.getCommont();
					data.getChartset();
					String dataType = data.getDatatype();//字段类型
					String defaultValue = data.getDefaultValue();
					data.getState();
					data.getType();
					String isnull = data.getIsnull();
					str.append("`");
					str.append(filed);
					str.append("` ");
					str.append(dataType);
					if ("NO".equals(isnull)) {
						str.append(" NOT NULL");
					}else{
						if("".equals(StringUtils.trimToEmpty(defaultValue))){
							str.append(" DEFAULT NULL");
						}else{
							str.append(" DEFAULT ");
							str.append(defaultValue);
						}
					}
					cols[i] = str.toString();
					continue;
				}
			}
		}
		StringBuilder p = new StringBuilder(" PRIMARY KEY (");
		for(String s : primarys){
			p.append("`");
			p.append(s);
			p.append("`");
		}
		p.append(")");
		StringBuilder k = new StringBuilder();
		for(String s : keys){
			k.append(" KEY `");
			k.append(tableName);
			k.append("_");
			k.append("index_");
			k.append(s);
			k.append("`");
			k.append(" (`");	
			k.append(s);
			k.append("`)");
		}
		StringBuilder m = new StringBuilder();
		for(String s : muls){
			m.append(" KEY `");
			m.append(tableName);
			m.append("_");
			m.append("index_");
			m.append(s);
			m.append("`");
			m.append(" (`");	
			m.append(s);
			m.append("`)");
		}
		
		String body = StringUtils.join(cols, ",");
		builder.append(body);
		
		if (primarys.size()>0) {
			builder.append(",");
			String s = p.toString();
			builder.append(s);
		}
		if (keys.size()>0) {
			builder.append(",");
			String s = k.toString();
			builder.append(s);
		}
		if (muls.size()>0) {
			builder.append(",");
			String s = m.toString();
			builder.append(s);
		}
		builder.append(")ENGINE=MyISAM DEFAULT CHARSET=utf8");
		logger.info(builder.toString());
	}
}
