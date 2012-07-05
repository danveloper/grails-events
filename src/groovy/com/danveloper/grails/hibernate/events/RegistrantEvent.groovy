package com.danveloper.grails.hibernate.events

import org.springframework.context.ApplicationEvent
import org.hibernate.event.PreInsertEvent

public class RegistrantEvent extends ApplicationEvent {
    PreInsertEvent preInsertEvent;

    RegistrantEvent(PreInsertEvent preInsertEvent) {
        super(preInsertEvent);
        this.preInsertEvent = preInsertEvent;
    }
}
