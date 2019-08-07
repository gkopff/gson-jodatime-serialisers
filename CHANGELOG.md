# Change Log

## [1.8.0] - 2019-07-07

### Added
 - Add Kotlin extension functions support (contributed by [mihakrajnc](https://github.com/mihakrajnc))
 - Enhance `Instant` deserialisation so it can deserialise values with or without milliseconds (contributed by [nathanrobb](https://github.com/nathanrobb))
 - Enhance `Instant` deserialisation so it can deserialise values a timezone offset (contributed by [nathanrobb](https://github.com/nathanrobb))

## [1.7.1] - 2019-02-04

### Fixed
 - Correctly deserialise ISO 8601 string with timezone offset into a `DateTime` (contributed by [sgrossberndt](https://github.com/sgrossberndt)).

## [1.7.0] - 2018-08-30

### Added
 - Support for `DateTimeZone` (contributed by [manianand74](https://github.com/manianand74)) 
 
## [1.6.0] - 2017-03-29

### Added
 - Support for `Instant` (contributed by [JamesMcIntosh](https://github.com/JamesMcIntosh)) 
 
## [1.5.0] - 2017-01-19

### Added
 - Made OSGi aware (contributed by [spegelref](https://github.com/spegelref)) 
 
## [1.4.0] - 2016-09-21

### Added
 - Support for `Period` (contributed by [brtietz](https://github.com/brtietz))

## [1.3.0] - 2016-07-03

### Changed
 - Parsing `DateTime` values that omit milliseconds is now supported (contributed by [Hikaru755](https://github.com/Hikaru755))

## [1.2.0] - 2015-07-24

### Changed
 - Deserialise empty strings and null strings to a null object (contributed by [anilmamede](https://github.com/anilmamede))
