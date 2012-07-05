package com.danveloper.grails.hibernate.events

import org.hibernate.event.Initializable
import org.hibernate.cfg.Configuration
import javax.annotation.PostConstruct
import org.hibernate.event.PreInsertEvent

class PreInsertEventListener implements org.hibernate.event.PreInsertEventListener, Initializable {
    def sessionFactory
    def grailsApplication

    @PostConstruct
    void postConstruct() {
        initialize()
    }

    @Override
    void initialize(Configuration configuration) {
        sessionFactory.eventListeners.preInsertEventListeners = (sessionFactory.eventListeners.preInsertEventListeners as Set) << this
    }

    @Override
    boolean onPreInsert(PreInsertEvent preInsertEvent) {
        if (preInsertEvent.entity instanceof Registrant) {
            grailsApplication.mainContext.publishEvent(new RegistrantEvent(preInsertEvent))
        }
        return false
    }
}
