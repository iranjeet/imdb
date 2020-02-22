package com.example.page.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages="com.example.dao",
		entityManagerFactoryRef = "applicationEntityManagerFactory",
        transactionManagerRef = "applicationTransactionManager")
public class ApplicationDbConfig {
    
	@Primary
    @Bean(name = "applicationDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
    @ConfigurationProperties(prefix = "applicationdb")
    public DataSource applicationDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Primary
    @PersistenceContext(unitName = "application")
    @Bean(name = "applicationEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean applicationEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("applicationDataSource") DataSource applicationDataSource) {
        return builder
                .dataSource(applicationDataSource)
                .packages("com.example.page.domain")
                .persistenceUnit("application")
                .build();
    }
    
    @Primary
    @Bean(name = "applicationTransactionManager")
    public PlatformTransactionManager applicationTransactionManager(
            @Qualifier("applicationEntityManagerFactory") EntityManagerFactory applicationEntityManagerFactory) {
        return new JpaTransactionManager(applicationEntityManagerFactory);
    }
}