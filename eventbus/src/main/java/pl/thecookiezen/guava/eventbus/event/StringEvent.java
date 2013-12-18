package pl.thecookiezen.guava.eventbus.event;

/**
 * @author Korneliusz Rabczak
 */
public class StringEvent {

    private String message;

    public StringEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
