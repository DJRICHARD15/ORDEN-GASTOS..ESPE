package com.HelpDesk.HelpDesk.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.HelpDesk.HelpDesk.dao.HistorialEmpleadoRepository;
import com.HelpDesk.HelpDesk.model.HistorialEmpleado;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HistorialEmpleadoController {

	@Autowired
	private HistorialEmpleadoRepository historialEmpleadoRepository;

	private ObjectMapper mapper;

	/* metodo editar y guardar */

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/saveOrUpdateHistorialEmpleado", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateHistorialEmpleado(@RequestBody String historialEmpleadoJson)
			throws JsonParseException, JsonMappingException, IOException {
		HistorialEmpleado historialEmpleado = new HistorialEmpleado();

		this.mapper = new ObjectMapper();
		try {
			historialEmpleado = this.mapper.readValue(historialEmpleadoJson, HistorialEmpleado.class);
			System.out.println(historialEmpleado);

			if (!this.validate(historialEmpleado)) {
				System.out.println("if");
				return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
			}
			this.historialEmpleadoRepository.save(historialEmpleado);
			System.out.println("save");
			return new ResponseEntity(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/getHistorialEmpleado", method = RequestMethod.GET)

	/* metodo buscar */

	public List<HistorialEmpleado> getHistorialEmpleado() {

		return (List<HistorialEmpleado>) this.historialEmpleadoRepository.findAll();
	}

	@RequestMapping(value = "/deleteHistorialEmpleado", method = RequestMethod.POST)
	public void deleteHistorialEmpleado(@RequestBody String historialEmpleadoJson) throws Exception {
		this.mapper = new ObjectMapper();
		HistorialEmpleado login = this.mapper.readValue(historialEmpleadoJson, HistorialEmpleado.class);
		if (login.getHistEmp() == 0L) {
			throw new Exception("El Id esta nulo");
		}
		this.historialEmpleadoRepository.delete(login);
	}

	private boolean validate(HistorialEmpleado login) {
		boolean isValid = true;

		return isValid;
	}
}