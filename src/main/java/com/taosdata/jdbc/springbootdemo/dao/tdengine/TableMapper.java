package com.taosdata.jdbc.springbootdemo.dao.tdengine;

import com.taosdata.jdbc.springbootdemo.domain.TableMetadata;

public interface TableMapper {

    boolean createSTable(TableMetadata tableMetadata);
}