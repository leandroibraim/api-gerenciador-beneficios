package br.com.gerenciador.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import br.com.gerenciador.dto.DependenteBeneficioDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TB_DEPENDENTES")
public class DependenteBeneficioModelo implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private Integer idade;
	private Date dataDeNascimento;

	public DependenteBeneficioModelo(DependenteBeneficioDto dependente) {
		nome = dependente.getNome();
		idade = dependente.getIdade();
	}
}
