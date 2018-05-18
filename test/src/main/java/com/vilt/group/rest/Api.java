package com.vilt.group.rest;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vilt.group.teste;
import com.vilt.group.bean.CadastroUsuario;

@RestController
public class Api {
	@Autowired
	teste teste = new teste();

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getObjeto", method = RequestMethod.GET)
	public CadastroUsuario getObjeto() throws JAXBException {
		CadastroUsuario user = new CadastroUsuario("Guilherme de Oliveira", "Antônio Carlos de Oliveira",
				"Leila Rodrigues Araujo de Oliveira", "14/02/1996", "44522896816", "377961383", "SP", "01/06/2014",
				"01/06/2019", "Av Berrini,376", "04571000", "São Paulo", "São Paulo", "17/05/2019", "17/05/2018");
		StringWriter sw = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(CadastroUsuario.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.marshal(user, sw);
		String xmlString = sw.toString();
		return user;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getTriangulo", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getTriangulo() {
		return teste.calcularTriangulo(teste.gerarNumeroI(), teste.gerarNumeroI(), teste.gerarNumeroI());
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getRaio", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getRaio() {
		return teste.calcularRaio(teste.gerarNumeroD());
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getRaio/{a}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String getRaioComParametro(@PathVariable Double a) {
		return teste.calcularRaio(a);
	}
}
