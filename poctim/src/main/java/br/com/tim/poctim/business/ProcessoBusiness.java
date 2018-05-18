package br.com.tim.poctim.business;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.tim.poctim.bean.CadastroUsuarioBean;
import br.com.tim.poctim.bean.DadosResidenciaBean;
import br.com.tim.poctim.bean.DadosUsuarioBean;
import br.com.tim.poctim.bean.XmlErroBean;
import br.com.tim.poctim.converter.ResidenciaXmlToBean;
import br.com.tim.poctim.converter.UsuarioXmlToBean;
import br.com.tim.poctim.exception.BusinessException;
import br.com.tim.poctim.util.GeradorDeXML;
import br.com.tim.poctim.util.LeitorDeXML;
import br.com.tim.poctim.util.Validador;

@Component
public class ProcessoBusiness {

	private static final Logger log = LoggerFactory.getLogger(ProcessoBusiness.class);

	@Value("${path.xml.input}")
	private String caminhoXmlInput;

	@Value("${path.xml.output}")
	private String caminhoXmlOutput;

	@Autowired
	private LeitorDeXML leitorDeXml;

	@Autowired
	private GeradorDeXML geradorDeXml;

	@Autowired
	private ResidenciaXmlToBean converterResidencia;

	@Autowired
	private UsuarioXmlToBean converterUsuario;

	@Autowired
	private Validador validador;

	public void start() {
		DadosUsuarioBean usuario = null;
		DadosResidenciaBean residencia = null;
		try {
			usuario = converterUsuario.convertEntityToBean(leitorDeXml.getDadosUsuarioXml());
			residencia = converterResidencia.convertEntityToBean(leitorDeXml.getDadosResidenciaXml());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		moverArquivo();
		try {
			if (validador.validar(usuario, residencia)) {
				CadastroUsuarioBean bean = new CadastroUsuarioBean();
				bean.setResidencia(residencia);
				bean.setUsuario(usuario);
				try {
					geradorDeXml.gerarXml(bean);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		} catch (BusinessException e) {
			XmlErroBean bean = e.getErro();
			try {
				geradorDeXml.gerarXmlErro(bean);
			} catch (Exception er) {
				log.error(er.getMessage());
			}
		}
	}

	public void moverArquivo() {
		File dir1 = new File(caminhoXmlInput);
		if (dir1.isDirectory()) {
			File[] content = dir1.listFiles();
			for (int i = 0; i < content.length; i++) {
				content[i].renameTo(new File(caminhoXmlOutput + content[i].getName()));
			}
		}
	}
}
