package com.projetoPI.projetoPI;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	//MEU BANCO DE DADOS
	@Bean 
	public DataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/databasepi?useTimezone=true&serverTimezone=UTC");
		datasource.setUsername("root"); // Nome de usuário de acesso do BD
		datasource.setPassword("root"); // Senha utilizada no seu BD
		return datasource; 
		
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	adapter.setDatabase(Database.MYSQL);
	adapter.setShowSql(true); // Mostra o sql em execução
	adapter.setGenerateDdl(true);
	adapter.setDatabasePlatform("org.hibernate.dialect.MariaDBDialect");
	adapter.setPrepareConnection(true);
	
	return adapter;
	
	}

}
