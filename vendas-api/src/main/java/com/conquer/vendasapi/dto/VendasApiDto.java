package com.conquer.vendasapi.dto;

import java.util.List;

import lombok.Data;

@Data
public class VendasApiDto {

	private String cpfAluno;
	
	private List<Long> produtos;
	
	private Double valor;
	
}
