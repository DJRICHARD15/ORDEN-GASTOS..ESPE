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

import com.HelpDesk.HelpDesk.dao.DatosEmpleadoRepository;
import com.HelpDesk.HelpDesk.model.DatosEmpleado;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DatosEmpleadoController {

	@Autowired
	private DatosEmpleadoRepository datosEmpleadoRepository;

	private ObjectMapper mapper;

	/* metodo editar y guardar */

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/saveOrUpdateDatosEmpleado", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateDatosEmpleado(@RequestBody String datosEmpleadoJson)
			throws JsonParseException, JsonMappingException, IOException {

		DatosEmpleado datosEmpleado = new DatosEmpleado();

		this.mapper = new ObjectMapper();
		try {
			datosEmpleado = this.mapper.readValue(datosEmpleadoJson, DatosEmpleado.class);
			System.out.println(datosEmpleado);

			if (!this.validate(datosEmpleado)) {
				System.out.println("if");
				return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
			}
			this.datosEmpleadoRepository.save(datosEmpleado);
			System.out.println("save");
			return new ResponseEntity(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/getDatosEmpleado", method = RequestMethod.GET)

	/* metodo buscar */

	public List<DatosEmpleado> getDatosEmpleado() {

		return (List<DatosEmpleado>) this.datosEmpleadoRepository.findAll();
	}

	@RequestMapping(value = "/deleteDatosEmpleado", method = RequestMethod.POST)
	public void deleteDatosEmpleado(@RequestBody String datosEmpleadoJson) throws Exception {
		this.mapper = new ObjectMapper();
		DatosEmpleado datosEmpleado = this.mapper.readValue(datosEmpleadoJson, DatosEmpleado.class);
		if (datosEmpleado.getRuc() == 0L) {
			throw new Exception("El Id esta nulo");
		}
		this.datosEmpleadoRepository.delete(datosEmpleado);
	}

	private boolean validate(DatosEmpleado datosEmpleado) {
		boolean isValid = true;

		return isValid;
	}
}