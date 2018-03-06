//WEB SERVICE NÃO FUNCIONOU EM UMA APICAÇÃO WEB COM .HTML, CONTINUAR VERIFICANDO

//package br.com.springmvc.config;
//
//import java.util.EnumSet;
//
//import javax.servlet.DispatcherType;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration.Dynamic;
//import javax.servlet.FilterRegistration;
//
//import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//public class Application implements WebApplicationInitializer {
//
//	/**
//	 * Servlet da contextualização e inicialização da aplicação.
//	 */
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//		webApplicationContext.setConfigLocations("br.com.springmvc.config");
//		
//		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(webApplicationContext));
//		appServlet.setLoadOnStartup(1);
//		appServlet.addMapping("/app/*");
//		
//		//Adiciona na lista todo o contexto da configuração da class ConfiguracaoBD
//		servletContext.addListener(new ContextLoaderListener(webApplicationContext));
//		
//		/*Filtro responsável por manter a transação aberta na sessão do usuário,
//		de acordo com o tipo da requisição.*/ 
//		FilterRegistration.Dynamic filter = servletContext.addFilter("openEntityManagerFilter", openEntityManagerInViewFilter());
//		filter.addMappingForUrlPatterns(getDispatcherTypes(), false, "/app/*");
//	}
//	
//	/**
//	 * Filter responsável por receber requisições da view para o controller;
//	 * Solução criada para resolver o problema de 'lazily do hibernate'.
//	 * Quando se é realizado a busca de um objeto ele abre e fecha a transação,
//	 * mais se ele tiver outro objeto'ex:objeto.getObjeto2', a transação já foi fechada.
//	 * Essa solução é pra manter a transação aberta na sessão do usuário.
//	 */
//	private OpenEntityManagerInViewFilter openEntityManagerInViewFilter(){
//		OpenEntityManagerInViewFilter inViewFilter = new OpenEntityManagerInViewFilter();
//		inViewFilter.setEntityManagerFactoryBeanName("entityManager");
//		return inViewFilter;
//	}
//	
//	/**
//	 * Método que irá filtrar os tipos de requisições.
//	 */
//	private EnumSet<DispatcherType> getDispatcherTypes(){
//		return EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC);
//	}
//}
