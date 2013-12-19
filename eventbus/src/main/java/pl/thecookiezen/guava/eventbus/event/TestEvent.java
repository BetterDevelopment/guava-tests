package pl.thecookiezen.guava.eventbus.event;

/**
 * @author Korneliusz Rabczak
 */
public class TestEvent {

    private String message;

    public TestEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
