package com.fatboyindustrial.gsonjodatime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.Duration;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@link DurationConverter}.
 */
public class DurationConverterTest {

    /**
     * Tests that the {@link Duration} can be round-tripped.
     */
    @Test
    public void testRoundtrip() {
        final Gson gson = Converters.registerDuration(new GsonBuilder()).create();
        final Duration d = Duration.standardSeconds(45L);

        assertThat(gson.fromJson(gson.toJson(d), Duration.class), is(d));
    }
}
