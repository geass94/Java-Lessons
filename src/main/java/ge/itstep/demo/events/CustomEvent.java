package ge.itstep.demo.events;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

    public CustomEvent(Object object) {
        super(object);
    }
    
}