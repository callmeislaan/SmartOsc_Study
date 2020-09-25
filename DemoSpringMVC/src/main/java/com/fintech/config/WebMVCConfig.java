package com.fintech.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.text.SimpleDateFormat;

@Configuration
@EnableWebMvc
@ComponentScan("com.fintech.controller")
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(false);
        registry.jsp("/WEB-INF/views/", ".jsp").viewClass(JstlView.class);
        registry.enableContentNegotiation(
                new MappingJackson2JsonView()
        );
    }

    @Bean(name = "jsonViewResolver")
    public ViewResolver jsonViewResolver() {
        return (viewName, locale) -> {
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            view.setPrettyPrint(true);
            ObjectMapper mapper = new ObjectMapper();
            mapper.setDateFormat(new SimpleDateFormat("dd~MM~yyyy"));
            view.setObjectMapper(mapper);
            return view;
        };
    }


//    to set i18n
//    @Bean
//    MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setBasename("classpath:i18n/message");
//        return messageSource;
//    }
//
//    @Bean
//    public LocaleResolver localeResolver() {
//        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
//        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
//        return cookieLocaleResolver;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
//        interceptor.setParamName("lang");
//        registry.addInterceptor(interceptor);
//    }

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.enableContentNegotiation(true);
//        registry.jsp("/WEB-INF/views/", ".jsp");
//    }
//
//    @ Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.defaultContentType(MediaType.APPLICATION_JSON)
//                .ignoreAcceptHeader(true);
//
//    }

//    format json

//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper());
//        return mappingJackson2HttpMessageConverter;
//    }

//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper objMapper = new ObjectMapper();
//        objMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        return objMapper;
//    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
//        converters.add(new MappingJackson2HttpMessageConverter(builder.createXmlMapper(true).build()));
////        WebMvcConfigurer.super.configureMessageConverters(converters);
//    }
}
