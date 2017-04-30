package com.billjc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by wb266042 on 2017/4/28.
 */
@Configuration
@ConfigurationProperties(prefix = "second.datasource")
@MapperScan(basePackages = SecondDataSourceConfig.BASEPACKAGE,
        sqlSessionFactoryRef = "secondFactory")
public class SecondDataSourceConfig {

    protected static final String BASEPACKAGE = "com.billjc.dao.second";
    protected static final String MAPPERLOCATION = "classpath:mapper/second/*.xml";
    protected static final String TYPEALIASESPACKAGE = "com.billjc.entity";

    private String url;
    private String username;
    private String password;

    @Bean
    public DataSource secondDataSource() {
        DruidDataSource secondDataSource = new DruidDataSource();
        secondDataSource.setUrl(url);
        secondDataSource.setUsername(username);
        secondDataSource.setPassword(password);
        return secondDataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(secondDataSource());
    }

    @Bean(name = "secondFactory")
    public SqlSessionFactoryBean sessionFactoryBean() throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(secondDataSource());
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SecondDataSourceConfig.MAPPERLOCATION));
        factoryBean.setTypeAliasesPackage(SecondDataSourceConfig.TYPEALIASESPACKAGE);
        return factoryBean;
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
