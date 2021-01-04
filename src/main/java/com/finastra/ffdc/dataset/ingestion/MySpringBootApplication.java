package com.finastra.ffdc.dataset.ingestion;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MySpringBootApplication {

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    @Bean
	private static DataSource setupDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ds.setUsername("");
        ds.setPassword("");
        ds.setUrl("jdbc:sqlserver://[].database.windows.net:1433;database=[]");
        return ds;
    }
}