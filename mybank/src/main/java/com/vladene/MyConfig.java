package com.vladene;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.vladene.service.BankRmiRemote;

/**
 * This class i use for spring to configure application. It's an alaternative to xml conf files.
 * 
 * @author henri.tala
 *
 */
@Configuration
public class MyConfig {

	
	/**
	 * 
	 * @return Return the JaxService object that run at a the given adress 
	 */
	@Bean
	public SimpleJaxWsServiceExporter getJaxWS() {
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8089/myBank");
		return exporter;
	}
	
	
	/**
	 * 
	 * @param context
	 * 				Use to get bean that represent the RMIImplementation Service
	 * @return An a singleton bean that represent the RMI Service
	 * 			
	 */
	@Bean
	public RmiServiceExporter getRmiService(ApplicationContext context) {
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setService(context.getBean("myRmiService"));
		exporter.setRegistryPort(1099);
		exporter.setServiceInterface(BankRmiRemote.class);
		/**
		 * serviceName is mandatory and is use by RMI registry
		 */
		exporter.setServiceName("bank");
		return exporter;
		
		
	}
}
