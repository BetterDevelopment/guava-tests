package pl.thecookiezen.guava.eventbus;

import com.google.common.eventbus.Subscribe;
import pl.thecookiezen.guava.eventbus.event.TestEvent;

/**
 * @author Korneliusz Rabczak
 */
public class EventBusChangeRecorder {

    private String lastMessage;

    @Subscribe
    public void onEvent(TestEvent event) {
        lastMessage = event.getMessage();
    }

    public String getLastMessage() {
        return lastMessage;
    }

}
