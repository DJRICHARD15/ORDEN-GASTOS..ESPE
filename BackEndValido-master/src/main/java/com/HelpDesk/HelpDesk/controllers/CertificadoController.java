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

import com.HelpDesk.HelpDesk.dao.CertificadoRepository;
import com.HelpDesk.HelpDesk.model.Certificado;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import constants.ConstantesHelpDesk;
@CrossOrigin(origins= {ConstantesHelpDesk. DOMAINS_1})
@RestController
public class CertificadoController {

	@Autowired
	private CertificadoRepository certificadoRepository;

	private ObjectMapper mapper;

	/* metodo editar y guardar */

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/saveOrUpdateCertificado", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateCertificado(@RequestBody String certificadoJson)
			throws JsonParseException, JsonMappingException, IOException {

		Certificado certificado = new Certificado();

		this.mapper = new ObjectMapper();
		try {
			certificado = this.mapper.readValue(certificadoJson, Certificado.class);
			System.out.println(certificado);

			if (!this.validate(certificado)) {
				System.out.println("if");
				return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
			}
			this.certificadoRepository.save(certificado);
			System.out.println("save");
			return new ResponseEntity(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/getCertificado", method = RequestMethod.GET)

	/* metodo buscar */

	public List<Certificado> getCertificado() {

		return (List<Certificado>) this.certificadoRepository.findAll();
	}

	@RequestMapping(value = "/deleteCertificado", method = RequestMethod.POST)
	public void deleteCertificado(@RequestBody String certificadoJson) throws Exception {
		this.mapper = new ObjectMapper();
		Certificado certificado = this.mapper.readValue(certificadoJson, Certificado.class);
		if (certificado.getCodigo()==0L) {
			throw new Exception("El Id esta nulo");
		}
		this.certificadoRepository.delete(certificado);
	}

	private boolean validate(Certificado certificado) {
		boolean isValid = true;

		return isValid;
	}
}
