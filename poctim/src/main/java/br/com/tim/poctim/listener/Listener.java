package br.com.tim.poctim.listener;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.tim.poctim.business.ProcessoBusiness;

@Component
public class Listener {

	private static final Logger log = LoggerFactory.getLogger(Listener.class);
	
	@Autowired
	private ProcessoBusiness processoBusiness;
	
	@Value("${path.xml.input}")
	private String caminhoXmlInput;

	@Scheduled(cron = "0 * * * * *")
	public void reportCurrentTime() {
		log.info("Verificando xmls");
		File file = new File(caminhoXmlInput);
		int count = file.listFiles().length;
		if(count == 3) {
			processoBusiness.start();
		}
	}
}