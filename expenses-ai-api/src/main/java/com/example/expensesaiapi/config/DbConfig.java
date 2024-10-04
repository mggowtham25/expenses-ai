package com.example.expensesaiapi.config;

import com.example.expensesaiapi.constant.Constant;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
public class DbConfig {

    @Autowired
    AppConfig appConfig;

    @Bean(name = "entityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManager() {

        Map<String, Object> jpaPropertiesMap = new HashMap<>();
        jpaPropertiesMap.put(Environment.FORMAT_SQL, appConfig.getFormatSql());
        jpaPropertiesMap.put(Environment.HBM2DDL_AUTO, appConfig.getDdlAuto());
        jpaPropertiesMap.put(Environment.DIALECT, appConfig.getHibernateDialect());
        jpaPropertiesMap.put(Environment.DEFAULT_SCHEMA, appConfig.getDbSchema());

        var em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(Constant.APP_ENTITY_PACKAGE);

        var vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(appConfig.getDatabasePlatform());
        vendorAdapter.setGenerateDdl(appConfig.getGenerateDdl());
        vendorAdapter.setShowSql(appConfig.getShowSql());

        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(jpaPropertiesMap);

        return em;
    }

    @Bean(name = "dataSourceManager")
    @Primary
    public DataSource dataSource() {

        var dataSource = new HikariDataSource();
        dataSource.setSchema(appConfig.getDbSchema());
        dataSource.setDriverClassName(appConfig.getDbDriverClass());
        dataSource.setJdbcUrl(appConfig.getDbUrl());
        dataSource.setUsername(appConfig.getDbUserName());
        dataSource.setPassword(appConfig.getDbPassword());

        return dataSource;
    }

    @Bean(name = "transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager() {

        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }
}
