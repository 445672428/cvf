
package others.demo.saybase;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.data.DBUtils;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.style.RtfParagraphStyle;

public class SybaseTables {

    public static void main(String[] args) throws Exception {
    	//create();
    	//name1();
    	insertIntoSql();
    }

    public static void insertIntoSql() throws Exception {
        
        String[] paths = {"C:\\ahdc_bi09.ADM_EAJ 2018-06-26.sql","C:\\ahdc_bi09.AAM_EAJ_SJC 2018-06-26.sql",
        		"C:\\ahdc_bi09.ADM_AHDM_ZLBG 2018-06-26.sql","C:\\ahdc_bi09.AAM_SSDT_SFJD 2018-06-26.sql",
        		"C:\\ahdc_bi09.AAM_SSDT_LCJD_TEMP 2018-06-26.sql","C:\\ahdc_bi09.AAM_EAJ 2018-06-26.sql",
        		"C:\\ahdc_bi09.AAM_EAJ_AJLY 2018-06-26.sql","C:\\ahdc_bi09.AAM_EAJ_JAFS 2018-06-26.sql",
        		"C:\\ahdc_bi09.AAM_EAJ5_LY 2018-06-26.sql","C:\\ahdc_bi09.AAM_EAJ5_YJ 2018-06-26.sql",
        		"C:\\ahdc_bi09.AAM_EAJ5_ZT 2018-06-26.sql","C:\\ahdc_bi09.AAM_REPORT_ZYSJ 2018-06-26.sql",
        		"C:\\ahdc_bi09.AAM_EAJ_XZ 2018-06-26.sql","C:\\ahdc_bi09.AAM_EAJ1 2018-06-26.sql",
        		"C:\\ahdc_bi09.AAM_EAJ_WJ 2018-06-26.sql","C:\\ahdc_bi09.AAM_EAJ_SXPJ 2018-06-26.sql",
        		"C:\\ahdc_bi09.AAM_EAJ_SJC_XS 2018-06-26.sql","C:\\ahdc_bi09.AAM_EAJ5_JAFS 2018-06-26.sql"
        		};
        
        for(int i = 0; i < paths.length; i++){
        	final String path = paths[i];
        	Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
			        String d = "com.sybase.jdbc3.jdbc.SybDriver";
			        String u = "jdbc:sybase:Tds:localhost:5000/ahdcbi09?charset=cp936";
			        String s = "sa";
			        String p = "";
			        Connection connection = null;
			        Statement statement = null;
			        ResultSet resultSet = null;
			        connection = DBUtils.getConnection(d, u, s, p);
			        try {
						statement = connection.createStatement();
						File file = new File(path);
				        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "GBK"); //或GB2312,GB18030
				        BufferedReader read = new BufferedReader(isr);
						String line = null;
						while ((line = read.readLine()) != null) {
							if (line.startsWith("INSERT")) {
								try {
									statement.execute(line);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
						read.close();
						DBUtils.closeConnection(connection, statement, resultSet);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
        	thread.start();
        }
		
    }
    
    
//    public static void create() throws Exception {
//        //System.out.println(SybaseTables.class.getResource("/").getPath());
//        //URL url = SybaseTables.class.getClassLoader().getResource("config/spring-dataSource-sybase.xml");
//        
//        String d = "com.sybase.jdbc3.jdbc.SybDriver";
//        String u = "jdbc:sybase:Tds:localhost:5000/ahdcbi09?charset=cp936";
//        String s = "sa";
//        String p = "";
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        connection = DBUtils.getConnection(d, u, s, p);
//        statement = connection.createStatement();
//        String tableSql = " SELECT name from sysobjects";
//        statement.execute(tableSql);
//        resultSet = statement.getResultSet();
//        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
//        while (resultSet.next()) {
//			String v = resultSet.getString("name");
//			Map<String, Object> m = new HashMap<String, Object>();
//			m.put("name", v);
//			list.add(m);
//		}
//        
//        
//
//
//        /**
//         * 查询sybase 库所有主键
//         */
//        Map<String, Map<String, String>> allPkMap = new HashMap<String, Map<String, String>>();
//        String keySql = " select   indid, keycnt, name,object_name(id) as tabname from sysindexes where  indid >=1 and status&2048=2048 ";// --
//                                                                                                                                  // indid大于1
//        statement.execute(keySql);
//        resultSet = statement.getResultSet();
//        
//        // 表示主键或索引
//        List<Map<String, Object>> keyList = new ArrayList<Map<String,Object>>();
//        while (resultSet.next()) {
//			int v1 = resultSet.getInt("indid");
//			int v2 = resultSet.getInt("keycnt");
//			String v3 = resultSet.getString("name");
//			String v4 = resultSet.getString("tabname");
//			
//			Map<String, Object> m = new HashMap<String, Object>();
//			m.put("indid", v1);
//			m.put("keycnt", v2);
//			m.put("name", v3);
//			m.put("tabname", v4);
//			
//			keyList.add(m);
//		}
//        
//        
//        for(Map<String, Object> map : keyList) {
//            int indid = map.get("indid") == null ? 0 : (Integer)map.get("indid");
//            int keycnt = map.get("keycnt") == null ? 0 : (Integer)map.get("keycnt");
//            String keyName = StringUtils.trim((String)map.get("name"));// 主键名称
//            String tableName = StringUtils.trim((String)map.get("tabname"));// 表名称
//            for(int index = 1; index <= keycnt; index++) {
//                String pkSql = "SELECT index_col('" + tableName + "',2," + index
//                                + ") as pkname from sysindexes WHERE indid=2 AND  id=object_id('" + tableName + "')";
//                
//                List<Map<String, Object>> pkList = new ArrayList<Map<String,Object>>();
//                statement.execute(pkSql);
//                resultSet = statement.getResultSet();
//                while (resultSet.next()) {
//        			String v1 = resultSet.getString("pkname");
//        			
//        			Map<String, Object> m = new HashMap<String, Object>();
//        			m.put("pkname", v1);
//        			pkList.add(m);
//        		}
//                
//                
//                if(pkList != null && pkList.size() > 0) {
//                    Map<String, Object> kyM = pkList.get(0);
//                    String pkName = StringUtils.trim((String)kyM.get("pkname"));
//                    if(allPkMap.get(tableName) == null) {
//                        Map<String, String> mm = new HashMap<String, String>();
//                        mm.put(pkName, "Y");
//                        allPkMap.put(tableName, mm);
//                    } else {
//                        Map<String, String> mm = allPkMap.get(tableName);
//                        mm.put(pkName, "Y");
//                        allPkMap.put(tableName, mm);
//                    }
//                }
//            }
//        }
//
//        List<String> taleNames = new ArrayList<String>();
//        for(int i = 0; i < list.size(); i++) {
//            Map<String, Object> map = list.get(i);
//            String name = StringUtils.trim((String)map.get("name"));
//            char first = name.charAt(0);
//            if(Character.isLowerCase(first)) {
//                continue;
//            } else {
//                taleNames.add(name);
//            }
//        }
//        
//        String removes = "AAM_EAJ5_JAFS, AAM_EAJ5_LY, AAM_EAJ5_YJ, AAM_EAJ5_ZT, AAM_EAJ_25, AAM_EAJ_CPWSSW, AAM_EAJ_DYSJ, AAM_EAJ_JXJS, AAM_EAJ_SJC_AJLXBS, AAM_EAJ_SJC_AJLXBS_ALL, AAM_EAJ_SJC_AJLXBS_TEMP, AAM_EAJ_SJC_RY, AAM_EAJ_SJC_SFJD, AAM_EAJ_SJC_SSXF, AAM_EAJ_SJC_ZH, AAM_EAJ_SJC_ZXXF, AAM_EAJ_SPCY, AAM_GS, AAM_JRFZ, AAM_JXJSQK, AAM_KS, AAM_MSYSJDC, AAM_SSDT_ALL_SQL, AAM_TJAJTJB_TEMP, AAM_ZLBG_DATA_TEMP, AAM_ZLBG_SQL, ADM_AHDM_ZLBG, ADM_DEPART, ADM_EAJ2_TEMP, ADM_EAJ3_TEMP, ADM_EAJ51_TEMP, ADM_EAJ61_TEMP, ADM_EAJ_AHDM, ADM_EAJ_JXJSQK, ADM_EAJ_QXBG_TEMP, ADM_EAJ_SFJD, ADM_EAJ_SPCY, ADM_EAJ_SPHD, ADM_EAJ_SPHD_TEMP, ADM_EAJ_SP_AHDM_1932530887, ADM_EAJ_SP_JS_1964531001, ADM_EAJ_SP_XH_1948530944, ADM_EAJ_SSXF, ADM_EAJ_XZ_TEMP, ADM_EAJ_YAXX_TEMP, ADM_EAJ_ZXXF, ADM_EDSR_DZLX_TEMP, ADM_EDSR_SXPJ, ADM_EDSR_SXPJ_TEMP, ADM_EDSR_TEMP, ADM_EDSR_XZXW, ADM_EDSR_XZXW_TEMP, ADM_EDSR_ZKZM, ADM_EDSR_ZKZM_TEMP, BB_JXJSTJ_01, BB_JXJSTJ_01_TEMP, BB_JXJSTJ_02, BB_JXJSTJ_02_TEMP, BB_JXJSTJ_03, BB_JXJSTJ_03_TEMP, BB_JXJSTJ_04, BB_JXJSTJ_04_TEMP, BB_JXJSTJ_05, BB_JXJSTJ_05_TEMP, BB_JXJSTJ_06, BB_JXJSTJ_06_TEMP, BB_JXJSTJ_07, BB_JXJSTJ_07_TEMP, BB_JXJSTJ_08, BB_JXJSTJ_08_TEMP, BB_JXJSTJ_12, BB_JXJSTJ_12_TEMP, BB_JXJSTJ_13, BB_JXJSTJ_13_TEMP, BB_JXJSTJ_14, BB_JXJSTJ_14_TEMP, BB_JXJS_EAJ, BB_JXJS_EAJ_AJPY, BB_JXJS_EAJ_FTSY, BB_JXJS_EAJ_JJSXXF, BB_JXJS_EAJ_JXJSQK, BB_JXJS_EAJ_JXJSQK_FZ, BB_JXJS_EA_AHCFXH_1705054079, BB_JXJS_EA_AHDM_1769054307, BB_JXJS_EA_AHDM_1881054706, BB_JXJS_EA_AHDM_293573053, BB_JXJS_EA_AH_325573167, BB_JXJS_EA_AH_793050830, BB_JXJS_EA_AJBS_921051286, BB_JXJS_EA_AJLB_1577053623, BB_JXJS_EA_AJLX_873051115, BB_JXJS_EA_AJLY_1273052540, BB_JXJS_EA_AJMJ_905051229, BB_JXJS_EA_AJSD_825050944, BB_JXJS_EA_AYMS_1321052711, BB_JXJS_EA_BCYSFT_1689054022, BB_JXJS_EA_BDJE_1337052768, BB_JXJS_EA_BDZZQL_437573566, BB_JXJS_EA_BDZZQL_453573623, BB_JXJS_EA_BDZZQL_469573680, BB_JXJS_EA_BHRWZB_53572198, BB_JXJS_EA_BL_181572654, BB_JXJS_EA_BZ_2073055390, BB_JXJS_EA_CBBM1_1449053167, BB_JXJS_EA_CBBM2_1465053224, BB_JXJS_EA_CBR_1481053281, BB_JXJS_EA_CTZZZR_37572141, BB_JXJS_EA_DD_2009055162, BB_JXJS_EA_DSR_1401052996, BB_JXJS_EA_DTBHRH_21572084, BB_JXJS_EA_DTDSR_2121055561, BB_JXJS_EA_DZ_985051514, BB_JXJS_EA_FBGG_2105055504, BB_JXJS_EA_FTYT_1913054820, BB_JXJS_EA_FYDM_937051343, BB_JXJS_EA_FYJC_969051457, BB_JXJS_EA_FZCJA_1625053794, BB_JXJS_EA_GDJSRQ_1129052027, BB_JXJS_EA_GKKT_2025055219, BB_JXJS_EA_HXXQN_405573452, BB_JXJS_EA_HXXQY_421573509, BB_JXJS_EA_HYCY_1529053452, BB_JXJS_EA_JAFSSM_1385052939, BB_JXJS_EA_JAFS_1369052882, BB_JXJS_EA_JARQ_1065051799, BB_JXJS_EA_JATJ_1225052369, BB_JXJS_EA_JBDTDS_2137055618, BB_JXJS_EA_JBFY_309573110, BB_JXJS_EA_JJBHHD_69572255, BB_JXJS_EA_JSSJ_1977055048, BB_JXJS_EA_JZXH_1641053851, BB_JXJS_EA_KSSJ_1961054991, BB_JXJS_EA_KTDWXC_85572312, BB_JXJS_EA_KTFT_1993055105, BB_JXJS_EA_KTRQ_1193052255, BB_JXJS_EA_KTRQ_1929054877, BB_JXJS_EA_LABM_1417053053, BB_JXJS_EA_LAQXJM_1145052084, BB_JXJS_EA_LARQ_1049051742, BB_JXJS_EA_LSAH_809050887, BB_JXJS_EA_MQZZ_841051001, BB_JXJS_EA_NDXH_1017051628, BB_JXJS_EA_ND_953051400, BB_JXJS_EA_PBJL_1673053965, BB_JXJS_EA_PCZT_1657053908, BB_JXJS_EA_PCZX_357573281, BB_JXJS_EA_PQCS_857051058, BB_JXJS_EA_PQRQ_2041055276, BB_JXJS_EA_PQR_2057055333, BB_JXJS_EA_PTRS_101572369, BB_JXJS_EA_PYLX_1801054421, BB_JXJS_EA_PYRQ_1817054478, BB_JXJS_EA_RDDBPT_117572426, BB_JXJS_EA_SAAY_1305052654, BB_JXJS_EA_SARQ_1033051685, BB_JXJS_EA_SAR_1433053110, BB_JXJS_EA_SATJ_1209052312, BB_JXJS_EA_SCR_1545053509, BB_JXJS_EA_SDRQ_1081051856, BB_JXJS_EA_SJJSSJ_245572882, BB_JXJS_EA_SJKSSJ_229572825, BB_JXJS_EA_SJKTRQ_213572768, BB_JXJS_EA_SJY_1513053395, BB_JXJS_EA_SLY_2089055447, BB_JXJS_EA_SPCX_1609053737, BB_JXJS_EA_SPZ_1497053338, BB_JXJS_EA_SQSX_1721054136, BB_JXJS_EA_SWHDTT_149572540, BB_JXJS_EA_SXJMRQ_1177052198, BB_JXJS_EA_SXPJQD_341573224, BB_JXJS_EA_SXQSRQ_1161052141, BB_JXJS_EA_SXRQ_1097051913, BB_JXJS_EA_SXTJ_1241052426, BB_JXJS_EA_SYCX_1289052597, BB_JXJS_EA_TC_1945054934, BB_JXJS_EA_TJBH_1257052483, BB_JXJS_EA_TJGDRQ_1113051970, BB_JXJS_EA_TLJG_1833054535, BB_JXJS_EA_TZCJQK_197572711, BB_JXJS_EA_WLTTDS_5572027, BB_JXJS_EA_XH_1001051571, BB_JXJS_EA_XH_1785054364, BB_JXJS_EA_XH_1897054763, BB_JXJS_EA_XH_517573851, BB_JXJS_EA_XLA_889051172, BB_JXJS_EA_XPQK_165572597, BB_JXJS_EA_XTAJLX_1593053680, BB_JXJS_EA_YPXGRQ_485573737, BB_JXJS_EA_YSSX_1353052825, BB_JXJS_EA_ZFBJYK_501573794, BB_JXJS_EA_ZTC_1561053566, BB_JXJS_EA_ZXWYPT_133572483, BB_JXJS_EA_ZXXQN_373573338, BB_JXJS_EA_ZXXQY_389573395, BB_JXJS_EDSR, BB_JXJS_ED_AHDM_629574250, BB_JXJS_ED_BGLDXT_1333576758, BB_JXJS_ED_BGRLX_997575561, BB_JXJS_ED_BGRPXH_1013575618, BB_JXJS_ED_BGZYLD_1317576701, BB_JXJS_ED_BS_773574763, BB_JXJS_ED_CSRQ_1445577157, BB_JXJS_ED_CXHXJS_1093575903, BB_JXJS_ED_CXMM_693574478, BB_JXJS_ED_CXZH_677574421, BB_JXJS_ED_DBRZJH_1925578867, BB_JXJS_ED_DBRZJZ_1909578810, BB_JXJS_ED_DRGLRZ_1269576530, BB_JXJS_ED_DSRLX_1285576587, BB_JXJS_ED_DWFZZJ_1029575675, BB_JXJS_ED_DWJSSF_981575504, BB_JXJS_ED_DWXZ_1861578639, BB_JXJS_ED_DZYX_885575162, BB_JXJS_ED_DZ_837574991, BB_JXJS_ED_FCTZRQ_1157576131, BB_JXJS_ED_FDDBR_1893578753, BB_JXJS_ED_FLYZYY_1061575789, BB_JXJS_ED_FZJE_2101579494, BB_JXJS_ED_GJDQ_1829578525, BB_JXJS_ED_GJ_1477577271, BB_JXJS_ED_GLRLX_1253576473, BB_JXJS_ED_HJSZD_1765578297, BB_JXJS_ED_HXJSKY_1077575846, BB_JXJS_ED_HYHLC_1045575732, BB_JXJS_ED_HYZK_1653577898, BB_JXJS_ED_HY_1125576017, BB_JXJS_ED_JGGBJB_1573577613, BB_JXJS_ED_JGZWXZ_1557577556, BB_JXJS_ED_JS_789574820, BB_JXJS_ED_JTJJZK_1813578468, BB_JXJS_ED_LB_661574364, BB_JXJS_ED_LDRY_1781578354, BB_JXJS_ED_LEIF_2053579323, BB_JXJS_ED_LXDH_869575105, BB_JXJS_ED_LXQJ_2021579209, BB_JXJS_ED_LX_805574877, BB_JXJS_ED_LY_757574706, BB_JXJS_ED_MC_821574934, BB_JXJS_ED_MZ_1493577328, BB_JXJS_ED_NL_1461577214, BB_JXJS_ED_PCJDRQ_1365576872, BB_JXJS_ED_PCJDWS_1381576929, BB_JXJS_ED_PCYWJG_1349576815, BB_JXJS_ED_QSTZRQ_1173576188, BB_JXJS_ED_QTLXFF_901575219, BB_JXJS_ED_QTZJHM_1605577727, BB_JXJS_ED_QTZJZL_1589577670, BB_JXJS_ED_SBZQRQ_1141576074, BB_JXJS_ED_SFDSR_2117579551, BB_JXJS_ED_SFZHM_1525577442, BB_JXJS_ED_SF_1509577385, BB_JXJS_ED_SLTZRQ_1205576302, BB_JXJS_ED_SLTZR_1189576245, BB_JXJS_ED_SSDLRB_1957578981, BB_JXJS_ED_SSDLR_1941578924, BB_JXJS_ED_SSDW1_709574535, BB_JXJS_ED_SSDW2_725574592, BB_JXJS_ED_SSDW3_741574649, BB_JXJS_ED_SSDX_933575333, BB_JXJS_ED_SWHJL_2005579152, BB_JXJS_ED_SWQK_965575447, BB_JXJS_ED_SYZXZ_1109575960, BB_JXJS_ED_SZDW_1701578069, BB_JXJS_ED_TCYYJM_1237576416, BB_JXJS_ED_TCYYRQ_1221576359, BB_JXJS_ED_TSHY_1877578696, BB_JXJS_ED_TSSF_1733578183, BB_JXJS_ED_TSSLHB_1749578240, BB_JXJS_ED_WCNRJT_1797578411, BB_JXJS_ED_WFJS_2069579380, BB_JXJS_ED_WHCD_1637577841, BB_JXJS_ED_WSD_2085579437, BB_JXJS_ED_XBHR_949575390, BB_JXJS_ED_XB_1429577100, BB_JXJS_ED_XFRSF_1397576986, BB_JXJS_ED_XH_645574307, BB_JXJS_ED_XWNL_917575276, BB_JXJS_ED_XYJRSF_1541577499, BB_JXJS_ED_XZJB_1685578012, BB_JXJS_ED_YDSRGX_1413577043, BB_JXJS_ED_YGQSLY_1301576644, BB_JXJS_ED_YUANJI_1973579038, BB_JXJS_ED_YZBM_853575048, BB_JXJS_ED_ZIBAOS_1989579095, BB_JXJS_ED_ZMMS_2037579266, BB_JXJS_ED_ZW_1717578126, BB_JXJS_ED_ZY_1621577784, BB_JXJS_ED_ZZJGDM_1845578582, BB_JXJS_ED_ZZMM_1669577955, BB_SQJZRY_EDSR, BB_SQJZRY_JC_EDSR, DC_CITY_XZQH, DC_DAY_ALL_SQL_copy1115, DC_DAY_EAJ_CBBM1_1010099608, DC_DAY_EAJ_CBBM1_1058099779, DC_DAY_EAJ_CBBM1_1106099950, DC_DAY_EAJ_CBBM1_1154100121, DC_DAY_EAJ_CBBM1_1202100292, DC_DAY_EAJ_CBBM1_1250100463, DC_DAY_EAJ_TEMP, DC_DAY_SQL_copy1115, DC_MON_ALL_SQL_copy, DC_MON_SQL_copy1115, DIM_AJLXBS, DIM_AJLXBS_1115, DIM_AJZH, DIM_BDJE, DIM_CBR_1120, DIM_DYSJ, DIM_FZJE, DIM_JAFS_bak, DIM_JG, DIM_SXYCYY, DIM_SYZXZ, DIM_XFBGLX, DIM_ZX_JAFS, DIM_ZX_LY, DIM_ZX_YJ, DIM_ZX_ZT, DM_RS, SPJX_INDEX, TS_AJFL_AJSXR_443145593, TS_AJFL_AJSXY_427145536, TS_AJFL_YQKTTS_459145650, TS_AJFL_ZDKTTS_475145707, TS_AY_CCBM_523145878, TS_DAGL_FYDM, TS_DB_ALL, TS_DB_SFJD, TS_DB_SSXF, TS_DB_ZXXF, TS_DEL, T_BASE_JXJS, T_DEPART, T_DEPART_BMBS_2014627189, T_DEPART_PXH_1998627132, T_DEPART_RS, T_FY_RS, T_USER, T_USERROLE, T_USER_RS, T_USER_RS_copy";
//        
//        String[] rems = removes.split(",");
//        Map<String, String> rM = new HashMap<String, String>();
//        for (int i = 0; i < rems.length; i++) {
//			String v = StringUtils.strip(rems[i]);
//        	rM.put(v, v);
//		}
//        
//        Document document = new Document(PageSize.A4);
//        FileOutputStream outputStream = new FileOutputStream("D:/word.doc");
//        RtfWriter2.getInstance(document, outputStream);
//        document.open();
//        for(String table : taleNames) {
//        	if (rM.get(table)==null) {
//				continue;
//			}
//        	
//            String tableInfo =
//                    "SELECT sysobjects.name AS tablename ,"
//                    + "syscolumns.name as colname,"
//                    + "syscolumns.length as colLength,"
//                    + "systypes.name as colType,"
//                    + "systypes.variable,systypes.allownulls "
//                            + " from syscolumns left join sysobjects on syscolumns.id = sysobjects.id and ( sysobjects.type = 'U' OR  sysobjects.type = 'V' ) "
//                            + " and sysobjects.name='"
//                            + table
//                            + "' left join systypes on syscolumns.usertype = systypes.usertype where sysobjects.name='"
//                            + table + "' " + " order  by sysobjects.name,syscolumns.name";
//            List<Map<String, Object>> infoList = new ArrayList<Map<String,Object>>();
//            
//            statement.execute(tableInfo);
//            resultSet = statement.getResultSet();
//            while (resultSet.next()) {
//    			String v1 = resultSet.getString("tablename");
//    			String v2 = resultSet.getString("colname");
//    			String v3 = resultSet.getString("colLength");
//    			String v4 = resultSet.getString("colType");
//    			
//    			Map<String, Object> m = new HashMap<String, Object>();
//    			m.put("tablename", v1);
//    			m.put("colname", v2);
//    			m.put("colLength", v3);
//    			m.put("colType", v4);
//    			
//    			infoList.add(m);
//    		}
//            
//            
//            Table wordTable = new Table(5);
//
//            // 第二级标题样式
//            RtfParagraphStyle rtfGsBt2 = RtfParagraphStyle.STYLE_HEADING_3;
//            rtfGsBt2.setAlignment(Element.ALIGN_LEFT);
//            rtfGsBt2.setStyle(Font.BOLD);
//            rtfGsBt2.setSize(13);
//            rtfGsBt2.setStyle(Font.NORMAL);
//            Paragraph title11 = new Paragraph(table + "表");
//            title11.setFont(rtfGsBt2);
//            title11.setSpacingBefore(-1f);
//            title11.setLeading(0f);
//            title11.setMultipliedLeading(0f);
//            title11.setSpacingAfter(0f);
//            document.add(title11);
//
//            wordTable.setBorderWidth(1);
//            wordTable.setBorderColor(Color.BLACK);
//            wordTable.setOffset(1f);// 修改间距表与标题间距
//            wordTable.setPadding(0);
//            wordTable.setSpacing(0);
//            Cell cell1 = new Cell();
//            Cell cell2 = new Cell();
//            Cell cell3 = new Cell();
//            Cell cell4 = new Cell();
//            Cell cell5 = new Cell();
//            cell1.setBackgroundColor(new Color(174, 170, 170, 1));
//            cell2.setBackgroundColor(new Color(174, 170, 170, 1));
//            cell3.setBackgroundColor(new Color(174, 170, 170, 1));
//            cell4.setBackgroundColor(new Color(174, 170, 170, 1));
//            cell5.setBackgroundColor(new Color(174, 170, 170, 1));
//            cell1.add(new Paragraph("字段"));
//            cell2.add(new Paragraph("名称"));
//            cell3.add(new Paragraph("类型"));
//            cell4.add(new Paragraph("主键"));
//            cell5.add(new Paragraph("备注"));
//            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
//            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中
//            cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
//            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中
//            cell3.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
//            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中
//            cell4.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
//            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中
//            cell5.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
//            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中
//            wordTable.addCell(cell1);
//            wordTable.addCell(cell2);
//            wordTable.addCell(cell3);
//            wordTable.addCell(cell4);
//            wordTable.addCell(cell5);
//            if(infoList == null || infoList.size() == 0) {
//                // System.out.println(table);
//            } else {
//                // 获取 当前 结果长度
//                int len = infoList.size();
//                for(Map<String, Object> tmpMap : infoList) {
//                    Map<String, String> tMap = aliaName();
//                    String tName = StringUtils.trim((String)tmpMap.get("tablename"));
//                    String cName = StringUtils.trim((String)tmpMap.get("colname"));
//                    String cLen = StringUtils.trim((String)tmpMap.get("colLength"));
//                    String cType = StringUtils.trim((String)tmpMap.get("colType"));
//                    String mc = "";
//                    int mapSize = 0;
//                    for(String key : tMap.keySet()) {
//                        if(cName.indexOf(key) > -1) {
//                            if(cName.toLowerCase().indexOf("name") > -1) {
//                                mc = tMap.get(key) + "名称";
//                                break;
//                            } else if(cName.toLowerCase().indexOf("code") > -1) {
//                                mc = tMap.get(key) + "代码";
//                                break;
//                            } else {
//                                mc = tMap.get(key);
//                                break;
//                            }
//                        } else {
//                            if(mapSize == tmpMap.size()) {
//                                mc = cName;
//                            }
//                        }
//                        mapSize++;
//                    }
//                    Cell c1 = new Cell();
//                    Cell c2 = new Cell();
//                    Cell c3 = new Cell();
//                    Cell c4 = new Cell();
//                    Cell c5 = new Cell();
//                    c1.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
//                    c1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中
//                    c2.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
//                    c2.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中
//                    c3.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
//                    c3.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中
//                    c4.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
//                    c4.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中
//                    c5.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
//                    c5.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中
//                    c1.add(new Paragraph(cName));
//                    c2.add(new Paragraph(mc));
//                    c3.add(new Paragraph(cType + "(" + cLen + ")"));
//                    wordTable.addCell(c1);
//                    wordTable.addCell(c2);
//                    wordTable.addCell(c3);
//                    Map<String, String> mm = allPkMap.get(table);
//                    if(mm != null) {
//                        c4.add(new Paragraph(StringUtils.trim(mm.get(cName))));
//                        wordTable.addCell(c4);
//                    } else {
//                        c4.add(new Paragraph(""));// 没有主键
//                        wordTable.addCell(c4);
//                    }
//                    c5.add(new Paragraph(""));
//                    wordTable.addCell(c5);
//                }
//            }
//            document.add(wordTable);
//        }
//        document.close();
//        DBUtils.closeConnection(connection, statement, resultSet);
//    }


//    public static void name1() throws Exception {
//        Document document = new Document(PageSize.A4.rotate());
//        RtfWriter2.getInstance(document, new FileOutputStream("d:\\word.doc"));
//        document.open();
//        Font titleFont = new Font(Font.NORMAL, 16, Font.BOLD);
//        /* 设置标题1格式 */
//        RtfParagraphStyle rtfGsBt1 = RtfParagraphStyle.STYLE_HEADING_1;
//        rtfGsBt1.setAlignment(Element.ALIGN_CENTER);
//        rtfGsBt1.setStyle(Font.BOLD);
//        rtfGsBt1.setSize(14);
//        /* 设置标题2格式 */
//        RtfParagraphStyle rtfGsBt2 = RtfParagraphStyle.STYLE_HEADING_2;
//        rtfGsBt2.setAlignment(Element.ALIGN_LEFT);
//        rtfGsBt2.setStyle(Font.NORMAL);
//        rtfGsBt2.setSize(12);
//        Paragraph title = new Paragraph("测试");
//        title.setAlignment(Element.ALIGN_CENTER);
//        title.setFont(titleFont);
//        document.add(title);
//        // 正文
//        title = new Paragraph("1.第一章");
//        title.setFont(rtfGsBt1);
//        document.add(title);
//        title = new Paragraph("1.1 第一节");
//        title.setFont(rtfGsBt2);
//        document.add(title);
//        title = new Paragraph("1.2 第二节");
//        title.setFont(rtfGsBt2);
//        document.add(title);
//        title = new Paragraph("2.第二章");
//        title.setFont(rtfGsBt1);
//        document.add(title);
//        title = new Paragraph("2.1 第一节");
//        title.setFont(rtfGsBt2);
//        document.add(title);
//        title = new Paragraph("2.2 第二节");
//        title.setFont(rtfGsBt2);
//        document.add(title);
//
//        List<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
//        
//        for(int i = 0; i  < 5; i++){
//        	
//        	Map<String, Integer> m = new HashMap<String, Integer>();
//        	m.put("a", i);
//        	m.put("b", i);
//        	m.put("c", i);
//        	m.put("d", i);
//        	list.add(m);
//        }
//        
//        
//        RtfParagraphStyle rtfGsBt3 = RtfParagraphStyle.STYLE_HEADING_3;
//        rtfGsBt3.setAlignment(Element.ALIGN_LEFT);
//        rtfGsBt3.setStyle(Font.BOLD);
//        rtfGsBt3.setSize(13);
//        rtfGsBt3.setStyle(Font.NORMAL);
//        Paragraph title11 = new Paragraph("表1111111111");
//        title11.setFont(rtfGsBt3);
//        document.add(title11);
//
//        
//        for (int i = 0; i < list.size(); i++) {
//            Table table = new Table(4);
//            RtfParagraphStyle r = RtfParagraphStyle.STYLE_NORMAL;
//            
//            Paragraph p = new Paragraph("生成表格");
//            p.setFont(rtfGsBt2);
//            		
//            document.add(p);
//            p.setFont(r);
//            
//            table.setBorderWidth(1);
//            table.setBorderColor(Color.BLACK);
//            table.setPadding(0);
//            table.setSpacing(0);
//            table.complete();
//            table.setSpacing(1f);
//            table.setOffset(1f);
//            table.setTop(1f);
//            table.addCell("1,1");
//            table.addCell("1,2");
//            table.addCell("1,3");
//            table.addCell("1,4");
//            Paragraph p1 = new Paragraph("用java生成的表格1");
//            p1.setFont(r);
//            Paragraph p2 = new Paragraph("用java生成的表格1");
//            p2.setFont(r);
//            Paragraph p3 = new Paragraph("用java生成的表格1");
//            p3.setFont(r);
//            Paragraph p4 = new Paragraph("用java生成的表格1");
//            p4.setFont(r);
//            
//            table.addCell(p1);
//            table.addCell(p2);
//            table.addCell(p3);
//            table.addCell(p4);
//            document.add(table);
//		}
//        
//        RtfParagraphStyle rtfGsBt4 = RtfParagraphStyle.STYLE_HEADING_3;
//        rtfGsBt4.setAlignment(Element.ALIGN_LEFT);
//        rtfGsBt4.setStyle(Font.BOLD);
//        rtfGsBt4.setSize(13);
//        rtfGsBt4.setStyle(Font.NORMAL);
//
//        Paragraph title12 = new Paragraph("表2222222222");
//        title12.setFont(rtfGsBt4);
//        document.add(title12);
//
//
//        document.close();
//    }

    private static Map<String, String> aliaName() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("﻿YHDM", "用户代码");
        map.put("DWDM", "单位代码");
        map.put("YHXM", "用户姓名");
        map.put("FLZW", "法律职务");
        map.put("BS", "标识");
        map.put("YHBM", "用户编码");
        map.put("BMDM", "部门代码");
        map.put("FBMDM", "父部门代码");
        map.put("DWDM", "单位代码");
        map.put("BMMC", "部门名称");
        map.put("BMJC", "部门简称");
        map.put("DEPATID", "部门标识");
        map.put("AHDM", "案号代码");
        map.put("AJLXDM", "案件类型代码");
        map.put("XTAJLX", "系统案件类型");
        map.put("AJZT", "案件状态");
        map.put("FYDM", "法院代码");
        map.put("AH", "案号");
        map.put("AYMS", "案由描述");
        map.put("DSR", "当事人");
        map.put("LARQ", "立案日期");
        map.put("JARQ", "结案日期");
        map.put("SATJ", "收案统计");
        map.put("JATJ", "结案统计");
        map.put("BDJE", "标的金额");
        map.put("SAAY", "收案案由");
        map.put("CBBM1", "承办部门");
        map.put("SXJMRQ", "审限届满日期");
        map.put("CBR", "承办人");
        map.put("SPCX", "审判程序");
        map.put("FLZW", "法律职务");
        map.put("AHDM", "案号代码");
        map.put("SJDWJE", "实际到位金额");
        map.put("JABDJE", "结案标的金额");
        map.put("JAFSN", "新结案方式");
        map.put("JASY1", "结案事由1");
        map.put("AHDM", "案号代码");
        map.put("YZXAH", "原执行案号");
        map.put("AJLYN", "案件来源");
        map.put("ZXYJ", "执行依据");
        map.put("XZXYJ", "新执行依据");
        map.put("SQCYLXJLX", "申请延迟履行金利息");
        map.put("SQCYLXJ", "申请延迟履行金");
        map.put("AHDM", "案号代码");
        map.put("FDSXTS", "法定审限天数");
        map.put("SJTS", "实际天数");
        map.put("BGLB", "变更类别");
        map.put("QTSY", "其它事由");
        map.put("AHDM", "案号代码");
        map.put("XH", "法定审限天数");
        map.put("BGLB", "变更类别");
        map.put("QTSY", "其他事由");
        map.put("YY", "原因");
        map.put("BMDM", "部门代码");
        map.put("FBMDM", "父部门代码");
        map.put("DWDM", "单位代码");
        map.put("BMID", "部门ID");
        map.put("BMMC", "部门名称");
        map.put("BMJC", "部门简称");
        map.put("DEPTID", "临时ID");
        map.put("AJLB", "案件类别");
        map.put("AJLBDL", "案件类别大类");
        map.put("PXH", "排序号");
        map.put("AJBM", "案件编码");
        map.put("XTAJLX", "系统案件类型");
        map.put("CODE_LXDL", "类型大类代码");
        map.put("NAME_LXDL", "类型大类名称");
        map.put("AJLXBS", "案件类型标识");
        map.put("AJLX", "案件类型");
        map.put("AJLY", "案件来源");
        map.put("ID_AY", "案由");
        map.put("CODE_AY1", "案由一级代码");
        map.put("NAME_AY1", "案由名称");
        map.put("CODE_AY2", "案由二级代码");
        map.put("NAME_AY2", "案由名称");
        map.put("CODE_AY3", "案由三级代码");
        map.put("NAME_AY3", "案由名称");
        map.put("CODE_AY4", "案由四级代码");
        map.put("NAME_AY4", "案由名称");
        map.put("CODE_AY5", "案由五级代码");
        map.put("NAME_AY5", "案由名称");
        map.put("CODE_AY6", "案由六级代码");
        map.put("NAME_AY6", "案由名称");
        map.put("YSDM", "原始代码");
        map.put("CC", "层次");
        map.put("TJBH", "统计编码");
        map.put("SFJY", "是否禁用");
        map.put("AY", "案由");
        map.put("NAME_AY", "案由名称");
        map.put("AYLX", "案由类型");
        map.put("NAME_AYLX", "案由类型名称");
        map.put("BGYY", "变更原因");
        map.put("YSDM", "原始代码");
        map.put("BGLB", "变更类别");
        map.put("CBBM", "承办部门");
        map.put("CODE_CBBM", "承办部门代码");
        map.put("NAME_CBBM", "承办部门名称");
        map.put("CODE_FYDM", "法院代码");
        map.put("NAME_FYDM", "F法院代码名称");
        map.put("CODE_CITY", "城市代码");
        map.put("NAME_CITY", "城市代码");
        map.put("CODE_PRO", "省代码");
        map.put("NAME_PRO", "省名称");
        map.put("N_PXH", "排序号");
        map.put("YSDM", "原始代码");
        map.put("BMBS", "部门标识");
        map.put("CBR", "承办人");
        map.put("CBBM", "承办部门");
        map.put("FYDM", "法院");
        map.put("CITY", "城市代码");
        map.put("PRO", "省");
        map.put("PRO", "省");
        map.put("YSDM", "元素代码");
        map.put("RYBS", "人员标识");
        map.put("BGKYY", "裁判文书不上网原因");
        map.put("KIND", "类别");
        map.put("YSDM", "原始代码");
        map.put("ID_DAY", "每天时间ID");
        map.put("CODE_DAY", "天代码");
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
