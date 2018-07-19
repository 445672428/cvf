package com.frame.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.annotation.SysLogColumn;
import com.base.BaseService;
import com.utils.HttpUtils;

@Service
public class ConfigService extends BaseService{
	@Value("${img.src1}")
	public String IMG_SRC1;
	@Value("${img.src2}")
	public String IMG_SRC2;
	@Value("${img.src3}")
	public String IMG_SRC3;
	@Value("${img.src4}")
	public String IMG_SRC4;
	
	@Value("${websocket.savePath}")
	public String W_FILE_PATH;
	@Value("${websocket.blobSize}")
	public int W_FILE_BLOBSIZE;
	@Value("${websocket.textSize}")
	public int W_FILE_TEXTSIZE;
	
	
	
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	@SysLogColumn(operationName="查询天气接口")
	public String queryWeather(String city){
		
		JSONObject object = httpToWeather(city);
		
		return JSONObject.toJSONString(object);
	}
	
	@SysLogColumn(operationName="首页查询天气接口")
	public JSONObject httpToWeather(String city){
		String url = "http://47.106.87.178:8080/weather/getw?city="+city;
		String result = HttpUtils.doGet(url);
		if (null==result) {
			return null;
		}
		result = result.substring(0,result.length() - 1);
		result = result.substring(1,result.length());
		
		String[] eles = result.split(", ");
		int index = 0;
		JSONObject object = new JSONObject();
		for(String ele: eles){
			String[] r = ele.split("=");
			String cxt = r[1];
			switch (index) {
			case 1:
				object.put("dict", cxt);//武汉
				break;
			case 3:
				object.put("time", cxt);//2018/06/05 08:17:21
				break;
			case 4:
				object.put("detail", cxt);//今日天气实况：气温：23℃；风向/风力：西南风 1级；湿度：87%
				break;	
			case 6:
				object.put("tip", cxt);//紫外线指数：弱，辐射较弱，涂擦SPF12-15、PA+护肤品。 健臻·血糖指数：不易波动，天气条件好，血糖不易波动，可适时进行户外锻炼。 穿衣指数：热，适合穿T恤、短薄外套等夏季服装。 洗车指数：较适宜，无雨且风力较小，易保持清洁度。 空气污染指数：较差，气象条件较不利于空气污染物扩散。。 
				break;
			case 7:
				object.put("brief", cxt);//6月4日 阴转多云
				break;			
			case 8:
				cxt = cxt.replace("/", "～");
				object.put("range", cxt);	//19℃/28℃
				break;			
			case 10:
				object.put("img", cxt);	//2.gif
				break;
			default:
				break;
			}
			index ++;
		}
		
		return object;
	}
	@SysLogColumn(operationName="全国城市树")
	public JSONArray queryChinaCode(String parentCode) {
		if (null==parentCode) {
			parentCode = "0";
		}
		String sql = "select name,code,parentcode from china where parentcode = '"+parentCode+"'";
		logger.info(sql);
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		JSONArray array = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> china = list.get(i);
			JSONObject object = new JSONObject();
			object.put("id", china.get("code"));
			object.put("pId", china.get("parentcode"));
			object.put("name", china.get("name"));
			if (StringUtils.trim(parentCode).length()!=6) {
				object.put("isParent", true);
			}else{
				object.put("isParent", false);
			}
			array.add(object);
		}
		return array;
	}
}
