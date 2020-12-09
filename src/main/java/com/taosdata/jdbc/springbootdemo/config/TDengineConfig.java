package com.taosdata.jdbc.springbootdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.taosdata.jdbc.springbootdemo.dao.tdengine"},sqlSessionTemplateRef  = "tdengineSqlSessionTemplate")
public class TDengineConfig {
    @Bean(name = "tdengineDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.tdengine-server")
    public DataSource tdengineDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "tdengineSqlSessionFactory")
    public SqlSessionFactory tdengineSqlSessionFactory(@Qualifier("tdengineDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/tdengine/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "tdengineTransactionManager")
    public DataSourceTransactionManager tdengineTransactionManager(@Qualifier("tdengineDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "tdengineSqlSessionTemplate")
    public SqlSessionTemplate tdengineSqlSessionTemplate(@Qualifier("tdengineSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);

    }
}
