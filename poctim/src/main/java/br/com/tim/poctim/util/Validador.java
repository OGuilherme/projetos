package br.com.tim.poctim.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.tim.poctim.bean.DadosResidenciaBean;
import br.com.tim.poctim.bean.DadosUsuarioBean;
import br.com.tim.poctim.bean.XmlErroBean;
import br.com.tim.poctim.enumarator.CodigoErroEnum;
import br.com.tim.poctim.exception.BusinessException;

@Component
public class Validador {

	private static final Logger log = LoggerFactory.getLogger(Validador.class);

	public Boolean validar(DadosUsuarioBean usuario, DadosResidenciaBean residencia) throws BusinessException {
		Boolean result = true;
		log.info("Inicio do processo de validação dos dados.");
		if (!validaData(usuario.getDataEmissao())) {
			throw new BusinessException(new XmlErroBean(usuario.getNome(), CodigoErroEnum.DATA_CNH_INVALIDA.getValue(),
					CodigoErroEnum.DATA_CNH_INVALIDA.getDocumento(), CodigoErroEnum.DATA_CNH_INVALIDA.getMensagem()));
		}
		if (!validaData(usuario.getDataNascimento())) {
			throw new BusinessException(
					new XmlErroBean(usuario.getNome(), CodigoErroEnum.DATA_NASCIMENTO_INVALIDA.getValue(),
							CodigoErroEnum.DATA_NASCIMENTO_INVALIDA.getDocumento(),
							CodigoErroEnum.DATA_NASCIMENTO_INVALIDA.getMensagem()));
		}
		if (!verificarDataVencimento(usuario.getDataValidade())) {
			throw new BusinessException(new XmlErroBean(usuario.getNome(), CodigoErroEnum.DATA_CNH_EXPIRADA.getValue(),
					CodigoErroEnum.DATA_CNH_EXPIRADA.getDocumento(), CodigoErroEnum.DATA_CNH_EXPIRADA.getMensagem()));
		}
		if (!validaCpf(usuario.getCpf())) {
			throw new BusinessException(new XmlErroBean(usuario.getNome(), CodigoErroEnum.CPF_INVALIDO.getValue(),
					CodigoErroEnum.CPF_INVALIDO.getDocumento(), CodigoErroEnum.CPF_INVALIDO.getMensagem()));
		}
		if (!validaData(residencia.getDataEmissao())) {
			throw new BusinessException(
					new XmlErroBean(usuario.getNome(), CodigoErroEnum.DATA_COMPROVANTE_RESIDENCIA_INVALIDO.getValue(),
							CodigoErroEnum.DATA_COMPROVANTE_RESIDENCIA_INVALIDO.getDocumento(),
							CodigoErroEnum.DATA_COMPROVANTE_RESIDENCIA_INVALIDO.getMensagem()));
		}
		if (!validaComprovanteDeResidencia(residencia.getDataVencimento())) {
			throw new BusinessException(
					new XmlErroBean(usuario.getNome(), CodigoErroEnum.DATA_COMPROVANTE_RESIDENCIA_EXPIRADO.getValue(),
							CodigoErroEnum.DATA_COMPROVANTE_RESIDENCIA_EXPIRADO.getDocumento(),
							CodigoErroEnum.DATA_COMPROVANTE_RESIDENCIA_EXPIRADO.getMensagem()));
		}
		if (!validaCEP(residencia.getCep(), residencia.getEndereco())) {
			throw new BusinessException(new XmlErroBean(usuario.getNome(), CodigoErroEnum.CEP_INVALIDO.getValue(),
					CodigoErroEnum.CEP_INVALIDO.getDocumento(), CodigoErroEnum.CEP_INVALIDO.getMensagem()));
		}
		if (!compararNomes(usuario.getNome(), residencia.getNome())) {
			throw new BusinessException(
					new XmlErroBean(usuario.getNome(), CodigoErroEnum.NOME_COMPROVANTE_RESIDENCIA_INVALIDO.getValue(),
							CodigoErroEnum.NOME_COMPROVANTE_RESIDENCIA_INVALIDO.getDocumento(),
							CodigoErroEnum.NOME_COMPROVANTE_RESIDENCIA_INVALIDO.getMensagem()));
		}
		log.info("Fim do processo de validação dos dados.");
		return result;
	}

	private Boolean validaData(String data) {
		log.info("Inicio do método de validação de data.");
		LocalDate date, dateAtual, dateMin;
		try {
			date = formataData(data);
			dateAtual = LocalDate.now();
			dateMin = LocalDate.of(1900, 01, 01);
			if (date.isBefore(dateAtual) && date.isAfter(dateMin)) {
				log.info("Fim do método de validação de data.");
				return true;
			} else {
				log.info("Fim do método de validação de data.");
				return false;
			}
		} catch (DateTimeParseException e) {
			log.error("Fim do método de validação de data. Erro: " + e.getMessage());
			return false;
		}
	}

	private Boolean verificarDataVencimento(String data) {
		log.info("Inicio do método de validação de data de vencimento.");
		LocalDate dateComp, dateAtual;
		try {
			dateComp = formataData(data);
			dateAtual = LocalDate.now();
			if (dateComp.isAfter(dateAtual) || dateComp.isEqual(dateAtual)) {
				log.info("Fim do método de validação de data de vencimento.");
				return true;
			} else {
				log.info("Fim do método de validação de data de vencimento.");
				return false;
			}
		} catch (DateTimeParseException e) {
			log.error("Fim do método de validação de data de vencimento. Erro: " + e.getMessage());
			return false;
		}
	}

