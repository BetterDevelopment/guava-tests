package pl.thecookiezen.guava.base.optional;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

/**
 * https://code.google.com/p/guava-libraries/wiki/UsingAndAvoidingNullExplained#Optional
 *
 * @author Korneliusz Rabczak
 * @author Rafos
 */
public class OptionalTest {

    @Test
    public void optionalOfIntegerFiveShouldBePresentAndEqualsFive() {
        // given
        final Integer five = 5;

        // when
        final Optional<Integer> actualOptionalInteger = Optional.of(five);

        // then
        assertThat(actualOptionalInteger.isPresent(), is(true));
        assertThat(actualOptionalInteger.get(), is(five));
    }

	@Test
	public void optionalOfIntegerNullShouldThrowNullPointerException() throws Exception {
		// given
		final Integer nullValue = null;

		try {
			// when
			Optional.of(nullValue);
			fail("Should throw NullPointerException");
		} catch (final NullPointerException e) {
			// then
			assertThat(e, instanceOf(NullPointerException.class));
		}
	}

	@Test
	public void optionalAbsentShouldNotBePresent() throws Exception {
		// given
		final Optional<Integer> absent = Optional.absent();

		// when
		final boolean actual = absent.isPresent();

		// then
		assertThat(actual, is(false));
	}

	@Test
	public void optionalAbsentShouldThrowIllegalStateExceptionIfGet() throws Exception {
		// given
		final Optional<Integer> absent = Optional.absent();

		try {
			// when
			absent.get();
		} catch (final IllegalStateException e) {
			// then
			assertThat(e, instanceOf(IllegalStateException.class));
		}
	}

	@Test
	public void fromNullableShouldBePresentAndEqualsFive() throws Exception {
		// given
		final Integer five = 5;

		// when
		final Optional<Integer> fromNullable = Optional.fromNullable(five);

		// then
		assertThat(fromNullable.isPresent(), is(true));
		assertThat(fromNullable.get(), is(five));
	}

	@Test
	public void fromNullableShouldBeAbsentForNull() throws Exception {
		// given
		final Integer nullValue = null;

		// when
		final Optional<Integer> fromNullable = Optional.fromNullable(nullValue);

		// then
		assertThat(fromNullable.isPresent(), is(false));
	}
}