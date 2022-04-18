package com.bcp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bcp.exception.ModeloNotFoundException;
import com.bcp.model.Conversion;
import com.bcp.model.Tipocambio;
import com.bcp.service.IConversionService;
import com.bcp.service.ITipocambioService;
import com.bcp.service.impl.UsuarioServiceImpl;


@RestController
@RequestMapping("/conversion")

public class ConversionController {

	@Autowired
	private ITipocambioService service;
	
	@Autowired
	private IConversionService serviceConversion;
	
	
	

	String tipcam, smontipcam;

	@GetMapping
	public ResponseEntity<List<Tipocambio>> listar() throws Exception {
		List<Tipocambio> lista = service.listar();
		return new ResponseEntity<List<Tipocambio>>(lista, HttpStatus.OK);
	}

	@PostMapping
	public Conversion resultado(@RequestBody Conversion objConversion) throws Exception {

		tipcam = service.RecuperarTipoCambio(LocalDate.now());
		smontipcam = String.format("%.2f", objConversion.getMonto() * Double.parseDouble(tipcam));

		Authentication usuarioLogueado = SecurityContextHolder.getContext().getAuthentication();
		
		Conversion conversion = new Conversion();
		conversion.setMonto(objConversion.getMonto());
		conversion.setMontocontipocambio(Double.parseDouble(smontipcam));
		conversion.setMonedaorigen(objConversion.getMonedaorigen());
		conversion.setMonedadestino(objConversion.getMonedadestino());
		conversion.setTipocambio(Double.parseDouble(tipcam));
		conversion.setUsuarioLogueado(usuarioLogueado.getName());
		
		
		
		return serviceConversion.registrar(conversion);

	}

}
