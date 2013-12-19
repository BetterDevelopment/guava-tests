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

    public static final String TEST_MESSAGE = "test message";
    public static final int TEST_NUMERIC_VALUE = 1337;
    private final EventBus eventBus = new EventBus("test");

    @Test
    public void listenerShouldReceiveSingleStringMessage() {
        // given
        EventBusChangeRecorder listener = new EventBusChangeRecorder();
        eventBus.register(listener);

        // when
        eventBus.post(new TestEvent(TEST_MESSAGE));

        // then
        assertThat(listener.getLastMessage(), is(TEST_MESSAGE));
    }

    @Test
    public void listenerShouldHandleMultipleTypesOfEvents() {
        // given
        MultipleTypesEventBusChangeRecorder listener = new MultipleTypesEventBusChangeRecorder();
        eventBus.register(listener);

        // when
        eventBus.post(new StringEvent(TEST_MESSAGE));
        eventBus.post(new IntegerEvent(TEST_NUMERIC_VALUE));

        // then
        assertThat(listener.getLastMessage(), is(TEST_MESSAGE));
        assertThat(listener.getLastStatus(), is(TEST_NUMERIC_VALUE));
    }

    @Test
    public void deadEventShouldBeHandle() {
        // given
        DeadEventBusRecorder listener = new DeadEventBusRecorder();
        eventBus.register(listener);

        // when
        eventBus.post(new String(TEST_MESSAGE));

        // then
        assertThat(listener.isDeadEventNotDelivered(), is(true));
        assertThat(listener.getDeadEventMessage(), is(TEST_MESSAGE));
    }

    @Test
    public void listenersShouldHandleSubclassEvents() {
        // given
        IntegerListener integerListener = new IntegerListener();
        NumberListener numberListener = new NumberListener();

        eventBus.register(integerListener);
        eventBus.register(numberListener);

        // when
        eventBus.post(new Integer(TEST_NUMERIC_VALUE));

        // then
        assertThat(integerListener.getLastMessage(), is(TEST_NUMERIC_VALUE));
        assertThat(numberListener.getLastMessage(), is((Number) TEST_NUMERIC_VALUE));
    }
}
