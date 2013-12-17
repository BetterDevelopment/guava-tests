package pl.thecookiezen.guava.preconditions;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.fail;

/**
 * @author rafos
 */
public class PreconditionsTest {

	private final String errorMessage = "Error Message!";

	private final int[] arrayOfInts = new int[]{1, 2, 3, 4};
	private final List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4);
	private final Set<Integer> setOfIntegers = new HashSet<Integer>(listOfIntegers);
	private final Map<Integer, Integer> mapOfIntegers = ImmutableMap.of(1, 1, 2, 2, 3, 3, 4, 4);


	@Test
	public void checkArgumentShouldPass() throws Exception {
		// given
		final boolean expression = true;

		try {
			// when
			Preconditions.checkArgument(expression);
		} catch (final IllegalArgumentException e) {
			// then
			fail("Should not throw exception " + e);
		}
	}

	@Test
	public void checkArgumentShouldThrowIllegalArgumentExceptionWithMessage() throws Exception {
		// given
		final boolean expression = false;

		try {
			// when
			Preconditions.checkArgument(expression, errorMessage);
			fail("Should throw IllegalArgumentException");
		} catch (final IllegalArgumentException e) {
			// then
			assertThat(e, instanceOf(IllegalArgumentException.class));
			assertThat(e.getMessage(), is(errorMessage));
		}
	}

	@Test
	public void checkElementIndexShouldPass() throws Exception {
		// given
		final int[] indexes = new int[]{0, 1, 2, 3};

		for (final int index : indexes) {
			try {
				// when
				callCheckElementIndex(index);
			} catch (final IndexOutOfBoundsException e) {
				// then
				fail("Should not throw exception " + e);
			}
		}
	}

	private void callCheckElementIndex(final int index) {
		Preconditions.checkElementIndex(index, arrayOfInts.length);
		Preconditions.checkElementIndex(index, listOfIntegers.size());
		Preconditions.checkElementIndex(index, setOfIntegers.size());
		Preconditions.checkElementIndex(index, mapOfIntegers.size());
	}

	@Test
	public void checkElementIndexShouldThrowIndexOutOfBoundExceptionWithMessage() throws Exception {
		// given
		final int index = 5;

		try {
			// when
			Preconditions.checkElementIndex(index, arrayOfInts.length, errorMessage);
			fail("Should throw IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// then
			assertThat(e, instanceOf(IndexOutOfBoundsException.class));
			final String message = errorMessage + " (" + index + ") must be less than size (" + arrayOfInts.length + ")";
			assertThat(e.getMessage(), is(message));
		}
	}

	@Test
	public void checkNotNullShouldPass() throws Exception {
		// given
		final String notNullReference = "NotNullReference";

		try {
			// when
			Preconditions.checkNotNull(notNullReference);
		} catch (final NullPointerException e) {
			// then
			fail("Should not throw exception " + e);
		}
	}

	@Test
	public void checkNotNullShouldThrowNullPointerExceptionWithMessage() throws Exception {
		// given
		final String nullReference = null;

		try {
			// when
			Preconditions.checkNotNull(nullReference, errorMessage);
			fail("Should throw NullPointerException");
		} catch (final NullPointerException e) {
			// then
			assertThat(e, instanceOf(NullPointerException.class));
			assertThat(e.getMessage(), is(errorMessage));
		}
	}

	@Test
	public void checkPositionIndexShouldPass() throws Exception {
		// given
		final int[] indexes = new int[]{0, 1, 2, 3, 4};

		for (final int index : indexes) {
			try {
				// when
				callCheckPositionIndex(index);
			} catch (final IndexOutOfBoundsException e) {
				// then
				fail("Should not throw exception " + e);
			}
		}
	}

	private void callCheckPositionIndex(final int index) {
		Preconditions.checkPositionIndex(index, arrayOfInts.length);
		Preconditions.checkPositionIndex(index, listOfIntegers.size());
		Preconditions.checkPositionIndex(index, setOfIntegers.size());
		Preconditions.checkPositionIndex(index, mapOfIntegers.size());
	}

	@Test
	public void checkPositionIndexShouldThrowIndexOutOfBoundExceptionWithMessage() throws Exception {
		// given
		final int index = 5;

		try {
			// when
			Preconditions.checkPositionIndex(index, arrayOfInts.length, errorMessage);
			fail("Should throw IndexOutOfBoundsException");
		} catch (final IndexOutOfBoundsException e) {
			// then
			assertThat(e, instanceOf(IndexOutOfBoundsException.class));
			final String message = errorMessage + " (" + index + ") must not be greater than size (" + arrayOfInts.length + ")";
			assertThat(e.getMessage(), is(message));
		}
	}
}