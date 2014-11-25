package enumdemo;

import java.util.ArrayList;

import static java.lang.String.format;

/**
 * Demonstrates an enumeration which allows an enum constant to be found using a collection of alternate names.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201411250559
 * @since 0.1201411250559
 */
public enum Gender {

    MALE("m", "1"),

    FEMALE("f", "2"),

    ;

    /**
     * Default error message template used to report errors in {@link #getByName(String)}. Current value is: {@value}.
     */
    private static final String DEFAULT_ERR_MSG = "Unable to find enum in class %s with name %s";

    /**
     * A collection of alternate names by which this enum constant can be found.
     */
    private final LowerCaseList alternateNames;

    /**
     * Construct an enum constant with a collection of alternate names by which it could be found.
     *
     * @param names     alternate names by which this enumeration constant can be found. This should be a
     *                  non-{@code null} collection of lowercase names.
     * @throws java.lang.NullPointerException
     *                  if {@code names} is {@code null}.
     */
    Gender(final String... names) {
        alternateNames = new LowerCaseList(names);
        alternateNames.add(name());
    }

    /**
     * Returns the enum constant defined in this class whose {@link #name() name} or
     * {@link #alternateNames one of its alternate names} matches the specified name.
     * The match of the name is case insensitive but extraneous whitespace characters are not permitted.
     *
     * @param name          the case-insensitive name of the enum constant to be found.
     * @return              the enum constant with the name specified.
     * @throws NullPointerException
     *                      if {@code name} is {@code null}.
     * @throws IllegalArgumentException
     *                      if no enum constant can be found that matches the specified {code name}.
     */
    public static Gender getByName(String name) {

        if (name == null) {
            throw new NullPointerException(format(DEFAULT_ERR_MSG, Gender.class, "null"));
        }

        for (final Gender g : values()) {
            if (g.alternateNames.contains(name.toLowerCase())) {
                return g;
            }
        }

        throw new IllegalArgumentException(format(DEFAULT_ERR_MSG, Gender.class, name));
    }

    /**
     * Private class which is a specialisation of {@link java.util.ArrayList} which allows only lowercase strings to
     * be stored in the list.
     */
    private static final class LowerCaseList extends ArrayList<String> {

        /**
         * Create a new list with the specified elements, converting each element to the lowercase equivalent of the
         * element passed in.
         *
         * @param elements          a non-{@code null} collection of elements to be stored in this list.
         * @throws java.lang.NullPointerException
         *                          if {@code elements} is {@code null}.
         */
        public LowerCaseList(String... elements) {

            if(elements == null) { //sanity check
                throw new NullPointerException("elements cannot be null");
            }

            for (final String e : elements) {
                add(e);
            }
        }

        /**
         * Add a new string to the list, converting the string to its lowercase equivalent using
         * {@link String#toLowerCase()}.
         *
         * @param s         the element to be added. Could be {@code null}.
         * @return          {@code true} if this collection changed as a result of the call, else {@code false}
         *                  (as specified by {@link java.util.Collection#add(Object)}).
         */
        @Override
        public final boolean add(String s) {  //final because rather safe than sorry!
            final String lowerCased = (s == null) ? null : s.toLowerCase();
            return super.add(lowerCased);
        }

    }

}
