package com.fintech.soap_task_client.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.ws.client.support.interceptor.ClientInterceptor;
//import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
//import org.springframework.ws.soap.security.wss4j2.support.CryptoFactoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.client.support.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.support.CryptoFactoryBean;

import java.io.IOException;

@Configuration
@EnableScheduling
public class WsConfig {
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("com.fintech.soap_task_client.generated");
        return jaxb2Marshaller;
    }

//    @Bean
//    public Wss4jSecurityInterceptor securityInterceptor() {
//        Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
//        wss4jSecurityInterceptor.setSecurementActions("Timestamp");
//        wss4jSecurityInterceptor.setSecurementUsername("admin");
//        wss4jSecurityInterceptor.setSecurementPassword("password");
//        return wss4jSecurityInterceptor;
//    }

    @Bean
    public SoapConnector soapConnector(Jaxb2Marshaller marshaller) throws Exception {
        SoapConnector connector = new SoapConnector();
        connector.setDefaultUri("http://localhost:8080/ws");
        connector.setMarshaller(marshaller);
        connector.setUnmarshaller(marshaller);
        connector.setInterceptors(new ClientInterceptor[]{wss4jSecurityInterceptor()});
        return connector;
    }

    @Bean
    public CryptoFactoryBean getCryptoFactoryBean() throws IOException {
        CryptoFactoryBean cryptoFactoryBean=new CryptoFactoryBean();
        cryptoFactoryBean.setKeyStoreLocation(new ClassPathResource("server.keystore"));
        cryptoFactoryBean.setKeyStorePassword("anhphuoc1998");
        return cryptoFactoryBean;
    }

    @Bean
    public Wss4jSecurityInterceptor wss4jSecurityInterceptor() throws Exception {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();

        // set security actions: Timestamp Signature SAMLTokenSigned SAMLTokenUnsigned
        securityInterceptor.setSecurementActions("Timestamp Signature");

        // sign the request
        securityInterceptor.setSecurementUsername("mycert");
        securityInterceptor.setSecurementPassword("anhphuoc1998");

        securityInterceptor.setSecurementSignatureCrypto(getCryptoFactoryBean().getObject());

        securityInterceptor.setSecurementSignatureParts(
                "{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;" +
                        "{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body"
        );
        return securityInterceptor;
    }
}