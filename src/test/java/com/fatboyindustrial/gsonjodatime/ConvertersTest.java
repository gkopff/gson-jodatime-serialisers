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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@link Converters}.
 */
public class ConvertersTest
{
  /**
   * Tests that the {@link Converters#registerAll} method registers the converters successfully.
   */
  @Test
  public void testRegisterAll()
  {
    final Gson gson = Converters.registerAll(new GsonBuilder()).create();
    final DateMidnight dm = new DateMidnight();
    final DateTime dt = new DateTime();
    final LocalDate ld = new LocalDate();
    final LocalDateTime ldt = new LocalDateTime();
    final LocalTime lt = new LocalTime();

    assertThat(gson.fromJson(gson.toJson(dm), DateMidnight.class), is(dm));
    assertThat(gson.fromJson(gson.toJson(dt), DateTime.class), is(dt));
    assertThat(gson.fromJson(gson.toJson(ld), LocalDate.class), is(ld));
    assertThat(gson.fromJson(gson.toJson(ldt), LocalDateTime.class), is(ldt));
    assertThat(gson.fromJson(gson.toJson(lt), LocalTime.class), is(lt));
  }
}
