package com.bagus.findhawker;

import com.bagus.findhawker.hawker.HawkerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

@SpringBootApplication
@ComponentScan("com.bagus.findhawker")
public class FindhawkerApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FindhawkerApplication.class, args);
		HawkerService service = applicationContext.getBean(HawkerService.class);
		try {
			service.initializeHawkersData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
