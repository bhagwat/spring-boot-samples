package com.person

import groovy.util.logging.Log
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Log
@Controller
@RequestMapping("/person")
class PersonController {

    @RequestMapping("/list")
    public ModelAndView list() {
        new ModelAndView("/person/index", [
                personInstanceList : Person.list(),
                personInstanceCount: Person.count
        ])
    }

    @RequestMapping("/show/{id}")
    public ModelAndView show(@PathVariable Long id) {
        Person person = Person.read(id)
        if (person) {
            new ModelAndView("/person/show", [
                    personInstance: Person.get(id)
            ])
        } else {
            log.info "No entity fount for id : " + id
            new ModelAndView("redirect:/person/list")
        }
    }

    @RequestMapping("/create")
    public ModelAndView create() {
        new ModelAndView("/person/create", [
                personInstance: new Person()
        ])
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Person person = Person.read(id)
        if (person) {
            new ModelAndView("/person/edit", [
                    personInstance: Person.get(id)
            ])
        } else {
            log.info "No entity fount for id : " + id
            new ModelAndView("redirect:/person/list")
        }
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        Person person = Person.get(id)
        if (person && person.delete()) {
            log.info "${person} delete successfully."
        } else {
            log.info "Unable to delete ${person}"
        }
        return new ModelAndView("redirect:/person/list")
    }

    @RequestMapping("/update/{id}")
    public ModelAndView update(Person person, @PathVariable Long id) {
        Person personToUpdate = Person.get(id)
        if (personToUpdate) {
            personToUpdate.name = person.name
            personToUpdate.age = person.age
            return saveOrUpdate(personToUpdate)
        }
        log.info "No entity fount for id : " + id
        return new ModelAndView("redirect:/person/list")
    }

    @RequestMapping("/save")
    public ModelAndView save(Person person) {
        return saveOrUpdate(person)
    }

    private ModelAndView saveOrUpdate(Person person) {
        String view = person?.id ? "edit" : "create"
        if (!person.save(flush: true)) {
            log.info "Failed to update person with Id:" + person?.id
            return new ModelAndView("/person/" + view, [
                    personInstance: person
            ])
        } else {
            log.info "Person updated successfully. Id :" + person?.id
            return new ModelAndView("redirect:/person/show/" + person?.id)
        }
    }
}
