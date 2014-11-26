package enumdemo;

import util.LowerCaseList;

/**
 * Represents an enumerated type where the constants in the enumerated type can be uniquely identified by more than one
 * name. In other words, each constant can be identified by at least one unique name in a case-insensitive manner but
 * may also have additional, alternate names by which it can be uniquely identified.
 *
 * <p>
 * This interface does not declare the method used to find an enumerated constant since this is typically done via a
 * {@code static} method. However, the {@link util.EnumeratedTypeUtil#getByName(String, EnumeratedTypeWithAlternateNames)}
 * method is a utility class which works with this interface to perform the required search behaviour.
 * </p>
 *
 * <p>
 * Note that the standard Java {@link java.lang.Enum enumeration} class does not satisfy the above criteria without
 * enhancement since the name match is case-sensitive and there are never alternate names by which a constant can be
 * identified. However, enhancing the standard Java enumeration to satisfy the above criteria is a trivial task of
 * implementing this interface and supplying implementations for each of these methods.
 * </p>
 *
 * <p>
 * This approach will not only work for standard Java {@link Enum enumerated types} but also for classes following the
 * Enumerated type pattern (such as {@code org.apache.commons.lang.enums.Enum}).
 * </p>
 *
 * @param <T>       the enumerated type.
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201411251428
 * @since 0.1201411251428
 */
public interface EnumeratedTypeWithAlternateNames<T extends EnumeratedTypeWithAlternateNames> {

    /**
     * The unique name of this enumerated type constant. This name must be unique to an enumerated constant in this
     * enumerated type. If the implementing class is a standard {@link java.lang.Enum enumeration} then this method is
     * equivalent to {@link Enum#name()}.
     *
     * @return      the name of this enum constant
     */
    String name();

    /**
     * Returns a collection of alternate names by which this enumerated constant can also be identified within this
     * enumerated type. All names included in this collection should be unique to an enumerated constant defined in
     * this enumerated type. The names are stored as lowercase versions of all the names added to the collection.
     *
     * @return              a collection of alternate names which can be used to identify this enumerated constant.
     */
    LowerCaseList getAlternateNames();

    /**
     * Returns an array containing the constants of this enum type, in the order they're declared. If the implementing
     * class is a standard Java {@link java.lang.Enum enumeration} then this method is equivalent to
     * {@code java.lang.Enum.values()}.
     * <p>
     * Note that this method will return exactly the same array irrespective which constant it is called on.
     * </p>
     *
     * @return      an array containing the constants of this enum type, in the order they're declared
     */
    T[] getEnumeratedTypes();

}
