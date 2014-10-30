package com

import com.person.PersonBootstrap
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application);
        ConfigurableApplicationContext ctx = app.run(args);
        PersonBootstrap personBootstrap = (PersonBootstrap) ctx.getBean("personBootstrap")
        personBootstrap.populate()
//        personBootstrap.show()
    }
}