package com

import groovy.util.logging.Log
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan

@Log
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application);
        ConfigurableApplicationContext ctx = app.run(args);
        AppConfig appConfig = (AppConfig) ctx.getBean("appConfig")
        log.info "*" * 20
        log.info "appName : " + appConfig.appName
        log.info "*" * 20
        log.info "port : " + appConfig.port
        log.info "*" * 20
        log.info "description : " + appConfig.description
        log.info "*" * 20
        log.info "secret : " + appConfig.randomSecret
    }
}