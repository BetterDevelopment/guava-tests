package pl.thecookiezen.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author Korneliusz Rabczak
 */
public class NumberListener {

    private Number lastMessage;

    @Subscribe
    public void listen(Number event) {
        lastMessage = event;
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}
