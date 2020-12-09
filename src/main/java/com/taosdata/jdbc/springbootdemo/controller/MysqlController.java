package com.taosdata.jdbc.springbootdemo.controller;

import com.taosdata.jdbc.springbootdemo.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/mysql")
public class MysqlController {

    @Autowired
    private MysqlService mysqlService;

    @GetMapping("/{limit}")
    public Map queryPostingsByAccount (@PathVariable Long limit) {
        return mysqlService.selectOne();
    }

}
