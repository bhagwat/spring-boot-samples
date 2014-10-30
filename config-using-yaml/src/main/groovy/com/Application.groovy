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
        YamlConfig yamlConfig = ctx.getBean("yamlConfig")
        log.info "*" * 20
        log.info "appName : " + yamlConfig.appName
        log.info "*" * 20
        log.info "port : " + yamlConfig.port
    }
}