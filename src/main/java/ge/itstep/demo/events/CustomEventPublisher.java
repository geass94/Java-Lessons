package ge.itstep.demo.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CustomEventPublisher {


    private final ApplicationEventPublisher applicationEventPublisher;


    public CustomEventPublisher(ApplicationEventPublisher publisher) {
        this.applicationEventPublisher = publisher;
    }



    public void publishCustomEvent()
    {
        CustomEvent customEvent = new CustomEvent(this);
        applicationEventPublisher.publishEvent(customEvent);
    }
}
