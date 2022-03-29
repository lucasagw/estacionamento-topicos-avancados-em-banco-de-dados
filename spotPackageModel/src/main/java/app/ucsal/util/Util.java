package app.ucsal.util;

import java.util.Collection;

import org.springframework.stereotype.Component;

@Component
public final class Util {
	
	@SuppressWarnings("unused")
	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	@SuppressWarnings("unused")
	private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	private static final int TAM_CNPJ = 14;

	private static final int TAM_CPF = 11;

	private static final String STRING_DEFAULT = "0";
	
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object value) {

		if (value == null) {
			return true;
		} else if (value instanceof Collection) {
			return ((Collection) value).isEmpty();
		}

		return false;
	}
	
	public static boolean isNotEmpty(String str) {
		return (str != null && str.length() > 0);
	}
	
	public static String removerNaoDigitos(String param) {

		if (param == null) {
			return null;
		}

		return param.replaceAll("\\D", "");
	}
	
	public static String cpfComMascara(String cpf) {
		if (cpf == null || cpf.equals("")) {
			return null;
		}

		cpf = removerCaracter(cpf);

		cpf = preencheString(cpf, TAM_CPF);

		return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
	}
	
	public static String cnpjComMascara(String cnpj) {
		if (cnpj == null || cnpj.equals("")) {
			cnpj = new String();
		}
		cnpj = removerCaracter(cnpj);

		cnpj = preencheString(cnpj, TAM_CNPJ);

		return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
	}
	
	public static String removerCaracter(String param) {

		if (param == null) {
			return null;
		}

		return param.replaceAll("\\D", "");
	}
	
	private static String preencheString(String param, int tamanho) {

		if (param == null) {
			param = new String();
		}
		int dif = tamanho - param.length();

		for (; dif > 0; dif--) {
			param = STRING_DEFAULT + param;
		}
		return param;
	}
}
