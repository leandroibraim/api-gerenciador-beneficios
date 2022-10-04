package br.com.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "TB_FAMILIA")
public class FamiliaBeneficioModelo {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer status;
	private Integer renda;
	private Integer pontos;
	private Integer numeroGeristro;
	private Integer buscaTodasFamiliasContempladas;
	private String nomeFamilia;

	@Column
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id")
	private List<DependenteBeneficioModelo> dependentes = new ArrayList<>();

}
