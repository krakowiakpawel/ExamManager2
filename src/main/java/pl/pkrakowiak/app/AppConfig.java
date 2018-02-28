package pl.pkrakowiak.app;

import java.util.Locale;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import pl.pkrakowiak.converter.ComMemberConverter;
import pl.pkrakowiak.converter.ExamConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.pkrakowiak")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.pkrakowiak.repo")

// DROP DATABASE your_db;
//
// CREATE DATABASE your_db
// DEFAULT CHARACTER SET utf8
// DEFAULT COLLATE utf8_general_ci;

public class AppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("ExamManager");
		return emfb;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(getExamConverter());
		registry.addConverter(getComMemberConverter());
	}

	@Bean
	public ExamConverter getExamConverter() {
		return new ExamConverter();
	}

	@Bean
	public ComMemberConverter getComMemberConverter() {
		return new ComMemberConverter();
	}

	@Bean(name = "localeResolver")
	public LocaleContextResolver getLocaleContextResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pl", "PL"));
		return localeResolver;
	}

	// ładowanie obrazków z webapp
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// @Bean
	// public Validator validator() {
	// return new LocalValidatorFactoryBean();
	// }

}
