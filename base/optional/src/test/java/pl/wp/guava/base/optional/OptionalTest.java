package pl.wp.guava.base.optional;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Korneliusz Rabczak
 */
public class OptionalTest {

    @Test
    public void optional_integer_should_be_present_and_equals_five() {
        // given
        int expected = 5;

        // when
        Optional<Integer> actualOptionalInteger = Optional.of(expected);

        // then
        assertThat(actualOptionalInteger.isPresent(), is(true));
        assertThat(actualOptionalInteger.get(), is(expected));
    }

}
