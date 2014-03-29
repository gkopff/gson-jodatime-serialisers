# gson-jodatime-serialisers

## What is it?

A set of [GSON](http://code.google.com/p/google-gson/) serialiser/deserialisers for dealing with 
[Joda Time](http://joda-time.sourceforge.net/) entities.  Wherever possible, [ISO 8601 string representations]
(http://en.wikipedia.org/wiki/ISO_8601) are used.

## Getting it

````
<dependency>
  <groupId>com.fatboyindustrial.gson-jodatime-serialisers</groupId>
  <artifactId>gson-jodatime-serialisers</artifactId>
  <version>1.0.0</version>
</dependency>
````

## Using it

````
final Gson gson = Converters.registerDateTime(new GsonBuilder()).create();
final DateTime original = new DateTime();

final String json = gson.toJson(original);
final DateTime reconstituted = gson.fromJson(json, DateTime.class);
````
