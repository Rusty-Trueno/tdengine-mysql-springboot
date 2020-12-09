package com.taosdata.jdbc.springbootdemo.dao.tdengine;

import com.taosdata.jdbc.springbootdemo.domain.Weather;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WeatherMapper {

    int insert(Weather weather);

    int batchInsert(List<Weather> weatherList);

    List<Weather> select(@Param("limit") Long limit, @Param("offset")Long offset);

    void createDB();

    void createTable();
}
