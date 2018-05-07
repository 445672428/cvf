package com.utils;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class MapPosition {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//114.067262,22.554056
		Map<String,Object> mp=	findNeighPosition(114.067262,22.554056,10);
		for (Object v : mp.values()) {
			System.out.println(v.toString());
			
		}
	double km=	distance(113.96988203045626,22.554056,114.067262,22.554056);
	System.out.println(String.valueOf(km));
	}
	
	 private final static double R = 6371229; // 地球的半径
	 
	
	public static Map<String,Object> findNeighPosition(double longitude,double latitude,double distance){
		//先计算查询点的经纬度范围
	    double r = 6371;//地球半径千米
		double dis = distance;//距离
		double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));
		dlng = dlng*(180/Math.PI);//角度转为弧度
		double dlat = dis/r;
		dlat = dlat*(180/Math.PI);	
	
		double minlat =latitude-dlat;
		double maxlat = latitude+dlat;
		double minlng = longitude -dlng;
		double maxlng = longitude + dlng;
		Map<String,Object> mp=new HashedMap();
		mp.put("minlat", minlat);
		mp.put("maxlat", maxlat);
		mp.put("minlng", minlng);
		mp.put("maxlng", maxlng);
		return mp;
	}
	
	   
	    public static double getDistance(double longt1, double lat1, double longt2,double lat2) {
	        double x, y, distance;
	        x = (longt2 - longt1) * Math.PI * R
	                * Math.cos(((lat1 + lat2) / 2) * Math.PI / 180) / 180;
	        y = (lat2 - lat1) * Math.PI * R / 180;
	        distance = Math.hypot(x, y);
	        return distance;
	    }
	    
	  public static  double distance( double lon1,double lat1, double lon2, double lat2) {
	        double theta = lon1 - lon2;
	        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
	                    + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
	                    * Math.cos(deg2rad(theta));
	        dist = Math.acos(dist);
	        dist = rad2deg(dist);
	        double miles = dist * 60 * 1.1515;
	        //这个计算得出的结果是英里,如果要转换成公里,需要乘以1.609344,若是海里需要乘以0.8684
	        double km=miles*1.609344;
	        return km;
	    }
	    //将角度转换为弧度
	    static double deg2rad(double degree) {
	        return degree / 180 * Math.PI;
	    }
	    //将弧度转换为角度
	    static double rad2deg(double radian) {
	        return radian * 180 / Math.PI;
	    }


}
