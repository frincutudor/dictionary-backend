package com.dictionary.view;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.dictionary.repo.DictionaryRepository;
import com.dictionary.repo.DictionaryRepositoryImpl;
import com.dictionary.service.DictionaryService;
import com.dictionary.service.DictionaryServiceImpl;



/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         Spring annotation configuration class
 * 
 */
@Configuration
@EnableAutoConfiguration
public class AppConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public DictionaryService dictionaryService() {
        return new DictionaryServiceImpl(dictionaryRepository());
    }


  @Bean
  public DictionaryRepository dictionaryRepository() {
      
      return new DictionaryRepositoryImpl(jdbcTemplate);
  }
    
  @Bean
  public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurerAdapter() {
          @Override
          public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/login").allowedOrigins("http://localhost:4200");
          }
      };
  }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dictionary");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        return dataSource;
    }
    



    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    

    

}