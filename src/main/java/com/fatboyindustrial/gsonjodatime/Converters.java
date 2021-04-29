/*
 * GSON Joda Time Serialisers
 *
 * Copyright 2013-2018 Greg Kopff
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
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.lang.reflect.Type;

/**
 * The {@code Converters} class contains static methods for registering Joda Time converters.
 */
public class Converters
{
  /** The specific genericized type for {@code DateMidnight}. */
  public static final Type DATE_MIDNIGHT_TYPE = new TypeToken<DateMidnight>(){}.getType();

  /** The specific genericized type for {@code DateTime}. */
  public static final Type DATE_TIME_TYPE = new TypeToken<DateTime>(){}.getType();

  /** The specific genericized type for {@code LocalDate}. */
  public static final Type LOCAL_DATE_TYPE = new TypeToken<LocalDate>(){}.getType();

  /** The specific genericized type for {@code LocalDateTime}. */
  public static final Type LOCAL_DATE_TIME_TYPE = new TypeToken<LocalDateTime>(){}.getType();

  /** The specific genericized type for {@code LocalTime}. */
  public static final Type LOCAL_TIME_TYPE = new TypeToken<LocalTime>(){}.getType();

  /** The specific genericized type for {@code Interval}. */
  public static final Type INTERVAL_TYPE = new TypeToken<Interval>(){}.getType();

  /** The specific genericized type for {@code Duration}. */
  public static final Type DURATION_TYPE = new TypeToken<Duration>(){}.getType();

  /** The specific genericized type for {@code Period}. */
  public static final Type PERIOD_TYPE = new TypeToken<Period>(){}.getType();

  /** The specific genericized type for {@code Instant}. */
  public static final Type INSTANT_TYPE = new TypeToken<Instant>(){}.getType();

  /** The specific genericized type for {@code DateTimeZone}. */
  public static final Type DATE_TIME_ZONE_TYPE = new TypeToken<DateTimeZone>(){}.getType();

  /**
   * Registers all the Joda Time converters.
   * @param builder The GSON builder to register the converters with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerAll(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    registerDateMidnight(builder);
    registerDateTime(builder);
    registerDuration(builder);
    registerLocalDate(builder);
    registerLocalDateTime(builder);
    registerLocalTime(builder);
    registerInterval(builder);
    registerPeriod(builder);
    registerInstant(builder);
    registerDateTimeZone(builder);

    return builder;
  }

  /**
   * Registers the {@link DateMidnight} converter.
   * @param builder The GSON builder to register the converter with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerDateMidnight(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    builder.registerTypeAdapter(DATE_MIDNIGHT_TYPE, new DateMidnightConverter());

    return builder;
  }

  /**
   * Registers the {@link DateTime} converter.
   * @param builder The GSON builder to register the converter with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerDateTime(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    builder.registerTypeAdapter(
      DATE_TIME_TYPE,
      new DateTimeConverter(
        ISODateTimeFormat.dateTime(),
        ISODateTimeFormat.dateTimeParser().withOffsetParsed()));

    return builder;
  }

  /**
   * Registers the {@link DateTime} converter.
   * @param builder The GSON builder to register the converter with.
   * @param serializeFormatter The DateTimeFormatter to use during ser.
   * @param deserializeFormatter The DateTimeFormatter to use during des.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerDateTime(
    GsonBuilder builder,
    DateTimeFormatter serializeFormatter,
    DateTimeFormatter deserializeFormatter)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }
    if (serializeFormatter == null) { throw new NullPointerException("serializeFormatter cannot be null"); }
    if (deserializeFormatter == null) { throw new NullPointerException("deserializeFormatter cannot be null"); }

    builder.registerTypeAdapter(
      DATE_TIME_TYPE,
      new DateTimeConverter(
        serializeFormatter,
        deserializeFormatter));

    return builder;
  }

  /**
   * Registers the {@link Duration} converter.
   * @param builder The GSON builder to register the converter with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerDuration(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    builder.registerTypeAdapter(DURATION_TYPE, new DurationConverter());

    return builder;
  }

  /**
   * Registers the {@link LocalDate} converter.
   * @param builder The GSON builder to register the converter with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerLocalDate(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    builder.registerTypeAdapter(LOCAL_DATE_TYPE, new LocalDateConverter());

    return builder;
  }

  /**
   * Registers the {@link LocalDateTime} converter.
   * @param builder The GSON builder to register the converter with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerLocalDateTime(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    builder.registerTypeAdapter(LOCAL_DATE_TIME_TYPE, new LocalDateTimeConverter());

    return builder;
  }

  /**
   * Registers the {@link LocalTime} converter.
   * @param builder The GSON builder to register the converter with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerLocalTime(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    builder.registerTypeAdapter(LOCAL_TIME_TYPE, new LocalTimeConverter());

    return builder;
  }

  /**
   * Registers the {@link Instant} converter.
   * @param builder The GSON builder to register the converter with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerInstant(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    builder.registerTypeAdapter(INSTANT_TYPE, new InstantConverter());

    return builder;
  }

  /**
   * Registers the {@link Interval} converter.
   * @param builder The GSON builder to register the converter with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerInterval(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    builder.registerTypeAdapter(INTERVAL_TYPE, new IntervalConverter());

    return builder;
  }

  /**
   * Registers the {@link Period} converter.
   * @param builder The GSON builder to register the converter with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerPeriod(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    builder.registerTypeAdapter(PERIOD_TYPE, new PeriodConverter());

    return builder;
  }

  /**
   * Registers the {@link DateTimeZone} converter.
   * @param builder The GSON builder to register the converter with.
   * @return A reference to {@code builder}.
   */
  public static GsonBuilder registerDateTimeZone(GsonBuilder builder)
  {
    if (builder == null) { throw new NullPointerException("builder cannot be null"); }

    builder.registerTypeAdapter(DATE_TIME_ZONE_TYPE, new DateTimeZoneConverter());

    return builder;
  }

}
