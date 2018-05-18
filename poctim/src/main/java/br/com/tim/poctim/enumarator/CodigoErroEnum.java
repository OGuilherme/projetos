package br.com.tim.poctim.enumarator;

import java.util.HashMap;

public enum CodigoErroEnum {
	DATA_NASCIMENTO_INVALIDA(7000, "CNH","Data de nascimento inválida"),
	CPF_INVALIDO(7001,"CNH","CPF inválido"),
	NOME_COMPROVANTE_RESIDENCIA_INVALIDO(7002,"Comprovante de residência", "Nome no comprovante de residência não é o mesmo da CNH"),
	DATA_COMPROVANTE_RESIDENCIA_INVALIDO(7003,"Comprovante de residência", "Data do comprovante de residência inválido"),
	DATA_COMPROVANTE_RESIDENCIA_EXPIRADO(7004,"Comprovante de residência", "Comprovante de residência com vecimento superior a 3 meses"),
	DATA_CNH_INVALIDA(7005, "CNH","CNH com data inválida"),
	DATA_CNH_EXPIRADA(7006,"CNH", "CNH vencida"),
	CEP_INVALIDO(7007, "Comprovante de residência", "Endereço do CEP não condiz com endereço no comprovante de residência");
	
	private Integer value;
	private String documento;
	private String mensagem;
	private static HashMap<Integer, CodigoErroEnum> map = new HashMap<Integer, CodigoErroEnum>();
	
	CodigoErroEnum(Integer newValue, String documento, String mensagem) {
		value = newValue;
		this.documento = documento;
		this.mensagem = mensagem;
	}
	
	static {
        for (CodigoErroEnum pageType : CodigoErroEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static CodigoErroEnum valueOf(Integer CodigoErroEnum) {
        return map.get(CodigoErroEnum);
    }

	public Integer getValue() {
		return value;
	}

	public String getDocumento() {
		return documento;
	}

	public String getMensagem() {
		return mensagem;
	}
}