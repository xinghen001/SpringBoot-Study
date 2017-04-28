package com.billjc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wb266042 on 2017/4/28.
 */
@Configuration
@ConfigurationProperties(prefix = "second.datasource")
@MapperScan
public class SecondDataSourceConfig {

    protected static final String BASEPACKAGE = "";

}
