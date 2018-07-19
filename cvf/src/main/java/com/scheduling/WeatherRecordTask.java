package com.scheduling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pojo.City;

public class WeatherRecordTask {
	private static final Logger log = LoggerFactory.getLogger(WeatherRecordTask.class);
	
	public List<City> getAllCitesFromFile() {
		List<City> cities = new ArrayList<>(2650);
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("D:\\bobo\\repository\\cvf\\src\\main\\resources\\config\\cities.txt"));
			// 设置编码！当直接运行本文件的main方法时，是正常的UTF-8，当通过web访问Controller调用时就成了GBK，因此在这里设置。
			Scanner in = new Scanner(inputStream, "UTF-8");
			while (in.hasNext()) {
				City city = parseCity(in.nextLine());
				cities.add(city);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		log.info(cities.toString());
		return cities;
	}
	
	private City parseCity(String str) {
		City city = new City();
		String cityId = str.substring(str.indexOf("cityId='") + 8,
				str.indexOf("', cityName"));
		String cityName = str.substring(str.indexOf("cityName='") + 10,
				str.indexOf("', stationName"));
		String stationName = str.substring(str.indexOf("stationName='") + 13,
				str.indexOf("', provinceName"));
		String provinceName = str.substring(str.indexOf("provinceName='") + 14,
				str.lastIndexOf("'}"));
		city.setCityId(cityId);
		city.setCityName(cityName);
		city.setStationName(stationName);
		city.setProvinceName(provinceName);

		log.trace("parse city {}", city);

		return city;
	}
	
	
    public static void main(String[] args) {
    	WeatherRecordTask weatherRecordTask =new WeatherRecordTask();
    	 List<City> cityList = null;
        log.trace("读取资源文件");
        cityList = new WeatherRecordTask().getAllCitesFromFile();
    }
}
