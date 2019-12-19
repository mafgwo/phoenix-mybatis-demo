package com.mafgwo.phoenixmybatisdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.phoenix.queryserver.client.Driver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * hbase phoenix 扫描配置
 *
 * @author chenxiaoqi
 * @since 2019/09/17
 */
@Configuration
@MapperScan(basePackages = "com.mafgwo.phoenixmybatisdemo.mapper")
public class PhoenixForMybatisConfiguration {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource phoenixDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(Driver.class.getName());
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        return druidDataSource;
    }
}
