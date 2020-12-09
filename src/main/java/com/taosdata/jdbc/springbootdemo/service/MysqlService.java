package com.taosdata.jdbc.springbootdemo.service;


import com.taosdata.jdbc.springbootdemo.dao.mysql.MysqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(transactionManager = "mysqlTransactionManager")
public class MysqlService {

    @Autowired
    private MysqlMapper mysqlDao;

    public Map selectOne() {
        return mysqlDao.selectOne();
    }
}
