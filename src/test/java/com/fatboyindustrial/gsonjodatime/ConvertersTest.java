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
import org.joda.time.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link Converters}.
 */
public class ConvertersTest {
    /**
     * Tests that the {@link Converters#registerAll} method registers the converters successfully.
     */
    @Test
    public void testRegisterAll() {
        final Container original = new Container();
        original.dt = new DateTime().withZone(DateTimeZone.forID("America/Boise"));
        original.dtz = DateTimeZone.forID("America/Boise");
        original.days = Days.days(6);
        original.d = Duration.standardMinutes(30L);
        original.hours = Hours.hours(33);
        original.instant = Instant.now();
        original.interval = new Interval(DateTime.now().minusDays(14), DateTime.now().plusDays(2));
        original.ld = new LocalDate();
        original.ldt = new LocalDateTime();
        original.lt = new LocalTime();
        original.minutes = Minutes.minutes(55);
        original.months = Months.months(7);
        original.mdt = MutableDateTime.now();
        original.minterval = new MutableInterval(DateTime.now().minusDays(14), DateTime.now().plusDays(2));
        original.minutes = Minutes.minutes(42);
        original.mp = new MutablePeriod(1, 33, 5, 90);
        original.p = new Period(1, 33, 5, 90);
        original.seconds = Seconds.seconds(43);
        original.weeks = Weeks.weeks(4);
        original.ym = YearMonth.now();
        original.years = Years.years(4);

        final Gson gson = Converters.registerAll(new GsonBuilder()).create();
        final Container reconstituted = gson.fromJson(gson.toJson(original), Container.class);

        assertTrue(reconstituted.dt.isEqual(original.dt));
        assertEquals(reconstituted.dtz, original.dtz);
        assertEquals(reconstituted.days, original.days);
        assertEquals(reconstituted.d, original.d);
        assertEquals(reconstituted.hours, original.hours);
        assertEquals(reconstituted.instant, original.instant);
        assertEquals(reconstituted.interval, original.interval);
        assertEquals(reconstituted.ld, original.ld);
        assertEquals(reconstituted.ldt, original.ldt);
        assertEquals(reconstituted.lt, original.lt);
        assertEquals(reconstituted.minutes, original.minutes);
        assertEquals(reconstituted.months, original.months);
        assertTrue(reconstituted.mdt.isEqual(original.mdt));
        assertEquals(reconstituted.minterval, original.minterval);
        assertEquals(reconstituted.minutes, original.minutes);
        assertEquals(reconstituted.mp, original.mp);
        assertEquals(reconstituted.p, original.p);
        assertEquals(reconstituted.seconds, original.seconds);
        assertEquals(reconstituted.weeks, original.weeks);
        assertEquals(reconstituted.ym, original.ym);
        assertEquals(reconstituted.years, original.years);
    }

    /**
     * Container for serialising many fields.
     */
    private static class Container {
        private DateTime dt;
        private DateTimeZone dtz;
        private Days days;
        private Duration d;
        private Hours hours;
        private Instant instant;
        private Interval interval;
        private LocalDate ld;
        private LocalDateTime ldt;
        private LocalTime lt;
        private Minutes minutes;
        private Months months;
        private MutableDateTime mdt;
        private MutableInterval minterval;
        private MutablePeriod mp;
        private Period p;
        private Seconds seconds;
        private Weeks weeks;
        private YearMonth ym;
        private Years years;
    }
}
