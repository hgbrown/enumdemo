package util;

import com.google.common.base.Preconditions;
import enumdemo.EnumeratedTypeWithAlternateNames;

import static java.lang.String.format;

/**
 * A utility class to perform common operations on {@link EnumeratedTypeWithAlternateNames}.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201411251430
 * @since 0.1201411251430
 */
public final class EnumeratedTypeUtil {

    /**
     * Default error message template used to report errors in
     * {@link EnumeratedTypeUtil#getByName(String, enumdemo.EnumeratedTypeWithAlternateNames)}.
     * Current value is: {@value}.
     */
    private static final String DEFAULT_ERR_MSG = "Unable to find enum in class %s with name %s";

    /**
     * Prevent instantiation of utility class.
     */
    private EnumeratedTypeUtil() {
    }

    /**
     * Returns the enum constant defined in the specified class whose
     * {@link EnumeratedTypeWithAlternateNames#name() name} or
     * {@link enumdemo.EnumeratedTypeWithAlternateNames#getAlternateNames()  one of its alternate names} matches the
     * specified name. The match of the name is case insensitive but extraneous whitespace characters are not permitted.
     *
     * @param name          the case-insensitive name of the enum constant to be found.
     * @param e             any instance of the enumerated type to be searched for the name.
     * @return              the enum constant with the name specified.
     * @throws NullPointerException
     *                      if {@code name} or {@code e} is {@code null}.
     * @throws IllegalArgumentException
     *                      if no enum constant can be found that matches the specified {code name}.
     */
    public static <T extends EnumeratedTypeWithAlternateNames> T getByName(String name, EnumeratedTypeWithAlternateNames<T> e) {
        Preconditions.checkNotNull(e, "Enumerated Type cannot be null.");

        final Class<? extends EnumeratedTypeWithAlternateNames> c = e.getClass();
        Preconditions.checkNotNull(name, DEFAULT_ERR_MSG, c, "null");

        for (final T t : e.getEnumeratedTypes()) {
            if (t.getAlternateNames().contains(name.toLowerCase())) {
                return t;
            }
        }

        throw new IllegalArgumentException(format(DEFAULT_ERR_MSG, c, name));
    }

}
