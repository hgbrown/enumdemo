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
public enum Ethnicity implements EnumeratedTypeWithAlternateNames<Ethnicity> {

    WHITE("w", "900", "wh"),

    BLACK("b", "500", "bl"),

    ;

    /**
     * A collection of alternate names by which this enum constant can be found.
     */
    private final LowerCaseList alternateNames;

    Ethnicity(final String... names) {
        alternateNames = new LowerCaseList(names);
        alternateNames.add(name());
    }

    @Override
    public LowerCaseList getAlternateNames() {
        return alternateNames;
    }

    @Override
    public Ethnicity[] getEnumeratedTypes() {
        return values();
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
    public static Ethnicity getByName(String name) {
        return EnumeratedTypeUtil.getByName(name, Ethnicity.BLACK);
    }

}
