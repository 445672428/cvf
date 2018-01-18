package others.down10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdateDate {
	private Connection connection = null;
	private String sql1 = "select substring('0000'+CONVERT(char,DM),DATALENGTH('0000'+CONVERT(VARCHAR,DM))-3,4) FROM TS_AY_NEW";
	String insertsql = "insert into TS_AY_NEW(C_DM) VALUES(?)";
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	List<String> list = new ArrayList<String>();
	Statement statement = null;
	/**
	 * SELECT FDM,C_DM FROM TS_AY_NEW WHERE FDM=0
	 * 
	 * List<pojo> list1
	 * 
	 * list2
	 * 
	 * list3
	 * 
	 * list4
	 * 
	 * list5
	 * 
	 * list6
	 * 
	 * for(pojo dx : list1){ fdm String sql =
	 * "SELECT * FROM TS_AY_NEW WHERE FDM = "+dx.getDm(); list2.add() }
	 * 
	 * 
	 * 
	 */
	/**
	 * 根据dm生成dm1-dm6对应的树
	 */
	
	public void test() {
		String sql1 = "SELECT DM,FDM,C_DM FROM TS_AY_NEW WHERE FDM=" + 0;
		System.out.println(sql1);
		List<String> list1 = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareStatement(sql1);
			resultSet = preparedStatement.executeQuery();
			statement = connection.createStatement();
			while (resultSet.next()) {
				Integer dm = resultSet.getInt("DM");
				Integer fdm = resultSet.getInt("FDM");
				String cdm = resultSet.getString("C_DM");
				list1.add(dm + "_" + fdm + "_" + cdm);
			}
			for (String str : list1) {
				System.out.println(str);
				// 查询fdm为0 然后更改它的dm1为的值
				String cdm = str.split("_")[2];
				statement.execute("UPDATE TS_AY_NEW SET DM1=" + "'" + cdm + "'"
						+ " where C_DM='" + cdm + "'");
			}
			List<String> list2 = new ArrayList<String>();
			for (String str : list1) {
				String dm = str.split("_")[0];
				String sql = "SELECT DM,FDM,C_DM,(select C_DM FROM TS_AY_NEW B WHERE B.DM = TS_AY_NEW.FDM) C_DM2 FROM TS_AY_NEW WHERE FDM = "
						+ dm;
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Integer _dm = resultSet.getInt("DM");
					Integer fdm = resultSet.getInt("FDM");
					String cdm2 = resultSet.getString("C_DM");
					String cdm = resultSet.getString("C_DM2");
					list2.add(_dm + "_" + fdm + "_" + cdm + "_" + cdm2);
				}
			}

			for (String str : list2) {
				// 查询fdm为0 然后更改它的dm1为的值
				String _dm = str.split("_")[0];
				String fdm = str.split("_")[1];
				String cdm = str.split("_")[2];// 第一级c_dm
				String cdm2 = str.split("_")[3];// 第二级c_dm
				statement.execute("UPDATE TS_AY_NEW SET DM2=" + "'" + cdm
						+ cdm2 + "'" + " where C_DM='" + cdm2 + "'");
				System.out.println("list2=:" + str);
				String sql3 = "SELECT DM,FDM,C_DM FROM TS_AY_NEW WHERE FDM = "
						+ _dm;
				System.out.println("sql3:" + sql3);
				preparedStatement = connection.prepareStatement(sql3);
				resultSet = preparedStatement.executeQuery();

				List<String> list3 = new ArrayList<String>();
				while (resultSet.next()) {
					Integer _dm3 = resultSet.getInt("DM");
					Integer fdm3 = resultSet.getInt("FDM");
					String cdm3 = resultSet.getString("C_DM");
					System.out.println("xxxx:" + _dm3 + "_" + fdm3 + "_" + cdm3
							+ "     yyyy:"
							+ list3.contains(_dm3 + "_" + fdm3 + "_" + cdm3));
					if (!list3.contains(_dm3 + "_" + fdm3 + "_" + cdm3)) {
						list3.add(_dm3 + "_" + fdm3 + "_" + cdm3);
					}

				}

				System.out.println("list3.size:" + list3.size());
				for (String str3 : list3) {
					// 查询fdm为0 然后更改它的dm1为的值
					String _dm3 = str3.split("_")[0];
					String fdm3 = str3.split("_")[1];
					String cdm3 = str3.split("_")[2];// 第二级c_dm
					String up_sql = "UPDATE TS_AY_NEW SET DM3=" + "'" + cdm
							+ cdm2 + cdm3 + "'" + " where DM=" + _dm3;
					System.out.println(up_sql);
					statement.execute(up_sql);

					List<String> list4 = new ArrayList<String>();
					String sql4 = "SELECT DM,FDM,C_DM FROM TS_AY_NEW WHERE FDM="
							+ _dm3;
					preparedStatement = connection.prepareStatement(sql4);
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						Integer _dm4 = resultSet.getInt("DM");
						Integer fdm4 = resultSet.getInt("FDM");
						String cdm4 = resultSet.getString("C_DM");
						list4.add(_dm4 + "_" + fdm4 + "_" + cdm4);
					}

					for (String str4 : list4) {
						String _dm4 = str4.split("_")[0];
						String fdm4 = str4.split("_")[1];
						String cdm4 = str4.split("_")[2];
						String sql5 = "UPDATE TS_AY_NEW SET DM4=" + "'" + cdm
								+ cdm2 + cdm3 + cdm4 + "'" + "where DM=" + _dm4;
						statement.execute(sql5);
						List<String> list5 = new ArrayList<String>();
						String findsql = "SELECT DM,FDM,C_DM FROM TS_AY_NEW WHERE FDM="
								+ _dm4;
						preparedStatement = connection
								.prepareStatement(findsql);
						resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {
							Integer _dm5 = resultSet.getInt("DM");
							Integer fdm5 = resultSet.getInt("FDM");
							String cdm5 = resultSet.getString("C_DM");
							list5.add(_dm5 + "_" + fdm5 + "_" + cdm5);
						}
						for (String str5 : list5) {
							String _dm5 = str5.split("_")[0];
							String fdm5 = str5.split("_")[1];
							String cdm5 = str5.split("_")[2];
							String sql6 = "UPDATE TS_AY_NEW SET DM5=" + "'"
									+ cdm + cdm2 + cdm3 + cdm4 + cdm5 + "'"
									+ "where DM=" + _dm5;
							statement.execute(sql6);
							String findsql2 = "SELECT DM,FDM,C_DM FROM TS_AY_NEW WHERE FDM="
									+ _dm5;
							preparedStatement = connection
									.prepareStatement(findsql2);
							resultSet = preparedStatement.executeQuery();
							List<String> list6 = new ArrayList<String>();
							while (resultSet.next()) {
								Integer _dm6 = resultSet.getInt("DM");
								Integer fdm6 = resultSet.getInt("FDM");
								String cdm6 = resultSet.getString("C_DM");
								list6.add(_dm6 + "_" + fdm6 + "_" + cdm6);
							}
							for (String str6 : list6) {
								String _dm6 = str6.split("_")[0];
								String fdm6 = str6.split("_")[1];
								String cdm6 = str6.split("_")[2];
								String sql7 = "UPDATE TS_AY_NEW SET DM6=" + "'"
										+ cdm + cdm2 + cdm3 + cdm4 + cdm5
										+ cdm6 + "'" + "where DM=" + _dm6;
								statement.execute(sql7);
							}

						}
					}

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				resultSet.close();
				connection.close();
				System.out.println("成功了");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	/**
	 * 更新dm1-dm6未更新完的数据
	 */
	public void test1() {
		List<String> list1 = new ArrayList<String>();
		String sql = "SELECT DM1,DM2,DM3,DM4,DM5,DM6,DM FROM TS_AY_NEW";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String DM1 = resultSet.getString("DM1");
				String DM2 = resultSet.getString("DM2");
				String DM3 = resultSet.getString("DM3");
				String DM4 = resultSet.getString("DM4");
				String DM5 = resultSet.getString("DM5");
				String DM6 = resultSet.getString("DM6");
				String DM = resultSet.getString("DM");
				list1.add(DM1 + "," + DM2 + "," + DM3 + "," + DM4 + "," + DM5
						+ "," + DM6 + "," + DM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < list1.size(); i++) {
			String columns = list1.get(i);
			String[] column = columns.split(",");
			// System.out.println("------------------------现在遍历数组一里面的数据:"+columns+"数组list1大小:"+list1.size());
			for (int j = 0; j < column.length - 1; j++) {
				// System.out.println("第i=:"+i+"第j列:="+j+"值是:"+column[j]+"column[j]当前长度:"+column[j].length());
				if (column[j].length() != 1) {
					
					String xx = column[column.length - 1];
					int DM = Integer.valueOf(xx).intValue();
					String val = column[j];
					Integer index = val.length() / 4;
					switch (index) {
					case 1:
						String val1 = val;
						String val2 = val + "0000";
						String val3 = val + "0000" + "0000";
						String val4 = val + "0000" + "0000" + "0000";
						String val5 = val + "0000" + "0000" + "0000" + "0000";
						String val6 = val + "0000" + "0000" + "0000" + "0000"+ "0000";
						String up__sql1 = "UPDATE TS_AY_NEW SET DM2=" + "'"
								+ val2 + "'" + ",DM3=" + "'" + val3 + "'"
								+ ",DM4=" + "'" + val4 + "'" + ",DM5=" + "'"
								+ val5 + "'" + ",DM6=" + "'" + val6 + "'"
								+ " WHERE DM=" + DM;
						System.out.println("插入条件为1：" + up__sql1);
						try {
							statement = connection.createStatement();
							statement.executeUpdate(up__sql1);
						} catch (SQLException e) {
							e.printStackTrace();
						}

						break;
					case 2:
						String val11 = val.substring(0, 4);
						String val12 = val;
						String val13 = val + "0000";
						String val14 = val + "0000" + "0000";
						String val15 = val + "0000" + "0000" + "0000";
						String val16 = val + "0000" + "0000" + "0000" + "0000";
						String up__sql2 = "UPDATE TS_AY_NEW SET DM1= " + "'"
								+ val11 + "'" + ",DM3=" + "'" + val13 + "'"
								+ ",DM4=" + "'" + val14 + "'" + ",DM5=" + "'"
								+ val15 + "'" + ",DM6=" + "'" + val16 + "'"
								+ "WHERE DM=" + DM;
						System.out.println("插入条件为2：" + up__sql2);
						try {
							statement = connection.createStatement();
							statement.executeUpdate(up__sql2);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					case 3:
						String val21 = val.substring(0, 4);
						String val22 = val.substring(4, 8);
						String val23 = val;
						String val24 = val + "0000";
						String val25 = val + "0000" + "0000";
						String val26 = val + "0000" + "0000" + "0000";
						String up__sql3 = "UPDATE TS_AY_NEW SET DM1= " + "'"
								+ val21 + "'" + ",DM2=" + "'" + val22 + "'"
								+ ",DM4=" + "'" + val24 + "'" + ",DM5=" + "'"
								+ val25 + "'" + ",DM6=" + "'" + val26 + "'"
								+ "WHERE DM=" + DM;
						System.out.println("插入条件为3：" + up__sql3);
						try {
							statement = connection.createStatement();
							statement.executeUpdate(up__sql3);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					case 4:
						String val31 = val.substring(0, 4);
						String val32 = val.substring(4, 8);
						String val33 = val.substring(8, 12);
						String val34 = val;
						String val35 = val + "0000";
						String val36 = val + "0000" + "0000";
						String up__sql4 = "UPDATE TS_AY_NEW SET DM1= " + "'"
								+ val31 + "'" + ",DM2=" + "'" + val32 + "'"
								+ ",DM3=" + "'" + val33 + "'" + ",DM5=" + "'"
								+ val35 + "'" + ",DM6=" + "'" + val36 + "'"
								+ " WHERE DM=" + DM;
						System.out.println("插入条件为4：" + up__sql4);
						try {
							statement = connection.createStatement();
							statement.executeUpdate(up__sql4);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					case 5:
						String val41 = val.substring(0, 4);
						String val42 = val.substring(4, 8);
						String val43 = val.substring(8, 12);
						String val44 = val.substring(12, 16);
						String val45 = val;
						String val46 = val + "0000";
						String up__sql5 = "UPDATE TS_AY_NEW SET DM1= " + "'"
								+ val41 + "'" + ",DM2=" + "'" + val42 + "'"
								+ ",DM3=" + "'" + val43 + "'" + ",DM4=" + "'"
								+ val44 + "'" + ",DM6=" + "'" + val46 + "'"
								+ " WHERE DM=" + DM;
						System.out.println("插入条件为5：" + up__sql5);
						try {
							statement = connection.createStatement();
							statement.executeUpdate(up__sql5);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					case 6:
						String val51 = val.substring(0, 4);
						String val52 = val.substring(4, 8);
						String val53 = val.substring(8, 12);
						String val54 = val.substring(12, 16);
						String val55 = val.substring(16, 20);
						String val56 = val;
						String up__sql6 = "UPDATE TS_AY_NEW SET DM1= " + "'"
								+ val51 + "'" + ",DM2=" + "'" + val52 + "'"
								+ ",DM3=" + "'" + val53 + "'" + ",DM4=" + "'"
								+ val54 + "'" + ",DM5=" + "'" + val55 + "'"
								+ " WHERE DM=" + DM;
						System.out.println("插入条件为6：" + up__sql6);
						try {
							statement = connection.createStatement();
							statement.executeUpdate(up__sql6);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					default:
						break;
					}
				}
			}
		}
	}
}
