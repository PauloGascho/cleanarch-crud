package br.com.almode.cleanarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {
        "br.com.almode.cleanarch.persistence.entities",
})
@ComponentScan(basePackages = {
        "br.com.almode.cleanarch.persistence.adapters",
        "br.com.almode.cleanarch.usecases.services",
        "br.com.almode.cleanarch.rest_api_spring.api",
})
@EnableJpaRepositories(basePackages = {
        "br.com.almode.cleanarch.persistence.repositories"
})
@EnableAutoConfiguration
public class CleanArchAlmodeApplication {
  public static void main(String[] args){
    //SpringApplication.run(CleanArchAlmodeApplication.class, args);
    System.out.println("olá mundo!");
  }
}
