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
import org.joda.time.*;

/**
 * The {@code Converters} class contains static methods for registering Joda Time converters.
 */
public class Converters {

    /**
     * Registers all the Joda Time converters.
     *
     * @param builder The GSON builder to register the converters with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerAll(GsonBuilder builder) {

        registerDateTime(builder);
        registerDateTimeZone(builder);
        registerDays(builder);
        registerDuration(builder);
        registerHours(builder);
        registerInstant(builder);
        registerInterval(builder);
        registerLocalDate(builder);
        registerLocalDateTime(builder);
        registerLocalTime(builder);
        registerMinutes(builder);
        registerMonths(builder);
        registerMutableDateTime(builder);
        registerMutableInterval(builder);
        registerMutablePeriod(builder);
        registerPeriod(builder);
        registerSeconds(builder);
        registerWeeks(builder);
        registerYearMonth(builder);
        registerYears(builder);

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

        builder.registerTypeAdapter(DateTime.class, new DateTimeConverter());

        return builder;
    }

    /**
     * Registers the {@link DateTimeZone} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerDateTimeZone(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(DateTimeZone.class, new DateTimeZoneConverter());

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

        builder.registerTypeAdapter(Duration.class, new DurationConverter());

        return builder;
    }

    /**
     * Registers the {@link Days} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerDays(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(Days.class, new DaysConverter());

        return builder;
    }

    /**
     * Registers the {@link Hours} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerHours(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(Hours.class, new HoursConverter());

        return builder;
    }

    /**
     * Registers the {@link Instant} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerInstant(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(Instant.class, new InstantConverter());

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

        builder.registerTypeAdapter(Interval.class, new IntervalConverter());

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

        builder.registerTypeAdapter(LocalDate.class, new LocalDateConverter());

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

        builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeConverter());

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

        builder.registerTypeAdapter(LocalTime.class, new LocalTimeConverter());

        return builder;
    }

    /**
     * Registers the {@link Minutes} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerMinutes(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(Minutes.class, new MinutesConverter());

        return builder;
    }

    /**
     * Registers the {@link Months} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerMonths(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(Months.class, new MonthsConverter());

        return builder;
    }

    /**
     * Registers the {@link MutableDateTime} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerMutableDateTime(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(MutableDateTime.class, new MutableDateTimeConverter());

        return builder;
    }

    /**
     * Registers the {@link MutableInterval} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerMutableInterval(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(MutableInterval.class, new MutableIntervalConverter());

        return builder;
    }

    /**
     * Registers the {@link MutablePeriod} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerMutablePeriod(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(MutablePeriod.class, new MutablePeriodConverter());

        return builder;
    }

    /**
     * Registers the {@link Period} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerPeriod(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(Period.class, new PeriodConverter());

        return builder;
    }

    /**
     * Registers the {@link Seconds} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerSeconds(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(Seconds.class, new SecondsConverter());

        return builder;
    }

    /**
     * Registers the {@link Weeks} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerWeeks(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(Weeks.class, new WeeksConverter());

        return builder;
    }

    /**
     * Registers the {@link YearMonth} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerYearMonth(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(YearMonth.class, new YearMonthConverter());

        return builder;
    }

    /**
     * Registers the {@link Years} converter.
     *
     * @param builder The GSON builder to register the converter with.
     * @return A reference to {@code builder}.
     */
    public static GsonBuilder registerYears(GsonBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("builder cannot be null");
        }

        builder.registerTypeAdapter(Years.class, new YearsConverter());

        return builder;
    }
}
