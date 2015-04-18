package demo;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("demo")
@PropertySource(value = "classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories("demo")
public class DatabaseConfig {

	@Value("${spring.datasource.url}")
	private String datasourceurl;

	@Value("${spring.datasource.username}")
	private String datasourceuser;

	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
		bean.setPersistenceUnitName("application");
		bean.setPackagesToScan("demo");
		bean.setDataSource(dataSource());
		bean.setJpaDialect(jpaDialect());
		bean.setJpaVendorAdapter(jpaVendorAdapter());
		return bean;
	}

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		return vendorAdapter;
	}

	@Bean
	public HibernateJpaDialect jpaDialect() {
		// TODO Auto-generated method stub
		return new HibernateJpaDialect();
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dSource = new DriverManagerDataSource();
		dSource.setUrl(datasourceurl);
		dSource.setUsername(datasourceuser);
		dSource.setPassword(password);
		dSource.setDriverClassName(driver);
		return dSource;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager txMgr = new JpaTransactionManager();
		txMgr.setDataSource(dataSource());
		txMgr.setEntityManagerFactory(emf);
		txMgr.setJpaDialect(jpaDialect());
	    return txMgr;
	}
	

}
