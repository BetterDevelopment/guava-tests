package pl.thecookiezen.primitives;

import com.google.common.primitives.Ints;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * https://code.google.com/p/guava-libraries/wiki/PrimitivesExplained
 *
 * @author Korneliusz Rabczak
 */
public class IntsTest {

    private final int[] integersA = new int[]{4, 11, 65, 222, 567};
    private final int[] integersB = new int[]{3, 12, 66, 233};

    @Test
    public void integerArrayContainsEleven() {
        // when
        boolean actual = Ints.contains(integersA, 11);

        // then
        assertThat(actual, is(true));
    }

    @Test
    public void indexOfElevenIsOne() {
        // when
        int actual = Ints.indexOf(integersA, 11);

        // then
        assertThat(actual, is(1));
    }

    @Test
    public void concatenatedArrayLengthShouldBeEqualToSumOfLengthTwoArrays() {
        // when
        int[] actual = Ints.concat(integersA, integersB);

        // then
        assertThat(actual.length, is(integersA.length + integersB.length));
    }

    @Test
    public void shouldJoinArrayWithSeparator() {
        assertThat(Ints.join(",", integersA), is("4,11,65,222,567"));
    }

    @Test
    public void shouldFindMinAndMaxFromIntegersArray() {
        assertThat(Ints.min(integersA), is(4));
        assertThat(Ints.max(integersA), is(567));
    }
}
