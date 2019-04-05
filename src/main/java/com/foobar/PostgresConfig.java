package com.foobar;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "barEntityManagerFactory", 
  transactionManagerRef = "barTransactionManager", 
  basePackages = {"com.foobar.bar.repo", "com.foobar.employee" })
@Profile("postgres")
public class PostgresConfig {

  @Bean(name = "barDataSource")
  @ConfigurationProperties(prefix = "datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "barEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
      @Qualifier("barDataSource") DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean emf = builder.dataSource(dataSource)
        .packages("com.foobar.bar.domain", "com.foobar.employee").persistenceUnit("bar").build();

    HibernateJpaVendorAdapter jpaVendorAdapter = createVendorAdaptor();
    emf.setJpaVendorAdapter(jpaVendorAdapter);
    return emf;
  }

  @Bean(name = "barTransactionManager")
  public PlatformTransactionManager barTransactionManager(
      @Qualifier("barEntityManagerFactory") EntityManagerFactory barEntityManagerFactory) {
    return new JpaTransactionManager(barEntityManagerFactory);
  }

  public static HibernateJpaVendorAdapter createVendorAdaptor() {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
    // jpaVendorAdapter.setGenerateDdl((Boolean) properties.get("generateDdl"));
    jpaVendorAdapter.setShowSql(true);

    return jpaVendorAdapter;
  }

}
