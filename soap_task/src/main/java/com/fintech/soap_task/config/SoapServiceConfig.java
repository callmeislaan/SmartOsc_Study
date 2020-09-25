package com.fintech.soap_task.config;

import com.fintech.soap_task.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SpringSecurityPasswordValidationCallbackHandler;
import org.springframework.ws.soap.security.wss4j2.support.CryptoFactoryBean;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.io.IOException;
import java.util.List;

@EnableWs
@Configuration
public class SoapServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "task")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema taskSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TaskPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://fintech.com");
        wsdl11Definition.setSchema(taskSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema taskSchema() {
        return new SimpleXsdSchema(new ClassPathResource("task.xsd"));
    }

    @Bean
    PayloadLoggingInterceptor payloadLoggingInterceptor() {
        return new PayloadLoggingInterceptor();
    }


    //WSS4J digest password
    @Bean
    Wss4jSecurityInterceptor securityInterceptor() throws Exception {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setValidationCallbackHandler(callbackHandler());
        securityInterceptor.setSecurementActions("Timestamp Signature");

        securityInterceptor.setSecurementUsername("mycert");
        securityInterceptor.setSecurementPassword("anhphuoc1998");
        securityInterceptor.setSecurementSignatureCrypto(getCryptoFactoryBean().getObject());

        return securityInterceptor;
    }

    @Bean
    public CryptoFactoryBean getCryptoFactoryBean() throws IOException {
        CryptoFactoryBean cryptoFactoryBean=new CryptoFactoryBean();
        cryptoFactoryBean.setKeyStoreLocation(new ClassPathResource("server.keystore"));
        cryptoFactoryBean.setKeyStorePassword("anhphuoc1998");
        return cryptoFactoryBean;
    }


    @Bean
    SpringSecurityPasswordValidationCallbackHandler callbackHandler() {
        SpringSecurityPasswordValidationCallbackHandler callbackHandler = new SpringSecurityPasswordValidationCallbackHandler();
        callbackHandler.setUserDetailsService(userDetailsService);
        return callbackHandler;
    }


    //     XWSS digest password
//    @Bean
//    XwsSecurityInterceptor securityInterceptor() {
//        XwsSecurityInterceptor xwsSecurityInterceptor = new XwsSecurityInterceptor();
//        xwsSecurityInterceptor.setCallbackHandler(callBackHandler());
//        xwsSecurityInterceptor.setPolicyConfiguration(new ClassPathResource("securityDigestPolicy.xml"));
//        return xwsSecurityInterceptor;
//    }
//
//    @Bean
//    SpringDigestPasswordValidationCallbackHandler callBackHandler() {
//        SpringDigestPasswordValidationCallbackHandler callbackHandler = new SpringDigestPasswordValidationCallbackHandler();
//        callbackHandler.setUserDetailsService(userDetailsService);
//        return callbackHandler;
//    }

    @Autowired
    UserDetailsServiceImp userDetailsService;

    // validate interceptor
    @Bean
    PayloadValidatingInterceptor payloadValidatingInterceptor() {
        PayloadValidatingInterceptor payloadValidatingInterceptor = new PayloadValidatingInterceptor();
        payloadValidatingInterceptor.setValidateResponse(true);
        payloadValidatingInterceptor.setValidateRequest(true);
        payloadValidatingInterceptor.setXsdSchema(taskSchema());
        return payloadValidatingInterceptor;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(payloadValidatingInterceptor());
        try {
            interceptors.add(securityInterceptor());
        } catch (Exception e) {
            e.printStackTrace();
        }
        interceptors.add(payloadLoggingInterceptor());
    }
}
