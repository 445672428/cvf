package com.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
public class City {
    @Id
    private String cityId;    
    private String cityName;
    private String stationName;
    private String provinceName;
    private long searchCount;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WeatherRecord> weatherRecords = new ArrayList<>();

    //region //getter aand setter
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<WeatherRecord> getWeatherRecords() {
        return weatherRecords;
    }

    public void setWeatherRecords(List<WeatherRecord> weatherRecords) {
        this.weatherRecords = weatherRecords;
    }

    public long getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(long searchCount) {
        this.searchCount = searchCount;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stationName='" + stationName + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", searchCount=" + searchCount +
                ", weatherRecords=" + weatherRecords +
                '}';
    }

    public String toJsonString() {
        return "{\"cityId\":\"" + cityId
                + "\",\"cityName\":\"" + removeEnWords(cityName)
                + "\",\"stationName\":\"" + removeEnWords(stationName)
                + "\",\"provinceName\":\"" + removeEnWords(provinceName) + "\"}";
    }

    private String removeEnWords(String word) {
        return word.replaceAll("[a-zA-Z]", "");
    }

    public String getCityNameCN() {
        return getCityName().replaceAll("[a-zA-Z]", "");
    }
    //endregion

}
