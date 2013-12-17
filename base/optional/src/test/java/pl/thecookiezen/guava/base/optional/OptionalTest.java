package pl.thecookiezen.guava.base.optional;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * https://code.google.com/p/guava-libraries/wiki/UsingAndAvoidingNullExplained#Optional
 *
 * @author Korneliusz Rabczak
 */
public class OptionalTest {

    @Test
    public void optionalIntegerShouldBePresentAndEqualsFive() {
        // given
        int expected = 5;

        // when
        Optional<Integer> actualOptionalInteger = Optional.of(expected);

        // then
        assertThat(actualOptionalInteger.isPresent(), is(true));
        assertThat(actualOptionalInteger.get(), is(expected));
    }

}
