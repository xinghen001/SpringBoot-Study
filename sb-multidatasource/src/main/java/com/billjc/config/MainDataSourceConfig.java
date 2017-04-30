package com.billjc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by wb266042 on 2017/4/28.
 */

@Configuration
@ConfigurationProperties(prefix = "main.datasource")
@MapperScan(basePackages = MainDataSourceConfig.BASEPACKAGE,
        sqlSessionFactoryRef = "mainFactory")
public class MainDataSourceConfig {

    static final String BASEPACKAGE = "com.billjc.dao.main";
    static final String MAPPERLOCATION = "classpath:mapper/main/*.xml";
    static final String TYPEALIASESPACKAGE = "com.billjc.entity";

    private String url;
    private String username;
    private String password;

    @Bean
    @Primary
    public DataSource mainDataSource() {
        DruidDataSource mainDataSource = new DruidDataSource();
        mainDataSource.setUrl(url);
        mainDataSource.setUsername(username);
        mainDataSource.setPassword(password);
        return mainDataSource;
    }

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(mainDataSource());
    }

    @Bean(name = "mainFactory")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(mainDataSource());
        factory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MainDataSourceConfig.MAPPERLOCATION));
        factory.setTypeAliasesPackage(MainDataSourceConfig.TYPEALIASESPACKAGE);
        return factory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
