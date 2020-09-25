package com.fintech.wsbl_demo;

import com.fintech.wsbl_demo.service.UserDetailServiceImp;
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
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "compute")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema computeSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ComputePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://fintech.com");
        wsdl11Definition.setSchema(computeSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema computeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("compute.xsd"));
    }

    // interceptor
    @Bean
    PayloadLoggingInterceptor payloadLoggingInterceptor() {
        return new PayloadLoggingInterceptor();
    }

    @Bean
    PayloadValidatingInterceptor payloadValidatingInterceptor() {
        PayloadValidatingInterceptor payloadValidatingInterceptor = new PayloadValidatingInterceptor();
        payloadValidatingInterceptor.setValidateRequest(true);
        payloadValidatingInterceptor.setValidateResponse(true);
        payloadValidatingInterceptor.setXsdSchema(computeSchema());
        return payloadValidatingInterceptor;
    }

    // add interceptor
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(payloadLoggingInterceptor());
        interceptors.add(payloadValidatingInterceptor());
        interceptors.add(securityInterceptor());
    }

    // XWSS plain password
//    @Bean
//    XwsSecurityInterceptor securityInterceptor() {
//        XwsSecurityInterceptor xwsSecurityInterceptor = new XwsSecurityInterceptor();
//        xwsSecurityInterceptor.setCallbackHandler(callBackHandler());
//        xwsSecurityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
//        return xwsSecurityInterceptor;
//    }
//
//    @Bean
//    SimplePasswordValidationCallbackHandler callBackHandler() {
//        SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
//        callbackHandler.setUsersMap(Collections.singletonMap("admin", "password"));
//        return callbackHandler;
//    }
//

    //WSS4J plain password
//    @Bean
//    Wss4jSecurityInterceptor securityInterceptor() {
//        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
//        securityInterceptor.setValidationCallbackHandler(callbackHandler());
//        securityInterceptor.setValidationActions("UsernameToken");
//        return securityInterceptor;
//    }
//
//    @Bean
//    SpringSecurityPasswordValidationCallbackHandler callbackHandler() {
//        SpringSecurityPasswordValidationCallbackHandler callbackHandler = new SpringSecurityPasswordValidationCallbackHandler();
//        callbackHandler.setUserDetailsService(userDetailsService);
//        return callbackHandler;
//    }
//
    @Autowired
    UserDetailServiceImp userDetailsService;

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

    //WSS4J digest password
    @Bean
    Wss4jSecurityInterceptor securityInterceptor() {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setValidationCallbackHandler(callbackHandler());
        securityInterceptor.setValidationActions("UsernameToken");
        return securityInterceptor;
    }

    @Bean
    SpringSecurityPasswordValidationCallbackHandler callbackHandler() {
        SpringSecurityPasswordValidationCallbackHandler callbackHandler = new SpringSecurityPasswordValidationCallbackHandler();
        callbackHandler.setUserDetailsService(userDetailsService);
        return callbackHandler;
    }
    
}
