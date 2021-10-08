package com.todojava.todolist.config;


import com.todojava.todolist.services.BDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private BDService dbservice;

    @Bean
    public boolean instancia() {
        this.dbservice.instanciaBaseDeDados();
        return true;
    }
}
