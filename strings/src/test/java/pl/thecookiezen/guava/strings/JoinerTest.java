package pl.thecookiezen.guava.strings;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author rafos
 */
public class JoinerTest {

	@Test
	public void shouldJoinOnSemicolon() throws Exception {
		// given
		final Joiner joiner = Joiner.on(";");

		// when
		final String joined = joiner.join("Rafos", "Better Development");

		// then
		assertThat(joined, is("Rafos;Better Development"));
	}

	@Test
	public void shouldJoinOnSemicolonAndSkipNull() throws Exception {
		// given
		final Joiner joiner = Joiner.on(";").skipNulls();

		// when
		final String joined = joiner.join("Rafos", null, "Better Development", null);

		// then
		assertThat(joined, is("Rafos;Better Development"));
	}

	@Test
	public void shouldJoinOnSemicolonAndReplaceNulls() throws Exception {
		// given
		final Joiner joiner = Joiner.on(";").useForNull("nulls double");

		// when
		final String joined = joiner.join("Rafos", null, "Better Development", null);

		// then
		assertThat(joined, is("Rafos;nulls double;Better Development;nulls double"));
	}

	@Test
	public void shouldJoinOnSemicolonKeysAndValuesSeparatedByArrow() throws Exception {
		// given
		final Joiner.MapJoiner mapJoiner = Joiner.on(";").withKeyValueSeparator("=>");
		final Map<String, String> map = ImmutableMap.of("R", "Rafos", "BD", "Better Development");

		// when
		final String joined = mapJoiner.join(map);

		// then
		assertThat(joined, is("R=>Rafos;BD=>Better Development"));
	}
}