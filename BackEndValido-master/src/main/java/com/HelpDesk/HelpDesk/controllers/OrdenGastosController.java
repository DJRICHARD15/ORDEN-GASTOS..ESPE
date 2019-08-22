package com.HelpDesk.HelpDesk.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.HelpDesk.HelpDesk.dao.OrdenGastosRepository;
import com.HelpDesk.HelpDesk.model.OrdenGastos;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import constants.ConstantesHelpDesk;
@CrossOrigin(origins= {ConstantesHelpDesk. DOMAINS_1})
@RestController
public class OrdenGastosController {

	@Autowired
	private OrdenGastosRepository ordenGastosRepository;
	

	private ObjectMapper mapper;

	/* metodo editar y guardar */

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/saveOrUpdateOrdenGastos", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateOrdenGastos(@RequestBody String ordenGastosJson)
			throws JsonParseException, JsonMappingException, IOException {

		OrdenGastos ordenGastos = new OrdenGastos();

		this.mapper = new ObjectMapper();
		try {
			ordenGastos = this.mapper.readValue(ordenGastosJson, OrdenGastos.class);
			System.out.println(ordenGastos);

			if (!this.validate(ordenGastos)) {
				System.out.println("if");
				return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
			}
			this.ordenGastosRepository.save(ordenGastos);
			System.out.println("save");
			return new ResponseEntity(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/getOrdenGastos", method = RequestMethod.GET)

	/* metodo buscar */

	public List<OrdenGastos> getOrdenGastos() {

		return (List<OrdenGastos>) this.ordenGastosRepository.findAll();
	}

	@RequestMapping(value = "/deleteOrdenGastos", method = RequestMethod.POST)
	public void deleteOrdenGastos(@RequestBody String ordenGastosJson) throws Exception {
		this.mapper = new ObjectMapper();
		OrdenGastos ordenGastos = this.mapper.readValue(ordenGastosJson, OrdenGastos.class);
		if (ordenGastos.getId_orden() == 0L) {
			throw new Exception("El Id esta nulo");
		}
		this.ordenGastosRepository.delete(ordenGastos);
	}

	private boolean validate(OrdenGastos ordenGastos) {
		boolean isValid = true;

		return isValid;
	}
}