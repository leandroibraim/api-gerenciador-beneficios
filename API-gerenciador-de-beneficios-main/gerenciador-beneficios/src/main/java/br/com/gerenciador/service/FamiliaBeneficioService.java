package br.com.gerenciador.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gerenciador.dto.DependenteBeneficioDto;
import br.com.gerenciador.repository.FamiliaBeneficioRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.gerenciador.dto.FamiliaBeneficioDto;
import br.com.gerenciador.model.DependenteBeneficioModelo;
import br.com.gerenciador.model.FamiliaBeneficioModelo;
import br.com.gerenciador.utils.MensagensUtil;
import br.com.gerenciador.utils.PontuacaoUtil;
import br.com.gerenciador.utils.RendasUtil;

@Service
public class FamiliaBeneficioService {

	private final FamiliaBeneficioRepository familiaBeneficioRepository;

	public FamiliaBeneficioService(FamiliaBeneficioRepository familiaBeneficioRepository) {
		this.familiaBeneficioRepository = familiaBeneficioRepository;
	}
	public void getFamiliaContemplada(FamiliaBeneficioDto familia) {

		FamiliaBeneficioModelo modelo = FamiliaBeneficioModelo.builder()
				.id(familia.getId())
				.nomeFamilia(familia.getNome())
				.renda(familia.getRendaFamilia())
				.pontos(familia.getPontos())
				.dependentes(listaDependente(familia.getDependentes()))
				.build();

		familiaBeneficioRepository.save(modelo);

	}
	public List<FamiliaBeneficioModelo> getTodasFamiliasContempladas() {
    	List<FamiliaBeneficioModelo> listaFamiliaContemplada =  familiaBeneficioRepository.findAll(Sort.by(Sort.Direction.DESC, "pontos"));
    	return listaFamiliaContemplada.stream().filter((FamiliaBeneficioModelo familia) -> familia.getPontos() != null).collect(Collectors.toList());
   }
	private List<DependenteBeneficioModelo> listaDependente(List<DependenteBeneficioDto> dependentes){ //Lista dependentes ordenado
		return dependentes.stream().map(DependenteBeneficioModelo::new).collect(Collectors.toList());
	}

    private Integer getFamiliaContempladaPorPontuacaoGeral(FamiliaBeneficioDto beneficiario) {
		int pontuacao = 0;
		if (beneficiario.getRendaFamilia() <= RendasUtil.getRendaFamiliarCincoPontos()) {
			pontuacao += PontuacaoUtil.getCincoPontos();
		}
		if (beneficiario.getRendaFamilia() > RendasUtil.getRendaFamiliarCincoPontos()
				&& beneficiario.getRendaFamilia() <= RendasUtil.getRendaFamiliarTresPontos()) {
			pontuacao += PontuacaoUtil.getTresPontos();
		}
		pontuacao += getPontuacaoPorDependentes(beneficiario.getDependentes());

		return pontuacao;
	}

	private int getPontuacaoPorDependentes(List<DependenteBeneficioDto> dependentes){
    	List<DependenteBeneficioDto> listDependentes = dependentes.stream()
				.filter((DependenteBeneficioDto dependente) -> dependente.getIdade() <= MensagensUtil.getMaiorIdade())
    			.collect(Collectors.toList());

		if(listDependentes.size() >= PontuacaoUtil.getTresPontos()){
            return PontuacaoUtil.getTresPontos();
        }

		if(listDependentes.size() > PontuacaoUtil.getDoisPontos()){
            return PontuacaoUtil.getDoisPontos();
        }

        return PontuacaoUtil.getZeroPontos();
    }

}