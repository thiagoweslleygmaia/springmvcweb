//package br.com.springmvc.config;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.view.UrlBasedViewResolver;
//
//@EnableWebMvc
//@Configuration
//@ComponentScan(basePackages="br.com.springmvc")
//public class ConfiguracaoWeb extends WebMvcConfigurerAdapter {
//	
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
//		viewResolver.setPrefix("/WEB-INF/");
//		viewResolver.setSuffix(".html");
//		viewResolver.setViewClass(JstlView.class);
//		registry.viewResolver(viewResolver);
//	}
//}
