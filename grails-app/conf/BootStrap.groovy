import org.hibernate.event.PreInsertEvent

class BootStrap {

    def init = { servletContext ->
        PreInsertEvent.metaClass.set = { prop, val ->
            def propertyNames = delegate.persister.entityMetamodel.propertyNames;
            def state = delegate.state
            state[propertyNames.findIndexOf { it == prop }] = val
            delegate.entity."${prop}" = val
        }
    }
    def destroy = {
    }
}
