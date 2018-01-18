package others.demo.saybase;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.apache.solr.common.util.Hash;
import org.bytedeco.javacpp.RealSense.intrinsics;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.style.RtfParagraphStyle;
import com.utils.StringUtils;

public class SybaseTables {
	public static void main(String[] args) throws Exception {
		//createWord();
		create();
	}
	
	public static void create() throws Exception {
		System.out.println(SybaseTables.class.getResource("/").getPath());
		URL url = SybaseTables.class.getClassLoader().getResource("config/spring.xml");
		String path = url.getPath();
		System.out.println(url.getPath());
		File file = new File(url.getFile());
		//PropertyConfigurator.configure("classpath:config/jdbc-sybase.properties");
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("sybaseJdbcTemplate");
		String tableSql = " SELECT name from sysobjects";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(tableSql);
		
		/**
		 * 查询sybase 库所有主键
		 */
		Map<String, Map<String, String>> allPkMap = new HashMap<String, Map<String,String>>();
		String keySql = " select   indid, keycnt, name,object_name(id) as tabname from sysindexes where  indid >=1 and status&2048=2048 ";//-- indid大于1 表示主键或索引 
		List<Map<String, Object>> keyList = jdbcTemplate.queryForList(keySql);
		for(Map<String, Object> map : keyList){
			int indid = map.get("indid") == null?0:(Integer)map.get("indid");
		 	int keycnt = map.get("keycnt") == null ? 0: (Integer)map.get("keycnt");
			String keyName = StringUtils.trim(map.get("name"));//主键名称
			String tableName = StringUtils.trim(map.get("tabname"));//表名称
			for(int index = 1; index <=keycnt;index++){
				String pkSql = "SELECT index_col('"+tableName+"',2,"+index+") as pkname from sysindexes WHERE indid=2 AND  id=object_id('"+tableName+"')";
				//System.out.println(pkSql);
				List<Map<String, Object>> pkList = jdbcTemplate.queryForList(pkSql);
				if (pkList!=null&&pkList.size()>0) {
					Map<String, Object> kyM = pkList.get(0);
					String pkName = StringUtils.trim(kyM.get("pkname"));
					if (allPkMap.get(tableName)==null) {
						Map<String, String> mm = new HashMap<String, String>();
						mm.put(pkName, "Y");
						allPkMap.put(tableName, mm);
					}else{
						Map<String, String> mm = allPkMap.get(tableName);
						mm.put(pkName, "Y");
						allPkMap.put(tableName, mm);
					}
				}
			}
		}
		
		
		
		List<String> taleNames = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			String name = StringUtils.trim(map.get("name"));
			char first = name.charAt(0);
			if (Character.isLowerCase(first)) {
				continue;
			} else {
				taleNames.add(name);
			}
		}
		int index = 0;
		
