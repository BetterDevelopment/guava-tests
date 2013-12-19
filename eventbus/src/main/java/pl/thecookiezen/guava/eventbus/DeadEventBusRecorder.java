package pl.thecookiezen.guava.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * @author Korneliusz Rabczak
 */
public class DeadEventBusRecorder {

    private boolean deadEventNotDelivered = false;

    private String deadEventMessage;

    @Subscribe
    public void listen(DeadEvent event) {
        deadEventMessage = (String) event.getEvent();
        deadEventNotDelivered = true;
    }

    public boolean isDeadEventNotDelivered() {
        return deadEventNotDelivered;
    }

    public String getDeadEventMessage() {
        return deadEventMessage;
    }
}
