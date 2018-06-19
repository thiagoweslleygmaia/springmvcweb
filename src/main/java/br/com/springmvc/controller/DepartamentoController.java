package br.com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.springmvc.departamento.business.DepartamentoBusiness;
import br.com.springmvc.model.Departamento;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	/** URL: http://localhost:8081/springmvcweb/departamento/listar */

	@Autowired
	private DepartamentoBusiness departamentoBusiness;
	
	@RequestMapping(value="/buscar", method=RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> buscar(@RequestBody Departamento departamento){
		try {
			Departamento dep = departamentoBusiness.buscarDepartamento(departamento);
			if(dep!=null) {
				return new ResponseEntity<Object>(dep, HttpStatus.OK);
			}else {
				return ResponseEntity.ok("Nunhum registro encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value="/listar", produces = "application/json")
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
	
	@RequestMapping(value="/incluir", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> incluir(@RequestBody Departamento departamento){
		try {
			departamentoBusiness.incluirDepartamento(departamento);
			return ResponseEntity.ok("Registro incluido com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value="/atualizar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> atualizar(@RequestBody Departamento departamento){
		try {
			departamentoBusiness.atualizarDepartamento(departamento);
			return ResponseEntity.ok("Registro atualizado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@RequestMapping(value="/excluir", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Object> excluir(@RequestBody Departamento departamento){
		try {
			departamentoBusiness.excluirDepartamento(departamento);
			return ResponseEntity.ok("Registro excluido com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
}