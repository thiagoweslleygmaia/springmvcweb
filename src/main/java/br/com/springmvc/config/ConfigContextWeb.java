package br.com.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.springmvc.business.DepartamentoBusiness;
import br.com.springmvc.business.DepartamentoBusinessImpl;

@Configuration
@Import(value = { ConfigContextCore.class, ApplicationConfig.class })
@EnableTransactionManagement
@ComponentScan({ "br.com.springmvc" })
public class ConfigContextWeb {
	
	@Bean
	public DepartamentoBusiness departamentoBusiness() {
		return new DepartamentoBusinessImpl();
	}
}