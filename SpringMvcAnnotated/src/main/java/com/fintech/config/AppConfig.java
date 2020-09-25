package com.fintech.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                SpringMvcConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected DispatcherServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
        final DispatcherServlet dispatcherServlet = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        return dispatcherServlet;
    }


//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        boolean done = registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
//        if (!done) throw new RuntimeException();
//    }

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        boolean done = registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
//        if (!done) throw new RuntimeException();
//    }
}
