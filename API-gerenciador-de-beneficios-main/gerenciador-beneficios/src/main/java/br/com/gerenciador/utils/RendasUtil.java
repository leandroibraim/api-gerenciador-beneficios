package br.com.gerenciador.utils;

public class RendasUtil {

	private RendasUtil() {
		throw new IllegalStateException("Class utilitaria");
	}

	private static final Integer RENDA_FAMILIAR_CINCO_PONTOS = 900;
	private static final Integer RENDA_FAMILIAR_TRES_PONTOS = 1500;

	public static Integer getRendaFamiliarCincoPontos() {
		return RENDA_FAMILIAR_CINCO_PONTOS;
	}

	public static Integer getRendaFamiliarTresPontos() {
		return RENDA_FAMILIAR_TRES_PONTOS;
	}
}
