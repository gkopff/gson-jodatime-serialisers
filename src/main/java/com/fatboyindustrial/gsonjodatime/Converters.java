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

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.joda.time.*;

import java.lang.reflect.Type;

/**
 * The {@code Converters} class contains static methods for registering Joda Time converters.
 */
public class Converters {
    /**
     * The specific genericized type for {@code DateMidnight}.
     */
    public static final Type DATE_MIDNIGHT_TYPE = new TypeToken<DateMidnight>() {
    }.getType();

    /**
     * The specific genericized type for {@code DateTime}.
     */
    public static final Type DATE_TIME_TYPE = new TypeToken<DateTime>() {
    }.getType();

    /**
     * The specific genericized type for {@code Duration}.
     */
    public static final Type DURATION_TYPE = new TypeToken<Duration>() {
    }.getType();

    /**
     * The specific genericized type for {@code LocalDate}.
     */
    public static final Type LOCAL_DATE_TYPE = new TypeToken<LocalDate>() {
    }.getType();

    /**
     * The specific genericized type for {@code LocalDateTime}.
     */
    public static final Type LOCAL_DATE_TIME_TYPE = new TypeToken<LocalDateTime>() {
    }.getType();

    /**
     * The specific genericized type for {@code LocalTime}.
     */
    public static final Type LOCAL_TIME_TYPE = new TypeToken<LocalTime>() {
    }.getType();

    /**
     * The specific genericized type for {@code Interval}.
     */
    public static final Type INTERVAL_TYPE = new TypeToken<Interval>() {
    }.getType();

    /**
     * Registers all the Joda Time converters.
     *
     * @param builder The GSON builder to register the converters with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerAll(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        registerDateMidnight(builder);
        registerDateTime(builder);
        registerDuration(builder);
        registerLocalDate(builder);
        registerLocalDateTime(builder);
        registerLocalTime(builder);
        registerInterval(builder);

        return builder;
    }

    /**
     * Registers the {@link DateMidnight} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerDateMidnight(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(DATE_MIDNIGHT_TYPE, new DateMidnightConverter());

        return builder;
    }

    /**
     * Registers the {@link DateTime} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerDateTime(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(DATE_TIME_TYPE, new DateTimeConverter());

        return builder;
    }

    /**
     * Registers the {@link Duration} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerDuration(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(DURATION_TYPE, new DurationConverter());

        return builder;
    }

    /**
     * Registers the {@link LocalDate} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerLocalDate(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(LOCAL_DATE_TYPE, new LocalDateConverter());

        return builder;
    }

    /**
     * Registers the {@link LocalDateTime} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerLocalDateTime(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(LOCAL_DATE_TIME_TYPE, new LocalDateTimeConverter());

        return builder;
    }

    /**
     * Registers the {@link LocalTime} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerLocalTime(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(LOCAL_TIME_TYPE, new LocalTimeConverter());

        return builder;
    }

    /**
     * Registers the {@link Interval} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerInterval(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(INTERVAL_TYPE, new IntervalConverter());

        return builder;
    }
}
