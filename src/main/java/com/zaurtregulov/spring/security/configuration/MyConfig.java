package com.zaurtregulov.spring.security.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = "com.zaurtregulov.spring.security")
public class MyConfig {

  @Bean
  public ViewResolver viewResolver(){
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

    viewResolver.setPrefix("/WEB-INF/view/");
    viewResolver.setSuffix(".jsp");

    return viewResolver;
  }

  @Bean
  public DataSource dataSource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass("org.firebirdsql.jdbc.FBDriver");
    dataSource.setJdbcUrl("jdbc:firebirdsql://localhost:3050/W:/Work_2021/Spring/Spring for beginners (Zaur Tregulov)" +
      "/spring_course_security/db/test4.fdb?useSSL=false&amp;serverTimezone=UTC&amp;charSet=utf8");
    dataSource.setUser("user");
    dataSource.setPassword("user");

    return dataSource;
  }


}
