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

import com.HelpDesk.HelpDesk.dao.LoginRepository;
import com.HelpDesk.HelpDesk.model.Login;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;

	private ObjectMapper mapper;

	/* metodo editar y guardar */

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/saveOrUpdateLogin", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateLogin(@RequestBody String loginJson)
			throws JsonParseException, JsonMappingException, IOException {

		Login login = new Login();

		this.mapper = new ObjectMapper();
		try {
			login = this.mapper.readValue(loginJson, Login.class);
			System.out.println(login);

			if (!this.validate(login)) {
				System.out.println("if");
				return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
			}
			this.loginRepository.save(login);
			System.out.println("save");
			return new ResponseEntity(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/getLogin", method = RequestMethod.GET)

	/* metodo buscar */

	public List<Login> getLogin() {

		return (List<Login>) this.loginRepository.findAll();
	}

	@RequestMapping(value = "/deleteOrdenLogin", method = RequestMethod.POST)
	public void deleteLogin(@RequestBody String loginJson) throws Exception {
		this.mapper = new ObjectMapper();
		Login login = this.mapper.readValue(loginJson, Login.class);
		if (login.getUsuario() == 0L) {
			throw new Exception("El Id esta nulo");
		}
		this.loginRepository.delete(login);
	}

	private boolean validate(Login login) {
		boolean isValid = true;

		return isValid;
	}
}