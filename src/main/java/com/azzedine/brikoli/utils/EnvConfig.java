package com.azzedine.brikoli.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class EnvConfig {
    @Bean
    public Dotenv dotenv(){
        return Dotenv.configure()
                .directory("./")
                .ignoreIfMissing()
                .load() ;
    }
}
