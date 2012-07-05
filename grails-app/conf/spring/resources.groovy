beans = {
    preInsertEventListener(com.danveloper.grails.hibernate.events.PreInsertEventListener) {
        sessionFactory = ref("sessionFactory")
        grailsApplication = ref("grailsApplication")
    }
    registrantEventListener(com.danveloper.grails.hibernate.events.RegistrantEventListener) {}
}
