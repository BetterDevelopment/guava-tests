package pl.thecookiezen.guava.collections.functions;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.sun.istack.internal.Nullable;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * http://code.google.com/p/guava-libraries/wiki/FunctionalExplained
 * @author Patryk Makuch
 */
public class FunctionTest {
	@Test
	public void function_should_be_apply_to_collections_elements() {
		// given
		Function<Integer, Integer> square = new Function<Integer, Integer>() {
			@Override
			public Integer apply(@Nullable java.lang.Integer integer) {
				return null == integer ? null : integer * integer;
			}
		};
		Collection<Integer> inputCollection = Arrays.asList(0,1,2,3);

		// when
		Collection<Integer> transformedCollection = Collections2.transform(inputCollection, square);

		// then
		MatcherAssert.assertThat(transformedCollection, Matchers.hasSize(inputCollection.size()));
		MatcherAssert.assertThat(transformedCollection, Matchers.contains(0,1,4,9));
	}
}
