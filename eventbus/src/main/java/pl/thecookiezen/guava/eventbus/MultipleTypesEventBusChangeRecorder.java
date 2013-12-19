package pl.thecookiezen.guava.eventbus;

import com.google.common.eventbus.Subscribe;
import pl.thecookiezen.guava.eventbus.event.IntegerEvent;
import pl.thecookiezen.guava.eventbus.event.StringEvent;

/**
 * @author Korneliusz Rabczak
 */
public class MultipleTypesEventBusChangeRecorder {

    private String lastMessage;
    private int lastStatus;

    @Subscribe
    public void listenMessage(StringEvent event) {
        lastMessage = event.getMessage();
    }

    @Subscribe
    public void listenStatus(IntegerEvent event) {
        lastStatus = event.getStatus();
    }

    public int getLastStatus() {
        return lastStatus;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
