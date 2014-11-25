# Enum Demo

Demonstrate how to find an enum constant in a class where multiple alternate names could be sent for the same constant.
If this functionality is needed by multiple enumeration classes then the same pattern can be applied by extracting the
 functionality into a utility class which accepts the enumeration class as a parameter. Each enumeration class would
 then simply delegate to this utility class.


## Software

This project is built using [http://gradle.org/](Gradle) version 2.0 running on JDK 1.7.

To run the test, you can run `gradle clean test`.

If you don not have Gradle, installed this process can be automated by running the Gradle Wrapper: `gradlew` script.

----

Author: <henry.g.brown@gmail.com>
