grails-events
===

Call a spring event during the pre-insert phase of saving a grails domain object by hooking into hibernate's pre-insert event listener.

rough overview
---

The basic idea here is to demonstrate how to programmatically hook into a hibernate pre-insert event and fire off a Spring application event that has a registered listener that will do something (in this case, "send an email") and then manipulate some properties on the object that's being persisted, all before completing the save. The general application of this architecture would be to have decoupled business/workflow logic that you can modularize in your application without having to explicitly change the parts of your application related to persistence (services or model, for example).

technical notes
---

I have added a "set" method to hibernate's PreInsertEventListener class through Groovy's metaClass feature. This piece of code is what is responsible for mutating the object's properties before they are persisted. 

Author/Contact
---

dan woods/daniel.p.woods@gmail.com

License
---

Free of use -- please hat tip me if you talk about me in a post or something.
