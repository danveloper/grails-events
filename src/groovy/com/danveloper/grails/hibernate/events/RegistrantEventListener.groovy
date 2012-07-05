package com.danveloper.grails.hibernate.events

import org.springframework.context.ApplicationListener

class RegistrantEventListener implements ApplicationListener<RegistrantEvent> {
    @Override
    void onApplicationEvent(RegistrantEvent registrantEvent) {
        def preInsertEvent = registrantEvent.preInsertEvent
        // Send the email
        try {
            // Send the email
            sendEmail(preInsertEvent.entity)

            // For the following line of code, I've created the "set" method on the PreInsertEvent class in BootStrap.groovy
            // "Only update the domain entity if we succeeded & no exceptions were thrown"
            preInsertEvent.set("welcomeEmailSent", true)

        } catch (Exception e) {
            // We didn't get to send the email :-(
            // TODO: Something useful on failure?
        }
    }

    void sendEmail(Registrant registrant) {
        println "Sending an email to: ${registrant.email}"
        // Do some email sending here...
    }
}
