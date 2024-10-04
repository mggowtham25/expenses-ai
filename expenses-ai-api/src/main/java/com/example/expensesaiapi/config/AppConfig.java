package com.example.expensesaiapi.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AppConfig {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUserName;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.ddlauto}")
    private String ddlAuto;

    @Value("${db.hibernate.dialect}")
    private String hibernateDialect;

    @Value("${db.show_sql}")
    private Boolean showSql;

    @Value("${db.format_sql}")
    private Boolean formatSql;

    @Value("${db.generate_ddl}")
    private Boolean generateDdl;

    @Value("${db.database_platform}")
    private String databasePlatform;

    @Value("${db.schema}")
    private String dbSchema;

    @Value("${db.driverclassname}")
    private String dbDriverClass;

    @Value("${db.poolname}")
    private String dbPoolName;

    @Value("${db.minimumidle}")
    private Integer dbMinimumIdle;

    @Value("${db.maximumpoolsize}")
    private Integer dbMaximumPoolSize;

    @Value("${db.idletimeout}")
    private Long dbIdleTimeout;

    @Value("${db.connectiontimeout}")
    private Long dbConnectionTimeout;

}
