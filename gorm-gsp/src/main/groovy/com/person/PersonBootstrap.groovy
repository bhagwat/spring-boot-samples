package com.person

import groovy.util.logging.Log
import org.springframework.stereotype.Component

@Log
@Component
class PersonBootstrap {

    public void populate() {
//        log.info "Removing existing persons......."
//        Person.executeUpdate("delete from Person");
        log.info "Boot Straping persons......."
        [
                ["Samurai", 31],
                ["Sima", 29],
                ["Vijay", 36],
                ["Kashi", 35],
                ["Kailash", 35],
                ["Marry", 36],
                ["Goblin", 26],
                ["Boby", 33],
                ["Baby", 24],
                ["Sona", 25],
                ["Kite", 25],
                ["Karan", 22],
                ["Mac", 32]
        ].each {
            new Person(name: it[0], age: it[1]).save(flush: true)
        }
        log.info "........ done"
    }

    public void show() {
        log.info "Showing all persons......."
        Person.list().eachWithIndex { Person person, Integer index ->
            println ">>>>>>>>>>>>>>>>>>>> : ${index}"
            println person
        }
    }
}
