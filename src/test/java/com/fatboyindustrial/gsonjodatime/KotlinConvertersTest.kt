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

package com.fatboyindustrial.gsonjodatime

import com.google.gson.GsonBuilder
import org.hamcrest.Matchers.`is`
import org.joda.time.*
import org.junit.Assert.assertThat
import org.junit.Test

class KotlinConvertersTest {
    /**
     * Tests that the [registerAllJodaConverters] kotlin extension method registers the converters successfully.
     */
    @Test
    fun testRegisterAll() {
        val gson = GsonBuilder().registerAllJodaConverters().create()
        val original = Container()

        original.dm = DateMidnight()
        original.dt = DateTime()
        original.dtz = DateTimeZone.forID("UTC")
        original.d = Duration.standardMinutes(30L)
        original.ld = LocalDate()
        original.ldt = LocalDateTime()
        original.lt = LocalTime()
        original.i = Interval(DateTime.now().minusDays(14), DateTime.now().plusDays(2))
        original.p = Period.days(2)

        val reconstituted = gson.fromJson(gson.toJson(original), Container::class.java)

        assertThat<DateMidnight>(reconstituted.dm, `is`<DateMidnight>(original.dm))
        assertThat<String>(reconstituted.dt!!.toString(), `is`<String>(original.dt.toString()))  // work-around the loss of zone name and just worry about the offset
        assertThat<DateTimeZone>(reconstituted.dtz, `is`<DateTimeZone>(original.dtz))
        assertThat<Duration>(reconstituted.d, `is`<Duration>(original.d))
        assertThat<LocalDate>(reconstituted.ld, `is`<LocalDate>(original.ld))
        assertThat<LocalDateTime>(reconstituted.ldt, `is`<LocalDateTime>(original.ldt))
        assertThat<LocalTime>(reconstituted.lt, `is`<LocalTime>(original.lt))
        assertThat<Interval>(reconstituted.i, `is`<Interval>(original.i))
        assertThat<Period>(reconstituted.p, `is`<Period>(original.p))
    }

    /**
     * Container for serialising many fields.
     */
    private class Container {
        var dm: DateMidnight? = null
        var dt: DateTime? = null
        var dtz: DateTimeZone? = null
        var d: Duration? = null
        var ld: LocalDate? = null
        var ldt: LocalDateTime? = null
        var lt: LocalTime? = null
        var i: Interval? = null
        var p: Period? = null
    }
}