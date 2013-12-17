package pl.thecookiezen.guava.collections.functions;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * http://code.google.com/p/guava-libraries/wiki/FunctionalExplained
 *
 * @author Patryk Makuch
 */
public class FunctionTest {
    @Test
    public void functionShouldBeApplyToCollectionsElements() {
        // given
        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(@Nullable java.lang.Integer integer) {
                return null == integer ? null : integer * integer;
            }
        };
        Collection<Integer> inputCollection = Arrays.asList(0, 1, 2, 3);

        // when
        Collection<Integer> transformedCollection = Collections2.transform(inputCollection, square);

        // then
        assertThat(transformedCollection, hasSize(inputCollection.size()));
        assertThat(transformedCollection, contains(0, 1, 4, 9));
    }
}
