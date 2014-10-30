package com.person

import grails.persistence.Entity

@Entity
class Person {
    String name
    Integer age

    static constraints = {
        name blank: false
        age min: 15
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", version=" + version +
                '}';
    }
}
