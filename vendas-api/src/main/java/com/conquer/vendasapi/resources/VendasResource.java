package com.conquer.vendasapi.resources;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conquer.vendasapi.dto.VendasApiDto;
import com.conquer.vendasapi.service.VendasService;
import com.google.gson.Gson;

@RestController
public class VendasResource {

	@Autowired
	private VendasService vendasService;
	
	@PostMapping(path = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarVenda(@RequestBody VendasApiDto venda, HttpServletRequest request){
		
		//Deve ser implementado aqui um sistema de reserva de matrícula para alterar a situação da matrícula antes de efetuar a venda e uma task para liberar as reservas expiradas
		if(vendasService.registrarVenda(venda)) {
			return ResponseEntity.ok().body(venda);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(venda);
		}
		
	}
	
	
	@GetMapping(value = "/lista-vendas", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> listarVendas(@RequestParam("data")  @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataVenda, HttpServletRequest request){
		//Listar as vendas efetuadas na data informada
		System.out.println(dataVenda);
		return ResponseEntity.ok("API Online");
	}
	
	@GetMapping(value = "/consulta-venda", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> consultarVenda(@RequestParam("id") Long idVenda, HttpServletRequest request){
		//Consulta uma venda a partir da id
		System.out.println(idVenda);
		return ResponseEntity.ok("API Online");
	}
}
