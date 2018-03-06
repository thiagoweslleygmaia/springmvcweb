package br.com.springmvc.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;

import br.com.springmvc.business.DepartamentoBusiness;
import br.com.springmvc.config.ConfigContextCore;
import br.com.springmvc.model.Departamento;

@Controller
@Path("/deparatamento")
//@ComponentScan("br.com.springmvc.*")
public class DepartamentoController {
	
	/** URL: http://localhost:8081/springmvcweb/deparatamento/listar */

	@Autowired
	private DepartamentoBusiness departamentoBusiness;
	
//	public DepartamentoController() {
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		departamentoBusiness = (DepartamentoBusiness) context.getBean("departamentoBusinessImpl");
//		context.close();
//	}
	
	@GET
	@Path("/listar")
	@Produces("application/json;charset=utf-8")
	public Response ola(){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ConfigContextCore.class/*ApplicationConfig.class*/);
		departamentoBusiness = (DepartamentoBusiness) context.getBean("departamentoBusinessImpl");
		context.close();
		
		try {
			List<Departamento> list = departamentoBusiness.listarDepartamentos();
			if(list!=null && list.size()>0) {
				return Response.ok(list).build();
			}else {
				return Response.ok("Nunhum registro encontrado.").build();
			}
		} catch (Exception e) {
			return Response.ok(e.getMessage()).build();
		}
	}
	
//	public static void main(String[] args) {
//		try {
//			AbstractApplicationContext context = new AnnotationConfigApplicationContext(configContextWeb.class);
//			DepartamentoBusiness departamentoBusiness = (DepartamentoBusiness) context.getBean("departamentoBusinessImpl");
//			List<Departamento> listDepart = departamentoBusiness.listarDepartamentos();
//			for (Departamento dep : listDepart) {
//				System.out.println(dep.getCodDepartamento());
//				System.out.println(dep.getNomeDepartamento());
//				System.out.println(dep.getLocalizacaoDepartamento());
//			}
//			context.close();
//		} catch (Exception e) {
//			Logger.getLogger(DepartamentoBusinessImpl.class).error(e.getMessage());
//		}
//	}
}
