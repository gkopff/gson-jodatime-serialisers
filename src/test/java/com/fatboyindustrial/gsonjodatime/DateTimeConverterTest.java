// ===================================================================
// GSON Joda Time Serialisers
// (c) Copyright 2013 Gregory Kopff
// All Rights Reserved.
// ===================================================================

package com.fatboyindustrial.gsonjodatime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Type;

import org.joda.time.DateTime;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 *  Tests for {@link DateTimeConverter}.
 */
public class DateTimeConverterTest
{
  /**
   *  Tests that the {@link DateTime} can be round-tripped.
   */
  @Test
  public void testRoundtrip()
  {
    final Type type = new TypeToken<DateTime>(){}.getType();
    final GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(type, new DateTimeConverter());
    final Gson gson = builder.create();
    
    final DateTime dt = new DateTime();
    
    assertThat(gson.fromJson(gson.toJson(dt), DateTime.class), is(dt));
  }
}
