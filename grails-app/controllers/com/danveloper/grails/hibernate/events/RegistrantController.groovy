package com.danveloper.grails.hibernate.events

import grails.converters.JSON

class RegistrantController {
    def sessionFactory

    def index() { }

    def create() {
        def registrant = new Registrant()
        registrant.with {
            firstName = "Dan"
            lastName = "Woods"
            email = "daniel.p.woods@gmail.com"
        }

        if (registrant.save(flush: true)) {
            render registrant as JSON
        } else {
            render registrant.errors
        }
    }
}
