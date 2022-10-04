package br.com.gerenciador.controller;

import java.util.List;

import br.com.gerenciador.service.FamiliaBeneficioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gerenciador.dto.FamiliaBeneficioDto;
import br.com.gerenciador.model.FamiliaBeneficioModelo;

@RestController
@RequestMapping("familias")
public class GerenciadorFamiliaController {
	private final FamiliaBeneficioService familiaBeneficioService;

	public GerenciadorFamiliaController(FamiliaBeneficioService familiaBeneficioService) {
		this.familiaBeneficioService = familiaBeneficioService;
	}

	@GetMapping//(value = "/sortByPontos")
	public ResponseEntity<List<FamiliaBeneficioModelo>> buscaFamiliaMelhorPontuada() {
		List<FamiliaBeneficioModelo> listBeneficiario = familiaBeneficioService.getTodasFamiliasContempladas();
		if (listBeneficiario.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listBeneficiario);
	}
	
    @PostMapping()
    public ResponseEntity<String> addBeneficiario(@RequestBody FamiliaBeneficioDto familia){
        try {
        	familiaBeneficioService.getFamiliaContemplada(familia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Lista das familias beneficiadas gerada com sucesso!");
    }


    /* End-Points pronto abaixo, use conforme Necessidade. *
	@PostMapping
	public void incluiFamilia(@RequestBody FamiliaBeneficioModelo familia) {
		familiaBeneficioRepositorio.save(familia);
	}	
	@GetMapping(value = "/sortByPontos")
	public ResponseEntity<List<FamiliaBeneficioModelo>> buscaMelhorPontuacao() {
		List<FamiliaBeneficioModelo> result = familiaBeneficioRepositorio.findByOrderByPontos();
		return ResponseEntity.ok(result);
	}
	@GetMapping("/{numeroGeristro}")
	public Optional<FamiliaBeneficioModelo> buscaPorNumeroDeGeristro(@PathVariable Long numeroGeristro) {
		return familiaBeneficioRepositorio.findById(numeroGeristro);
	}
	@PutMapping
	public void atualizarFamilia(@RequestBody FamiliaBeneficioModelo atualizaFamilia) {
		familiaBeneficioRepositorio.save(atualizaFamilia);
	}
	@DeleteMapping("/{numeroGeristro}")
	public void deletarFamilia(@PathVariable Long numeroGeristro) {
		familiaBeneficioRepositorio.deleteById(numeroGeristro);
	} 
	*/
}
