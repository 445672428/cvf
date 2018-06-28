package com.scheduling;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.DBUtils;
import com.utils.BigDecimalUtils;
import com.utils.FileUtils;

public class SendMessage extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// 从spring 容器中获取 调度名称
		ApplicationContext applicationContext = (ApplicationContext) context
				.getJobDetail().getJobDataMap().get("applicationContext");
		// 时间参数，当前时间向前推2天
		System.out.println(222);

	}


	@Test
	public void changeData() {
		Map<String, Station> aliasMap = new HashMap<String, SendMessage.Station>();
		String sql = "select name,code,west,east,south,north from region_station";
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String code = resultSet.getString("code");
				double west = resultSet.getDouble("west");
				double east = resultSet.getDouble("east");
				double south = resultSet.getDouble("south");
				double north = resultSet.getDouble("north");
				Station s = new Station();
				s.setName(name);
				s.setCode(code);
				s.setWest(west);
				s.setEast(east);
				s.setSouth(south);
				s.setNorth(north);
				aliasMap.put(name, s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] names = STATION_NAMES.split("\\|");
		Integer total = names.length / 5;
		String[][] e_city = new String[total][5];
		for (int index = 0; index < names.length; index++) {
			if (index == (names.length - 1)) {
				continue;
			}
			String ele = names[index];
			Integer col = index / 5;
			e_city[col][index % 5] = ele;
		}
		Map<String, String> m = new HashMap<String, String>();
		Map<String, String> c = new HashMap<String, String>();

		for (int index = 0; index < total; index++) {
			String name = e_city[index][1];
			String code = e_city[index][2];
			m.put(name, code);
			c.put(code, name);

		}
		// 针对一个点对应 单个点进行处理
		// 针对一个点对应多个点处理
		File file = new File("C:\\12306\\GAP\\");
		List<JSONArray> list = new ArrayList<JSONArray>();
		for (File f : file.listFiles()) {
			String content = FileUtils.readTextAllContent(f);
			JSONObject collection = JSONObject.parseObject(content);
			JSONArray ar = collection.getJSONObject("data").getJSONArray("data");
			if (ar != null && ar.size() > 0) {
				JSONObject obj = ar.getJSONObject(0);
				if (obj.getString("station_train_code").startsWith("G")) {
					list.add(ar);
				}
			}
		}
		List<LinkedHashMap<String, JSONObject>> datas = new ArrayList<LinkedHashMap<String, JSONObject>>();

		for (JSONArray arr : list) {
			for (int index = 0; index < arr.size(); index++) {
				if (index < (arr.size() - 1)) {
					JSONObject o1 = arr.getJSONObject(index);
					JSONObject o2 = arr.getJSONObject(index + 1);
					String v1 = o1.getString("station_name");
					String v2 = o2.getString("station_name");
					v1 += "站";
					v2 += "站";
					
					if (datas.size()>0) {
						int[] l = new int[datas.size()];
						for (int k = 0; k < datas.size(); k++) {
							LinkedHashMap<String, JSONObject> map = datas.get(k);
							JSONObject source = map.get("source");
							JSONObject target = map.get("target");
							if (source.getString("id").equals(v1)) {
								if (!target.getString("id").equals(v2)) {
									l[k] = 0;
								} else {
									l[k] = 1;
								}
							} else if (source.getString("id").equals(v2)) {
								l[k] = 2;
							} else {
								l[k] = 3;
							}
						}
					
						boolean isFlag = true;
						for(Integer k = 0; k < l.length ; k ++){
							if (l[k]!=3||l[k]==0) {
								isFlag = false;
								break;
							}
						}
						if (isFlag) {
							if (aliasMap.get(v1)!=null&&aliasMap.get(v2)!=null) {
								LinkedHashMap<String, JSONObject> ele = new LinkedHashMap<String, JSONObject>();
								double e1 = aliasMap.get(v1).getEast();
								double w1 = aliasMap.get(v1).getWest();
								double n1 = aliasMap.get(v1).getNorth();
								double s1 = aliasMap.get(v1).getSouth();

								double x1 = BigDecimalUtils.add(w1, e1);
								double y1 = BigDecimalUtils.add(s1, n1);
								
								double _x1 = BigDecimalUtils.sub(w1, e1);
								double _y1 = BigDecimalUtils.sub(n1, s1);
								
								Integer r1 = (int) ((_x1 + _y1) * 200);
								
								JSONObject obj1 = new JSONObject();
								obj1.put("x", x1 / 2);
								obj1.put("y", y1 / 2);
								obj1.put("id", v1);
								obj1.put("r", r1);
								
								
								double e2 = aliasMap.get(v2).getEast();
								double w2 = aliasMap.get(v2).getWest();
								double n2 = aliasMap.get(v2).getNorth();
								double s2 = aliasMap.get(v2).getSouth();

								double x2 = BigDecimalUtils.add(w2, e2);
								double y2 = BigDecimalUtils.add(s2, n2);
								
								double _x2 = BigDecimalUtils.sub(w2, e2);
								double _y2 = BigDecimalUtils.sub(n2, s2);
								
								Integer r2 = (int) ((_x2 + _y2) * 200);
								
								JSONObject obj2 = new JSONObject();
								obj2.put("x", x2 / 2);
								obj2.put("y", y2 / 2);
								obj2.put("id", v2);
								obj2.put("r", r2);
								
								
								ele.put("source", obj1);
								ele.put("target", obj2);
								datas.add(ele);
							}else{
								FileUtils.appendFileWriterTxt("C://12306.txt",v1+"-------"+v2);
							}
						}
					}else{
						if (aliasMap.get(v1)!=null&&aliasMap.get(v2)!=null) {
							LinkedHashMap<String, JSONObject> ele = new LinkedHashMap<String, JSONObject>();
							double e1 = aliasMap.get(v1).getEast();
							double w1 = aliasMap.get(v1).getWest();
							double n1 = aliasMap.get(v1).getNorth();
							double s1 = aliasMap.get(v1).getSouth();

							double x1 = BigDecimalUtils.add(w1, e1);
							double y1 = BigDecimalUtils.add(s1, n1);
							
							double _x1 = BigDecimalUtils.sub(w1, e1);
							double _y1 = BigDecimalUtils.sub(n1, s1);
							
							Integer r1 = (int) ((_x1 + _y1) * 200);
							
							JSONObject obj1 = new JSONObject();
							obj1.put("x", x1 / 2);
							obj1.put("y", y1 / 2);
							obj1.put("id", v1);
							obj1.put("r", r1);
							
							
							double e2 = aliasMap.get(v2).getEast();
							double w2 = aliasMap.get(v2).getWest();
							double n2 = aliasMap.get(v2).getNorth();
							double s2 = aliasMap.get(v2).getSouth();

							double x2 = BigDecimalUtils.add(w2, e2);
							double y2 = BigDecimalUtils.add(s2, n2);
							
							double _x2 = Math.abs(BigDecimalUtils.sub(w2, e2));
							double _y2 = Math.abs(BigDecimalUtils.sub(n2, s2));
							
							Integer r2 = (int) ((_x2 + _y2) * 200);
							
							JSONObject obj2 = new JSONObject();
							obj2.put("x", x2 / 2);
							obj2.put("y", y2 / 2);
							obj2.put("id", v2);
							obj2.put("r", r2);
							
							
							ele.put("source", obj1);
							ele.put("target", obj2);
							datas.add(ele);
						}else{
							FileUtils.appendFileWriterTxt("C://12306.txt",v1+"-------"+v2);
						}
					}
				}
			}
		}
		//需要处理 以某个点为基础点 其他数据根据距离缩放
		int count = 0;
		JSONArray array = new JSONArray(datas.size());
		for(LinkedHashMap<String, JSONObject> map :datas){
			JSONObject object = new JSONObject();
			object.put("source", map.get("source"));
			object.put("target", map.get("target"));
			object.put("index", count);
			array.add(object);
			count ++;
		}
		System.out.println(array.toJSONString());
		FileUtils.createFile("C://12306.json", array.toJSONString());
	}

	@Test
	public void queryGAP() {
		File file = new File(
				"D:\\bobo\\repository\\cvf\\src\\main\\resources\\config\\0525.json");
		String content = FileUtils.readTextAllContent(file);
		JSONObject collection = JSONObject.parseObject(content);

		String[] names = STATION_NAMES.split("\\|");
		Integer total = names.length / 5;
		String[][] e_city = new String[total][5];
		for (int index = 0; index < names.length; index++) {
			if (index == (names.length - 1)) {
				continue;
			}
			String ele = names[index];
			Integer col = index / 5;
			e_city[col][index % 5] = ele;
		}
		Map<String, String> m = new HashMap<String, String>();
		Map<String, String> c = new HashMap<String, String>();

		for (int index = 0; index < total; index++) {
			String name = e_city[index][1];
			String code = e_city[index][2];
			m.put(name, code);
			c.put(code, name);

		}

		CookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient closeableClient = HttpClients.custom()
				.setDefaultCookieStore(cookieStore).build();
		boolean isNext = false;
		for (String k : m.keySet()) {
			String F = m.get(k);
			c.remove(m.get(k));
			for (String j : c.keySet()) {
				String in = "(" + k + "-" + c.get(j) + ")";
				isNext = false;
				for (String n : collection.keySet()) {// 车型
					if (isNext) {
						break;
					}
					JSONArray arr = collection.getJSONArray(n);
					for (int index = 0; index < arr.size(); index++) {
						if (isNext) {
							break;
						}
						JSONObject element = arr.getJSONObject(index);
						String station_train_code = element
								.getString("station_train_code");
						String train_no = element.getString("train_no");
						if (station_train_code.indexOf(in) > -1) {
							System.out.println(true);
							String url = "https://kyfw.12306.cn/otn/czxx/queryByTrainNo?train_no="
									+ train_no
									+ "&from_station_telecode="
									+ F
									+ "&to_station_telecode="
									+ j
									+ "&depart_date=2018-05-25";
							HttpGet request = new HttpGet(url);
							try {
								HttpResponse response = closeableClient
										.execute(request);
								if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
									String results = EntityUtils
											.toString(response.getEntity());
									FileUtils.createFile("C://12306//GAP//" + n
											+ "_" + F + "_" + j + ".txt",
											results);
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							isNext = true;
							break;
						}
					}
				}
			}
		}
	}

	@Test
	public void readWENS() {
		File file = new File(
				"D:\\bobo\\repository\\cvf\\src\\main\\resources\\config\\0525.json");
		String content = FileUtils.readTextAllContent(file);
		JSONObject object = JSONObject.parseObject(content);
		String[] names = STATION_NAMES.split("\\|");
		Integer total = names.length / 5;
		String[][] e_city = new String[total][5];
		for (int index = 0; index < names.length; index++) {
			if (index == (names.length - 1)) {
				continue;
			}
			String ele = names[index];
			Integer col = index / 5;
			e_city[col][index % 5] = ele;
		}
		Map<String, String> m = new HashMap<String, String>();
		Map<String, String> c = new HashMap<String, String>();

		for (int index = 0; index < total; index++) {
			String name = e_city[index][1];
			String code = e_city[index][2];
			m.put(name, code);
			c.put(code, name);

		}

		// 以三亚站 作为全国铁路最南端起点
		JSONArray array = (JSONArray) object.get("G");
		CookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient closeableClient = HttpClients.custom()
				.setDefaultCookieStore(cookieStore).build();
		for (int index = 0; index < array.size(); index++) {
			JSONObject obj = (JSONObject) array.get(index);
			String train_no = obj.getString("train_no");
			String train_code = obj.getString("station_train_code");
			int end = train_code.indexOf("(");
			String code = train_code.substring(0, end);
			String name = train_code
					.substring(end + 1, train_code.length() - 1);
			String F = m.get(name.split("-")[0]);
			String T = m.get(name.split("-")[1]);
			String url = "https://kyfw.12306.cn/otn/czxx/queryByTrainNo?train_no="
					+ train_no
					+ "&from_station_telecode="
					+ F
					+ "&to_station_telecode=" + T + "&depart_date=2018-05-25";
			HttpGet request = new HttpGet(url);
			try {
				HttpResponse response = closeableClient.execute(request);
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					String results = EntityUtils.toString(response.getEntity());
					FileUtils.createFile("C://12306//GAP//" + F + "_" + T
							+ ".txt", results);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}

	/**
	 * 获取高德地图信息
	 */
	@Test
	public void getGdMapData() {
		String[] names = STATION_NAMES.split("\\|");
		Integer total = names.length / 5;
		String[][] e_city = new String[total][5];
		for (int index = 0; index < names.length; index++) {
			if (index == (names.length - 1)) {
				continue;
			}
			String ele = names[index];
			Integer col = index / 5;
			e_city[col][index % 5] = ele;
		}
		for (int index = 0; index < total; index++) {
			String name = e_city[index][1];
			String code = e_city[index][2];
			System.out.println(name);
			CloseableHttpClient closeableClient = null;
			Header[] headers = null;
			try {
				name = name + "站";
				String url = "https://www.amap.com/service/poiInfo?query_type=TQUERY&keywords="
						+ name;
				CookieStore cookieStore = new BasicCookieStore();
				closeableClient = HttpClients.custom()
						.setDefaultCookieStore(cookieStore).build();
				HttpGet request = new HttpGet(url);
				HttpResponse response;
				response = closeableClient.execute(request);
				headers = response.getAllHeaders();
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					String results = EntityUtils.toString(response.getEntity());
					JSONObject object = JSONObject.parseObject(results);
					if ("too fast".equals(object.get("data"))) {
						System.out.println(object);
					}
					FileUtils.createFile("C://12306//" + name + "_" + code
							+ ".txt", results);
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Test
	public void get12306Data() {
		String[] names = STATION_NAMES.split("\\|");
		Integer total = names.length / 5;
		String[][] e_city = new String[total][5];
		for (int index = 0; index < names.length; index++) {
			if (index == (names.length - 1)) {
				continue;
			}
			String ele = names[index];
			Integer col = index / 5;
			e_city[col][index % 5] = ele;
		}
		// 总的情况
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String train_date = format.format(date);
		String mainUrl = "https://kyfw.12306.cn/otn/leftTicket/init";

		CloseableHttpClient closeableClient = null;

		Header[] headers = null;
		try {
			//
			// SSLContext sslcontext = createIgnoreVerifySSL();
			// // 设置协议http和https对应的处理socket链接工厂的对象
			// Registry<ConnectionSocketFactory> socketFactoryRegistry =
			// RegistryBuilder.<ConnectionSocketFactory>create()
			// .register("http", PlainConnectionSocketFactory.INSTANCE)
			// .register("https", new SSLConnectionSocketFactory(sslcontext))
			// .build();
			// PoolingHttpClientConnectionManager connManager = new
			// PoolingHttpClientConnectionManager(socketFactoryRegistry);
			// HttpClients.custom().setConnectionManager(connManager);
			// client =
			// HttpClients.custom().setConnectionManager(connManager).build();
			//
			CookieStore cookieStore = new BasicCookieStore();
			closeableClient = HttpClients.custom()
					.setDefaultCookieStore(cookieStore).build();
			HttpGet request = new HttpGet(mainUrl);
			HttpResponse response = closeableClient.execute(request);
			headers = response.getAllHeaders();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int index = 0; index < total; index++) {
			for (int k = 0; k < total; k++) {
				if (index == k) {
					continue;
				}
				String from = e_city[index][2];
				String to = e_city[k][2];
				String url = "https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date="
						+ train_date
						+ "&leftTicketDTO.from_station="
						+ from
						+ "&leftTicketDTO.to_station="
						+ to
						+ "&purpose_codes=ADULT";
				String results = "";
				try {
					HttpClient client = HttpClients.createDefault();
					HttpGet request = new HttpGet(url);
					HttpResponse response = client.execute(request);
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						results = EntityUtils.toString(response.getEntity());
						try {
							JSONObject object = JSONObject.parseObject(results);
							FileUtils.createFile("C://12306//" + from + "_"
									+ to + ".txt", results);
						} catch (Exception e) {
							System.out.println("解析错误");
						}

					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 绕过验证
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	public static SSLContext createIgnoreVerifySSL()
			throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("SSLv3");

		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(
					java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
					String paramString) throws CertificateException {
			}

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		sc.init(null, new TrustManager[] { trustManager }, null);
		return sc;
	}

	private String STATION_NAMES = "@bjb|北京北|VAP|beijingbei|bjb|"
			+ "0@bjd|北京东|BOP|beijingdong|bjd|"
			+ "1@bji|北京|BJP|beijing|bj|"
			+ "2@bjn|北京南|VNP|beijingnan|bjn|"
			+ "3@bjx|北京西|BXP|beijingxi|bjx|"
			+ "4@gzn|广州南|IZQ|guangzhounan|gzn|"
			+ "5@cqb|重庆北|CUW|chongqingbei|cqb|"
			+ "6@cqi|重庆|CQW|chongqing|cq|"
			+ "7@cqn|重庆南|CRW|chongqingnan|cqn|"
			+ "8@cqx|重庆西|CXW|chongqingxi|cqx|"
			+ "9@gzd|广州东|GGQ|guangzhoudong|gzd|"
			+ "10@sha|上海|SHH|shanghai|sh|"
			+ "11@shn|上海南|SNH|shanghainan|shn|"
			+ "12@shq|上海虹桥|AOH|shanghaihongqiao|shhq|"
			+ "13@shx|上海西|SXH|shanghaixi|shx|"
			+ "14@tjb|天津北|TBP|tianjinbei|tjb|"
			+ "15@tji|天津|TJP|tianjin|tj|"
			+ "16@tjn|天津南|TIP|tianjinnan|tjn|"
			+ "17@tjx|天津西|TXP|tianjinxi|tjx|"
			+ "18@cch|长春|CCT|changchun|cc|"
			+ "19@ccn|长春南|CET|changchunnan|ccn|"
			+ "20@ccx|长春西|CRT|changchunxi|ccx|"
			+ "21@cdd|成都东|ICW|chengdudong|cdd|"
			+ "22@cdn|成都南|CNW|chengdunan|cdn|"
			+ "23@cdu|成都|CDW|chengdu|cd|"
			+ "24@csh|长沙|CSQ|changsha|cs|"
			+ "25@csn|长沙南|CWQ|changshanan|csn|"
			+ "26@fzh|福州|FZS|fuzhou|fz|27@fzn|福州南|FYS|fuzhounan|fzn|28@gya|贵阳|GIW|guiyang|gy|29@gzh|广州|GZQ|guangzhou|gz|"
			+ "30@gzx|广州西|GXQ|guangzhouxi|gzx|31@heb|哈尔滨|HBB|haerbin|heb|32@hed|哈尔滨东|VBB|haerbindong|hebd|"
			+ "33@hex|哈尔滨西|VAB|haerbinxi|hebx|34@hfe|合肥|HFH|hefei|hf|35@hfx|合肥西|HTH|hefeixi|hfx|36@hhd|呼和浩特东|NDC|huhehaotedong|hhhtd|"
			+ "37@hht|呼和浩特|HHC|huhehaote|hhht|38@hkd|海口东|KEQ|haikoudong|hkd|39@hkd|海口东|HMQ|haikoudong|hkd|40@hko|海口|VUQ|haikou|hk|"
			+ "41@hzd|杭州东|HGH|hangzhoudong|hzd|42@hzh|杭州|HZH|hangzhou|hz|43@hzn|杭州南|XHH|hangzhounan|hzn|44@jna|济南|JNK|jinan|jn|"
			+ "45@jnd|济南东|JAK|jinandong|jnd|46@jnx|济南西|JGK|jinanxi|jnx|47@kmi|昆明|KMM|kunming|km|48@kmx|昆明西|KXM|kunmingxi|kmx|"
			+ "49@lsa|拉萨|LSO|lasa|ls|50@lzd|兰州东|LVJ|lanzhoudong|lzd|51@lzh|兰州|LZJ|lanzhou|lz|52@lzx|兰州西|LAJ|lanzhouxi|lzx|"
			+ "53@nch|南昌|NCG|nanchang|nc|54@nji|南京|NJH|nanjing|nj|55@njn|南京南|NKH|nanjingnan|njn|56@nni|南宁|NNZ|nanning|nn|"
			+ "57@sjb|石家庄北|VVP|shijiazhuangbei|sjzb|58@sjz|石家庄|SJP|shijiazhuang|sjz|"
			+ "59@sya|沈阳|SYT|shenyang|sy|60@syb|沈阳北|SBT|shenyangbei|syb|61@syd|沈阳东|SDT|shenyangdong|syd|62@syn|沈阳南|SOT|shenyangnan|syn|"
			+ "63@tyb|太原北|TBV|taiyuanbei|tyb|64@tyd|太原东|TDV|taiyuandong|tyd|65@tyu|太原|TYV|taiyuan|ty|66@wha|武汉|WHN|wuhan|wh|"
			+ "67@wjx|王家营西|KNM|wangjiayingxi|wjyx|68@wln|乌鲁木齐南|WMR|wulumuqinan|wlmqn|69@xab|西安北|EAY|xianbei|xab|70@xan|西安|XAY|xian|xa|"
			+ "71@xan|西安南|CAY|xiannan|xan|72@xni|西宁|XNO|xining|xn|73@ych|银川|YIJ|yinchuan|yc|74@zzh|郑州|ZZF|zhengzhou|zz|"
			+ "75@aes|阿尔山|ART|aershan|aes|76@aka|安康|AKY|ankang|ak|77@aks|阿克苏|ASR|akesu|aks|78@alh|阿里河|AHX|alihe|alh|"
			+ "79@alk|阿拉山口|AKR|alashankou|alsk|80@api|安平|APT|anping|ap|81@aqi|安庆|AQH|anqing|aq|82@ash|安顺|ASW|anshun|as|"
			+ "83@ash|鞍山|AST|anshan|as|84@aya|安阳|AYF|anyang|ay|85@ban|北安|BAB|beian|ba|86@bbu|蚌埠|BBH|bengbu|bb|87@bch|白城|BCT|baicheng|bc|"
			+ "88@bha|北海|BHZ|beihai|bh|89@bhe|白河|BEL|baihe|bh|90@bji|白涧|BAP|baijian|bj|91@bji|宝鸡|BJY|baoji|bj|92@bji|滨江|BJB|binjiang|bj|"
			+ "93@bkt|博克图|BKX|boketu|bkt|94@bse|百色|BIZ|baise|bs|95@bss|白山市|HJL|baishanshi|bss|96@bta|北台|BTT|beitai|bt|"
			+ "97@btd|包头东|BDC|baotoudong|btd|98@bto|包头|BTC|baotou|bt|99@bts|北屯市|BXR|beitunshi|bts|100@bxi|本溪|BXT|benxi|bx|"
			+ "101@byb|白云鄂博|BEC|baiyunebo|byeb|102@byx|白银西|BXJ|baiyinxi|byx|103@bzh|亳州|BZH|bozhou|bz|104@cbi|赤壁|CBN|chibi|cb|"
			+ "105@cde|常德|VGQ|changde|cd|106@cde|承德|CDP|chengde|cd|107@cdi|长甸|CDT|changdian|cd|108@cfe|赤峰|CFD|chifeng|cf|"
			+ "109@cli|茶陵|CDG|chaling|cl|110@cna|苍南|CEH|cangnan|cn|111@cpi|昌平|CPP|changping|cp|112@cre|崇仁|CRG|chongren|cr|"
			+ "113@ctu|昌图|CTT|changtu|ct|114@ctz|长汀镇|CDB|changtingzhen|ctz|115@cxi|曹县|CXK|caoxian|cx|116@cxn|楚雄南|COM|chuxiongnan|cxn|117@cxt|陈相屯|CXT|chenxiangtun|cxt|118@czb|长治北|CBF|changzhibei|czb|119@czh|池州|IYH|chizhou|cz|120@czh|长征|CZJ|changzheng|cz|121@czh|常州|CZH|changzhou|cz|122@czh|郴州|CZQ|chenzhou|cz|123@czh|长治|CZF|changzhi|cz|124@czh|沧州|COP|cangzhou|cz|125@czu|崇左|CZZ|chongzuo|cz|126@dab|大安北|RNT|daanbei|dab|127@dch|大成|DCT|dacheng|dc|128@ddo|丹东|DUT|dandong|dd|129@dfh|东方红|DFB|dongfanghong|dfh|130@dgd|东莞东|DMQ|dongguandong|dgd|131@dhs|大虎山|DHD|dahushan|dhs|132@dhu|敦煌|DHJ|dunhuang|dh|133@dhu|敦化|DHL|dunhua|dh|134@dhu|德惠|DHT|dehui|dh|135@djc|东京城|DJB|dongjingcheng|djc|136@dji|大涧|DFP|dajian|dj|137@djy|都江堰|DDW|dujiangyan|djy|138@dlb|大连北|DFT|dalianbei|dlb|139@dli|大理|DKM|dali|dl|140@dli|大连|DLT|dalian|dl|141@dna|定南|DNG|dingnan|dn|142@dqi|大庆|DZX|daqing|dq|143@dsh|东胜|DOC|dongsheng|ds|144@dsq|大石桥|DQT|dashiqiao|dsq|145@dto|大同|DTV|datong|dt|146@dyi|东营|DPK|dongying|dy|147@dys|大杨树|DUX|dayangshu|dys|148@dyu|都匀|RYW|duyun|dy|149@dzh|邓州|DOF|dengzhou|dz|150@dzh|达州|RXW|dazhou|dz|151@dzh|德州|DZP|dezhou|dz|152@ejn|额济纳|EJC|ejina|ejn|153@eli|二连|RLC|erlian|el|154@esh|恩施|ESN|enshi|es|155@fdi|福鼎|FES|fuding|fd|156@fhc|凤凰机场|FJQ|fenghuangjichang|fhjc|157@fld|风陵渡|FLV|fenglingdu|fld|"
			+ "158@fli|涪陵|FLW|fuling|fl|159@flj|富拉尔基|FRX|fulaerji|flej|160@fsb|抚顺北|FET|fushunbei|fsb|161@fsh|佛山|FSQ|foshan|fs|162@fxn|阜新南|FXD|fuxinnan|fxn|163@fya|阜阳|FYH|fuyang|fy|164@gem|格尔木|GRO|geermu|gem|165@gha|广汉|GHW|guanghan|gh|166@gji|古交|GJV|gujiao|gj|167@glb|桂林北|GBZ|guilinbei|glb|168@gli|古莲|GRX|gulian|gl|169@gli|桂林|GLZ|guilin|gl|170@gsh|固始|GXN|gushi|gs|171@gsh|广水|GSN|guangshui|gs|172@gta|干塘|GNJ|gantang|gt|173@gyu|广元|GYW|guangyuan|gy|174@gzb|广州北|GBQ|guangzhoubei|gzb|175@gzh|赣州|GZG|ganzhou|gz|176@gzl|公主岭|GLT|gongzhuling|gzl|177@gzn|公主岭南|GBT|gongzhulingnan|gzln|178@han|淮安|AUH|huaian|ha|179@hbe|淮北|HRH|huaibei|hb|180@hbe|鹤北|HMB|hebei|hb|181@hbi|淮滨|HVN|huaibin|hb|182@hbi|河边|HBV|hebian|hb|183@hch|潢川|KCN|huangchuan|hc|184@hch|韩城|HCY|hancheng|hc|185@hda|邯郸|HDP|handan|hd|186@hdz|横道河子|HDB|hengdaohezi|hdhz|187@hga|鹤岗|HGB|hegang|hg|188@hgt|皇姑屯|HTT|huanggutun|hgt|189@hgu|红果|HEM|hongguo|hg|190@hhe|黑河|HJB|heihe|hh|191@hhu|怀化|HHQ|huaihua|hh|192@hko|汉口|HKN|hankou|hk|193@hld|葫芦岛|HLD|huludao|hld|194@hle|海拉尔|HRX|hailaer|hle|195@hll|霍林郭勒|HWD|huolinguole|hlgl|196@hlu|海伦|HLB|hailun|hl|197@hma|侯马|HMV|houma|hm|198@hmi|哈密|HMR|hami|hm|199@hna|淮南|HAH|huainan|hn|200@hna|桦南|HNB|huanan|hn|201@hnx|海宁西|EUH|hainingxi|hnx|202@hqi|鹤庆|HQM|heqing|hq|203@hrb|怀柔北|HBP|huairoubei|hrb|204@hro|怀柔|HRP|huairou|hr|"
			+ "205@hsd|黄石东|OSN|huangshidong|hsd|206@hsh|华山|HSY|huashan|hs|207@hsh|黄山|HKH|huangshan|hs|208@hsh|黄石|HSN|huangshi|hs|209@hsh|衡水|HSP|hengshui|hs|210@hya|衡阳|HYQ|hengyang|hy|211@hze|菏泽|HIK|heze|hz|212@hzh|贺州|HXZ|hezhou|hz|213@hzh|汉中|HOY|hanzhong|hz|214@hzh|惠州|HCQ|huizhou|hz|215@jan|吉安|VAG|jian|ja|216@jan|集安|JAL|jian|ja|217@jbc|江边村|JBG|jiangbiancun|jbc|218@jch|晋城|JCF|jincheng|jc|219@jcj|金城江|JJZ|jinchengjiang|jcj|220@jdz|景德镇|JCG|jingdezhen|jdz|221@jfe|嘉峰|JFF|jiafeng|jf|222@jgq|加格达奇|JGX|jiagedaqi|jgdq|223@jgs|井冈山|JGG|jinggangshan|jgs|224@jhe|蛟河|JHL|jiaohe|jh|225@jhn|金华南|RNH|jinhuanan|jhn|226@jhu|金华|JBH|jinhua|jh|227@jji|九江|JJG|jiujiang|jj|228@jli|吉林|JLL|jilin|jl|229@jme|荆门|JMN|jingmen|jm|230@jms|佳木斯|JMB|jiamusi|jms|231@jni|济宁|JIK|jining|jn|232@jnn|集宁南|JAC|jiningnan|jnn|233@jqu|酒泉|JQJ|jiuquan|jq|234@jsh|江山|JUH|jiangshan|js|235@jsh|吉首|JIQ|jishou|js|236@jta|九台|JTL|jiutai|jt|237@jts|镜铁山|JVJ|jingtieshan|jts|238@jxi|鸡西|JXB|jixi|jx|239@jxx|绩溪县|JRH|jixixian|jxx|240@jyg|嘉峪关|JGJ|jiayuguan|jyg|241@jyo|江油|JFW|jiangyou|jy|242@jzh|锦州|JZD|jinzhou|jz|243@jzh|金州|JZT|jinzhou|jz|244@jzh|蓟州|JKP|jizhou|jz|245@kel|库尔勒|KLR|kuerle|kel|246@kfe|开封|KFF|kaifeng|kf|247@kla|岢岚|KLV|kelan|kl|248@kli|凯里|KLW|kaili|kl|249@ksh|喀什|KSR|kashi|ks|250@ksn|昆山南|KNH|kunshannan|ksn|251@ktu|奎屯|KTR|kuitun|kt|252@kyu|开原|KYT|kaiyuan|ky|253@lan|六安|UAH|luan|la|254@lba|灵宝|LBF|lingbao|lb|255@lcg|芦潮港|UCH|luchaogang|lcg|256@lch|隆昌|LCW|longchang|lc|257@lch|陆川|LKZ|luchuan|lc|258@lch|利川|LCN|lichuan|lc|"
			+ "259@lch|临川|LCG|linchuan|lc|260@lch|潞城|UTP|lucheng|lc|261@lda|鹿道|LDL|ludao|ld|262@ldi|娄底|LDQ|loudi|ld|263@lfe|临汾|LFV|linfen|lf|264@lgz|良各庄|LGP|lianggezhuang|lgz|265@lhe|临河|LHC|linhe|lh|266@lhe|漯河|LON|luohe|lh|267@lhu|绿化|LWJ|lvhua|lh|268@lhu|隆化|UHP|longhua|lh|269@lji|丽江|LHM|lijiang|lj|270@lji|临江|LQL|linjiang|lj|271@lji|龙井|LJL|longjing|lj|272@lli|吕梁|LHV|lvliang|ll|273@lli|醴陵|LLG|liling|ll|274@lln|柳林南|LKV|liulinnan|lln|275@lpi|滦平|UPP|luanping|lp|276@lps|六盘水|UMW|liupanshui|lps|277@lqi|灵丘|LVV|lingqiu|lq|278@lsh|旅顺|LST|lvshun|ls|279@lxi|兰溪|LWH|lanxi|lx|280@lxi|陇西|LXJ|longxi|lx|281@lxi|澧县|LEQ|lixian|lx|282@lxi|临西|UEP|linxi|lx|283@lya|龙岩|LYS|longyan|ly|284@lya|耒阳|LYQ|leiyang|ly|285@lya|洛阳|LYF|luoyang|ly|286@lyd|连云港东|UKH|lianyungangdong|lygd|287@lyd|洛阳东|LDF|luoyangdong|lyd|288@lyi|临沂|LVK|linyi|ly|289@lym|洛阳龙门|LLF|luoyanglongmen|lylm|290@lyu|柳园|DHR|liuyuan|ly|291@lyu|凌源|LYD|lingyuan|ly|"
			+ "292@lyu|辽源|LYL|liaoyuan|ly|293@lzh|立志|LZX|lizhi|lz|294@lzh|柳州|LZZ|liuzhou|lz|295@lzh|辽中|LZD|liaozhong|lz|296@mch|麻城|MCN|macheng|mc|297@mdh|免渡河|MDX|mianduhe|mdh|298@mdj|牡丹江|MDB|mudanjiang|mdj|299@meg|莫尔道嘎|MRX|moerdaoga|medg|300@mgu|明光|MGH|mingguang|mg|301@mgu|满归|MHX|mangui|mg|302@mhe|漠河|MVX|mohe|mh|303@mmi|茂名|MDQ|maoming|mm|304@mmx|茂名西|MMZ|maomingxi|mmx|305@msh|密山|MSB|mishan|ms|306@msj|马三家|MJT|masanjia|msj|307@mwe|麻尾|VAW|mawei|mw|308@mya|绵阳|MYW|mianyang|my|309@mzh|梅州|MOQ|meizhou|mz|310@mzl|满洲里|MLX|manzhouli|mzl|311@nbd|宁波东|NVH|ningbodong|nbd|312@nbo|宁波|NGH|ningbo|nb|313@nch|南岔|NCB|nancha|nc|314@nch|南充|NCW|nanchong|nc|315@nda|南丹|NDZ|nandan|nd|316@ndm|南大庙|NMP|nandamiao|ndm|317@nfe|南芬|NFT|nanfen|nf|318@nhe|讷河|NHX|nehe|nh|319@nji|嫩江|NGX|nenjiang|nj|320@nji|内江|NJW|neijiang|nj|321@npi|南平|NPS|nanping|np|322@nto|南通|NUH|nantong|nt|323@nya|南阳|NFF|nanyang|ny|324@nzs|碾子山|NZX|nianzishan|nzs|325@pds|平顶山|PEN|pingdingshan|pds|326@pji|盘锦|PVD|panjin|pj|327@pli|平凉|PIJ|pingliang|pl|328@pln|平凉南|POJ|pingliangnan|pln|329@pqu|平泉|PQP|pingquan|pq|330@psh|坪石|PSQ|pingshi|ps|331@pxi|萍乡|PXG|pingxiang|px|332@pxi|凭祥|PXZ|pingxiang|px|333@pxx|郫县西|PCW|pixianxi|pxx|334@pzh|攀枝花|PRW|panzhihua|pzh|335@qch|蕲春|QRN|qichun|qc|336@qcs|青城山|QSW|qingchengshan|qcs|337@qda|青岛|QDK|qingdao|qd|338@qhc|清河城|QYP|qinghecheng|qhc|339@qji|曲靖|QJM|qujing|qj|340@qji|黔江|QNW|qianjiang|qj|341@qjz|前进镇|QEB|qianjinzhen|qjz|342@qqe|齐齐哈尔|QHX|qiqihaer|qqhe|343@qth|七台河|QTB|qitaihe|qth|344@qxi|沁县|QVV|qinxian|qx|345@qzd|泉州东|QRS|quanzhoudong|qzd|346@qzh|泉州|QYS|quanzhou|qz|347@qzh|衢州|QEH|quzhou|qz|348@ran|融安|RAZ|rongan|ra|349@rjg|汝箕沟|RQJ|rujigou|rjg|350@rji|瑞金|RJG|ruijin|rj|351@rzh|日照|RZK|rizhao|rz|352@scp|双城堡|SCB|shuangchengpu|scp|353@sfh|绥芬河|SFB|suifenhe|sfh|354@sgd|韶关东|SGQ|shaoguandong|sgd|355@shg|山海关|SHD|shanhaiguan|shg|356@shu|绥化|SHB|suihua|sh|357@sjf|三间房|SFX|sanjianfang|sjf|358@sjt|苏家屯|SXT|sujiatun|sjt|359@sla|舒兰|SLL|shulan|sl|360@smi|三明|SMS|sanming|sm|361@smn|神木南|OMY|shenmunan|smn|362@smx|三门峡|SMF|sanmenxia|smx|363@sna|商南|ONY|shangnan|sn|364@sni|遂宁|NIW|suining|sn|365@spi|四平|SPT|siping|sp|366@sqi|商丘|SQF|shangqiu|sq|367@sra|上饶|SRG|shangrao|sr|368@ssh|韶山|SSQ|shaoshan|ss|369@sso|宿松|OAH|susong|ss|370@sto|汕头|OTQ|shantou|st|371@swu|邵武|SWS|shaowu|sw|372@sxi|涉县|OEP|shexian|sx|373@sya|三亚|SEQ|sanya|sy|374@sya|三亚|JUQ|sanya|sya|375@sya|邵阳|SYQ|shaoyang|sy|376@sya|十堰|SNN|shiyan|sy|377@sys|双鸭山|SSB|shuangyashan|sys|378@syu|松原|VYT|songyuan|sy|"
			+ "379@szh|苏州|SZH|suzhou|sz|380@szh|深圳|SZQ|shenzhen|sz|381@szh|宿州|OXH|suzhou|sz|382@szh|随州|SZN|suizhou|sz|383@szh|朔州|SUV|shuozhou|sz|384@szx|深圳西|OSQ|shenzhenxi|szx|385@tba|塘豹|TBQ|tangbao|tb|386@teq|塔尔气|TVX|taerqi|teq|387@tgu|潼关|TGY|tongguan|tg|388@tgu|塘沽|TGP|tanggu|tg|389@the|塔河|TXX|tahe|th|390@thu|通化|THL|tonghua|th|391@tla|泰来|TLX|tailai|tl|392@tlf|吐鲁番|TFR|tulufan|tlf|393@tli|通辽|TLD|tongliao|tl|394@tli|铁岭|TLT|tieling|tl|395@tlz|陶赖昭|TPT|taolaizhao|tlz|396@tme|图们|TML|tumen|tm|397@tre|铜仁|RDQ|tongren|tr|398@tsb|唐山北|FUP|tangshanbei|tsb|399@tsf|田师府|TFT|tianshifu|tsf|400@tsh|泰山|TAK|taishan|ts|401@tsh|唐山|TSP|tangshan|ts|402@tsh|天水|TSJ|tianshui|ts|403@typ|通远堡|TYT|tongyuanpu|typ|404@tys|太阳升|TQT|taiyangsheng|tys|405@tzh|泰州|UTH|taizhou|tz|406@tzi|桐梓|TZW|tongzi|tz|407@tzx|通州西|TAP|tongzhouxi|tzx|408@wch|五常|WCB|wuchang|wc|409@wch|武昌|WCN|wuchang|wc|410@wfd|瓦房店|WDT|wafangdian|wfd|411@wha|威海|WKK|weihai|wh|412@whu|芜湖|WHH|wuhu|wh|413@whx|乌海西|WXC|wuhaixi|whx|414@wjt|吴家屯|WJT|wujiatun|wjt|415@wlo|武隆|WLW|wulong|wl|416@wlt|乌兰浩特|WWT|wulanhaote|wlht|417@wna|渭南|WNY|weinan|wn|418@wsh|威舍|WSM|weishe|ws|419@wts|歪头山|WIT|waitoushan|wts|420@wwe|武威|WUJ|wuwei|ww|421@wwn|武威南|WWJ|wuweinan|wwn|422@wxi|无锡|WXH|wuxi|wx|423@wxi|乌西|WXR|wuxi|wx|424@wyl|乌伊岭|WPB|wuyiling|wyl|425@wys|武夷山|WAS|wuyishan|wys|426@wyu|万源|WYY|wanyuan|wy|427@wzh|万州|WYW|wanzhou|wz|"
			+ "428@wzh|梧州|WZZ|wuzhou|wz|429@wzh|温州|RZH|wenzhou|wz|430@wzn|温州南|VRH|wenzhounan|wzn|431@xch|西昌|ECW|xichang|xc|432@xch|许昌|XCF|xuchang|xc|433@xcn|西昌南|ENW|xichangnan|xcn|434@xfa|香坊|XFB|xiangfang|xf|435@xga|轩岗|XGV|xuangang|xg|436@xgu|兴国|EUG|xingguo|xg|437@xha|宣汉|XHY|xuanhan|xh|438@xhu|新会|EFQ|xinhui|xh|439@xhu|新晃|XLQ|xinhuang|xh|440@xlt|锡林浩特|XTC|xilinhaote|xlht|441@xlx|兴隆县|EXP|xinglongxian|xlx|442@xmb|厦门北|XKS|xiamenbei|xmb|443@xme|厦门|XMS|xiamen|xm|444@xmq|厦门高崎|XBS|xiamengaoqi|xmgq|445@xsh|小市|XST|xiaoshi|xs|446@xsh|秀山|ETW|xiushan|xs|447@xta|向塘|XTG|xiangtang|xt|448@xwe|宣威|XWM|xuanwei|xw|449@xxi|新乡|XXF|xinxiang|xx|450@xya|信阳|XUN|xinyang|xy|451@xya|咸阳|XYY|xianyang|xy|452@xya|襄阳|XFN|xiangyang|xy|453@xyc|熊岳城|XYT|xiongyuecheng|xyc|454@xyi|新沂|VIH|xinyi|xy|455@xyi|兴义|XRZ|xingyi|xy|456@xyu|新余|XUG|xinyu|xy|457@xzh|徐州|XCH|xuzhou|xz|458@yan|延安|YWY|yanan|ya|459@ybi|宜宾|YBW|yibin|yb|460@ybn|亚布力南|YWB|yabulinan|ybln|461@ybs|叶柏寿|YBD|yebaishou|ybs|462@ycd|宜昌东|HAN|yichangdong|ycd|463@ych|永川|YCW|yongchuan|yc|464@ych|盐城|AFH|yancheng|yc|465@ych|宜昌|YCN|yichang|yc|466@ych|运城|YNV|yuncheng|yc|467@ych|伊春|YCB|yichun|yc|468@yci|榆次|YCV|yuci|yc|469@ycu|杨村|YBP|yangcun|yc|470@ycx|宜春西|YCG|yichunxi|ycx|471@yes|伊尔施|YET|yiershi|yes|472@yga|燕岗|YGW|yangang|yg|473@yji|永济|YIV|yongji|yj|"
			+ "474@yji|延吉|YJL|yanji|yj|475@yko|营口|YKT|yingkou|yk|476@yks|牙克石|YKX|yakeshi|yks|477@yli|阎良|YNY|yanliang|yl|478@yli|玉林|YLZ|yulin|yl|479@yli|榆林|ALY|yulin|yl|480@ylw|亚龙湾|TWQ|yalongwan|ylw|481@ymp|一面坡|YPB|yimianpo|ymp|482@yni|伊宁|YMR|yining|yn|483@ypg|阳平关|YAY|yangpingguan|ypg|484@ypi|玉屏|YZW|yuping|yp|485@ypi|原平|YPV|yuanping|yp|486@yqi|延庆|YNP|yanqing|yq|487@yqq|阳泉曲|YYV|yangquanqu|yqq|488@yqu|玉泉|YQB|yuquan|yq|489@yqu|阳泉|AQP|yangquan|yq|490@ysh|营山|NUW|yingshan|ys|491@ysh|玉山|YNG|yushan|ys|492@ysh|燕山|AOP|yanshan|ys|493@ysh|榆树|YRT|yushu|ys|494@yta|鹰潭|YTG|yingtan|yt|495@yta|烟台|YAK|yantai|yt|496@yth|伊图里河|YEX|yitulihe|ytlh|497@ytx|玉田县|ATP|yutianxian|ytx|498@ywu|义乌|YWH|yiwu|yw|499@yxi|阳新|YON|yangxin|yx|500@yxi|义县|YXD|yixian|yx|501@yya|益阳|AEQ|yiyang|yy|502@yya|岳阳|YYQ|yueyang|yy|503@yzh|崖州|YUQ|yazhou|yz|504@yzh|永州|AOQ|yongzhou|yz|505@yzh|扬州|YLH|yangzhou|yz|506@zbo|淄博|ZBK|zibo|zb|507@zcd|镇城底|ZDV|zhenchengdi|zcd|508@zgo|自贡|ZGW|zigong|zg|509@zha|珠海|ZHQ|zhuhai|zh|510@zhb|珠海北|ZIQ|zhuhaibei|zhb|511@zji|湛江|ZJZ|zhanjiang|zj|512@zji|镇江|ZJH|zhenjiang|zj|513@zjj|张家界|DIQ|zhangjiajie|zjj|514@zjk|张家口|ZKP|zhangjiakou|zjk|515@zjn|张家口南|ZMP|zhangjiakounan|zjkn|516@zko|周口|ZKN|zhoukou|zk|517@zlm|哲里木|ZLC|zhelimu|zlm|518@zlt|扎兰屯|ZTX|zhalantun|zlt|519@zmd|驻马店|ZDN|zhumadian|zmd|520@zqi|肇庆|ZVQ|zhaoqing|zq|521@zsz|周水子|ZIT|zhoushuizi|zsz|522@zto|昭通|ZDW|zhaotong|zt|523@zwe|中卫|ZWJ|zhongwei|zw|524@zya|资阳|ZYW|ziyang|zy|525@zyx|遵义西|ZIW|zunyixi|zyx|526@zzh|枣庄|ZEK|zaozhuang|zz|527@zzh|资中|ZZW|zizhong|zz|528@zzh|株洲|ZZQ|zhuzhou|zz|529@zzx|枣庄西|ZFK|zaozhuangxi|zzx|530@aax|昂昂溪|AAX|angangxi|aax|531@ach|阿城|ACB|acheng|ac|532@ada|安达|ADX|anda|ad|533@ade|安德|ARW|ande|ad|534@adi|安定|ADP|anding|ad|535@adu|安多|ADO|anduo|ad|536@agu|安广|AGT|anguang|ag|537@aha|敖汉|YED|aohan|ah|538@ahe|艾河|AHP|aihe|ah|539@ahu|安化|PKQ|anhua|ah|540@ajc|艾家村|AJJ|aijiacun|ajc|541@aji|鳌江|ARH|aojiang|aj|542@aji|安家|AJB|anjia|aj|543@aji|阿金|AJD|ajin|aj|544@aji|安靖|PYW|anjing|aj|545@akt|阿克陶|AER|aketao|akt|546@aky|安口窑|AYY|ankouyao|aky|547@alg|敖力布告|ALD|aolibugao|albg|548@alo|安龙|AUZ|anlong|al|549@als|阿龙山|ASX|alongshan|als|550@alu|安陆|ALN|anlu|al|551@ame|阿木尔|JTX|amuer|ame|552@anz|阿南庄|AZM|ananzhuang|anz|553@aqx|安庆西|APH|anqingxi|aqx|554@asx|鞍山西|AXT|anshanxi|asx|555@ata|安塘|ATV|antang|at|556@atb|安亭北|ASH|antingbei|atb|557@ats|阿图什|ATR|atushi|ats|558@atu|安图|ATL|antu|at|559@axi|安溪|AXS|anxi|ax|560@bao|博鳌|BWQ|boao|ba|561@bbe|北碚|BPW|beibei|bb|562@bbg|白壁关|BGV|baibiguan|bbg|563@bbn|蚌埠南|BMH|bengbunan|bbn|564@bch|巴楚|BCR|bachu|bc|565@bch|板城|BUP|bancheng|bc|566@bdh|北戴河|BEP|beidaihe|bdh|"
			+ "567@bdi|保定|BDP|baoding|bd|568@bdi|宝坻|BPP|baodi|bd|569@bdl|八达岭|ILP|badaling|bdl|570@bdo|巴东|BNN|badong|bd|571@bgu|柏果|BGM|baiguo|bg|572@bha|布海|BUT|buhai|bh|573@bhd|白河东|BIY|baihedong|bhd|574@bho|贲红|BVC|benhong|bh|575@bhs|宝华山|BWH|baohuashan|bhs|576@bhx|白河县|BEY|baihexian|bhx|577@bjg|白芨沟|BJJ|baijigou|bjg|578@bjg|碧鸡关|BJM|bijiguan|bjg|579@bji|北滘|IBQ|beijiao|bj|580@bji|碧江|BLQ|bijiang|bj|581@bjp|白鸡坡|BBM|baijipo|bjp|"
			+ "582@bjs|笔架山|BSB|bijiashan|bjs|583@bjt|八角台|BTD|bajiaotai|bjt|584@bka|保康|BKD|baokang|bk|585@bkp|白奎堡|BKB|baikuipu|bkp|586@bla|白狼|BAT|bailang|bl|587@bla|百浪|BRZ|bailang|bl|588@ble|博乐|BOR|bole|bl|"
			+ "589@blg|宝拉格|BQC|baolage|blg|590@bli|巴林|BLX|balin|bl|591@bli|宝林|BNB|baolin|bl|592@bli|北流|BOZ|beiliu|bl|593@bli|勃利|BLB|boli|bl|594@blk|布列开|BLR|buliekai|blk|595@bls|宝龙山|BND|baolongshan|bls|596@blx|百里峡|AAP|bailixia|blx|597@bmc|八面城|BMD|bamiancheng|bmc|598@bmq|班猫箐|BNM|banmaoqing|bmq|599@bmt|八面通|BMB|bamiantong|bmt|600@bmz|北马圈子|BRP|beimaquanzi|bmqz|601@bpn|北票南|RPD|beipiaonan|bpn|602@bqi|白旗|BQP|baiqi|bq|603@bql|宝泉岭|BQB|baoquanling|bql|604@bqu|白泉|BQL|baiquan|bq|605@bsh|巴山|BAY|bashan|bs|606@bsj|白水江|BSY|baishuijiang|bsj|607@bsp|白沙坡|BPM|baishapo|bsp|608@bss|白石山|BAL|baishishan|bss|609@bsz|白水镇|BUM|baishuizhen|bsz|610@btd|包头东|FDC|baotoudong|btd|611@bti|坂田|BTQ|bantian|bt|612@bto|泊头|BZP|botou|bt|613@btu|北屯|BYP|beitun|bt|614@bxh|本溪湖|BHT|benxihu|bxh|615@bxi|博兴|BXK|boxing|bx|"
			+ "616@bxt|八仙筒|VXD|baxiantong|bxt|617@byg|白音察干|BYC|baiyinchagan|bycg|618@byh|背荫河|BYB|beiyinhe|byh|619@byi|北营|BIV|beiying|by|620@byl|巴彦高勒|BAC|bayangaole|bygl|621@byl|白音他拉|BID|baiyintala|bytl|622@byq|鲅鱼圈|BYT|bayuquan|byq|623@bys|白银市|BNJ|baiyinshi|bys|624@bys|白音胡硕|BCD|baiyinhushuo|byhs|625@bzh|巴中|IEW|bazhong|bz|626@bzh|霸州|RMP|bazhou|bz|627@bzh|北宅|BVP|beizhai|bz|628@cbb|赤壁北|CIN|chibibei|cbb|629@cbg|查布嘎|CBC|chabuga|cbg|630@cch|长城|CEJ|changcheng|cc|631@cch|长冲|CCM|changchong|cc|632@cdd|承德东|CCP|chengdedong|cdd|633@cfx|赤峰西|CID|chifengxi|cfx|634@cga|嵯岗|CAX|cuogang|cg|635@cga|柴岗|CGT|chaigang|cg|636@cge|长葛|CEF|changge|cg|637@cgp|柴沟堡|CGV|chaigoupu|cgp|638@cgu|城固|CGY|chenggu|cg|639@cgy|陈官营|CAJ|chenguanying|cgy|640@cgz|成高子|CZB|chenggaozi|cgz|641@cha|草海|WBW|caohai|ch|642@che|柴河|CHB|chaihe|ch|643@che|册亨|CHZ|ceheng|ch|644@chk|草河口|CKT|caohekou|chk|645@chk|崔黄口|CHP|cuihuangkou|chk|646@chu|巢湖|CIH|chaohu|ch|647@cjg|蔡家沟|CJT|caijiagou|cjg|648@cjh|成吉思汗|CJX|chengjisihan|cjsh|649@cji|岔江|CAM|chajiang|cj|650@cjp|蔡家坡|CJY|caijiapo|cjp|651@cle|昌乐|CLK|changle|cl|652@clg|超梁沟|CYP|chaolianggou|clg|653@cli|慈利|CUQ|cili|cl|654@cli|昌黎|CLP|changli|cl|655@clz|长岭子|CLT|changlingzi|clz|656@cmi|晨明|CMB|chenming|cm|657@cno|长农|CNJ|changnong|cn|658@cpb|昌平北|VBP|changpingbei|cpb|659@cpi|常平|DAQ|changping|cp|660@cpl|长坡岭|CPM|changpoling|cpl|661@cqi|辰清|CQB|chenqing|cq|662@csh|蔡山|CON|caishan|cs|663@csh|楚山|CSB|chushan|cs|664@csh|长寿|EFW|changshou|cs|665@csh|磁山|CSP|cishan|cs|666@csh|苍石|CST|cangshi|cs|667@csh|草市|CSL|caoshi|cs|668@csq|察素齐|CSC|chasuqi|csq|669@cst|长山屯|CVT|changshantun|cst|670@cti|长汀|CES|changting|ct|671@ctn|朝天南|CTY|chaotiannan|ctn|672@ctx|昌图西|CPT|changtuxi|ctx|673@cwa|春湾|CQQ|chunwan|cw|674@cxi|磁县|CIP|cixian|cx|675@cxi|岑溪|CNZ|cenxi|cx|676@cxi|辰溪|CXQ|chenxi|cx|677@cxi|磁西|CRP|cixi|cx|678@cxn|长兴南|CFH|changxingnan|cxn|679@cya|磁窑|CYK|ciyao|cy|680@cya|春阳|CAL|chunyang|cy|681@cya|城阳|CEK|chengyang|cy|682@cyc|创业村|CEX|chuangyecun|cyc|683@cyc|朝阳川|CYL|chaoyangchuan|cyc|684@cyd|朝阳地|CDD|chaoyangdi|cyd|685@cyn|朝阳南|CYD|chaoyangnan|cyn|686@cyu|长垣|CYF|changyuan|cy|687@cyz|朝阳镇|CZL|chaoyangzhen|cyz|688@czb|滁州北|CUH|chuzhoubei|czb|689@czb|常州北|ESH|changzhoubei|czb|690@czh|滁州|CXH|chuzhou|cz|691@czh|潮州|CKQ|chaozhou|cz|692@czh|常庄|CVK|changzhuang|cz|693@czl|曹子里|CFP|caozili|czl|694@czw|车转湾|CWM|chezhuanwan|czw|695@czx|郴州西|ICQ|chenzhouxi|czx|696@czx|沧州西|CBP|cangzhouxi|czx|697@dan|德安|DAG|dean|da|698@dan|大安|RAT|daan|da|699@dba|大坝|DBJ|daba|db|700@dba|大板|DBC|daban|db|701@dba|大巴|DBD|daba|db|702@dba|到保|RBT|daobao|db|703@dbi|定边|DYJ|dingbian|db|704@dbj|东边井|DBB|dongbianjing|dbj|705@dbs|德伯斯|RDT|debosi|dbs|706@dcg|打柴沟|DGJ|dachaigou|dcg|707@dch|德昌|DVW|dechang|dc|708@dda|滴道|DDB|didao|dd|709@ddg|大磴沟|DKJ|dadenggou|ddg|710@ded|刀尔登|DRD|daoerdeng|ded|711@dee|得耳布尔|DRX|deerbuer|debe|712@det|杜尔伯特|TKX|duerbote|tk|713@dfa|东方|UFQ|dongfang|df|714@dfe|丹凤|DGY|danfeng|df|715@dfe|东丰|DIL|dongfeng|df|716@dge|都格|DMM|duge|dg|717@dgt|大官屯|DTT|daguantun|dgt|718@dgu|大关|RGW|daguan|dg|719@dgu|东光|DGP|dongguang|dg|720@dha|东海|DHB|donghai|dh|721@dhc|大灰厂|DHP|dahuichang|dhc|722@dhq|大红旗|DQD|dahongqi|dhq|723@dht|大禾塘|SOQ|shaodong|dh|724@dhx|东海县|DQH|donghaixian|dhx|725@dhx|德惠西|DXT|dehuixi|dhx|726@djg|达家沟|DJT|dajiagou|djg|727@dji|东津|DKB|dongjin|dj|728@dji|杜家|DJL|dujia|dj|729@dkt|大口屯|DKP|dakoutun|dkt|730@dla|东来|RVD|donglai|dl|731@dlh|德令哈|DHO|delingha|dlh|732@dlh|大陆号|DLC|daluhao|dlh|733@dli|带岭|DLB|dailing|dl|734@dli|大林|DLD|dalin|dl|735@dlq|达拉特旗|DIC|dalateqi|dltq|736@dlt|独立屯|DTX|dulitun|dlt|737@dlu|豆罗|DLV|douluo|dl|"
			+ "738@dlx|达拉特西|DNC|dalatexi|dltx|739@dlx|大连西|GZT|dalianxi|dlx|740@dmc|东明村|DMD|dongmingcun|dmc|741@dmh|洞庙河|DEP|dongmiaohe|dmh|742@dmx|东明县|DNF|dongmingxian|dmx|743@dni|大拟|DNZ|dani|dn|744@dpf|大平房|DPD|dapingfang|dpf|745@dps|大盘石|RPP|dapanshi|dps|746@dpu|大埔|DPI|dapu|dp|747@dpu|大堡|DVT|dapu|dp|748@dqd|大庆东|LFX|daqingdong|dqd|749@dqh|大其拉哈|DQX|daqilaha|dqlh|750@dqi|道清|DML|daoqing|dq|751@dqs|对青山|DQB|duiqingshan|dqs|752@dqx|德清西|MOH|deqingxi|dqx|753@dqx|大庆西|RHX|daqingxi|dqx|754@dsh|东升|DRQ|dongsheng|ds|755@dsh|砀山|DKH|dangshan|ds|756@dsh|独山|RWW|dushan|ds|757@dsh|登沙河|DWT|dengshahe|dsh|758@dsp|读书铺|DPM|dushupu|dsp|759@dst|大石头|DSL|dashitou|dst|760@dsx|东胜西|DYC|dongshengxi|dsx|761@dsz|大石寨|RZT|dashizhai|dsz|762@dta|东台|DBH|dongtai|dt|763@dta|定陶|DQK|dingtao|dt|764@dta|灯塔|DGT|dengta|dt|765@dtb|大田边|DBM|datianbian|dtb|766@dth|东通化|DTL|dongtonghua|dth|767@dtu|丹徒|RUH|dantu|dt|768@dtu|大屯|DNT|datun|dt|769@dwa|东湾|DRJ|dongwan|dw|770@dwk|大武口|DFJ|dawukou|dwk|771@dwp|低窝铺|DWJ|diwopu|dwp|772@dwt|大王滩|DZZ|dawangtan|dwt|773@dwz|大湾子|DFM|dawanzi|dwz|774@dxg|大兴沟|DXL|daxinggou|dxg|775@dxi|大兴|DXX|daxing|dx|776@dxi|定西|DSJ|dingxi|dx|777@dxi|甸心|DXM|dianxin|dx|778@dxi|东乡|DXG|dongxiang|dx|779@dxi|代县|DKV|daixian|dx|780@dxi|定襄|DXV|dingxiang|dx|781@dxu|东戌|RXP|dongxu|dx|782@dxz|东辛庄|DXD|dongxinzhuang|dxz|783@dya|丹阳|DYH|danyang|dy|784@dya|德阳|DYW|deyang|dy|785@dya|大雁|DYX|dayan|dy|786@dya|当阳|DYN|dangyang|dy|787@dyb|丹阳北|EXH|danyangbei|dyb|788@dyd|大英东|IAW|dayingdong|dyd|789@dyd|东淤地|DBV|dongyudi|dyd|790@dyi|大营|DYV|daying|dy|791@dyu|定远|EWH|dingyuan|dy|792@dyu|岱岳|RYV|daiyue|dy|793@dyu|大元|DYZ|dayuan|dy|794@dyz|大营镇|DJP|dayingzhen|dyz|795@dyz|大营子|DZD|dayingzi|dyz|796@dzc|大战场|DTJ|dazhanchang|dzc|797@dzd|德州东|DIP|dezhoudong|dzd|798@dzh|东至|DCH|dongzhi|dz|799@dzh|低庄|DVQ|dizhuang|dz|800@dzh|东镇|DNV|dongzhen|dz|801@dzh|道州|DFZ|daozhou|dz|802@dzh|东庄|DZV|dongzhuang|dz|803@dzh|兑镇|DWV|duizhen|dz|804@dzh|豆庄|ROP|douzhuang|dz|805@dzh|定州|DXP|dingzhou|dz|806@dzy|大竹园|DZY|dazhuyuan|dzy|807@dzz|大杖子|DAP|dazhangzi|dzz|808@dzz|豆张庄|RZP|douzhangzhuang|dzz|809@ebi|峨边|EBW|ebian|eb|810@edm|二道沟门|RDP|erdaogoumen|edgm|811@edw|二道湾|RDX|erdaowan|edw|812@ees|鄂尔多斯|EEC|eerduosi|eeds|813@elo|二龙|RLD|erlong|el|814@elt|二龙山屯|ELA|erlongshantun|elst|815@eme|峨眉|EMW|emei|em|816@emh|二密河|RML|ermihe|emh|817@eyi|二营|RYJ|erying|ey|818@ezh|鄂州|ECN|ezhou|ez|819@fan|福安|FAS|fuan|fa|820@fch|丰城|FCG|fengcheng|fc|821@fcn|丰城南|FNG|fengchengnan|fcn|822@fdo|肥东|FIH|feidong|fd|823@fer|发耳|FEM|faer|fe|824@fha|富海|FHX|fuhai|fh|825@fha|福海|FHR|fuhai|fh|826@fhc|凤凰城|FHT|fenghuangcheng|fhc|827@fhe|汾河|FEV|fenhe|fh|828@fhu|奉化|FHH|fenghua|fh|829@fji|富锦|FIB|fujin|fj|830@fjt|范家屯|FTT|fanjiatun|fjt|831@flq|福利区|FLJ|fuliqu|flq|832@flt|福利屯|FTB|fulitun|flt|833@flz|丰乐镇|FZB|fenglezhen|flz|834@fna|阜南|FNH|funan|fn|835@fni|阜宁|AKH|funing|fn|836@fni|抚宁|FNP|funing|fn|837@fqi|福清|FQS|fuqing|fq|838@fqu|福泉|VMW|fuquan|fq|839@fsc|丰水村|FSJ|fengshuicun|fsc|840@fsh|丰顺|FUQ|fengshun|fs|841@fsh|繁峙|FSV|fanshi|fs|842@fsh|抚顺|FST|fushun|fs|843@fsk|福山口|FKP|fushankou|fsk|844@fsu|扶绥|FSZ|fusui|fs|845@ftu|冯屯|FTX|fengtun|ft|846@fty|浮图峪|FYP|futuyu|fty|847@fxd|富县东|FDY|fuxiandong|fxd|848@fxi|凤县|FXY|fengxian|fx|849@fxi|富县|FEY|fuxian|fx|850@fxi|费县|FXK|feixian|fx|851@fya|凤阳|FUH|fengyang|fy|852@fya|汾阳|FAV|fenyang|fy|853@fyb|扶余北|FBT|fuyubei|fyb|854@fyi|分宜|FYG|fenyi|fy|855@fyu|富源|FYM|fuyuan|fy|856@fyu|扶余|FYT|fuyu|fy|857@fyu|富裕|FYX|fuyu|fy|858@fzb|抚州北|FBG|fuzhoubei|fzb|859@fzh|凤州|FZY|fengzhou|fz|860@fzh|丰镇|FZC|fengzhen|fz|861@fzh|范镇|VZK|fanzhen|fz|862@gan|固安|GFP|guan|ga|863@gan|广安|VJW|guangan|ga|864@gbd|高碑店|GBP|gaobeidian|gbd|865@gbz|沟帮子|GBD|goubangzi|gbz|866@gcd|甘草店|GDJ|gancaodian|gcd|867@gch|谷城|GCN|gucheng|gc|868@gch|藁城|GEP|gaocheng|gc|869@gcu|高村|GCV|gaocun|gc|870@gcz|古城镇|GZB|guchengzhen|gcz|871@gde|广德|GRH|guangde|gd|872@gdi|贵定|GTW|guiding|gd|873@gdn|贵定南|IDW|guidingnan|gdn|874@gdo|古东|GDV|gudong|gd|875@gga|贵港|GGZ|guigang|gg|876@gga|官高|GVP|guangao|gg|877@ggm|葛根庙|GGT|gegenmiao|ggm|878@ggo|干沟|GGL|gangou|gg|879@ggu|甘谷|GGJ|gangu|gg|880@ggz|高各庄|GGP|gaogezhuang|ggz|881@ghe|甘河|GAX|ganhe|gh|882@ghe|根河|GEX|genhe|gh|883@gjd|郭家店|GDT|guojiadian|gjd|884@gjz|孤家子|GKT|gujiazi|gjz|885@gla|古浪|GLJ|gulang|gl|886@gla|皋兰|GEJ|gaolan|gl|887@glf|高楼房|GFM|gaoloufang|glf|888@glh|归流河|GHT|guiliuhe|glh|889@gli|关林|GLF|guanlin|gl|890@glu|甘洛|VOW|ganluo|gl|891@glz|郭磊庄|GLP|guoleizhuang|glz|892@gmi|高密|GMK|gaomi|gm|893@gmz|公庙子|GMC|gongmiaozi|gmz|894@gnh|工农湖|GRT|gongnonghu|gnh|895@gnn|广宁寺南|GNT|guangningsinan|gnn|896@gnw|广南卫|GNM|guangnanwei|gnw|897@gpi|高平|GPF|gaoping|gp|898@gqb|甘泉北|GEY|ganquanbei|gqb|899@gqc|共青城|GAG|gongqingcheng|gqc|900@gqk|甘旗卡|GQD|ganqika|gqk|901@gqu|甘泉|GQY|ganquan|gq|902@gqz|高桥镇|GZD|gaoqiaozhen|gqz|903@gsh|灌水|GST|guanshui|gs|904@gsh|赶水|GSW|ganshui|gs|905@gsk|孤山口|GSP|gushankou|gsk|906@gso|果松|GSL|guosong|gs|907@gsz|高山子|GSD|gaoshanzi|gsz|908@gsz|嘎什甸子|GXD|gashidianzi|gsdz|909@gta|高台|GTJ|gaotai|gt|910@gta|高滩|GAY|gaotan|gt|911@gti|古田|GTS|gutian|gt|912@gti|官厅|GTP|guanting|gt|913@gtx|官厅西|KEP|guantingxi|gtx|914@gxi|贵溪|GXG|guixi|gx|915@gya|涡阳|GYH|guoyang|gy|916@gyi|巩义|GXF|gongyi|gy|917@gyi|高邑|GIP|gaoyi|gy|918@gyn|巩义南|GYF|gongyinan|gyn|919@gyn|广元南|GAW|guangyuannan|gyn|920@gyu|固原|GUJ|guyuan|gy|921@gyu|菇园|GYL|guyuan|gy|922@gyz|公营子|GYD|gongyingzi|gyz|923@gze|光泽|GZS|guangze|gz|924@gzh|古镇|GNQ|guzhen|gz|925@gzh|固镇|GEH|guzhen|gz|926@gzh|虢镇|GZY|guozhen|gz|927@gzh|瓜州|GZJ|guazhou|gz|928@gzh|高州|GSQ|gaozhou|gz|929@gzh|盖州|GXT|gaizhou|gz|930@gzj|官字井|GOT|guanzijing|gzj|931@gzs|冠豸山|GSS|guanzhaishan|gzs|932@gzx|盖州西|GAT|gaizhouxi|gzx|933@han|淮安南|AMH|huaiannan|han|934@han|红安|HWN|hongan|ha|935@hax|海安县|HIH|haianxian|hax|936@hax|红安西|VXN|honganxi|hax|937@hba|黄柏|HBL|huangbai|hb|938@hbe|海北|HEB|haibei|hb|939@hbi|鹤壁|HAF|hebi|hb|940@hcb|会昌北|XEG|huichangbei|hcb|941@hch|华城|VCQ|huacheng|hc|942@hch|河唇|HCZ|hechun|hc|943@hch|汉川|HCN|hanchuan|hc|944@hch|海城|HCT|haicheng|hc|945@hch|合川|WKW|hechuan|hc|946@hct|黑冲滩|HCJ|heichongtan|hct|947@hcu|黄村|HCP|huangcun|hc|948@hcx|海城西|HXT|haichengxi|hcx|949@hde|化德|HGC|huade|hd|950@hdo|洪洞|HDV|hongtong|hd|951@hes|霍尔果斯|HFR|huoerguosi|hegs|952@hfe|横峰|HFG|hengfeng|hf|953@hfw|韩府湾|HXJ|hanfuwan|hfw|954@hgu|汉沽|HGP|hangu|hg|955@hgy|黄瓜园|HYM|huangguayuan|hgy|956@hgz|红光镇|IGW|hongguangzhen|hgz|957@hhe|浑河|HHT|hunhe|hh|958@hhg|红花沟|VHD|honghuagou|hhg|959@hht|黄花筒|HUD|huanghuatong|hht|960@hjd|贺家店|HJJ|hejiadian|hjd|961@hji|和静|HJR|hejing|hj|962@hji|红江|HFM|hongjiang|hj|963@hji|黑井|HIM|heijing|hj|964@hji|获嘉|HJF|huojia|hj|965@hji|河津|HJV|hejin|hj|966@hji|涵江|HJS|hanjiang|hj|967@hji|华家|HJT|huajia|hj|968@hjq|杭锦后旗|HDC|hangjinhouqi|hjhq|969@hjx|河间西|HXP|hejianxi|hjx|970@hjz|花家庄|HJM|huajiazhuang|hjz|971@hkn|河口南|HKJ|hekounan|hkn|972@hko|湖口|HKG|hukou|hk|973@hko|黄口|KOH|huangkou|hk|974@hla|呼兰|HUB|hulan|hl|975@hlb|葫芦岛北|HPD|huludaobei|hldb|976@hlh|浩良河|HHB|haolianghe|hlh|977@hlh|哈拉海|HIT|halahai|hlh|978@hli|鹤立|HOB|heli|hl|979@hli|桦林|HIB|hualin|hl|980@hli|黄陵|ULY|huangling|hl|981@hli|海林|HRB|hailin|hl|982@hli|虎林|VLB|hulin|hl|983@hli|寒岭|HAT|hanling|hl|984@hlo|和龙|HLL|helong|hl|985@hlo|海龙|HIL|hailong|hl|986@hls|哈拉苏|HAX|halasu|hls|987@hlt|呼鲁斯太|VTJ|hulusitai|hlst|988@hlz|火连寨|HLT|huolianzhai|hlz|989@hme|黄梅|VEH|huangmei|hm|990@hmy|韩麻营|HYP|hanmaying|hmy|991@hnh|黄泥河|HHL|huangnihe|hnh|992@hni|海宁|HNH|haining|hn|993@hno|惠农|HMJ|huinong|hn|994@hpi|和平|VAQ|heping|hp|995@hpz|花棚子|HZM|huapengzi|hpz|996@hqi|花桥|VQH|huaqiao|hq|997@hqi|宏庆|HEY|hongqing|hq|998@hre|怀仁|HRV|huairen|hr|999@hro|华容|HRN|huarong|hr|1000@hsb|华山北|HDY|huashanbei|hsb|1001@hsd|黄松甸|HDL|huangsongdian|hsd|1002@hsg|和什托洛盖|VSR|heshituoluogai|hstlg|1003@hsh|红山|VSB|hongshan|hs|1004@hsh|汉寿|VSQ|hanshou|hs|1005@hsh|衡山|HSQ|hengshan|hs|1006@hsh|黑水|HOT|heishui|hs|1007@hsh|惠山|VCH|huishan|hs|1008@hsh|虎什哈|HHP|hushiha|hsh|1009@hsp|红寺堡|HSJ|hongsipu|hsp|1010@hst|虎石台|HUT|hushitai|hst|1011@hsw|海石湾|HSO|haishiwan|hsw|1012@hsx|衡山西|HEQ|hengshanxi|hsx|1013@hsx|红砂岘|VSJ|hongshaxian|hsx|1014@hta|黑台|HQB|heitai|ht|1015@hta|桓台|VTK|huantai|ht|1016@hti|和田|VTR|hetian|ht|1017@hto|会同|VTQ|huitong|ht|1018@htz|海坨子|HZT|haituozi|htz|1019@hwa|黑旺|HWK|heiwang|hw|1020@hwa|海湾|RWH|haiwan|hw|1021@hxi|红星|VXB|hongxing|hx|1022@hxi|徽县|HYY|huixian|hx|1023@hxl|红兴隆|VHB|hongxinglong|hxl|1024@hxt|换新天|VTB|huanxintian|hxt|1025@hxt|红岘台|HTJ|hongxiantai|hxt|1026@hya|红彦|VIX|hongyan|hy|1027@hya|合阳|HAY|heyang|hy|1028@hya|海阳|HYK|haiyang|hy|1029@hyd|衡阳东|HVQ|hengyangdong|hyd|1030@hyi|华蓥|HUW|huaying|hy|1031@hyi|汉阴|HQY|hanyin|hy|1032@hyt|黄羊滩|HGJ|huangyangtan|hyt|1033@hyu|汉源|WHW|hanyuan|hy|1034@hyu|河源|VIQ|heyuan|hy|1035@hyu|花园|HUN|huayuan|hy|1036@hyu|湟源|HNO|huangyuan|hy|1037@hyz|黄羊镇|HYJ|huangyangzhen|hyz|1038@hzh|湖州|VZH|huzhou|hz|1039@hzh|化州|HZZ|huazhou|hz|1040@hzh|黄州|VON|huangzhou|hz|1041@hzh|霍州|HZV|huozhou|hz|1042@hzx|惠州西|VXQ|huizhouxi|hzx|1043@jba|巨宝|JRT|jubao|jb|1044@jbi|靖边|JIY|jingbian|jb|1045@jbt|金宝屯|JBD|jinbaotun|jbt|1046@jcb|晋城北|JEF|jinchengbei|jcb|1047@jch|金昌|JCJ|jinchang|jc|1048@jch|鄄城|JCK|juancheng|jc|1049@jch|交城|JNV|jiaocheng|jc|1050@jch|建昌|JFD|jianchang|jc|1051@jde|峻德|JDB|junde|jd|1052@jdi|井店|JFP|jingdian|jd|1053@jdo|鸡东|JOB|jidong|jd|1054@jdu|江都|UDH|jiangdu|jd|1055@jgs|鸡冠山|JST|jiguanshan|jgs|1056@jgt|金沟屯|VGP|jingoutun|jgt|1057@jha|静海|JHP|jinghai|jh|1058@jhe|金河|JHX|jinhe|jh|1059@jhe|锦河|JHB|jinhe|jh|1060@jhe|精河|JHR|jinghe|jh|1061@jhn|精河南|JIR|jinghenan|jhn|1062@jhu|江华|JHZ|jianghua|jh|1063@jhu|建湖|AJH|jianhu|jh|1064@jjg|纪家沟|VJD|jijiagou|jjg|1065@jji|晋江|JJS|jinjiang|jj|1066@jji|锦界|JEY|jinjie|jj|1067@jji|姜家|JJB|jiangjia|jj|1068@jji|江津|JJW|jiangjin|jj|1069@jke|金坑|JKT|jinkeng|jk|1070@jli|芨岭|JLJ|jiling|jl|1071@jmc|金马村|JMM|jinmacun|jmc|1072@jmd|江门东|JWQ|jiangmendong|jmd|1073@jme|角美|JES|jiaomei|jm|1074@jna|莒南|JOK|junan|jn|1075@jna|井南|JNP|jingnan|jn|1076@jou|建瓯|JVS|jianou|jo|1077@jpe|经棚|JPC|jingpeng|jp|1078@jqi|江桥|JQX|jiangqiao|jq|1079@jsa|九三|SSX|jiusan|js|1080@jsb|金山北|EGH|jinshanbei|jsb|1081@jsh|嘉善|JSH|jiashan|js|1082@jsh|京山|JCN|jingshan|js|1083@jsh|建始|JRN|jianshi|js|1084@jsh|稷山|JVV|jishan|js|1085@jsh|吉舒|JSL|jishu|js|1086@jsh|建设|JET|jianshe|js|1087@jsh|甲山|JOP|jiashan|js|1088@jsj|建三江|JIB|jiansanjiang|jsj|1089@jsn|嘉善南|EAH|jiashannan|jsn|1090@jst|金山屯|JTB|jinshantun|jst|1091@jst|江所田|JOM|jiangsuotian|jst|1092@jta|景泰|JTJ|jingtai|jt|1093@jtn|九台南|JNL|jiutainan|jtn|1094@jwe|吉文|JWX|jiwen|jw|1095@jxi|进贤|JUG|jinxian|jx|1096@jxi|莒县|JKK|juxian|jx|1097@jxi|嘉祥|JUK|jiaxiang|jx|1098@jxi|介休|JXV|jiexiu|jx|1099@jxi|嘉兴|JXH|jiaxing|jx|1100@jxi|井陉|JJP|jingxing|jx|1101@jxn|嘉兴南|EPH|jiaxingnan|jxn|1102@jxz|夹心子|JXT|jiaxinzi|jxz|1103@jya|姜堰|UEH|jiangyan|jy|1104@jya|揭阳|JRQ|jieyang|jy|1105@jya|建阳|JYS|jianyang|jy|1106@jya|简阳|JYW|jianyang|jy|1107@jye|巨野|JYK|juye|jy|1108@jyo|江永|JYZ|jiangyong|jy|1109@jyu|缙云|JYH|jinyun|jy|1110@jyu|靖远|JYJ|jingyuan|jy|1111@jyu|江源|SZL|jiangyuan|jy|1112@jyu|济源|JYF|jiyuan|jy|1113@jyx|靖远西|JXJ|jingyuanxi|jyx|1114@jzb|胶州北|JZK|jiaozhoubei|jzb|1115@jzd|焦作东|WEF|jiaozuodong|jzd|1116@jzh|金寨|JZH|jinzhai|jz|1117@jzh|靖州|JEQ|jingzhou|jz|1118@jzh|荆州|JBN|jingzhou|jz|1119@jzh|胶州|JXK|jiaozhou|jz|1120@jzh|晋州|JXP|jinzhou|jz|1121@jzn|锦州南|JOD|jinzhounan|jzn|1122@jzu|焦作|JOF|jiaozuo|jz|1123@jzw|旧庄窝|JVP|jiuzhuangwo|jzw|1124@jzz|金杖子|JYD|jinzhangzi|jzz|1125@kan|开安|KAT|kaian|ka|1126@kch|库车|KCR|kuche|kc|1127@kch|康城|KCP|kangcheng|kc|1128@kde|库都尔|KDX|kuduer|kde|1129@kdi|宽甸|KDT|kuandian|kd|1130@kdo|克东|KOB|kedong|kd|1131@kdz|昆都仑召|KDC|kundulunzhao|kdlz|1132@kji|开江|KAW|kaijiang|kj|1133@kjj|康金井|KJB|kangjinjing|kjj|1134@klq|喀喇其|KQX|kalaqi|klq|1135@klu|开鲁|KLC|kailu|kl|1136@kly|克拉玛依|KHR|kelamayi|klmy|1137@kqi|口前|KQL|kouqian|kq|1138@ksh|昆山|KSH|kunshan|ks|1139@ksh|奎山|KAB|kuishan|ks|1140@ksh|克山|KSB|keshan|ks|1141@kto|开通|KTT|kaitong|kt|1142@kxl|康熙岭|KXZ|kangxiling|kxl|1143@kya|昆阳|KAM|kunyang|ky|1144@kyh|克一河|KHX|keyihe|kyh|1145@kyx|开原西|KXT|kaiyuanxi|kyx|1146@kzh|康庄|KZP|kangzhuang|kz|1147@lbi|来宾|UBZ|laibin|lb|1148@lbi|老边|LLT|laobian|lb|1149@lbx|灵宝西|LPF|lingbaoxi|lbx|1150@lch|龙川|LUQ|longchuan|lc|1151@lch|乐昌|LCQ|lechang|lc|1152@lch|黎城|UCP|licheng|lc|1153@lch|聊城|UCK|liaocheng|lc|1154@lcu|蓝村|LCK|lancun|lc|1155@lda|两当|LDY|liangdang|ld|1156@ldo|林东|LRC|lindong|ld|1157@ldu|乐都|LDO|ledu|ld|1158@ldx|梁底下|LDP|liangdixia|ldx|1159@ldz|六道河子|LVP|liudaohezi|ldhz|1160@lfa|鲁番|LVM|lufan|lf|1161@lfa|廊坊|LJP|langfang|lf|1162@lfa|落垡|LOP|luofa|lf|1163@lfb|廊坊北|LFP|langfangbei|lfb|1164@lfu|老府|UFD|laofu|lf|1165@lga|兰岗|LNB|langang|lg|1166@lgd|龙骨甸|LGM|longgudian|lgd|1167@lgo|芦沟|LOM|lugou|lg|1168@lgo|龙沟|LGJ|longgou|lg|1169@lgu|拉古|LGB|lagu|lg|1170@lha|临海|UFH|linhai|lh|1171@lha|林海|LXX|linhai|lh|1172@lha|拉哈|LHX|laha|lh|1173@lha|凌海|JID|linghai|lh|1174@lhe|柳河|LNL|liuhe|lh|1175@lhe|六合|KLH|liuhe|lh|1176@lhu|龙华|LHP|longhua|lh|1177@lhy|滦河沿|UNP|luanheyan|lhy|1178@lhz|六合镇|LEX|liuhezhen|lhz|1179@ljd|亮甲店|LRT|liangjiadian|ljd|1180@ljd|刘家店|UDT|liujiadian|ljd|1181@ljh|刘家河|LVT|liujiahe|ljh|1182@lji|连江|LKS|lianjiang|lj|1183@lji|庐江|UJH|lujiang|lj|1184@lji|李家|LJB|lijia|lj|1185@lji|罗江|LJW|luojiang|lj|1186@lji|廉江|LJZ|lianjiang|lj|1187@lji|两家|UJT|liangjia|lj|1188@lji|龙江|LJX|longjiang|lj|1189@lji|龙嘉|UJL|longjia|lj|1190@ljk|莲江口|LHB|lianjiangkou|ljk|1191@ljl|蔺家楼|ULK|linjialou|ljl|1192@ljp|李家坪|LIJ|lijiaping|ljp|1193@lka|兰考|LKF|lankao|lk|1194@lko|林口|LKB|linkou|lk|1195@lkp|路口铺|LKQ|lukoupu|lkp|1196@lla|老莱|LAX|laolai|ll|1197@lli|拉林|LAB|lalin|ll|1198@lli|陆良|LRM|luliang|ll|1199@lli|龙里|LLW|longli|ll|1200@lli|临澧|LWQ|linli|ll|1201@lli|兰棱|LLB|lanling|ll|1202@lli|零陵|UWZ|lingling|ll|1203@llo|卢龙|UAP|lulong|ll|1204@lmd|喇嘛甸|LMX|lamadian|lmd|1205@lmd|里木店|LMB|limudian|lmd|1206@lme|洛门|LMJ|luomen|lm|1207@lna|龙南|UNG|longnan|ln|1208@lpi|梁平|UQW|liangping|lp|1209@lpi|罗平|LPM|luoping|lp|1210@lpl|落坡岭|LPP|luopoling|lpl|1211@lps|六盘山|UPJ|liupanshan|lps|1212@lps|乐平市|LPG|lepingshi|lps|1213@lqi|临清|UQK|linqing|lq|1214@lqs|龙泉寺|UQJ|longquansi|lqs|1215@lsb|乐山北|UTW|leshanbei|ls|1216@lsc|乐善村|LUM|leshancun|lsc|1217@lsd|冷水江东|UDQ|lengshuijiangdong|lsjd|1218@lsg|连山关|LGT|lianshanguan|lsg|1219@lsg|流水沟|USP|liushuigou|lsg|1220@lsh|丽水|USH|lishui|ls|1221@lsh|陵水|LIQ|lingshui|ls|1222@lsh|罗山|LRN|luoshan|ls|1223@lsh|鲁山|LAF|lushan|ls|1224@lsh|梁山|LMK|liangshan|ls|1225@lsh|灵石|LSV|lingshi|ls|1226@lsh|露水河|LUL|lushuihe|lsh|1227@lsh|庐山|LSG|lushan|ls|1228@lsp|林盛堡|LBT|linshengpu|lsp|1229@lst|柳树屯|LSD|liushutun|lst|1230@lsz|龙山镇|LAS|longshanzhen|lsz|1231@lsz|梨树镇|LSB|lishuzhen|lsz|1232@lsz|李石寨|LET|lishizhai|lsz|1233@lta|黎塘|LTZ|litang|lt|1234@lta|轮台|LAR|luntai|lt|1235@lta|芦台|LTP|lutai|lt|1236@ltb|龙塘坝|LBM|longtangba|ltb|1237@ltu|濑湍|LVZ|laituan|lt|1238@ltx|骆驼巷|LTJ|luotuoxiang|ltx|1239@lwa|李旺|VLJ|liwang|lw|1240@lwd|莱芜东|LWK|laiwudong|lwd|1241@lws|狼尾山|LRJ|langweishan|lws|1242@lwu|灵武|LNJ|lingwu|lw|1243@lwx|莱芜西|UXK|laiwuxi|lwx|1244@lxi|朗乡|LXB|langxiang|lx|1245@lxi|陇县|LXY|longxian|lx|1246@lxi|临湘|LXQ|linxiang|lx|1247@lxi|芦溪|LUG|luxi|lx|1248@lxi|莱西|LXK|laixi|lx|1249@lxi|林西|LXC|linxi|lx|1250@lxi|滦县|UXP|luanxian|lx|1251@lya|略阳|LYY|lueyang|ly|1252@lya|莱阳|LYK|laiyang|ly|1253@lya|辽阳|LYT|liaoyang|ly|1254@lyb|临沂北|UYK|linyibei|lyb|1255@lyd|凌源东|LDD|lingyuandong|lyd|1256@lyg|连云港|UIH|lianyungang|lyg|1257@lyi|临颍|LNF|linying|ly|1258@lyi|老营|LXL|laoying|ly|1259@lyo|龙游|LMH|longyou|ly|1260@lyu|罗源|LVS|luoyuan|ly|1261@lyu|林源|LYX|linyuan|ly|1262@lyu|涟源|LAQ|lianyuan|ly|1263@lyu|涞源|LYP|laiyuan|ly|1264@lyx|耒阳西|LPQ|leiyangxi|lyx|1265@lze|临泽|LEJ|linze|lz|1266@lzg|龙爪沟|LZT|longzhuagou|lzg|1267@lzh|雷州|UAQ|leizhou|lz|1268@lzh|六枝|LIW|liuzhi|lz|1269@lzh|鹿寨|LIZ|luzhai|lz|1270@lzh|来舟|LZS|laizhou|lz|1271@lzh|龙镇|LZA|longzhen|lz|1272@lzh|拉鲊|LEM|lazha|lz|1273@lzq|兰州新区|LQJ|lanzhouxinqu|lzxq|1274@mas|马鞍山|MAH|maanshan|mas|1275@mba|毛坝|MBY|maoba|mb|1276@mbg|毛坝关|MGY|maobaguan|mbg|1277@mcb|麻城北|MBN|machengbei|mcb|1278@mch|渑池|MCF|mianchi|mc|1279@mch|明城|MCL|mingcheng|mc|1280@mch|庙城|MAP|miaocheng|mc|1281@mcn|渑池南|MNF|mianchinan|mcn|1282@mcp|茅草坪|KPM|maocaoping|mcp|1283@mdh|猛洞河|MUQ|mengdonghe|mdh|1284@mds|磨刀石|MOB|modaoshi|mds|1285@mdu|弥渡|MDF|midu|md|1286@mes|帽儿山|MRB|maoershan|mes|1287@mga|明港|MGN|minggang|mg|1288@mhk|梅河口|MHL|meihekou|mhk|1289@mhu|马皇|MHZ|mahuang|mh|1290@mjg|孟家岗|MGB|mengjiagang|mjg|1291@mla|美兰|MHQ|meilan|ml|1292@mld|汨罗东|MQQ|miluodong|mld|1293@mlh|马莲河|MHB|malianhe|mlh|1294@mli|茅岭|MLZ|maoling|ml|1295@mli|庙岭|MLL|miaoling|ml|1296@mli|茂林|MLD|maolin|ml|1297@mli|穆棱|MLB|muling|ml|1298@mli|马林|MID|malin|ml|1299@mlo|马龙|MGM|malong|ml|1300@mlt|木里图|MUD|mulitu|mlt|1301@mlu|汨罗|MLQ|miluo|ml|1302@mnh|玛纳斯湖|MNR|manasihu|mnsh|1303@mni|冕宁|UGW|mianning|mn|1304@mpa|沐滂|MPQ|mupang|mp|1305@mqh|马桥河|MQB|maqiaohe|mqh|1306@mqi|闽清|MQS|minqing|mq|1307@mqu|民权|MQF|minquan|mq|1308@msh|明水河|MUT|mingshuihe|msh|1309@msh|麻山|MAB|mashan|ms|1310@msh|眉山|MSW|meishan|ms|1311@msw|漫水湾|MKW|manshuiwan|msw|1312@msz|茂舍祖|MOM|maoshezu|msz|1313@msz|米沙子|MST|mishazi|msz|1314@mxi|美溪|MEB|meixi|mx|1315@mxi|勉县|MVY|mianxian|mx|1316@mya|麻阳|MVQ|mayang|my|1317@myb|密云北|MUP|miyunbei|myb|1318@myi|米易|MMW|miyi|my|1319@myu|麦园|MYS|maiyuan|my|1320@myu|墨玉|MUR|moyu|my|1321@mzh|庙庄|MZJ|miaozhuang|mz|1322@mzh|米脂|MEY|mizhi|mz|1323@mzh|明珠|MFQ|mingzhu|mz|1324@nan|宁安|NAB|ningan|na|1325@nan|农安|NAT|nongan|na|1326@nbs|南博山|NBK|nanboshan|nbs|1327@nch|南仇|NCK|nanqiu|nc|1328@ncs|南城司|NSP|nanchengsi|ncs|1329@ncu|宁村|NCZ|ningcun|nc|1330@nde|宁德|NES|ningde|nd|1331@ngc|南观村|NGP|nanguancun|ngc|1332@ngd|南宫东|NFP|nangongdong|ngd|1333@ngl|南关岭|NLT|nanguanling|ngl|1334@ngu|宁国|NNH|ningguo|ng|1335@nha|宁海|NHH|ninghai|nh|1336@nhb|南华北|NHS|nanhuabei|nhb|1337@nhc|南河川|NHJ|nanhechuan|nhc|1338@nhz|泥河子|NHD|nihezi|nhz|1339@nji|宁家|NVT|ningjia|nj|1340@nji|南靖|NJS|nanjing|nj|1341@nji|牛家|NJB|niujia|nj|1342@nji|能家|NJD|nengjia|nj|1343@nko|南口|NKP|nankou|nk|1344@nkq|南口前|NKT|nankouqian|nkq|1345@nla|南朗|NNQ|nanlang|nl|1346@nli|乃林|NLD|nailin|nl|1347@nlk|尼勒克|NIR|nileke|nlk|1348@nlu|那罗|ULZ|naluo|nl|1349@nlx|宁陵县|NLF|ninglingxian|nlx|"
			+ "1350@nma|奈曼|NMD|naiman|nm|1351@nmi|宁明|NMZ|ningming|nm|1352@nmu|南木|NMX|nanmu|nm|1353@npn|南平南|NNS|nanpingnan|npn|1354@npu|那铺|NPZ|napu|np|1355@nqi|南桥|NQD|nanqiao|nq|1356@nqu|那曲|NQO|naqu|nq|1357@nqu|暖泉|NQJ|nuanquan|nq|1358@nta|南台|NTT|nantai|nt|1359@nto|南头|NOQ|nantou|nt|1360@nwu|宁武|NWV|ningwu|nw|1361@nwz|南湾子|NWP|nanwanzi|nwz|1362@nxb|南翔北|NEH|nanxiangbei|nxb|1363@nxi|宁乡|NXQ|ningxiang|nx|1364@nxi|内乡|NXF|neixiang|nx|1365@nxt|牛心台|NXT|niuxintai|nxt|1366@nyu|南峪|NUP|nanyu|ny|1367@nzg|娘子关|NIP|niangziguan|nzg|1368@nzh|南召|NAF|nanzhao|nz|1369@nzm|南杂木|NZT|nanzamu|nzm|1370@pan|蓬安|PAW|pengan|pa|1371@pan|平安|PAL|pingan|pa|1372@pay|平安驿|PNO|pinganyi|pay|1373@paz|磐安镇|PAJ|pananzhen|paz|1374@paz|平安镇|PZT|pinganzhen|paz|1375@pcd|蒲城东|PEY|puchengdong|pcd|1376@pch|蒲城|PCY|pucheng|pc|1377@pde|裴德|PDB|peide|pd|1378@pdi|偏店|PRP|piandian|pd|1379@pdx|平顶山西|BFF|pingdingshanxi|pdsx|1380@pdx|坡底下|PXJ|podixia|pdx|1381@pet|瓢儿屯|PRT|piaoertun|pet|1382@pfa|平房|PFB|pingfang|pf|1383@pga|平岗|PGL|pinggang|pg|1384@pgu|平关|PGM|pingguan|pg|1385@pgu|盘关|PAM|panguan|pg|1386@pgu|平果|PGZ|pingguo|pg|1387@phb|徘徊北|PHP|paihuaibei|phb|1388@phk|平河口|PHM|pinghekou|phk|1389@phu|平湖|PHQ|pinghu|ph|1390@pjb|盘锦北|PBD|panjinbei|pjb|1391@pjd|潘家店|PDP|panjiadian|pjd|1392@pkn|皮口南|PKT|pikounan|pk|1393@pld|普兰店|PLT|pulandian|pld|1394@pli|偏岭|PNT|pianling|pl|1395@psh|平山|PSB|pingshan|ps|1396@psh|彭山|PSW|pengshan|ps|1397@psh|皮山|PSR|pishan|ps|1398@psh|磐石|PSL|panshi|ps|1399@psh|平社|PSV|pingshe|ps|1400@psh|彭水|PHW|pengshui|ps|1401@pta|平台|PVT|pingtai|pt|1402@pti|平田|PTM|pingtian|pt|1403@pti|莆田|PTS|putian|pt|1404@ptq|葡萄菁|PTW|putaojing|ptq|1405@pwa|普湾|PWT|puwan|pw|1406@pwa|平旺|PWV|pingwang|pw|1407@pxg|平型关|PGV|pingxingguan|pxg|1408@pxi|普雄|POW|puxiong|px|1409@pxi|郫县|PWW|pixian|px|1410@pya|平洋|PYX|pingyang|py|1411@pya|彭阳|PYJ|pengyang|py|1412@pya|平遥|PYV|pingyao|py|1413@pyi|平邑|PIK|pingyi|py|1414@pyp|平原堡|PPJ|pingyuanpu|pyp|1415@pyu|平原|PYK|pingyuan|py|1416@pyu|平峪|PYP|pingyu|py|1417@pze|彭泽|PZG|pengze|pz|1418@pzh|邳州|PJH|pizhou|pz|1419@pzh|平庄|PZD|pingzhuang|pz|1420@pzi|泡子|POD|paozi|pz|1421@pzn|平庄南|PND|pingzhuangnan|pzn|1422@qan|乾安|QOT|qianan|qa|1423@qan|庆安|QAB|qingan|qa|1424@qan|迁安|QQP|qianan|qa|1425@qdb|祁东北|QRQ|qidongbei|qd|1426@qdi|七甸|QDM|qidian|qd|1427@qfd|曲阜东|QAK|qufudong|qfd|1428@qfe|庆丰|QFT|qingfeng|qf|1429@qft|奇峰塔|QVP|qifengta|qft|1430@qfu|曲阜|QFK|qufu|qf|1431@qha|琼海|QYQ|qionghai|qh|1432@qhd|秦皇岛|QTP|qinhuangdao|qhd|1433@qhe|千河|QUY|qianhe|qh|1434@qhe|清河|QIP|qinghe|qh|1435@qhm|清河门|QHD|qinghemen|qhm|1436@qhy|清华园|QHP|qinghuayuan|qhy|1437@qji|全椒|INH|quanjiao|qj|1438@qji|渠旧|QJZ|qujiu|qj|1439@qji|潜江|QJN|qianjiang|qj|1440@qji|秦家|QJB|qinjia|qj|1441@qji|綦江|QJW|qijiang|qj|1442@qjp|祁家堡|QBT|qijiapu|qjp|1443@qjx|清涧县|QNY|qingjianxian|qjx|1444@qjz|秦家庄|QZV|qinjiazhuang|qjz|1445@qlh|七里河|QLD|qilihe|qlh|1446@qli|秦岭|QLY|qinling|ql|1447@qli|渠黎|QLZ|quli|ql|1448@qlo|青龙|QIB|qinglong|ql|1449@qls|青龙山|QGH|qinglongshan|qls|1450@qme|祁门|QIH|qimen|qm|1451@qmt|前磨头|QMP|qianmotou|qmt|1452@qsh|青山|QSB|qingshan|qs|1453@qsh|确山|QSN|queshan|qs|1454@qsh|前山|QXQ|qianshan|qs|1455@qsh|清水|QUJ|qingshui|qs|1456@qsy|戚墅堰|QYH|qishuyan|qsy|1457@qti|青田|QVH|qingtian|qt|1458@qto|桥头|QAT|qiaotou|qt|1459@qtx|青铜峡|QTJ|qingtongxia|qtx|1460@qwe|前卫|QWD|qianwei|qw|1461@qwt|前苇塘|QWP|qianweitang|qwt|1462@qxi|渠县|QRW|quxian|qx|1463@qxi|祁县|QXV|qixian|qx|1464@qxi|青县|QXP|qingxian|qx|1465@qxi|桥西|QXJ|qiaoxi|qx|1466@qxu|清徐|QUV|qingxu|qx|1467@qxy|旗下营|QXC|qixiaying|qxy|1468@qya|千阳|QOY|qianyang|qy|1469@qya|沁阳|QYF|qinyang|qy|1470@qya|泉阳|QYL|quanyang|qy|1471@qyb|祁阳北|QVQ|qiyangbei|qy|1472@qyi|七营|QYJ|qiying|qy|1473@qys|庆阳山|QSJ|qingyangshan|qys|1474@qyu|清远|QBQ|qingyuan|qy|1475@qyu|清原|QYT|qingyuan|qy|1476@qzd|钦州东|QDZ|qinzhoudong|qzd|1477@qzh|钦州|QRZ|qinzhou|qz|1478@qzs|青州市|QZK|qingzhoushi|qzs|1479@ran|瑞安|RAH|ruian|ra|1480@rch|荣昌|RCW|rongchang|rc|1481@rch|瑞昌|RCG|ruichang|rc|1482@rga|如皋|RBH|rugao|rg|1483@rgu|容桂|RUQ|ronggui|rg|1484@rqi|任丘|RQP|renqiu|rq|1485@rsh|乳山|ROK|rushan|rs|1486@rsh|融水|RSZ|rongshui|rs|1487@rsh|热水|RSD|reshui|rs|1488@rxi|容县|RXZ|rongxian|rx|1489@rya|饶阳|RVP|raoyang|ry|1490@rya|汝阳|RYF|ruyang|ry|1491@ryh|绕阳河|RHD|raoyanghe|ryh|1492@rzh|汝州|ROF|ruzhou|rz|1493@sba|石坝|OBJ|shiba|sb|1494@sbc|上板城|SBP|shangbancheng|sbc|1495@sbi|施秉|AQW|shibing|sb|1496@sbn|上板城南|OBP|shangbanchengnan|sbcn|1497@sby|世博园|ZWT|shiboyuan|sby|1498@scb|双城北|SBB|shuangchengbei|scb|1499@sch|舒城|OCH|shucheng|sc|1500@sch|商城|SWN|shangcheng|sc|1501@sch|莎车|SCR|shache|sc|1502@sch|顺昌|SCS|shunchang|sc|1503@sch|神池|SMV|shenchi|sc|1504@sch|沙城|SCP|shacheng|sc|1505@sch|石城|SCT|shicheng|sc|1506@scz|山城镇|SCL|shanchengzhen|scz|1507@sda|山丹|SDJ|shandan|sd|1508@sde|顺德|ORQ|shunde|sd|1509@sde|绥德|ODY|suide|sd|1510@sdo|水洞|SIL|shuidong|sd|1511@sdu|商都|SXC|shangdu|sd|1512@sdu|十渡|SEP|shidu|sd|1513@sdw|四道湾|OUD|sidaowan|sdw|1514@sdy|顺德学院|OJQ|shundexueyuan|sdxy|1515@sfa|绅坊|OLH|shenfang|sf|1516@sfe|双丰|OFB|shuangfeng|sf|1517@sft|四方台|STB|sifangtai|sft|1518@sfu|水富|OTW|shuifu|sf|1519@sgk|三关口|OKJ|sanguankou|sgk|1520@sgl|桑根达来|OGC|sanggendalai|sgdl|1521@sgu|韶关|SNQ|shaoguan|sg|1522@sgz|上高镇|SVK|shanggaozhen|sgz|1523@sha|上杭|JBS|shanghang|sh|1524@sha|沙海|SED|shahai|sh|1525@she|蜀河|SHY|shuhe|sh|1526@she|松河|SBM|songhe|sh|1527@she|沙河|SHP|shahe|sh|1528@shk|沙河口|SKT|shahekou|shk|1529@shl|赛汗塔拉|SHC|saihantala|shtl|1530@shs|沙河市|VOP|shaheshi|shs|1531@shs|沙后所|SSD|shahousuo|shs|1532@sht|山河屯|SHL|shanhetun|sht|1533@shx|三河县|OXP|sanhexian|shx|1534@shy|四合永|OHD|siheyong|shy|1535@shz|三汇镇|OZW|sanhuizhen|shz|1536@shz|双河镇|SEL|shuanghezhen|shz|1537@shz|石河子|SZR|shihezi|shz|1538@shz|三合庄|SVP|sanhezhuang|shz|1539@sjd|三家店|ODP|sanjiadian|sjd|1540@sjh|水家湖|SQH|shuijiahu|sjh|1541@sjh|沈家河|OJJ|shenjiahe|sjh|1542@sjh|松江河|SJL|songjianghe|sjh|1543@sji|尚家|SJB|shangjia|sj|1544@sji|孙家|SUB|sunjia|sj|1545@sji|沈家|OJB|shenjia|sj|1546@sji|双吉|SML|shuangji|sj|1547@sji|松江|SAH|songjiang|sj|1548@sjk|三江口|SKD|sanjiangkou|sjk|1549@sjl|司家岭|OLK|sijialing|sjl|1550@sjn|松江南|IMH|songjiangnan|sjn|1551@sjn|石景山南|SRP|shijingshannan|sjsn|1552@sjt|邵家堂|SJJ|shaojiatang|sjt|1553@sjx|三江县|SOZ|sanjiangxian|sjx|1554@sjz|三家寨|SMM|sanjiazhai|sjz|1555@sjz|十家子|SJD|shijiazi|sjz|1556@sjz|松江镇|OZL|songjiangzhen|sjz|1557@sjz|施家嘴|SHM|shijiazui|sjz|1558@sjz|深井子|SWT|shenjingzi|sjz|1559@sld|什里店|OMP|shilidian|sld|1560@sle|疏勒|SUR|shule|sl|1561@slh|疏勒河|SHJ|shulehe|slh|1562@slh|舍力虎|VLD|shelihu|slh|1563@sli|石磷|SPB|shilin|sl|1564@sli|石林|SLM|shilin|sl|1565@sli|双辽|ZJD|shuangliao|sl|1566@sli|绥棱|SIB|suiling|sl|1567@sli|石岭|SOL|shiling|sl|1568@sln|石林南|LNM|shilinnan|sln|1569@slo|石龙|SLQ|shilong|sl|1570@slq|萨拉齐|SLC|salaqi|slq|1571@slu|索伦|SNT|suolun|sl|1572@slu|商洛|OLY|shangluo|sl|1573@slz|沙岭子|SLP|shalingzi|slz|1574@smb|石门县北|VFQ|shimenxianbei|smxb|1575@smn|三门峡南|SCF|sanmenxianan|smxn|1576@smx|三门县|OQH|sanmenxian|smx|1577@smx|石门县|OMQ|shimenxian|smx|1578@smx|三门峡西|SXF|sanmenxiaxi|smxx|1579@sni|肃宁|SYP|suning|sn|1580@son|宋|SOB|song|son|1581@spa|双牌|SBZ|shuangpai|sp|1582@spb|沙坪坝|CYW|shapingba|spb|1583@spd|四平东|PPT|sipingdong|spd|1584@spi|遂平|SON|suiping|sp|1585@spt|沙坡头|SFJ|shapotou|spt|1586@sqi|沙桥|SQM|shaqiao|sq|1587@sqn|商丘南|SPF|shangqiunan|sqn|1588@squ|水泉|SID|shuiquan|sq|1589@sqx|石泉县|SXY|shiquanxian|sqx|1590@sqz|石桥子|SQT|shiqiaozi|sqz|1591@src|石人城|SRB|shirencheng|src|1592@sre|石人|SRL|shiren|sr|1593@ssh|山市|SQB|shanshi|ss|1594@ssh|神树|SWB|shenshu|ss|1595@ssh|鄯善|SSR|shanshan|ss|1596@ssh|三水|SJQ|sanshui|ss|1597@ssh|泗水|OSK|sishui|ss|1598@ssh|石山|SAD|shishan|ss|1599@ssh|松树|SFT|songshu|ss|1600@ssh|首山|SAT|shoushan|ss|1601@ssj|三十家|SRD|sanshijia|ssj|1602@ssp|三十里堡|SST|sanshilipu|sslp|1603@ssz|松树镇|SSL|songshuzhen|ssz|1604@sta|松桃|MZQ|songtao|st|1605@sth|索图罕|SHX|suotuhan|sth|1606@stj|三堂集|SDH|santangji|stj|1607@sto|石头|OTB|shitou|st|1608@sto|神头|SEV|shentou|st|1609@stu|沙沱|SFM|shatuo|st|1610@swa|上万|SWP|shangwan|sw|1611@swu|孙吴|SKB|sunwu|sw|1612@swx|沙湾县|SXR|shawanxian|swx|1613@sxi|歙县|OVH|shexian|sx|1614@sxi|遂溪|SXZ|suixi|sx|1615@sxi|沙县|SAS|shaxian|sx|1616@sxi|绍兴|SOH|shaoxing|sx|1617@sxi|石岘|SXL|shixian|sx|1618@sxp|上西铺|SXM|shangxipu|sxp|1619@sxz|石峡子|SXJ|shixiazi|sxz|1620@sya|沭阳|FMH|shuyang|sy|1621@sya|绥阳|SYB|suiyang|sy|1622@sya|寿阳|SYV|shouyang|sy|1623@sya|水洋|OYP|shuiyang|sy|1624@syc|三阳川|SYJ|sanyangchuan|syc|1625@syd|上腰墩|SPJ|shangyaodun|syd|1626@syi|三营|OEJ|sanying|sy|1627@syi|顺义|SOP|shunyi|sy|1628@syj|三义井|OYD|sanyijing|syj|1629@syp|三源浦|SYL|sanyuanpu|syp|1630@syu|上虞|BDH|shangyu|sy|1631@syu|三原|SAY|sanyuan|sy|1632@syu|上园|SUD|shangyuan|sy|1633@syu|水源|OYJ|shuiyuan|sy|1634@syz|桑园子|SAJ|sangyuanzi|syz|1635@szb|绥中北|SND|suizhongbei|szb|1636@szb|苏州北|OHH|suzhoubei|szb|1637@szd|宿州东|SRH|suzhoudong|szd|1638@szd|深圳东|BJQ|shenzhendong|szd|1639@szh|深州|OZP|shenzhou|sz|1640@szh|孙镇|OZY|sunzhen|sz|1641@szh|绥中|SZD|suizhong|sz|1642@szh|尚志|SZB|shangzhi|sz|1643@szh|师庄|SNM|shizhuang|sz|1644@szi|松滋|SIN|songzi|sz|1645@szo|师宗|SEM|shizong|sz|1646@szq|苏州园区|KAH|suzhouyuanqu|szyq|1647@szq|苏州新区|ITH|suzhouxinqu|szxq|1648@tan|泰安|TMK|taian|ta|1649@tan|台安|TID|taian|ta|1650@tay|通安驿|TAJ|tonganyi|tay|1651@tba|桐柏|TBF|tongbai|tb|1652@tbe|通北|TBB|tongbei|tb|1653@tch|桐城|TTH|tongcheng|tc|1654@tch|汤池|TCX|tangchi|tc|1655@tch|郯城|TZK|tancheng|tc|1656@tch|铁厂|TCL|tiechang|tc|1657@tcu|桃村|TCK|taocun|tc|1658@tda|通道|TRQ|tongdao|td|1659@tdo|田东|TDZ|tiandong|td|1660@tga|天岗|TGL|tiangang|tg|1661@tgl|土贵乌拉|TGC|tuguiwula|tgwl|1662@tgo|通沟|TOL|tonggou|tg|1663@tgu|太谷|TGV|taigu|tg|1664@tha|塔哈|THX|taha|th|1665@tha|棠海|THM|tanghai|th|1666@the|唐河|THF|tanghe|th|1667@the|泰和|THG|taihe|th|1668@thu|太湖|TKH|taihu|th|1669@tji|团结|TIX|tuanjie|tj|1670@tjj|谭家井|TNJ|tanjiajing|tjj|1671@tjt|陶家屯|TOT|taojiatun|tjt|1672@tjw|唐家湾|PDQ|tangjiawan|tjw|1673@tjz|统军庄|TZP|tongjunzhuang|tjz|1674@tld|吐列毛杜|TMD|tuliemaodu|tlmd|1675@tlh|图里河|TEX|tulihe|tlh|1676@tli|铜陵|TJH|tongling|tl|1677@tli|田林|TFZ|tianlin|tl|1678@tli|亭亮|TIZ|tingliang|tl|1679@tli|铁力|TLB|tieli|tl|1680@tlx|铁岭西|PXT|tielingxi|tlx|1681@tmb|图们北|QSL|tumenbei|tmb|1682@tme|天门|TMN|tianmen|tm|1683@tmn|天门南|TNN|tianmennan|tmn|1684@tms|太姥山|TLS|taimushan|tms|1685@tmt|土牧尔台|TRC|tumuertai|tmet|1686@tmz|土门子|TCJ|tumenzi|tmz|1687@tna|洮南|TVT|taonan|tn|1688@tna|潼南|TVW|tongnan|tn|1689@tpc|太平川|TIT|taipingchuan|tpc|1690@tpz|太平镇|TEB|taipingzhen|tpz|1691@tqi|图强|TQX|tuqiang|tq|1692@tqi|台前|TTK|taiqian|tq|1693@tql|天桥岭|TQL|tianqiaoling|tql|1694@tqz|土桥子|TQJ|tuqiaozi|tqz|1695@tsc|汤山城|TCT|tangshancheng|tsc|1696@tsh|桃山|TAB|taoshan|ts|1697@tsz|塔石嘴|TIM|tashizui|tsz|1698@ttu|通途|TUT|tongtu|tt|1699@twh|汤旺河|THB|tangwanghe|twh|1700@txi|同心|TXJ|tongxin|tx|1701@txi|土溪|TSW|tuxi|tx|1702@txi|桐乡|TCH|tongxiang|tx|1703@tya|田阳|TRZ|tianyang|ty|1704@tyi|天义|TND|tianyi|ty|1705@tyi|汤阴|TYF|tangyin|ty|1706@tyl|驼腰岭|TIL|tuoyaoling|tyl|1707@tys|太阳山|TYJ|taiyangshan|tys|1708@tyu|汤原|TYB|tangyuan|ty|1709@tyy|塔崖驿|TYP|tayayi|tyy|1710@tzd|滕州东|TEK|tengzhoudong|tzd|1711@tzh|台州|TZH|taizhou|tz|1712@tzh|天祝|TZJ|tianzhu|tz|1713@tzh|滕州|TXK|tengzhou|tz|1714@tzh|天镇|TZV|tianzhen|tz|1715@tzl|桐子林|TEW|tongzilin|tzl|1716@tzs|天柱山|QWH|tianzhushan|tzs|1717@wan|文安|WBP|wenan|wa|1718@wan|武安|WAP|wuan|wa|1719@waz|王安镇|WVP|wanganzhen|waz|1720@wbu|吴堡|WUY|wubu|wb|1721@wca|旺苍|WEW|wangcang|wc|1722@wcg|五叉沟|WCT|wuchagou|wcg|1723@wch|文昌|WEQ|wenchang|wc|1724@wch|温春|WDB|wenchun|wc|1725@wdc|五大连池|WRB|wudalianchi|wdlc|1726@wde|文登|WBK|wendeng|wd|1727@wdg|五道沟|WDL|wudaogou|wdg|1728@wdh|五道河|WHP|wudaohe|wdh|1729@wdi|文地|WNZ|wendi|wd|1730@wdo|卫东|WVT|weidong|wd|1731@wds|武当山|WRN|wudangshan|wds|1732@wdu|望都|WDP|wangdu|wd|1733@weh|乌尔旗汗|WHX|wuerqihan|weqh|1734@wfa|潍坊|WFK|weifang|wf|1735@wft|万发屯|WFB|wanfatun|wft|1736@wfu|王府|WUT|wangfu|wf|1737@wfx|瓦房店西|WXT|wafangdianxi|wfdx|1738@wga|王岗|WGB|wanggang|wg|1739@wgo|武功|WGY|wugong|wg|1740@wgo|湾沟|WGL|wangou|wg|1741@wgt|吴官田|WGM|wuguantian|wgt|1742@wha|乌海|WVC|wuhai|wh|1743@whe|苇河|WHB|weihe|wh|1744@whu|卫辉|WHF|weihui|wh|1745@wjc|吴家川|WCJ|wujiachuan|wjc|1746@wji|五家|WUB|wujia|wj|1747@wji|威箐|WAM|weiqing|wj|1748@wji|午汲|WJP|wuji|wj|1749@wji|渭津|WJL|weijin|wj|1750@wjw|王家湾|WJJ|wangjiawan|wjw|1751@wke|倭肯|WQB|woken|wk|1752@wks|五棵树|WKT|wukeshu|wks|1753@wlb|五龙背|WBT|wulongbei|wlb|1754@wld|乌兰哈达|WLC|wulanhada|wlhd|1755@wle|万乐|WEB|wanle|wl|1756@wlg|瓦拉干|WVX|walagan|wlg|1757@wli|温岭|VHH|wenling|wl|1758@wli|五莲|WLK|wulian|wl|1759@wlq|乌拉特前旗|WQC|wulateqianqi|wltqq|1760@wls|乌拉山|WSC|wulashan|wls|1761@wlt|卧里屯|WLX|wolitun|wlt|1762@wnb|渭南北|WBY|weinanbei|wnb|1763@wne|乌奴耳|WRX|wunuer|wne|1764@wni|万宁|WNQ|wanning|wn|1765@wni|万年|WWG|wannian|wn|1766@wnn|渭南南|WVY|weinannan|wnn|1767@wnz|渭南镇|WNJ|weinanzhen|wnz|1768@wpi|沃皮|WPT|wopi|wp|1769@wqi|吴桥|WUP|wuqiao|wq|1770@wqi|汪清|WQL|wangqing|wq|1771@wqi|武清|WWP|wuqing|wq|1772@wsh|武山|WSJ|wushan|ws|1773@wsh|文水|WEV|wenshui|ws|1774@wsz|魏善庄|WSP|weishanzhuang|wsz|1775@wto|王瞳|WTP|wangtong|wt|1776@wts|五台山|WSV|wutaishan|wts|1777@wtz|王团庄|WZJ|wangtuanzhuang|wtz|1778@wwu|五五|WVR|wuwu|ww|1779@wxd|无锡东|WGH|wuxidong|wxd|1780@wxi|卫星|WVB|weixing|wx|1781@wxi|闻喜|WXV|wenxi|wx|1782@wxi|武乡|WVV|wuxiang|wx|1783@wxq|无锡新区|IFH|wuxixinqu|wxxq|1784@wxu|武穴|WXN|wuxue|wx|1785@wxu|吴圩|WYZ|wuxu|wx|1786@wya|王杨|WYB|wangyang|wy|1787@wyi|武义|RYH|wuyi|wy|1788@wyi|五营|WWB|wuying|wy|1789@wyt|瓦窑田|WIM|wayaotian|wyt|1790@wyu|五原|WYC|wuyuan|wy|1791@wzg|苇子沟|WZL|weizigou|wzg|1792@wzh|韦庄|WZY|weizhuang|wz|1793@wzh|五寨|WZV|wuzhai|wz|1794@wzt|王兆屯|WZB|wangzhaotun|wzt|1795@wzz|微子镇|WQP|weizizhen|wzz|1796@wzz|魏杖子|WKD|weizhangzi|wzz|1797@xan|新安|EAM|xinan|xa|1798@xan|兴安|XAZ|xingan|xa|1799@xax|新安县|XAF|xinanxian|xax|1800@xba|新保安|XAP|xinbaoan|xba|1801@xbc|下板城|EBP|xiabancheng|xbc|1802@xbl|西八里|XLP|xibali|xbl|1803@xch|宣城|ECH|xuancheng|xc|1804@xch|兴城|XCD|xingcheng|xc|1805@xcu|小村|XEM|xiaocun|xc|1806@xcy|新绰源|XRX|xinchuoyuan|xcy|1807@xcz|下城子|XCB|xiachengzi|xcz|1808@xcz|新城子|XCT|xinchengzi|xcz|1809@xde|喜德|EDW|xide|xd|1810@xdj|小得江|EJM|xiaodejiang|xdj|1811@xdm|西大庙|XMP|xidamiao|xdm|1812@xdo|小董|XEZ|xiaodong|xd|1813@xdo|小东|XOD|xiaodong|xd|1814@xfe|信丰|EFG|xinfeng|xf|1815@xfe|襄汾|XFV|xiangfen|xf|1816@xfe|息烽|XFW|xifeng|xf|1817@xga|新干|EGG|xingan|xg|1818@xga|孝感|XGN|xiaogan|xg|1819@xgc|西固城|XUJ|xigucheng|xgc|1820@xgu|西固|XIJ|xigu|xg|1821@xgy|夏官营|XGJ|xiaguanying|xgy|1822@xgz|西岗子|NBB|xigangzi|xgz|1823@xhe|襄河|XXB|xianghe|xh|1824@xhe|新和|XIR|xinhe|xh|1825@xhe|宣和|XWJ|xuanhe|xh|1826@xhj|斜河涧|EEP|xiehejian|xhj|1827@xht|新华屯|XAX|xinhuatun|xht|1828@xhu|新华|XHB|xinhua|xh|1829@xhu|新化|EHQ|xinhua|xh|1830@xhu|宣化|XHP|xuanhua|xh|1831@xhx|兴和西|XEC|xinghexi|xhx|1832@xhy|小河沿|XYD|xiaoheyan|xhy|1833@xhy|下花园|XYP|xiahuayuan|xhy|1834@xhz|小河镇|EKY|xiaohezhen|xhz|1835@xji|徐家|XJB|xujia|xj|1836@xji|峡江|EJG|xiajiang|xj|1837@xji|新绛|XJV|xinjiang|xj|1838@xji|辛集|ENP|xinji|xj|1839@xji|新江|XJM|xinjiang|xj|1840@xjk|西街口|EKM|xijiekou|xjk|1841@xjt|许家屯|XJT|xujiatun|xjt|1842@xjt|许家台|XTJ|xujiatai|xjt|1843@xjz|谢家镇|XMT|xiejiazhen|xjz|1844@xka|兴凯|EKB|xingkai|xk|1845@xla|小榄|EAQ|xiaolan|xl|1846@xla|香兰|XNB|xianglan|xl|1847@xld|兴隆店|XDD|xinglongdian|xld|1848@xle|新乐|ELP|xinle|xl|1849@xli|新林|XPX|xinlin|xl|1850@xli|小岭|XLB|xiaoling|xl|1851@xli|新李|XLJ|xinli|xl|1852@xli|西林|XYB|xilin|xl|1853@xli|西柳|GCT|xiliu|xl|1854@xli|仙林|XPH|xianlin|xl|1855@xlt|新立屯|XLD|xinlitun|xlt|1856@xlz|兴隆镇|XZB|xinglongzhen|xlz|1857@xlz|新立镇|XGT|xinlizhen|xlz|1858@xmi|新民|XMD|xinmin|xm|1859@xms|西麻山|XMB|ximashan|xms|1860@xmt|下马塘|XAT|xiamatang|xmt|1861@xna|孝南|XNV|xiaonan|xn|1862@xnb|咸宁北|XRN|xianningbei|xnb|1863@xni|兴宁|ENQ|xingning|xn|1864@xni|咸宁|XNN|xianning|xn|1865@xpd|犀浦东|XAW|xipudong|xpd|1866@xpi|西平|XPN|xiping|xp|1867@xpi|兴平|XPY|xingping|xp|1868@xpt|新坪田|XPM|xinpingtian|xpt|1869@xpu|霞浦|XOS|xiapu|xp|1870@xpu|溆浦|EPQ|xupu|xp|1871@xpu|犀浦|XIW|xipu|xp|1872@xqi|新青|XQB|xinqing|xq|1873@xqi|新邱|XQD|xinqiu|xq|1874@xqp|兴泉堡|XQJ|xingquanbu|xqp|1875@xrq|仙人桥|XRL|xianrenqiao|xrq|1876@xsg|小寺沟|ESP|xiaosigou|xsg|1877@xsh|杏树|XSB|xingshu|xs|1878@xsh|浠水|XZN|xishui|xs|1879@xsh|下社|XSV|xiashe|xs|1880@xsh|徐水|XSP|xushui|xs|1881@xsh|夏石|XIZ|xiashi|xs|1882@xsh|小哨|XAM|xiaoshao|xs|1883@xsp|新松浦|XOB|xinsongpu|xsp|1884@xst|杏树屯|XDT|xingshutun|xst|1885@xsw|许三湾|XSJ|xusanwan|xsw|1886@xta|湘潭|XTQ|xiangtan|xt|1887@xta|邢台|XTP|xingtai|xt|1888@xtx|仙桃西|XAN|xiantaoxi|xtx|1889@xtz|下台子|EIP|xiataizi|xtz|1890@xwe|徐闻|XJQ|xuwen|xw|1891@xwp|新窝铺|EPD|xinwopu|xwp|1892@xwu|修武|XWF|xiuwu|xw|1893@xxi|新县|XSN|xinxian|xx|1894@xxi|息县|ENN|xixian|xx|1895@xxi|西乡|XQY|xixiang|xx|1896@xxi|湘乡|XXQ|xiangxiang|xx|1897@xxi|西峡|XIF|xixia|xx|1898@xxi|孝西|XOV|xiaoxi|xx|1899@xxj|小新街|XXM|xiaoxinjie|xxj|1900@xxx|新兴县|XGQ|xinxingxian|xxx|1901@xxz|西小召|XZC|xixiaozhao|xxz|1902@xxz|小西庄|XXP|xiaoxizhuang|xxz|1903@xya|向阳|XDB|xiangyang|xy|1904@xya|旬阳|XUY|xunyang|xy|1905@xyb|旬阳北|XBY|xunyangbei|xyb|1906@xyd|襄阳东|XWN|xiangyangdong|xyd|1907@xye|兴业|SNZ|xingye|xy|1908@xyg|小雨谷|XHM|xiaoyugu|xyg|1909@xyi|信宜|EEQ|xinyi|xy|1910@xyj|小月旧|XFM|xiaoyuejiu|xyj|1911@xyq|小扬气|XYX|xiaoyangqi|xyq|1912@xyu|襄垣|EIF|xiangyuan|xy|1913@xyx|夏邑县|EJH|xiayixian|xyx|1914@xyx|祥云西|EXM|xiangyunxi|xyx|1915@xyy|新友谊|EYB|xinyouyi|xyy|1916@xyz|新阳镇|XZJ|xinyangzhen|xyz|1917@xzd|徐州东|UUH|xuzhoudong|xzd|1918@xzf|新帐房|XZX|xinzhangfang|xzf|1919@xzh|悬钟|XRP|xuanzhong|xz|1920@xzh|新肇|XZT|xinzhao|xz|1921@xzh|忻州|XXV|xinzhou|xz|1922@xzi|汐子|XZD|xizi|xz|1923@xzm|西哲里木|XRD|xizhelimu|xzlm|1924@xzz|新杖子|ERP|xinzhangzi|xzz|1925@yan|姚安|YAC|yaoan|ya|1926@yan|依安|YAX|yian|ya|1927@yan|永安|YAS|yongan|ya|1928@yax|永安乡|YNB|yonganxiang|yax|1929@ybl|亚布力|YBB|yabuli|ybl|1930@ybs|元宝山|YUD|yuanbaoshan|ybs|1931@yca|羊草|YAB|yangcao|yc|1932@ycd|秧草地|YKM|yangcaodi|ycd|1933@ych|阳澄湖|AIH|yangchenghu|ych|1934@ych|迎春|YYB|yingchun|yc|1935@ych|叶城|YER|yecheng|yc|1936@ych|盐池|YKJ|yanchi|yc|1937@ych|砚川|YYY|yanchuan|yc|1938@ych|阳春|YQQ|yangchun|yc|1939@ych|宜城|YIN|yicheng|yc|1940@ych|应城|YHN|yingcheng|yc|1941@ych|禹城|YCK|yucheng|yc|1942@ych|晏城|YEK|yancheng|yc|1943@ych|阳城|YNF|yangcheng|yc|1944@ych|阳岔|YAL|yangcha|yc|1945@ych|郓城|YPK|yuncheng|yc|1946@ych|雁翅|YAP|yanchi|yc|1947@ycl|云彩岭|ACP|yuncailing|ycl|"
			+ "1948@ycx|虞城县|IXH|yuchengxian|ycx|1949@ycz|营城子|YCT|yingchengzi|ycz|1950@yde|英德|YDQ|yingde|yd|1951@yde|永登|YDJ|yongdeng|yd|1952@ydi|尹地|YDM|yindi|yd|1953@ydi|永定|YGS|yongding|yd|1954@yds|雁荡山|YGH|yandangshan|yds|1955@ydu|于都|YDG|yudu|yd|1956@ydu|园墩|YAJ|yuandun|yd|1957@ydx|英德西|IIQ|yingdexi|ydx|1958@yfy|永丰营|YYM|yongfengying|yfy|1959@yga|杨岗|YRB|yanggang|yg|1960@yga|阳高|YOV|yanggao|yg|1961@ygu|阳谷|YIK|yanggu|yg|1962@yha|友好|YOB|youhao|yh|1963@yha|余杭|EVH|yuhang|yh|1964@yhc|沿河城|YHP|yanhecheng|yhc|1965@yhu|岩会|AEP|yanhui|yh|1966@yjh|羊臼河|YHM|yangjiuhe|yjh|1967@yji|永嘉|URH|yongjia|yj|1968@yji|营街|YAM|yingjie|yj|1969@yji|盐津|AEW|yanjin|yj|1970@yji|余江|YHG|yujiang|yj|1971@yji|燕郊|AJP|yanjiao|yj|1972@yji|姚家|YAT|yaojia|yj|1973@yjj|岳家井|YGJ|yuejiajing|yjj|1974@yjp|一间堡|YJT|yijianpu|yjp|1975@yjs|英吉沙|YIR|yingjisha|yjs|1976@yjs|云居寺|AFP|yunjusi|yjs|1977@yjz|燕家庄|AZK|yanjiazhuang|yjz|1978@yka|永康|RFH|yongkang|yk|1979@ykd|营口东|YGT|yingkoudong|ykd|1980@yla|银浪|YJX|yinlang|yl|1981@yla|永郎|YLW|yonglang|yl|1982@ylb|宜良北|YSM|yiliangbei|ylb|1983@yld|永乐店|YDY|yongledian|yld|1984@ylh|伊拉哈|YLX|yilaha|ylh|1985@yli|伊林|YLB|yilin|yl|1986@yli|杨陵|YSY|yangling|yl|1987@yli|彝良|ALW|yiliang|yl|1988@yli|杨林|YLM|yanglin|yl|1989@ylp|余粮堡|YLD|yuliangpu|ylp|1990@ylq|杨柳青|YQP|yangliuqing|ylq|1991@ylt|月亮田|YUM|yueliangtian|ylt|1992@yma|义马|YMF|yima|ym|1993@ymb|阳明堡|YVV|yangmingbu|ymb|1994@yme|玉门|YXJ|yumen|ym|1995@yme|云梦|YMN|yunmeng|ym|1996@ymo|元谋|YMM|yuanmou|ym|1997@yms|一面山|YST|yimianshan|yms|1998@yna|沂南|YNK|yinan|yn|1999@yna|宜耐|YVM|yinai|yn|2000@ynd|伊宁东|YNR|yiningdong|ynd|2001@yps|营盘水|YZJ|yingpanshui|yps|2002@ypu|羊堡|ABM|yangpu|yp|2003@yqb|阳泉北|YPP|yangquanbei|yqb|2004@yqi|乐清|UPH|yueqing|yq|2005@yqi|焉耆|YSR|yanqi|yq|2006@yqi|源迁|AQK|yuanqian|yq|2007@yqt|姚千户屯|YQT|yaoqianhutun|yqht|2008@yqu|阳曲|YQV|yangqu|yq|2009@ysg|榆树沟|YGP|yushugou|ysg|2010@ysh|月山|YBF|yueshan|ys|2011@ysh|玉石|YSJ|yushi|ys|2012@ysh|玉舍|AUM|yushe|ys|2013@ysh|偃师|YSF|yanshi|ys|2014@ysh|沂水|YUK|yishui|ys|2015@ysh|榆社|YSV|yushe|ys|2016@ysh|颍上|YVH|yingshang|ys|2017@ysh|窑上|ASP|yaoshang|ys|2018@ysh|元氏|YSP|yuanshi|ys|2019@ysl|杨树岭|YAD|yangshuling|ysl|2020@ysp|野三坡|AIP|yesanpo|ysp|2021@yst|榆树屯|YSX|yushutun|yst|2022@yst|榆树台|YUT|yushutai|yst|2023@ysz|鹰手营子|YIP|yingshouyingzi|ysyz|2024@yta|源潭|YTQ|yuantan|yt|2025@ytp|牙屯堡|YTZ|yatunpu|ytp|2026@yts|烟筒山|YSL|yantongshan|yts|2027@ytt|烟筒屯|YUX|yantongtun|ytt|2028@yws|羊尾哨|YWM|yangweishao|yws|2029@yxi|越西|YHW|yuexi|yx|2030@yxi|攸县|YOG|youxian|yx|2031@yxi|永修|ACG|yongxiu|yx|2032@yxx|玉溪西|YXM|yuxixi|yxx|2033@yya|弋阳|YIG|yiyang|yy|2034@yya|余姚|YYH|yuyao|yy|2035@yya|酉阳|AFW|youyang|yy|2036@yyd|岳阳东|YIQ|yueyangdong|yyd|2037@yyi|阳邑|ARP|yangyi|yy|2038@yyu|鸭园|YYL|yayuan|yy|2039@yyz|鸳鸯镇|YYJ|yuanyangzhen|yyz|2040@yzb|燕子砭|YZY|yanzibian|yzb|2041@yzh|仪征|UZH|yizheng|yz|2042@yzh|宜州|YSZ|yizhou|yz|2043@yzh|兖州|YZK|yanzhou|yz|2044@yzi|迤资|YQM|yizi|yz|2045@yzw|羊者窝|AEM|yangzhewo|yzw|2046@yzz|杨杖子|YZD|yangzhangzi|yzz|2047@zan|镇安|ZEY|zhenan|za|2048@zan|治安|ZAD|zhian|za|2049@zba|招柏|ZBP|zhaobai|zb|2050@zbw|张百湾|ZUP|zhangbaiwan|zbw|2051@zcc|中川机场|ZJJ|zhongchuanjichang|zcjc|2052@zch|枝城|ZCN|zhicheng|zc|2053@zch|子长|ZHY|zichang|zc|2054@zch|诸城|ZQK|zhucheng|zc|2055@zch|邹城|ZIK|zoucheng|zc|2056@zch|赵城|ZCV|zhaocheng|zc|2057@zda|章党|ZHT|zhangdang|zd|2058@zdi|正定|ZDP|zhengding|zd|2059@zdo|肇东|ZDB|zhaodong|zd|2060@zfp|照福铺|ZFM|zhaofupu|zfp|2061@zgt|章古台|ZGD|zhanggutai|zgt|2062@zgu|赵光|ZGB|zhaoguang|zg|2063@zhe|中和|ZHX|zhonghe|zh|2064@zhm|中华门|VNH|zhonghuamen|zhm|2065@zjb|枝江北|ZIN|zhijiangbei|zjb|2066@zjc|钟家村|ZJY|zhongjiacun|zjc|2067@zjg|朱家沟|ZUB|zhujiagou|zjg|2068@zjg|紫荆关|ZYP|zijingguan|zjg|2069@zji|周家|ZOB|zhoujia|zj|2070@zji|诸暨|ZDH|zhuji|zj|2071@zjn|镇江南|ZEH|zhenjiangnan|zjn|2072@zjt|周家屯|ZOD|zhoujiatun|zjt|2073@zjw|褚家湾|CWJ|zhujiawan|zjw|2074@zjx|湛江西|ZWQ|zhanjiangxi|zjx|2075@zjy|朱家窑|ZUJ|zhujiayao|zjy|2076@zjz|曾家坪子|ZBW|zengjiapingzi|zjpz|2077@zla|张兰|ZLV|zhanglan|zl|2078@zla|镇赉|ZLT|zhenlai|zl|2079@zli|枣林|ZIV|zaolin|zl|2080@zlt|扎鲁特|ZLD|zhalute|zlt|2081@zlx|扎赉诺尔西|ZXX|zhalainuoerxi|zlrex|2082@zmt|樟木头|ZOQ|zhangmutou|zmt|2083@zmu|中牟|ZGF|zhongmu|zm|2084@znd|中宁东|ZDJ|zhongningdong|znd|2085@zni|中宁|VNJ|zhongning|zn|2086@znn|中宁南|ZNJ|zhongningnan|znn|2087@zpi|镇平|ZPF|zhenping|zp|2088@zpi|漳平|ZPS|zhangping|zp|2089@zpu|泽普|ZPR|zepu|zp|2090@zqi|枣强|ZVP|zaoqiang|zq|2091@zqi|张桥|ZQY|zhangqiao|zq|2092@zqi|章丘|ZTK|zhangqiu|zq|2093@zrh|朱日和|ZRC|zhurihe|zrh|2094@zrl|泽润里|ZLM|zerunli|zrl|2095@zsb|中山北|ZGQ|zhongshanbei|zsb|2096@zsd|樟树东|ZOG|zhangshudong|zsd|2097@zsh|珠斯花|ZHD|zhusihua|zsh|2098@zsh|中山|ZSQ|zhongshan|zs|2099@zsh|柞水|ZSY|zhashui|zs|2100@zsh|钟山|ZSZ|zhongshan|zs|2101@zsh|樟树|ZSG|zhangshu|zs|2102@zwo|珠窝|ZOP|zhuwo|zw|2103@zwt|张维屯|ZWB|zhangweitun|zwt|2104@zwu|彰武|ZWD|zhangwu|zw|2105@zxi|棕溪|ZOY|zongxi|zx|2106@zxi|钟祥|ZTN|zhongxiang|zx|2107@zxi|资溪|ZXS|zixi|zx|2108@zxi|镇西|ZVT|zhenxi|zx|2109@zxi|张辛|ZIP|zhangxin|zx|2110@zxq|正镶白旗|ZXC|zhengxiangbaiqi|zxbq|2111@zya|紫阳|ZVY|ziyang|zy|2112@zya|枣阳|ZYN|zaoyang|zy|2113@zyb|竹园坝|ZAW|zhuyuanba|zyb|2114@zye|张掖|ZYJ|zhangye|zy|2115@zyu|镇远|ZUW|zhenyuan|zy|2116@zzd|漳州东|GOS|zhangzhoudong|zzd|2117@zzh|漳州|ZUS|zhangzhou|zz|2118@zzh|壮志|ZUX|zhuangzhi|zz|2119@zzh|子洲|ZZY|zizhou|zz|2120@zzh|中寨|ZZM|zhongzhai|zz|2121@zzh|涿州|ZXP|zhuozhou|zz|2122@zzi|咋子|ZAL|zhazi|zz|2123@zzs|卓资山|ZZC|zhuozishan|zzs|2124@zzx|株洲西|ZAQ|zhuzhouxi|zzx|2125@zzx|郑州西|XPF|zhengzhouxi|zzx|2126@abq|阿巴嘎旗|AQC|abagaqi|abgq|2127@aeb|阿尔山北|ARX|aershanbei|aesb|2128@alt|阿勒泰|AUR|aletai|alt|2129@are|安仁|ARG|anren|ar|2130@asx|安顺西|ASE|anshunxi|asx|2131@atx|安图西|AXL|antuxi|atx|2132@ayd|安阳东|ADF|anyangdong|ayd|2133@bba|博白|BBZ|bobai|bb|2134@bbu|八步|BBE|babu|bb|2135@bch|栟茶|FWH|bencha|bc|2136@bdd|保定东|BMP|baodingdong|bdd|2137@bfs|八方山|FGQ|bafangshan|bfs|2138@bgo|白沟|FEP|baigou|bg|2139@bha|滨海|FHP|binhai|bh|2140@bhb|滨海北|FCP|binhaibei|bhb|2141@bjn|宝鸡南|BBY|baojinan|bjn|2142@bjz|北井子|BRT|beijingzi|bjz|2143@bmj|白马井|BFQ|baimajing|bmj|2144@bqi|宝清|BUB|baoqing|bq|2145@bsh|璧山|FZW|bishan|bs|2146@bsp|白沙铺|BSN|baishapu|bsp|2147@bsx|白水县|BGY|baishuixian|bsx|2148@bta|板塘|NGQ|bantang|bt|2149@bxc|本溪新城|BVT|benxixincheng|bxxc|2150@bxi|彬县|BXY|binxian|bx|2151@bya|宾阳|UKZ|binyang|by|2152@byd|白洋淀|FWP|baiyangdian|byd|2153@byi|百宜|FHW|baiyi|by|2154@byn|白音华南|FNC|baiyinhuanan|byhn|2155@bzd|巴中东|BDE|bazhongdong|bzd|2156@bzh|滨州|BIK|binzhou|bz|2157@bzx|霸州西|FOP|bazhouxi|bzx|2158@cch|澄城|CUY|chengcheng|cc|2159@cgb|城固北|CBY|chenggubei|cgb|2160@cgh|查干湖|VAT|chaganhu|cgh|2161@chd|巢湖东|GUH|chaohudong|chd|2162@cji|从江|KNW|congjiang|cj|2163@cka|茶卡|CVO|chaka|ck|2164@clh|长临河|FVH|changlinhe|clh|2165@cln|茶陵南|CNG|chalingnan|cln|2166@cpd|常平东|FQQ|changpingdong|cpd|2167@cpn|常平南|FPQ|changpingnan|cpn|2168@cqq|长庆桥|CQJ|changqingqiao|cqq|2169@csb|长寿北|COW|changshoubei|csb|2170@csh|长寿湖|CSE|changshouhu|csh|2171@csh|常山|CSU|changshan|cs|2172@csh|潮汕|CBQ|chaoshan|cs|2173@csx|长沙西|RXQ|changshaxi|csx|2174@cti|朝天|CTE|chaotian|ct|2175@ctn|长汀南|CNS|changtingnan|ctn|2176@cwu|长武|CWY|changwu|cw|2177@cxi|长兴|CBH|changxing|cx|2178@cxi|苍溪|CXE|cangxi|cx|2179@cya|长阳|CYN|changyang|cy|2180@cya|潮阳|CNQ|chaoyang|cy|2181@czt|城子坦|CWT|chengzitan|czt|2182@dad|东安东|DCZ|dongandong|dad|2183@dba|德保|RBZ|debao|db|2184@dch|都昌|DCG|duchang|dc|2185@dch|东岔|DCJ|dongcha|dc|2186@dcn|东城南|IYQ|dongchengnan|dcn|2187@ddh|东戴河|RDD|dongdaihe|ddh|2188@ddx|丹东西|RWT|dandongxi|ddx|2189@deh|东二道河|DRB|dongerdaohe|dedh|2190@dfe|大丰|KRQ|dafeng|df|2191@dfn|大方南|DNE|dafangnan|dfn|2192@dgb|东港北|RGT|donggangbei|dgb|2193@dgs|大孤山|RMT|dagushan|dgs|2194@dgu|东莞|RTQ|dongguan|dg|2195@dhd|鼎湖东|UWQ|dinghudong|dhd|2196@dhs|鼎湖山|NVQ|dinghushan|dhs|2197@dji|道滘|RRQ|daojiao|dj|2198@dji|洞井|FWQ|dongjing|dj|2199@dji|垫江|DJE|dianjiang|dj|2200@dju|大苴|DIM|daju|dj|2201@dli|大荔|DNY|dali|dl|2202@dlz|大朗镇|KOQ|dalangzhen|dlz|2203@dqg|大青沟|DSD|daqinggou|dqg|2204@dqi|德清|DRH|deqing|dq|2205@dsd|东胜东|RSC|dongshengdong|dsd|2206@dsn|砀山南|PRH|dangshannan|dsn|2207@dsn|大石头南|DAL|dashitounan|dstn|2208@dtd|当涂东|OWH|dangtudong|dtd|2209@dtx|大通西|DTO|datongxi|dtx|2210@dwa|大旺|WWQ|dawang|dw|2211@dxb|定西北|DNJ|dingxibei|dxb|2212@dxd|德兴东|DDG|dexingdong|dxd|2213@dxi|德兴|DWG|dexing|dx|2214@dxs|丹霞山|IRQ|danxiashan|dxs|2215@dyb|大冶北|DBN|dayebei|dyb|2216@dyd|都匀东|KJW|duyundong|dyd|2217@dyn|东营南|DOK|dongyingnan|dyn|2218@dyu|大余|DYG|dayu|dy|2219@dzd|定州东|DOP|dingzhoudong|dzd|2220@dzh|端州|WZQ|duanzhou|dz|2221@dzn|大足南|FQW|dazunan|dzn|2222@ems|峨眉山|IXW|emeishan|ems|2223@epg|阿房宫|EGY|epanggong|epg|2224@ezd|鄂州东|EFN|ezhoudong|ezd|2225@fcb|防城港北|FBZ|fangchenggangbei|fcgb|2226@fcd|凤城东|FDT|fengchengdong|fcd|2227@fch|富川|FDZ|fuchuan|fc|2228@fcx|繁昌西|PUH|fanchangxi|fcx|2229@fdu|丰都|FUW|fengdu|fd|2230@flb|涪陵北|FEW|fulingbei|flb|2231@fli|枫林|FLN|fenglin|fl|2232@fni|富宁|FNM|funing|fn|2233@fpi|佛坪|FUY|foping|fp|2234@fqi|法启|FQE|faqi|fq|2235@frn|芙蓉南|KCQ|furongnan|frn|2236@fsh|复盛|FAW|fusheng|fs|2237@fso|抚松|FSL|fusong|fs|2238@fsx|佛山西|FOQ|foshanxi|fsx|2239@fsz|福山镇|FZQ|fushanzhen|fsz|2240@fti|福田|NZQ|futian|ft|2241@fyb|富源北|FBM|fuyuanbei|fyb|2242@fyu|抚远|FYB|fuyuan|fy|2243@fzd|抚州东|FDG|fuzhoudong|fzd|2244@fzh|抚州|FZG|fuzhou|fz|2245@gan|高安|GCG|gaoan|ga|2246@gan|广安南|VUW|guangannan|gan|2247@gan|贵安|GAE|guian|ga|2248@gbd|高碑店东|GMP|gaobeidiandong|gbdd|2249@gch|恭城|GCZ|gongcheng|gc|2250@gcn|藁城南|GUP|gaochengnan|gcn|2251@gdb|贵定北|FMW|guidingbei|gdb|2252@gdn|葛店南|GNN|gediannan|gdn|2253@gdx|贵定县|KIW|guidingxian|gdx|2254@ghb|广汉北|GVW|guanghanbei|ghb|2255@ghu|高花|HGD|gaohua|gh|2256@gju|革居|GEM|geju|gj|2257@gli|关岭|GLE|guanling|gl|2258@glx|桂林西|GEZ|guilinxi|glx|2259@gmc|光明城|IMQ|guangmingcheng|gmc|2260@gni|广宁|FBQ|guangning|gn|2261@gns|广宁寺|GQT|guangningsi|gns|2262@gnx|广南县|GXM|guangnanxian|gnx|2263@gpi|桂平|GAZ|guiping|gp|2264@gpz|弓棚子|GPT|gongpengzi|gpz|2265@gsd|赶水东|GDE|ganshuidong|gsd|2266@gsh|光山|GUN|guangshan|gs|2267@gsh|谷山|FFQ|gushan|gs|2268@gsl|观沙岭|FKQ|guanshaling|gsl|2269@gtb|古田北|GBS|gutianbei|gtb|2270@gtb|广通北|GPM|guangtongbei|gtb|2271@gtn|高台南|GAJ|gaotainan|gtn|2272@gtz|古田会址|STS|gutianhuizhi|gthz|2273@gyb|贵阳北|KQW|guiyangbei|gyb|2274@gyd|贵阳东|KEW|guiyangdong|gyd|2275@gyx|高邑西|GNP|gaoyixi|gyx|2276@han|惠安|HNS|huian|ha|2277@hbb|淮北北|PLH|huaibeibei|hbb|2278@hbd|鹤壁东|HFF|hebidong|hbd|2279@hcg|寒葱沟|HKB|hanconggou|hcg|2280@hch|霍城|SER|huocheng|hc|2281@hch|珲春|HUL|hunchun|hc|2282@hdd|邯郸东|HPP|handandong|hdd|2283@hdo|惠东|KDQ|huidong|hd|2284@hdp|哈达铺|HDJ|hadapu|hdp|2285@hdx|海东西|HDO|haidongxi|hdx|2286@hdx|洪洞西|HTV|hongtongxi|hdx|2287@heb|哈尔滨北|HTB|haerbinbei|hebb|2288@hfc|合肥北城|COH|hefeibeicheng|hfbc|2289@hfn|合肥南|ENH|hefeinan|hfn|2290@hga|黄冈|KGN|huanggang|hg|2291@hgd|黄冈东|KAN|huanggangdong|hgd|2292@hgd|横沟桥东|HNN|henggouqiaodong|hgqd|2293@hgx|黄冈西|KXN|huanggangxi|hgx|2294@hhe|洪河|HPB|honghe|hh|2295@hhn|怀化南|KAQ|huaihuanan|hhn|2296@hhq|黄河景区|HCF|huanghejingqu|hhjq|2297@hhu|花湖|KHN|huahu|hh|2298@hhu|惠环|KHQ|huihuan|hh|2299@hhu|后湖|IHN|houhu|hh|2300@hji|怀集|FAQ|huaiji|hj|2301@hkb|河口北|HBM|hekoubei|hkb|2302@hli|黄流|KLQ|huangliu|hl|2303@hln|黄陵南|VLY|huanglingnan|hln|2304@hme|鲘门|KMQ|houmen|hm|2305@hme|虎门|IUQ|humen|hm|2306@hmx|侯马西|HPV|houmaxi|hmx|2307@hna|衡南|HNG|hengnan|hn|2308@hnd|淮南东|HOH|huainandong|hnd|2309@hpu|合浦|HVZ|hepu|hp|2310@hqi|霍邱|FBH|huoqiu|hq|2311@hrd|怀仁东|HFV|huairendong|hrd|2312@hrd|华容东|HPN|huarongdong|hrd|2313@hrn|华容南|KRN|huarongnan|hrn|2314@hsb|黄石北|KSN|huangshibei|hsb|2315@hsb|黄山北|NYH|huangshanbei|hsb|2316@hsb|衡水北|IHP|hengshuibei|hsb|2317@hsd|贺胜桥东|HLN|heshengqiaodong|hsqd|2318@hsh|和硕|VUR|heshuo|hs|2319@hsn|花山南|KNN|huashannan|hsn|2320@hta|荷塘|KXQ|hetang|ht|2321@htd|黄土店|HKP|huangtudian|htd|2322@hyb|合阳北|HTY|heyangbei|hyb|2323@hyb|海阳北|HEK|haiyangbei|hyb|2324@hyi|槐荫|IYN|huaiyin|hy|2325@hyi|鄠邑|KXY|huyi|hyi|2326@hyk|花园口|HYT|huayuankou|hyk|2327@hzd|霍州东|HWV|huozhoudong|hzd|2328@hzn|惠州南|KNQ|huizhounan|hzn|2329@jan|建安|JUL|jianan|ja|2330@jch|泾川|JAJ|jingchuan|jc|2331@jdb|景德镇北|JDG|jingdezhenbei|jdzb|2332@jde|旌德|NSH|jingde|jd|2333@jfe|尖峰|PFQ|jianfeng|jf|2334@jha|近海|JHD|jinhai|jh|2335@jhx|蛟河西|JOL|jiaohexi|jhx|2336@jlb|军粮城北|JMP|junliangchengbei|jlcb|2337@jle|将乐|JLS|jiangle|jl|2338@jlh|贾鲁河|JLF|jialuhe|jlh|2339@jls|九郎山|KJQ|jiulangshan|jls|2340@jmb|即墨北|JVK|jimobei|jmb|2341@jmg|剑门关|JME|jianmenguan|jmg|2342@jnb|建宁县北|JCS|jianningxianbei|jnxb|2343@jni|江宁|JJH|jiangning|jn|2344@jnx|江宁西|OKH|jiangningxi|jnx|2345@jox|建瓯西|JUS|jianouxi|jox|2346@jqn|酒泉南|JNJ|jiuquannan|jqn|2347@jrx|句容西|JWH|jurongxi|jrx|2348@jsh|建水|JSM|jianshui|js|2349@jsh|尖山|JPQ|jianshan|js|2350@jss|界首市|JUN|jieshoushi|jss|2351@jxb|绩溪北|NRH|jixibei|jxb|2352@jxd|介休东|JDV|jiexiudong|jxd|2353@jxi|泾县|LOH|jingxian|jx|2354@jxi|靖西|JMZ|jingxi|jx|2355@jxn|进贤南|JXG|jinxiannan|jxn|2356@jyb|江油北|JBE|jiangyoubei|jyb|2357@jyn|嘉峪关南|JBJ|jiayuguannan|jygn|2358@jyn|简阳南|JOW|jianyangnan|jyn|2359@jyt|金银潭|JTN|jinyintan|jyt|2360@jyu|靖宇|JYL|jingyu|jy|2361@jyw|金月湾|PYQ|jinyuewan|jyw|2362@jyx|缙云西|PYH|jinyunxi|jyx|2363@jzh|晋中|JZV|jinzhong|jz|2364@jzh|景州|JEP|jingzhou|jz|2365@kfb|开封北|KBF|kaifengbei|kfb|2366@kfs|开福寺|FLQ|kaifusi|kfs|2367@khu|开化|KHU|kaihua|kh|2368@kln|凯里南|QKW|kailinan|kln|2369@klu|库伦|KLD|kulun|kl|2370@kmn|昆明南|KOM|kunmingnan|kmn|2371@kta|葵潭|KTQ|kuitan|kt|2372@kya|开阳|KVW|kaiyang|ky|2373@lad|隆安东|IDZ|longandong|lad|2374@lbb|来宾北|UCZ|laibinbei|lbb|2375@lbi|灵璧|GMH|lingbi|lb|2376@lbu|寮步|LTQ|liaobu|lb|2377@lby|绿博园|LCF|lvboyuan|lby|2378@lcb|隆昌北|NWW|longchangbei|lcb|2379@lcd|乐昌东|ILQ|lechangdong|lcd|2380@lch|临城|UUP|lincheng|lc|2381@lch|罗城|VCZ|luocheng|lc|2382@lch|陵城|LGK|lingcheng|lc|2383@lcz|老城镇|ACQ|laochengzhen|lcz|2384@ldb|龙洞堡|FVW|longdongbao|ldb|2385@ldn|乐都南|LVO|ledunan|ldn|2386@ldn|娄底南|UOQ|loudinan|ldn|2387@ldo|乐东|UQQ|ledong|ld|2388@ldy|离堆公园|INW|liduigongyuan|ldgy|2389@lfe|陆丰|LLQ|lufeng|lf|2390@lfe|龙丰|KFQ|longfeng|lf|2391@lfn|禄丰南|LQM|lufengnan|lfn|2392@lfx|临汾西|LXV|linfenxi|lfx|2393@lgn|临高南|KGQ|lingaonan|lgn|2394@lgu|麓谷|BNQ|lugu|lg|2395@lhe|滦河|UDP|luanhe|lh|2396@lhn|珞璜南|LNE|luohuangnan|lhn|2397@lhx|漯河西|LBN|luohexi|lhx|2398@ljd|罗江东|IKW|luojiangdong|ljd|2399@lji|柳江|UQZ|liujiang|lj|2400@ljn|利津南|LNK|lijinnan|ljn|2401@lkn|兰考南|LUF|lankaonan|lkn|2402@lks|龙口市|UKK|longkoushi|lks|2403@llb|兰陵北|COK|lanlingbei|llb|2404@llb|龙里北|KFW|longlibei|llb|2405@llb|沥林北|KBQ|lilinbei|llb|2406@lld|醴陵东|UKQ|lilingdong|lld|2407@lna|陇南|INJ|longnan|ln|2408@lpn|梁平南|LPE|liangpingnan|lpn|2409@lqu|礼泉|LGY|liquan|lq|2410@lsd|灵石东|UDV|lingshidong|lsd|2411@lsh|乐山|IVW|leshan|ls|2412@lsh|龙市|LAG|longshi|ls|2413@lsh|溧水|LDH|lishui|ls|2414@lsn|娄山关南|LSE|loushanguannan|lsgn|2415@lwj|洛湾三江|KRW|luowansanjiang|lwsj|2416@lxb|莱西北|LBK|laixibei|lxb|2417@lya|溧阳|LEH|liyang|ly|2418@lyi|临邑|LUK|linyi|ly|2419@lyn|柳园南|LNR|liuyuannan|lyn|2420@lzb|鹿寨北|LSZ|luzhaibei|lzb|2421@lzh|阆中|LZE|langzhong|lz|2422@lzn|临泽南|LDJ|linzenan|lzn|2423@mad|马鞍山东|OMH|maanshandong|masd|2424@mch|毛陈|MHN|maochen|mc|2425@mgd|明港东|MDN|minggangdong|mgd|2426@mhn|民和南|MNO|minhenan|mhn|2427@mji|闵集|MJN|minji|mj|2428@mla|马兰|MLR|malan|ml|2429@mle|民乐|MBJ|minle|ml|2430@mle|弥勒|MLM|mile|ml|2431@mns|玛纳斯|MSR|manasi|mns|2432@mpi|牟平|MBK|muping|mp|2433@mqb|闽清北|MBS|minqingbei|mqb|2434@mqb|民权北|MIF|minquanbei|mqb|2435@msd|眉山东|IUW|meishandong|msd|2436@msh|庙山|MSN|miaoshan|ms|2437@mxi|岷县|MXJ|minxian|mx|2438@myu|门源|MYO|menyuan|my|2439@myu|暮云|KIQ|muyun|my|2440@mzb|蒙自北|MBM|mengzibei|mzb|2441@mzh|孟庄|MZF|mengzhuang|mz|2442@mzi|蒙自|MZM|mengzi|mz|2443@nbu|南部|NBE|nanbu|nb|2444@nca|南曹|NEF|nancao|nc|2445@ncb|南充北|NCE|nanchongbei|ncb|2446@nch|南城|NDG|nancheng|nc|2447@ncx|南昌西|NXG|nanchangxi|ncx|2448@ndn|宁东南|NDJ|ningdongnan|ndn|2449@ndo|宁东|NOJ|ningdong|nd|2450@nfb|南芬北|NUT|nanfenbei|nfb|2451@nfe|南丰|NFG|nanfeng|nf|2452@nhd|南湖东|NDN|nanhudong|nhd|2453@njb|内江北|NKW|neijiangbei|njb|2454@nji|南江|FIW|nanjiang|nj|2455@njk|南江口|NDQ|nanjiangkou|njk|2456@nli|南陵|LLH|nanling|nl|2457@nmu|尼木|NMO|nimu|nm|2458@nnd|南宁东|NFZ|nanningdong|nnd|2459@nnx|南宁西|NXZ|nanningxi|nnx|2460@npb|南平北|NBS|nanpingbei|npb|2461@nqn|宁强南|NOY|ningqiangnan|nqn|2462@nxi|南雄|NCQ|nanxiong|nx|2463@nyo|纳雍|NYE|nayong|ny|2464@nyz|南阳寨|NYF|nanyangzhai|nyz|2465@pan|普安|PAN|puan|pa|2466@pax|普安县|PUE|puanxian|pax|2467@pbi|屏边|PBM|pingbian|pb|2468@pbn|平坝南|PBE|pingbanan|pbn|2469@pch|平昌|PCE|pingchang|pc|2470@pdi|普定|PGW|puding|pd|2471@pdu|平度|PAK|pingdu|pd|2472@pko|皮口|PUT|pikou|pk|2473@plc|盘龙城|PNN|panlongcheng|plc|2474@pls|蓬莱市|POK|penglaishi|pls|2475@pni|普宁|PEQ|puning|pn|2476@pnn|平南南|PAZ|pingnannan|pnn|2477@psb|彭山北|PPW|pengshanbei|psb|2478@psh|盘山|PUD|panshan|ps|2479@psh|坪上|PSK|pingshang|ps|2480@pxb|萍乡北|PBG|pingxiangbei|pxb|2481@pya|鄱阳|PYG|poyang|py|2482@pya|濮阳|PYF|puyang|py|2483@pyc|平遥古城|PDV|pingyaogucheng|pygc|2484@pyd|平原东|PUK|pingyuandong|pyd|2485@pzh|普者黑|PZM|puzhehei|pzh|2486@pzh|盘州|PAE|panzhou|pz|2487@pzh|彭州|PMW|pengzhou|pz|2488@qan|秦安|QGJ|qinan|qa|2489@qbd|青白江东|QFW|qingbaijiangdong|qbjd|2490@qch|青川|QCE|qingchuan|qc|2491@qdb|青岛北|QHK|qingdaobei|qdb|2492@qdo|祁东|QMQ|qidong|qd|2493@qdu|青堆|QET|qingdui|qd|2494@qfe|前锋|QFB|qianfeng|qf|2495@qjb|曲靖北|QBM|qujingbei|qjb|2496@qjd|綦江东|QDE|qijiangdong|qjd|2497@qji|曲江|QIM|qujiang|qj|2498@qli|青莲|QEW|qinglian|ql|2499@qqn|齐齐哈尔南|QNB|qiqihaernan|qqhen|2500@qsb|清水北|QEJ|qingshuibei|qsb|2501@qsh|青神|QVW|qingshen|qs|2502@qsh|岐山|QAY|qishan|qs|2503@qsh|庆盛|QSQ|qingsheng|qs|2504@qsx|清水县|QIJ|qingshuixian|qsx|2505@qsx|曲水县|QSO|qushuixian|qsx|2506@qxd|祁县东|QGV|qixiandong|qxd|2507@qxi|乾县|QBY|qianxian|qx|2508@qxn|旗下营南|QNC|qixiayingnan|qxyn|2509@qya|祁阳|QWQ|qiyang|qy|2510@qzn|全州南|QNZ|quanzhounan|qzn|2511@qzw|棋子湾|QZQ|qiziwan|qzw|2512@rbu|仁布|RUO|renbu|rb|2513@rcb|荣昌北|RQW|rongchangbei|rcb|2514@rch|荣成|RCK|rongcheng|rc|2515@rcx|瑞昌西|RXG|ruichangxi|rcx|2516@rdo|如东|RIH|rudong|rd|2517@rji|榕江|RVW|rongjiang|rj|2518@rkz|日喀则|RKO|rikaze|rkz|2519@rpi|饶平|RVQ|raoping|rp|2520@scl|宋城路|SFF|songchenglu|scl|2521@sdh|三道湖|SDL|sandaohu|sdh|2522@sdo|邵东|FIQ|shaodong|sd|2523@sdx|三都县|KKW|sanduxian|sdx|2524@sfa|胜芳|SUP|shengfang|sf|2525@sfb|双峰北|NFQ|shuangfengbei|sfb|2526@she|商河|SOK|shanghe|sh|"
			+ "2527@sho|泗洪|GQH|sihong|sh|2528@shu|四会|AHQ|sihui|sh|2529@sjd|石家庄东|SXP|shijiazhuangdong|sjzd|2530@sjn|三江南|SWZ|sanjiangnan|sjn|2531@sjz|三井子|OJT|sanjingzi|sjz|2532@slc|双流机场|IPW|shuangliujichang|sljc|2533@slx|石林西|SYM|shilinxi|slx|2534@slx|沙岭子西|IXP|shalingzixi|slzx|2535@slx|双流西|IQW|shuangliuxi|slx|2536@smb|三明北|SHS|sanmingbei|smb|2537@smi|嵩明|SVM|songming|sm|2538@sml|树木岭|FMQ|shumuling|sml|2539@smu|神木|HMY|shenmu|sm|2540@snq|苏尼特左旗|ONC|sunitezuoqi|sntzq|2541@spd|山坡东|SBN|shanpodong|spd|2542@sqi|石桥|SQE|shiqiao|sq|2543@sqi|沈丘|SQN|shenqiu|sq|2544@ssb|鄯善北|SMR|shanshanbei|ssb|2545@ssb|狮山北|NSQ|shishanbei|ssb|2546@ssb|三水北|ARQ|sanshuibei|ssb|2547@ssb|松山湖北|KUQ|songshanhubei|sshb|2548@ssh|狮山|KSQ|shishan|ss|2549@ssn|三水南|RNQ|sanshuinan|ssn|2550@ssn|韶山南|INQ|shaoshannan|ssn|2551@ssu|三穗|QHW|sansui|ss|2552@sti|石梯|STE|shiti|st|2553@swe|汕尾|OGQ|shanwei|sw|2554@sxb|歙县北|NPH|shexianbei|sxb|2555@sxb|绍兴北|SLH|shaoxingbei|sxb|2556@sxd|绍兴东|SSH|shaoxingdong|sxd|2557@sxi|泗县|GPH|sixian|sx|2558@sxi|始兴|IPQ|shixing|sx|2559@sya|泗阳|MPH|siyang|sy|2560@sya|双阳|OYT|shuangyang|sy|2561@syb|邵阳北|OVQ|shaoyangbei|syb|2562@syb|松原北|OCT|songyuanbei|syb|2563@syi|山阴|SNV|shanyin|sy|2564@szb|深圳北|IOQ|shenzhenbei|szb|2565@szh|神州|SRQ|shenzhou|sz|2566@szs|深圳坪山|IFQ|shenzhenpingshan|szps|2567@szs|石嘴山|QQJ|shizuishan|szs|2568@szx|石柱县|OSW|shizhuxian|szx|2569@tan|台安南|TAD|taiannan|tan|2570@tcb|桃村北|TOK|taocunbei|tcb|2571@tdb|田东北|TBZ|tiandongbei|tdb|2572@tdd|土地堂东|TTN|tuditangdong|tdtd|2573@tgx|太谷西|TIV|taiguxi|tgx|2574@tha|吐哈|THR|tuha|th|2575@tha|通海|TAM|tonghai|th|2576@thb|太和北|JYN|taihebei|thb|2577@thc|天河机场|TJN|tianhejichang|thjc|2578@thj|天河街|TEN|tianhejie|thj|2579@thx|通化县|TXL|tonghuaxian|thx|2580@tji|同江|TJB|tongjiang|tj|2581@tlb|铜陵北|KXH|tonglingbei|tlb|2582@tlb|吐鲁番北|TAR|tulufanbei|tlfb|2583@tni|泰宁|TNS|taining|tn|2584@trn|铜仁南|TNW|tongrennan|trn|2585@tsn|天水南|TIJ|tianshuinan|tsn|2586@twe|通渭|TWJ|tongwei|tw|2587@txd|田心东|KQQ|tianxindong|txd|2588@txh|汤逊湖|THN|tangxunhu|txh|2589@txi|藤县|TAZ|tengxian|tx|2590@tyn|太原南|TNV|taiyuannan|tyn|2591@tyx|通远堡西|TST|tongyuanpuxi|typx|2592@tzb|桐梓北|TBE|tongzibei|tzb|2593@tzd|桐梓东|TDE|tongzidong|tzd|2594@tzh|通州|TOP|tongzhou|tz|2595@wdd|文登东|WGK|wendengdong|wdd|2596@wfs|五府山|WFG|wufushan|wfs|2597@whb|威虎岭北|WBL|weihulingbei|whlb|2598@whb|威海北|WHK|weihaibei|whb|2599@wlb|乌兰察布|WPC|wulanchabu|wlcb|2600@wld|五龙背东|WMT|wulongbeidong|wlbd|2601@wln|乌龙泉南|WFN|wulongquannan|wlqn|2602@wlq|乌鲁木齐|WAR|wulumuqi|wlmq|2603@wns|五女山|WET|wunvshan|wns|2604@wsh|武胜|WSE|wusheng|ws|2605@wto|五通|WTZ|wutong|wt|2606@wwe|无为|IIH|wuwei|ww|2607@wws|瓦屋山|WAH|wawushan|wws|2608@wxx|闻喜西|WOV|wenxixi|wxx|2609@wyb|武义北|WDH|wuyibei|wyb|2610@wyb|武夷山北|WBS|wuyishanbei|wysb|2611@wyd|武夷山东|WCS|wuyishandong|wysd|2612@wyu|婺源|WYG|wuyuan|wy|2613@wyu|渭源|WEJ|weiyuan|wy|2614@wzb|万州北|WZE|wanzhoubei|wzb|2615@wzh|武陟|WIF|wuzhi|wz|2616@wzn|梧州南|WBZ|wuzhounan|wzn|2617@xab|兴安北|XDZ|xinganbei|xab|2618@xcd|许昌东|XVF|xuchangdong|xcd|2619@xch|项城|ERN|xiangcheng|xc|2620@xdd|新都东|EWW|xindudong|xdd|2621@xfe|西丰|XFT|xifeng|xf|2622@xfe|先锋|NQQ|xianfeng|xf|2623@xfl|湘府路|FVQ|xiangfulu|xfl|2624@xfx|襄汾西|XTV|xiangfenxi|xfx|2625@xgb|孝感北|XJN|xiaoganbei|xgb|2626@xgd|孝感东|GDN|xiaogandong|xgd|"
			+ "2627@xhd|西湖东|WDQ|xihudong|xhd|2628@xhn|新化南|EJQ|xinhuanan|xhn|2629@xhx|新晃西|EWQ|xinhuangxi|xhx|2630@xji|新津|IRW|xinjin|xj|2631@xjk|小金口|NKQ|xiaojinkou|xjk|2632@xjn|辛集南|IJP|xinjinan|xjn|2633@xjn|新津南|ITW|xinjinnan|xjn|2634@xnd|咸宁东|XKN|xianningdong|xnd|2635@xnn|咸宁南|UNN|xianningnan|xnn|2636@xpn|溆浦南|EMQ|xupunan|xpn|2637@xpx|西平西|EGQ|xipingxi|xpx|2638@xtb|湘潭北|EDQ|xiangtanbei|xtb|2639@xtd|邢台东|EDP|xingtaidong|xtd|2640@xwq|西乌旗|XWC|xiwuqi|xwq|2641@xwx|修武西|EXF|xiuwuxi|xwx|2642@xwx|修文县|XWE|xiuwenxian|xwx|2643@xxb|萧县北|QSH|xiaoxianbei|xxb|2644@xxd|新乡东|EGF|xinxiangdong|xxd|2645@xyb|新余北|XBG|xinyubei|xyb|2646@xyc|西阳村|XQF|xiyangcun|xyc|2647@xyd|信阳东|OYN|xinyangdong|xyd|2648@xyd|咸阳秦都|XOY|xianyangqindu|xyqd|2649@xyo|仙游|XWS|xianyou|xy|2650@xzc|新郑机场|EZF|xinzhengjichang|xzjc|2651@xzl|香樟路|FNQ|xiangzhanglu|xzl|2652@ybl|迎宾路|YFW|yingbinlu|ybl|2653@ycb|永城北|RGH|yongchengbei|ycb|2654@ycb|运城北|ABV|yunchengbei|ycb|2655@ycd|永川东|WMW|yongchuandong|ycd|2656@ycd|禹城东|YSK|yuchengdong|ycd|2657@ych|宜春|YEG|yichun|yc|2658@ych|岳池|AWW|yuechi|yc|2659@ydh|云东海|NAQ|yundonghai|ydh|2660@ydu|姚渡|AOJ|yaodu|yd|2661@yfd|云浮东|IXQ|yunfudong|yfd|2662@yfn|永福南|YBZ|yongfunan|yfn|2663@yge|雨格|VTM|yuge|yg|2664@yhe|洋河|GTH|yanghe|yh|2665@yjb|永济北|AJV|yongjibei|yjb|2666@yji|弋江|RVH|yijiang|yj|2667@yjp|于家堡|YKP|yujiapu|yjp|2668@yjx|延吉西|YXL|yanjixi|yjx|2669@ykn|永康南|QUH|yongkangnan|ykn|2670@ylh|运粮河|YEF|yunlianghe|ylh|2671@yli|炎陵|YAG|yanling|yl|2672@yln|杨陵南|YEY|yanglingnan|yln|2673@ymi|伊敏|YMX|yimin|ym|2674@yna|郁南|YKQ|yunan|yn|2675@ypi|银瓶|KPQ|yinping|yp|2676@ysh|永寿|ASY|yongshou|ys|2677@ysh|阳朔|YCZ|yangshuo|ys|2678@ysh|云山|KZQ|yunshan|ys|2679@ysn|玉山南|YGG|yushannan|ysn|2680@yta|永泰|YTS|yongtai|yt|2681@yta|银滩|CTQ|yintan|yt|2682@ytb|鹰潭北|YKG|yingtanbei|ytb|2683@ytn|烟台南|YLK|yantainan|ytn|2684@yto|伊通|YTL|yitong|yt|2685@ytx|烟台西|YTK|yantaixi|ytx|2686@yxi|尤溪|YXS|youxi|yx|2687@yxi|云霄|YBS|yunxiao|yx|2688@yxi|宜兴|YUH|yixing|yx|2689@yxi|玉溪|AXM|yuxi|yx|2690@yxi|阳信|YVK|yangxin|yx|2691@yxi|应县|YZV|yingxian|yx|2692@yxn|攸县南|YXG|youxiannan|yxn|2693@yxx|洋县西|YXY|yangxianxi|yxx|2694@yyb|余姚北|CTH|yuyaobei|yyb|2695@yzh|榆中|IZJ|yuzhong|yz|2696@zan|诏安|ZDS|zhaoan|za|2697@zdc|正定机场|ZHP|zhengdingjichang|zdjc|2698@zfd|纸坊东|ZMN|zhifangdong|zfd|2699@zge|准格尔|ZEC|zhungeer|zge|2700@zhb|庄河北|ZUT|zhuanghebei|zhb|2701@zhu|昭化|ZHW|zhaohua|zh|2702@zjb|织金北|ZJE|zhijinbei|zjb|2703@zjc|张家川|ZIJ|zhangjiachuan|zjc|2704@zji|芷江|ZPQ|zhijiang|zj|2705@zji|织金|IZW|zhijin|zj|2706@zka|仲恺|KKQ|zhongkai|zk|2707@zko|曾口|ZKE|zengkou|zk|2708@zli|左岭|ZSN|zuoling|zl|2709@zmd|樟木头东|ZRQ|zhangmutoudong|zmtd|2710@zmx|驻马店西|ZLN|zhumadianxi|zmdx|2711@zpu|漳浦|ZCS|zhangpu|zp|2712@zqd|肇庆东|FCQ|zhaoqingdong|zqd|2713@zqi|庄桥|ZQH|zhuangqiao|zq|2714@zsh|昭山|KWQ|zhaoshan|zs|2715@zsx|钟山西|ZAZ|zhongshanxi|zsx|2716@zxi|漳县|ZXJ|zhangxian|zx|2717@zyb|资阳北|FYW|ziyangbei|zyb|2718@zyi|遵义|ZYE|zunyi|zy|2719@zyn|遵义南|ZNE|zunyinan|zyn|2720@zyx|张掖西|ZEJ|zhangyexi|zyx|2721@zzb|资中北|WZW|zizhongbei|zzb|2722@zzd|涿州东|ZAP|zhuozhoudong|zzd|2723@zzd|枣庄东|ZNK|zaozhuangdong|zzd|2724@zzd|卓资东|ZDC|zhuozidong|zzd|2725@zzd|郑州东|ZAF|zhengzhoudong|zzd|2726@zzn|株洲南|KVQ|zhuzhounan|zzn|2727";

	public static class Target {
		private String source;
		private String target;
		private String type = "resolved";

		private double x = 0;

		private double y = 0;

		public Target() {
		};

	}

	public static class LinkedTrain {
		public String node;
		public LinkedTrain[] next;

		public LinkedTrain(String node) {
			this.node = node;
		}
	}

	public static class Station {
		private String name;
		private String code;

		private double west;
		private double east;
		private double south;
		private double north;

		public Station() {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public double getWest() {
			return west;
		}

		public void setWest(double west) {
			this.west = west;
		}

		public double getEast() {
			return east;
		}

		public void setEast(double east) {
			this.east = east;
		}

		public double getSouth() {
			return south;
		}

		public void setSouth(double south) {
			this.south = south;
		}

		public double getNorth() {
			return north;
		}

		public void setNorth(double north) {
			this.north = north;
		}
	}
}
