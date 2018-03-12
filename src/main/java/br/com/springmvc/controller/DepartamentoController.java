package br.com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springmvc.business.DepartamentoBusiness;
import br.com.springmvc.model.Departamento;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {
	
	/** URL: http://localhost:8081/springmvcweb/deparatamento/listar */

	@Autowired
	private DepartamentoBusiness departamentoBusiness;
	
	@RequestMapping(value="/listar")
	public ResponseEntity<Object> listar(){
		try {
			List<Departamento> list = departamentoBusiness.listarDepartamentos();
			if(list!=null && list.size()>0) {
				return new ResponseEntity<Object>(list, HttpStatus.OK);
			}else {
				return ResponseEntity.ok("Nunhum registro encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
}