		Document document = new Document(PageSize.A4);
		FileOutputStream outputStream = new FileOutputStream("D:/word.doc");
		RtfWriter2.getInstance(document, outputStream);
		document.open();
		for (String table : taleNames) {
			String tableInfo = "SELECT sysobjects.name AS tablename ,syscolumns.name as colname,syscolumns.length as colLength,systypes.name as colType,systypes.variable,systypes.allownulls "
					+ " from syscolumns left join sysobjects on syscolumns.id = sysobjects.id and ( sysobjects.type = 'U' OR  sysobjects.type = 'V' ) "
					+ " and sysobjects.name='"
					+ table
					+ "' left join systypes on syscolumns.usertype = systypes.usertype where sysobjects.name='"
					+ table
					+ "' "
					+ " order  by sysobjects.name,syscolumns.name";
			List<Map<String, Object>> infoList = jdbcTemplate.queryForList(tableInfo);
			
			
			Table wordTable = new Table(5);
			
			//第二级标题样式
	        RtfParagraphStyle rtfGsBt2 = RtfParagraphStyle.STYLE_HEADING_3;
	        rtfGsBt2.setAlignment(Element.ALIGN_LEFT);
	        rtfGsBt2.setStyle(Font.BOLD);
	        rtfGsBt2.setSize(13);
			Paragraph title11 = new Paragraph("1.1."+table+"表");
	        title11.setFont(rtfGsBt2);
	        document.add(title11);
	        
			wordTable.setBorderWidth(1);
			wordTable.setBorderColor(Color.BLACK);
			wordTable.setPadding(0);
			wordTable.setSpacing(0);
			Cell cell1 = new Cell();
			Cell cell2 = new Cell();
			Cell cell3 = new Cell();
			Cell cell4 = new Cell();
			Cell cell5 = new Cell();
			cell1.setBackgroundColor(new Color(174,170,170, 1));
			cell2.setBackgroundColor(new Color(174,170,170, 1));
			cell3.setBackgroundColor(new Color(174,170,170, 1));
			cell4.setBackgroundColor(new Color(174,170,170, 1));
			cell5.setBackgroundColor(new Color(174,170,170, 1));
			cell1.add(new Paragraph("字段"));
			cell2.add(new Paragraph("名称"));
			cell3.add(new Paragraph("类型"));
			cell4.add(new Paragraph("主键"));
			cell5.add(new Paragraph("备注"));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中   
		    cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中   
		    cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中   
		    cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中   
		    cell4.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中   
		    cell5.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
			wordTable.addCell(cell1);
			wordTable.addCell(cell2);
			wordTable.addCell(cell3);
			wordTable.addCell(cell4);
			wordTable.addCell(cell5);
			if (infoList == null || infoList.size() == 0) {
				//System.out.println(table);
			} else {
				//获取 当前 结果长度
				int len = infoList.size();
				for(Map<String, Object> tmpMap : infoList){
					Map<String, String> tMap = aliaName();
					String tName = StringUtils.trim(tmpMap.get("tablename"));
					String cName = StringUtils.trim(tmpMap.get("colname"));
					String cLen = StringUtils.trim(tmpMap.get("colLength"));
					String cType = StringUtils.trim(tmpMap.get("colType"));
					String mc = "";
					int mapSize = 0;
					for(String key : tMap.keySet()){
						if (cName.indexOf(key)>-1) {
							if (cName.toLowerCase().indexOf("name")>-1) {
								mc = tMap.get(key)+"名称";
								break;
							}else if(cName.toLowerCase().indexOf("code")>-1){
								mc = tMap.get(key)+"代码";
								break;
							}else{
								mc = tMap.get(key);
								break;
							}
						}else{
							if (mapSize == tmpMap.size()) {
								mc = cName;
							}
						}
						mapSize ++;
					}
					Cell c1 = new Cell();
					Cell c2 = new Cell();
					Cell c3 = new Cell();
					Cell c4 = new Cell();
					Cell c5 = new Cell();
					c1.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中   
				    c1.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
					c2.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中   
				    c2.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
					c3.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中   
				    c3.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
					c4.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中   
				    c4.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
					c5.setHorizontalAlignment(Element.ALIGN_CENTER); //水平居中   
				    c5.setVerticalAlignment(Element.ALIGN_MIDDLE); //垂直居中
				    c1.add(new Paragraph(cName));
				    c2.add(new Paragraph(mc));
				    c3.add(new Paragraph(cType + "("+cLen+")"));
				    wordTable.addCell(c1);
					wordTable.addCell(c2);
					wordTable.addCell(c3);
					Map<String, String> mm = allPkMap.get(table);
					if (mm!=null) {
						c4.add(new Paragraph(StringUtils.trim(mm.get(cName))));
						wordTable.addCell(c4);
					}else{
						c4.add(new Paragraph("主键"+tName));
						wordTable.addCell(c4);
					}
					c5.add(new Paragraph(""));
					wordTable.addCell(c5);
				}
				
				index++;
			}
			document.add(wordTable);
		}
		document.close();
	}

	public static void createWord() {
		try {
			Document document = new Document(PageSize.A4);
			FileOutputStream outputStream = new FileOutputStream("D:/word.doc");
			RtfWriter2.getInstance(document, outputStream);
			document.open();

			Paragraph ph = new Paragraph();
			Font f = new Font();
			Paragraph p = new Paragraph("出口合同", new Font(Font.NORMAL, 18,
					Font.BOLDITALIC, new Color(0, 0, 0)));
			p.setAlignment(1);
			document.add(p);
			ph.setFont(f);

			Table table = new Table(4);
			document.add(new Paragraph("生成表格"));
			table.setBorderWidth(1);
			table.setBorderColor(Color.BLACK);
			table.setPadding(0);
			table.setSpacing(0);


			table.addCell("1,1");
			table.addCell("1,2");
			table.addCell("1,3");
			table.addCell("1,4");
			
			table.addCell(new Paragraph("用java生成的表格1"));
			table.addCell(new Paragraph("用java生成的表格2"));
			table.addCell(new Paragraph("用java生成的表格3"));
			table.addCell(new Paragraph("用java生成的表格4"));
	
		
			table.addCell("2,1");
			table.addCell("2,2");
			table.addCell("2,3");
			table.addCell("2,4");
			
			table.addCell("3,1");
			table.addCell("3,2");
			table.addCell("3,3");
			table.addCell("3,4");
			document.add(table);
			
			Table table2 = new Table(4);
			table2.addCell("2,1");
			table2.addCell("2,2");
			table2.addCell("2,3");
			table2.addCell("2,4");
			
			table2.addCell("3,1");
			table2.addCell("3,2");
			table2.addCell("3,3");
			table2.addCell("3,4");
			document.add(table2);
			document.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	private static Map<String, String> aliaName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("﻿YHDM","用户代码");
		map.put("DWDM","单位代码");
		map.put("YHXM","用户姓名");
		map.put("FLZW","法律职务");
		map.put("BS","标识");
		map.put("YHBM","用户编码");
		map.put("BMDM","部门代码");
		map.put("FBMDM","父部门代码");
		map.put("DWDM","单位代码");
		map.put("BMMC","部门名称");
		map.put("BMJC","部门简称");
		map.put("DEPATID","部门标识");
		map.put("AHDM","案号代码");
		map.put("AJLXDM","案件类型代码");
		map.put("XTAJLX","系统案件类型");
		map.put("AJZT","案件状态");
		map.put("FYDM","法院代码");
		map.put("AH","案号");
		map.put("AYMS","案由描述");
		map.put("DSR","当事人");
		map.put("LARQ","立案日期");
		map.put("JARQ","结案日期");
		map.put("SATJ","收案统计");
		map.put("JATJ","结案统计");
		map.put("BDJE","标的金额");
		map.put("SAAY","收案案由");
		map.put("CBBM1","承办部门");
		map.put("SXJMRQ","审限届满日期");
		map.put("CBR","承办人");
		map.put("SPCX","审判程序");
		map.put("FLZW","法律职务");
		map.put("AHDM","案号代码");
		map.put("SJDWJE","实际到位金额");
		map.put("JABDJE","结案标的金额");
		map.put("JAFSN","新结案方式");
		map.put("JASY1","结案事由1");
		map.put("AHDM","案号代码");
		map.put("YZXAH","原执行案号");
		map.put("AJLYN","案件来源");
		map.put("ZXYJ","执行依据");
		map.put("XZXYJ","新执行依据");
		map.put("SQCYLXJLX","申请延迟履行金利息");
		map.put("SQCYLXJ","申请延迟履行金");
		map.put("AHDM","案号代码");
		map.put("FDSXTS","法定审限天数");
		map.put("SJTS","实际天数");
		map.put("BGLB","变更类别");
		map.put("QTSY","其它事由");
		map.put("AHDM","案号代码");
		map.put("XH","法定审限天数");
		map.put("BGLB","变更类别");
		map.put("QTSY","其他事由");
		map.put("YY","原因");
		map.put("BMDM","部门代码");
		map.put("FBMDM","父部门代码");
		map.put("DWDM","单位代码");
		map.put("BMID","部门ID");
		map.put("BMMC","部门名称");
		map.put("BMJC","部门简称");
		map.put("DEPTID","临时ID");
		map.put("AJLB","案件类别");
		map.put("AJLBDL","案件类别大类");
		map.put("PXH","排序号");
		map.put("AJBM","案件编码");
		map.put("XTAJLX","系统案件类型");
		map.put("CODE_LXDL","类型大类代码");
		map.put("NAME_LXDL","类型大类名称");
		map.put("AJLXBS","案件类型标识");
		map.put("AJLX","案件类型");
		map.put("AJLY","案件来源");
		map.put("ID_AY","案由");
		map.put("CODE_AY1","案由一级代码");
		map.put("NAME_AY1","案由名称");
		map.put("CODE_AY2","案由二级代码");
		map.put("NAME_AY2","案由名称");
		map.put("CODE_AY3","案由三级代码");
		map.put("NAME_AY3","案由名称");
		map.put("CODE_AY4","案由四级代码");
		map.put("NAME_AY4","案由名称");
		map.put("CODE_AY5","案由五级代码");
		map.put("NAME_AY5","案由名称");
		map.put("CODE_AY6","案由六级代码");
		map.put("NAME_AY6","案由名称");
		map.put("YSDM","原始代码");
		map.put("CC","层次");
		map.put("TJBH","统计编码");
		map.put("SFJY","是否禁用");
		map.put("AY","案由");
		map.put("NAME_AY","案由名称");
		map.put("AYLX","案由类型");
		map.put("NAME_AYLX","案由类型名称");
		map.put("BGYY","变更原因");
		map.put("YSDM","原始代码");
		map.put("BGLB","变更类别");
		map.put("CBBM","承办部门");
		map.put("CODE_CBBM","承办部门代码");
		map.put("NAME_CBBM","承办部门名称");
		map.put("CODE_FYDM","法院代码");
		map.put("NAME_FYDM","F法院代码名称");
		map.put("CODE_CITY","城市代码");
		map.put("NAME_CITY","城市代码");
		map.put("CODE_PRO","省代码");
		map.put("NAME_PRO","省名称");
		map.put("N_PXH","排序号");
		map.put("YSDM","原始代码");
		map.put("BMBS","部门标识");
		map.put("CBR","承办人");
		map.put("CBBM","承办部门");
		map.put("FYDM","法院");
		map.put("CITY","城市代码");
		map.put("PRO","省");
		map.put("PRO","省");
		map.put("YSDM","元素代码");
		map.put("RYBS","人员标识");
		map.put("BGKYY","裁判文书不上网原因");
		map.put("KIND","类别");
		map.put("YSDM","原始代码");
		map.put("ID_DAY","每天时间ID");
		map.put("CODE_DAY","天代码");
		map.put("JAS", "结案数");
		map.put("JCS", "旧存数");
		map.put("SAS", "新收数");
		map.put("WJS", "未结数");
		map.put("MTH", "月份");
		map.put("YWCB", "业务承办");
		map.put("SSDW", "诉讼地位");
		return map;
	}
	
	
	
}
