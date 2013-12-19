package pl.thecookiezen.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author Korneliusz Rabczak
 */
public class IntegerListener {

    private int lastMessage;

    @Subscribe
    public void listen(Integer event) {
        lastMessage = event;
    }

    public int getLastMessage() {
        return lastMessage;
    }
}
