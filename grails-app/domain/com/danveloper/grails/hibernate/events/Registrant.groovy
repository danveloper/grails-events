package com.danveloper.grails.hibernate.events

class Registrant {
    String firstName
    String lastName
    String email

    boolean welcomeEmailSent = false

    static constraints = {
    }
}
