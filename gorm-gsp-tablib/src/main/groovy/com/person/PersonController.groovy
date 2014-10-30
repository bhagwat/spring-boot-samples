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
    public ModelAndView firstPage() {
        return getPage(1)
    }

    @RequestMapping("/list/{currentPage}")
    public ModelAndView list(@PathVariable Integer currentPage) {
        return getPage(currentPage)
    }

    private ModelAndView getPage(Integer page) {
        Integer max = 10
        Integer offset = (page - 1) * max
        new ModelAndView("/views/person/index", [
                personInstanceList : Person.list(max: max, offset: offset),
                personInstanceCount: Person.count,
                currentPage        : page
        ])
    }

    @RequestMapping("/show/{id}")
    public ModelAndView show(@PathVariable Long id) {
        Person person = Person.read(id)
        if (person) {
            new ModelAndView("/views/person/show", [
                    personInstance: Person.get(id)
            ])
        } else {
            log.info "No entity fount for id : " + id
            new ModelAndView("redirect:/person/list")
        }
    }

    @RequestMapping("/create")
    public ModelAndView create() {
        new ModelAndView("/views/person/create", [
                personInstance: new Person()
        ])
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Person person = Person.read(id)
        if (person) {
            new ModelAndView("/views/person/edit", [
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
            return new ModelAndView("/views/person/" + view, [
                    personInstance: person
            ])
        } else {
            log.info "Person updated successfully. Id :" + person?.id
            return new ModelAndView("redirect:/person/show/" + person?.id)
        }
    }
}
