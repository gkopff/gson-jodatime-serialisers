/*
 * GSON Joda Time Serialisers
 *
 * Copyright 2018 Greg Kopff
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@link DateTimeZoneConverterTest}.
 */
public class DateTimeZoneConverterTest
{
  /**
   * Tests that the {@link org.joda.time.DateTimeZone} can be round-tripped.
   */
  @Test
  public void testRoundtrip()
  {
    final Gson gson = Converters.registerDateTimeZone(new GsonBuilder()).create();
    final DateTimeZone z = DateTimeZone.forID("America/New_York");

    assertThat(gson.fromJson(gson.toJson(z, DateTimeZone.class), DateTimeZone.class), is(z));
  }

  /**
   * Tests that deserialising an empty string returns null.
   */
  @Test
  public void testDeserialiseEmptyString()
  {
    final Gson gson = Converters.registerDateTimeZone(new GsonBuilder()).create();

    assertThat(gson.fromJson("", DateTimeZone.class), is(nullValue()));
  }

  /**
   * Tests that deserialising a null string returns null.
   */
  @Test
  public void testDeserialiseNullString()
  {
    final Gson gson = Converters.registerDateTimeZone(new GsonBuilder()).create();

    assertThat(gson.fromJson((String) null, DateTimeZone.class), is(nullValue()));
  }
}
