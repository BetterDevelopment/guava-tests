package pl.thecookiezen.guava.eventbus.event;

/**
 * @author Korneliusz Rabczak
 */
public class IntegerEvent {

    private int status;

    public IntegerEvent(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
