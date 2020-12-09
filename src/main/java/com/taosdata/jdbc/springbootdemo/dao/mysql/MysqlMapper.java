package com.taosdata.jdbc.springbootdemo.dao.mysql;


import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MysqlMapper {
    Map selectOne();
}

