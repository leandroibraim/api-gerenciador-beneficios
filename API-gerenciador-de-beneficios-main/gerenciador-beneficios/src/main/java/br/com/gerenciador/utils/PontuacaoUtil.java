package br.com.gerenciador.utils;

public class PontuacaoUtil {

	private PontuacaoUtil() {
		throw new IllegalStateException("Utility class");
	}

	private static final Integer ZERO_PONTOS = 0;
	private static final Integer UM_PONTO = 1;
	private static final Integer DOIS_PONTOS = 2;
	private static final Integer TRES_PONTOS = 3;
	private static final Integer QUATRO_PONTOS = 4;
	private static final Integer CINCO_PONTOS = 5;
	private static final Integer ATE_2_DEPENDENTES = 2;

	private static final Integer ACIMA_DE_3_DEPENDENTES = 3;


	public static Integer getZeroPontos() {
		return ZERO_PONTOS;
	}

	public static Integer getUmPonto() {
		return UM_PONTO;
	}

	public static Integer getDoisPontos() {
		return DOIS_PONTOS;
	}

	public static Integer getTresPontos() {
		return TRES_PONTOS;
	}

	public static Integer getQuatroPontos() {
		return QUATRO_PONTOS;
	}

	public static Integer getCincoPontos() {
		return CINCO_PONTOS;
	}

	public static Integer getAte2Dependentes() {
		return ATE_2_DEPENDENTES;
	}

}
