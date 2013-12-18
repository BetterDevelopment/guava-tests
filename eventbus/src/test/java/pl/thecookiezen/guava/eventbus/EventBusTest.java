package pl.thecookiezen.guava.eventbus;

import com.google.common.eventbus.EventBus;
import org.junit.Test;
import pl.thecookiezen.guava.eventbus.event.IntegerEvent;
import pl.thecookiezen.guava.eventbus.event.StringEvent;
import pl.thecookiezen.guava.eventbus.event.TestEvent;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * https://code.google.com/p/guava-libraries/wiki/EventBusExplained
 *
 * @author Korneliusz Rabczak
 */
public class EventBusTest {

    private static final EventBus eventBus = new EventBus("test");

    @Test
    public void listenerShouldReceiveSingleStringMessage() {
        // given
        EventBusChangeRecorder listener = new EventBusChangeRecorder();
        eventBus.register(listener);

        // when
        eventBus.post(new TestEvent("test message"));

        //then
        assertThat(listener.getLastMessage(), is("test message"));
    }

    @Test
    public void listenerShouldHandleMultipleTypesOfEvents() {
        MultipleTypesEventBusChangeRecorder listener = new MultipleTypesEventBusChangeRecorder();
        eventBus.register(listener);

        // when
        eventBus.post(new StringEvent("test message"));
        eventBus.post(new IntegerEvent(1337));

        //then
        assertThat(listener.getLastMessage(), is("test message"));
        assertThat(listener.getLastStatus(), is(1337));
    }

}