	private Boolean validaComprovanteDeResidencia(String dataComprovante) {
		log.info("Inicio do método de validação do comprovante de residência.");
		int dia, mes, ano;
		LocalDate dataComp, dataAtual;
		try {
			dataComp = formataData(dataComprovante);
			dataAtual = LocalDate.now();
			if (dataComp.isAfter(dataAtual) || dataComp.isEqual(dataAtual)) {
				log.info("Fim do método de validação do comprovante de residência.");
				return true;
			} else {
				dia = dataAtual.getDayOfMonth() - dataComp.getDayOfMonth();
				mes = dataAtual.getMonthValue() - dataComp.getMonthValue();
				ano = dataAtual.getYear() - dataComp.getYear();
				if ((mes < 3 && ano == 0) || (dia == 0 && mes == 3 && ano == 0) || (-2 > mes && mes <= 1 && ano == 1)
						|| (-2 == mes && dia == 0 && ano == 1)) {
					log.info("Fim do método de validação do comprovante de residência.");
					return true;
				}
				log.info("Fim do método de validação do comprovante de residência.");
				return false;
			}

		} catch (DateTimeParseException e) {
			log.info("Fim do método de validação do comprovante de residência. Erro : " + e.getMessage());
			return false;
		}
	}

	private Boolean validaCEP(String cep, String endereco) {
		log.info("Inicio do método de validação do CEP.");
		RestTemplate restTemplate = new RestTemplate();
		String[] getJson = restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json/", String.class)
				.split("\"");
		String enderecoCep = getJson[7];
		Boolean result = comparaString(endereco, enderecoCep);
		log.info("Fim do método de validação do CEP.");
		return result;
	}

	private Boolean validaCpf(String CPF) {
		log.info("Inicio do método de validação do CPF.");
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11)) {
			log.info("Fim do método de validação do CPF.");
			return (false);
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11)) {
				dig10 = '0';
			} else {
				dig10 = (char) (r + 48);
			}

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11)) {
				dig11 = '0';
			} else {
				dig11 = (char) (r + 48);
			}
			log.info("Fim do método de validação do CPF.");
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
				return (true);
			} else {
				return (false);
			}
		} catch (InputMismatchException erro) {
			log.info("Fim do método de validação do CPF. Erro" + erro.getMessage());
			return (false);
		}
	}

	private Boolean compararNomes(String documento, String comprovante) {
		return comparaString(documento, comprovante);
	}

	private LocalDate formataData(String data) {
		String dateFormat = "dd/MM/yyyy";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate dataFormatada = LocalDate.parse(data, dateTimeFormatter);
		return dataFormatada;
	}

	protected Boolean comparaString(String a, String b) {
		log.info("Inicio do método de comparação de Strings.");
		String[] c = removeCaracterEspecial(a).trim().split("");
		String[] d = removeCaracterEspecial(b).trim().split("");
		Double acertividade = 0.0;
		for (int i = 0; i < c.length; i++) {
			if (i < d.length && c[i].equalsIgnoreCase(d[i])) {
				acertividade += 1;
			} else {
				for (int j = i; j <= i + 3; j++) {
					if (j < d.length && i < c.length && c[i].equalsIgnoreCase(d[j])) {
						acertividade += 1;
						break;
					}
				}
			}
		}
		log.info("Fim do método de comparação de strings.");
		if ((double) c.length * 0.75 <= acertividade) {
			return true;
		}
		return false;
	}

	private String removeCaracterEspecial(String a) {
		return a.replaceAll("[ãâàáä]", "a").replaceAll("[êèéë&]", "e").replaceAll("[îìíï]", "i")
				.replaceAll("[õôòóö]", "o").replaceAll("[ûúùü]", "u").replaceAll("[ÃÂÀÁÄ]", "A")
				.replaceAll("[ÊÈÉË]", "E").replaceAll("[ÎÌÍÏ]", "I").replaceAll("[ÕÔÒÓÖ]", "O")
				.replaceAll("[ÛÙÚÜ]", "U").replace('ç', 'c').replace('Ç', 'C').replace('ñ', 'n').replace('Ñ', 'N');
	}

	@SuppressWarnings("unused")
	private Boolean comparacaoDeString(String a, String b) {
		String[] c = removeCaracterEspecial(a).trim().split(" ");
		String[] d = removeCaracterEspecial(b).trim().split(" ");
		if (c.length == d.length) {
			for (int i = 0; i < c.length; i++) {
				if (c[i].length() == d[i].length()) {
					comparaString(c[i].toString(), d[i].toString());
				} else if (c[i].length() > 2 && d[i].length() > 2) {
					comparaString(c[i].toString(), d[i].toString());
				} else {
					if (c[i].length() > 2) {
					}
					if (d[i].length() > 2) {
					}
				}
			}
		} else if (c.length > d.length) {
			for (int i = 0; i < c.length; i++) {
				if (c[i].length() == d[i].length()) {

				}
			}
		} else {
			for (int i = 0; i < d.length; i++) {
				if (c[i].length() == d[i].length()) {

				}
			}
		}

		return false;
	}
}