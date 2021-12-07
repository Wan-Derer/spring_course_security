package com.zaurtregulov.spring.security.configuration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{MyConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }


  // https://leodev.ru/blog/spring/spring-security-проблемы-кодировки-логин-формы/
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);

    FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
    fr.setInitParameter("encoding", "UTF-8");
    fr.setInitParameter("forceEncoding", "true");
    fr.addMappingForUrlPatterns(null, false, "/*");
  }


}
