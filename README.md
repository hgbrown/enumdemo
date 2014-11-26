# Enum Demo

Demonstrate how to find an enum constant in a class where multiple alternate names could be sent for the same constant.
This demo project describes a pattern where the enumerated type could be a standard Java enumeration (i.e. implemented
using the `enum` keyword and therefore a subclass of `java.lang.Enum`) or classes which follow the enumerated class
pattern (such as implemented in Apache Commons Lang using the `org.apache.commons.lang.enums.Enum`).

In order to operate on both of these types of enumerated classes a standard interface needs to be implemented
(`EnumeratedTypeWithAlternateNames`) to obscure the differences between these two types. The implementation could be
greatly simplified by only allowing standard Java enumerated types since most of the methods implemented in the
interface map directly to methods already implemented in `java.lang.Enum`.

The following classes are provided as examples of how the pattern works:

* `Gender` - as an example of a standard Java enumeration
* `Ethnicity` - as an example of a standard Java enumeration
* `ColorEnum` - as an example of an implementation of the enumerated type pattern using Apache Commons Lang


## Software

This project is built using [http://gradle.org/](Gradle) version 2.0 running on JDK 1.7.

To run the tests, run: `gradle clean test`.
To generate documentation, run: `gradle clean javadoc`

If you don not have Gradle, installed this process can be automated by running the Gradle Wrapper: `gradlew` script.

----

Author: <henry.g.brown@gmail.com>
