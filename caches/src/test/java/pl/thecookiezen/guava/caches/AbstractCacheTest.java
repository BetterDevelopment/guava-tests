package pl.thecookiezen.guava.caches;

import com.google.common.cache.AbstractCache;
import com.google.common.cache.Cache;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

/**
 * @author Korneliusz Rabczak
 */
public class AbstractCacheTest {

    private AtomicReference<Integer> provider = new AtomicReference<Integer>();

    Cache<String, Integer> cache = new AbstractCache<String, Integer>() {
        @Override
        public Integer getIfPresent(Object o) {
            return provider.get();
        }
    };

    @Test
    public void null_should_be_return_for_empty_reference() {
        // when
        Integer actual = cache.getIfPresent("test");

        // then
        assertThat(actual, is(nullValue()));
    }

    @Test
    public void reference_should_be_return() {
        // given
        Integer expected = new Integer(12);
        provider.set(expected);

        // when
        Integer actual = cache.getIfPresent("test");

        // then
        assertThat(actual, is(notNullValue()));
        assertThat(actual, is(expected));
    }

}
