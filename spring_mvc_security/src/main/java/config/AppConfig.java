package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                SpringMvcConfig.class,
                SpringSecurityConfig.class
        };
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
