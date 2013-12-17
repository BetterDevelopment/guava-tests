package pl.thecookiezen.guava.collections.ranges;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

/**
 * https://code.google.com/p/guava-libraries/wiki/RangesExplained
 *
 * @author Korneliusz Rabczak
 */
public class RangesTest {

    @Test
    public void closedRangeShouldContainsLowerAndUpperBound() {
        // given
        Range<Integer> closedFromOneToTen = Range.closed(1, 10);

        //then
        assertThat(closedFromOneToTen.contains(1), is(true));
        assertThat(closedFromOneToTen.contains(10), is(true));
    }

    @Test
    public void closedOpenRangeShouldContainsOnlyLowerBound() {
        // given
        Range<Integer> closedOpenFromOneToTen = Range.closedOpen(1, 10);

        // then
        assertThat(closedOpenFromOneToTen.contains(1), is(true));
        assertThat(closedOpenFromOneToTen.contains(10), is(false));
    }

    @Test
    public void smallerRangeShouldBeEnclosedInAnotherOne() {
        // given
        Range<Integer> smallerRange = Range.openClosed(3, 8);
        Range<Integer> range = Range.closed(1, 10);

        // when
        boolean actual = range.encloses(smallerRange);

        // then
        assertThat(actual, is(true));
    }

    @Test
    public void shouldIntersectForOnlyOneNumber() {
        // given
        Range<Integer> closedFromThreeToFive = Range.closed(3, 5);
        Range<Integer> openFromFiveToEight = Range.open(5, 8);

        // when
        Range<Integer> actual = closedFromThreeToFive.intersection(openFromFiveToEight);

        // then
        assertThat(actual, is(Range.openClosed(5, 5)));
    }

    @Test
    public void shouldIntersectForInnerNumbers() {
        // given
        Range<Integer> closedFromTwoToNine = Range.closed(2, 9);
        Range<Integer> openFromThreeToSix = Range.open(3, 6);

        // when
        Range<Integer> actual = closedFromTwoToNine.intersection(openFromThreeToSix);

        // then
        assertThat(actual, is(Range.open(3, 6)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNonIntersectingRanges() {
        // given
        Range<Integer> firstRange = Range.closed(1, 3);
        Range<Integer> secondRange = Range.open(5, 6);

        // when
        firstRange.intersection(secondRange);
    }

    @Test
    public void rangesShouldBeConnected() {
        // given
        Range<Integer> firstRange = Range.open(1, 3);
        Range<Integer> secondRange = Range.closed(3, 6);

        // when
        boolean actual = firstRange.isConnected(secondRange);

        // then
        assertThat(actual, is(true));
    }

    @Test
    public void rangesShouldNotBeConnected() {
        // given
        Range<Integer> firstRange = Range.open(1, 3);
        Range<Integer> secondRange = Range.open(3, 6);

        // when
        boolean actual = firstRange.isConnected(secondRange);

        // then
        assertThat(actual, is(false));
    }

    @Test
    public void lowerBoundShouldBeFromFirstRangeAndUpperBoundFromSecondRange() {
        // given
        Range<Integer> firstRange = Range.open(1, 3);
        Range<Integer> secondRange = Range.open(3, 6);

        // when
        Range<Integer> actual = firstRange.span(secondRange);

        // then
        assertThat(actual, is(Range.open(1, 6)));
    }

    @Test
    public void allElementsShouldBeInRange() {
        // given
        Range<Integer> firstRange = Range.openClosed(1, 10);
        ArrayList<Integer> integers = Lists.newArrayList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        // when
        boolean actual = firstRange.containsAll(integers);

        // then
        assertThat(actual, is(true));
    }

    @Test
    public void shouldReturnSetOfElementsFromRange() {
        // given
        Range<Integer> integerRange = Range.open(0, 10);

        // when
        ImmutableSortedSet<Integer> actualSet = ContiguousSet.create(integerRange, DiscreteDomain.integers());

        // then
        assertThat(actualSet, contains(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

}
