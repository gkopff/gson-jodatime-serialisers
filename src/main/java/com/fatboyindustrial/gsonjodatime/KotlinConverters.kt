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
import org.joda.time.*

/**
 * Registers all the Joda Time converters onto the receiver.
 * @see Converters.registerAll
 */
fun GsonBuilder.registerAllJodaConverters(): GsonBuilder = this
    .registerDateMidnight()
    .registerDateTime()
    .registerDuration()
    .registerLocalDate()
    .registerLocalDateTime()
    .registerLocalTime()
    .registerInterval()
    .registerPeriod()
    .registerInstant()
    .registerDateTimeZone()

/**
 * Registers the [DateMidnight] converter onto the receiver.
 * @see Converters.registerDateMidnight
 */
fun GsonBuilder.registerDateMidnight(): GsonBuilder = Converters.registerDateMidnight(this)

/**
 * Registers the [DateTime] converter onto the receiver.
 * @see Converters.registerDateTime
 */
fun GsonBuilder.registerDateTime(): GsonBuilder = Converters.registerDateTime(this)

/**
 * Registers the [Duration] converter onto the receiver.
 * @see Converters.registerDuration
 */
fun GsonBuilder.registerDuration(): GsonBuilder = Converters.registerDuration(this)

/**
 * Registers the [LocalDate] converter onto the receiver.
 * @see Converters.registerLocalDate
 */
fun GsonBuilder.registerLocalDate(): GsonBuilder = Converters.registerLocalDate(this)

/**
 * Registers the [LocalDateTime] converter onto the receiver.
 * @see Converters.registerLocalDateTime
 */
fun GsonBuilder.registerLocalDateTime(): GsonBuilder = Converters.registerLocalDateTime(this)

/**
 * Registers the [LocalTime] converter onto the receiver.
 * @see Converters.registerLocalTime
 */
fun GsonBuilder.registerLocalTime(): GsonBuilder = Converters.registerLocalTime(this)

/**
 * Registers the [Instant] converter onto the receiver.
 * @see Converters.registerInstant
 */
fun GsonBuilder.registerInstant(): GsonBuilder = Converters.registerInstant(this)

/**
 * Registers the [Interval] converter onto the receiver.
 * @see Converters.registerInterval
 */
fun GsonBuilder.registerInterval(): GsonBuilder = Converters.registerInterval(this)

/**
 * Registers the [Period] converter onto the receiver.
 * @see Converters.registerPeriod
 */
fun GsonBuilder.registerPeriod(): GsonBuilder = Converters.registerPeriod(this)

/**
 * Registers the [DateTimeZone] converter onto the receiver.
 * @see Converters.registerDateTimeZone
 */
fun GsonBuilder.registerDateTimeZone(): GsonBuilder = Converters.registerDateTimeZone(this)