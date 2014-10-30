package com

import com.customer.CustomerBootstrap
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration

@ComponentScan
@Import(RepositoryRestMvcConfiguration)
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application);
        ConfigurableApplicationContext ctx = app.run(args);
        CustomerBootstrap customerBootstrap = (CustomerBootstrap) ctx.getBean('customerBootstrap')
        customerBootstrap.populate()
        customerBootstrap.complexQueryExample()
    }
}