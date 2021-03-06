package enumdemo;

import util.EnumeratedTypeUtil;
import util.LowerCaseList;

/**
 * Demonstrates an enumeration which allows an enum constant to be found using a collection of alternate names.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201411250559
 * @since 0.1201411250559
 */
public enum Gender implements EnumeratedTypeWithAlternateNames<Gender> {

    MALE("m", "1", "man"),

    FEMALE("f", "2", "woman"),

    ;

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

    @Override
    public LowerCaseList getAlternateNames() {
        return alternateNames;
    }

    @Override
    public Gender[] getEnumeratedTypes() {
        return values();
    }

    /**
     * Returns the enum constant defined in this class whose {@link #name() name} or
     * {@link #alternateNames one of its alternate names} matches the specified name.
     * The match of the name is case insensitive but extraneous whitespace characters are not permitted.
     *
     * @param name      the case-insensitive name of the enum constant to be found.
     * @return          the enum constant with the name specified.
     * @throws NullPointerException
     *                  if {@code name} is {@code null}.
     * @throws IllegalArgumentException
     *                  if no enum constant can be found that matches the specified {code name}.
     */
    public static Gender getByName(String name) {
        return EnumeratedTypeUtil.getByName(name, Gender.FEMALE);
    }

}
