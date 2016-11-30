package testImmutable;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages={"com.jbc.mesObj", "com.jbc.testImmutable"})
public class Config {
	
	@Bean
	public DataSource dataSource() {
	  DriverManagerDataSource ds = new DriverManagerDataSource();
//	  ds.setDriverClassName("com.mysql.jdbc.Driver");
	  ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	  ds.setUrl("jdbc:mysql://localhost/transfusionfile?serverTimezone=UTC");
	  ds.setUsername("jbc");
	  ds.setPassword("");
	  return ds;
	}
	
	@Bean
	public JdbcOperations jdbcTemplate(DataSource dataSource) {
	  return new JdbcTemplate(dataSource);
	}
	
}

