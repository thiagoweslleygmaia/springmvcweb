//WEB SERVICE N�O FUNCIONOU EM UMA APICA��O WEB COM .HTML, CONTINUAR VERIFICANDO

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
//	 * Servlet da contextualiza��o e inicializa��o da aplica��o.
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
//		//Adiciona na lista todo o contexto da configura��o da class ConfiguracaoBD
//		servletContext.addListener(new ContextLoaderListener(webApplicationContext));
//		
//		/*Filtro respons�vel por manter a transa��o aberta na sess�o do usu�rio,
//		de acordo com o tipo da requisi��o.*/ 
//		FilterRegistration.Dynamic filter = servletContext.addFilter("openEntityManagerFilter", openEntityManagerInViewFilter());
//		filter.addMappingForUrlPatterns(getDispatcherTypes(), false, "/app/*");
//	}
//	
//	/**
//	 * Filter respons�vel por receber requisi��es da view para o controller;
//	 * Solu��o criada para resolver o problema de 'lazily do hibernate'.
//	 * Quando se � realizado a busca de um objeto ele abre e fecha a transa��o,
//	 * mais se ele tiver outro objeto'ex:objeto.getObjeto2', a transa��o j� foi fechada.
//	 * Essa solu��o � pra manter a transa��o aberta na sess�o do usu�rio.
//	 */
//	private OpenEntityManagerInViewFilter openEntityManagerInViewFilter(){
//		OpenEntityManagerInViewFilter inViewFilter = new OpenEntityManagerInViewFilter();
//		inViewFilter.setEntityManagerFactoryBeanName("entityManager");
//		return inViewFilter;
//	}
//	
//	/**
//	 * M�todo que ir� filtrar os tipos de requisi��es.
//	 */
//	private EnumSet<DispatcherType> getDispatcherTypes(){
//		return EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC);
//	}
//}
