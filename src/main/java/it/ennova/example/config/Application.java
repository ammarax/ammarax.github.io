package it.ennova.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ComponentScan(basePackages = "it.ennova")
@EntityScan(basePackages = { "it.ennova.example.entity" })
@EnableJpaRepositories(basePackages = { "it.ennova.example.repository" })
@PropertySource("application.properties")
@SpringBootApplication
public class Application {

	
	@Autowired
	private Environment env;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	
	/**
	 * configure of DB source and configuration
	 */
	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
	 
	    return dataSource;
	}
}
