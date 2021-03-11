package cn.gyw.components.web.log.event;

import org.springframework.context.ApplicationEvent;

public class ApiLogEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public ApiLogEvent(Object source) {
        super(source);
    }
}
