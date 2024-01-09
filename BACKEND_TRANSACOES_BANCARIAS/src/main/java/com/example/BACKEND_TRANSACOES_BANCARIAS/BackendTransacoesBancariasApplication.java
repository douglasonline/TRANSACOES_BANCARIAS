package com.example.BACKEND_TRANSACOES_BANCARIAS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
public class BackendTransacoesBancariasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTransacoesBancariasApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		String defaultDbUrl = "jdbc:postgresql://localhost:5432/postgres"; // Banco de dados padrão
		DataSource defaultDataSource = DataSourceBuilder.create()
				.username("postgres")
				.password("1234")
				.url(defaultDbUrl)
				.driverClassName("org.postgresql.Driver")
				.build();

		createDatabaseIfNotExists(defaultDataSource);

		String targetDbUrl = "jdbc:postgresql://localhost:5432/transacoes_bancarias"; // Banco de dados desejado
		return DataSourceBuilder.create()
				.username("postgres")
				.password("1234")
				.url(targetDbUrl)
				.driverClassName("org.postgresql.Driver")
				.build();
	}

	private void createDatabaseIfNotExists(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String dbName = "transacoes_bancarias";
		String checkIfDatabaseExistsQuery = "SELECT 1 FROM pg_database WHERE datname = '" + dbName + "'";

		int result = jdbcTemplate.queryForList(checkIfDatabaseExistsQuery).size();
		if (result == 0) {
			jdbcTemplate.execute("CREATE DATABASE " + dbName);
		}
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("com.example.BACKEND_TRANSACOES_BANCARIAS.Model");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaProperties(hibernateProperties());
		return emf;
	}

	private Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update"); // Alterado para update
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		return hibernateProperties;
	}
}
