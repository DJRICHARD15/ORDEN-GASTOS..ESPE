package com.HelpDesk.HelpDesk.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.HelpDesk.HelpDesk.dao.ContratoRepository;
import com.HelpDesk.HelpDesk.model.Contrato;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.ConstantesHelpDesk;
@CrossOrigin(origins= {ConstantesHelpDesk. DOMAINS_1})
@RestController
public class ContratoController {

	@Autowired
	private ContratoRepository contratoRepository;

	private ObjectMapper mapper;

	/* metodo editar y guardar */

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/saveOrUpdateContrato", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateContrato(@RequestBody String contratoJson)
			throws JsonParseException, JsonMappingException, IOException {

		Contrato contrato = new Contrato();

		this.mapper = new ObjectMapper();
		try {
			contrato = this.mapper.readValue(contratoJson, Contrato.class);
			System.out.println(contrato);

			if (!this.validate(contrato)) {
				System.out.println("if");
				return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
			}
			this.contratoRepository.save(contrato);
			System.out.println("save");
			return new ResponseEntity(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/getContrato", method = RequestMethod.GET)

	/* metodo buscar */

	public List<Contrato> getContrato() {

		return (List<Contrato>) this.contratoRepository.findAll();
	}

	@RequestMapping(value = "/deleteContrato", method = RequestMethod.POST)
	public void deleteContrato(@RequestBody String contratoJson) throws Exception {
		this.mapper = new ObjectMapper();
		Contrato contrato = this.mapper.readValue(contratoJson, Contrato.class);
		if (contrato.getRuc()==0L) {
			throw new Exception("El Id esta nulo");
		}
		this.contratoRepository.delete(contrato);
	}

	private boolean validate(Contrato contrato) {
		boolean isValid = true;

		return isValid;
	}
}