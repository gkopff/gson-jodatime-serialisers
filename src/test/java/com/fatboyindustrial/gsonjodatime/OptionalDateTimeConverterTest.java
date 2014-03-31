/*
 * GSON Joda Time Serialisers
 *
 * Copyright 2013-2014 Greg Kopff
 * All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.fatboyindustrial.gsonjodatime;

import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@link OptionalDateTimeConverter}.
 */
public class OptionalDateTimeConverterTest
{
  /**
   * Tests that the present value can be round-tripped.
   */
  @Test
  public void testPresentValueRoundtrip()
  {
    final Gson gson = Converters.registerOptionalDateTime(new GsonBuilder()).create();
    final Optional<DateTime> original = Optional.of(new DateTime());

    final Optional<DateTime> reconstituted = gson.fromJson(gson.toJson(original, Converters.OPTIONAL_DATE_TIME_TYPE), Converters.OPTIONAL_DATE_TIME_TYPE);
    assertThat(reconstituted, is(original));
  }

  /**
   * Tests that the absent value can be round-tripped.
   */
  @Test
  public void testAbsentValueRoundtrip()
  {
    final Gson gson = Converters.registerOptionalDateTime(new GsonBuilder()).create();
    final Optional<DateTime> original = Optional.absent();

    final Optional<DateTime> reconstituted = gson.fromJson(gson.toJson(original, Converters.OPTIONAL_DATE_TIME_TYPE), Converters.OPTIONAL_DATE_TIME_TYPE);
    assertThat(reconstituted, is(original));
  }

  /**
   * Tests that both present and absent values can be round-tripped when inside a container object.
   */
  @Test
  public void testContainedRoundtrip()
  {
    final Gson gson = Converters.registerOptionalDateTime(new GsonBuilder()).create();
    final Container original = new Container();

    final Container reconstituted = gson.fromJson(gson.toJson(original), Container.class);
    assertThat(reconstituted.present, is(original.present));
    assertThat(reconstituted.absent, is(original.absent));
  }

  /**
   * A container for encapsulating optional {@link DateTime} instances.
   */
  private static class Container
  {
    private final Optional<DateTime> present = Optional.of(new DateTime());
    private final Optional<DateTime> absent = Optional.absent();
  }
}
