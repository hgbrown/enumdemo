package enumdemo;

import org.apache.commons.lang.enums.Enum;
import util.EnumeratedTypeUtil;
import util.LowerCaseList;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Demonstrates an enumeration class implemented using the type safe enum pattern using the Apache Commons Lang classes
 * to perform the heavy lifting.
 *
 * @author <a href="mailto:henry.g.brown@gmail.com">henryb</a>
 * @version 0.1201411250559
 * @since 0.1201411250559
 */
public final class ColorEnum extends Enum implements EnumeratedTypeWithAlternateNames<ColorEnum> {

    public static final ColorEnum RED = new ColorEnum("Red", "r", "#ff0000", "#f00" , "255,0,0");
    public static final ColorEnum GREEN = new ColorEnum("Green", "g", "#00ff00", "#0f0", "0,255,0");
    public static final ColorEnum BLUE = new ColorEnum("Blue", "b", "#0000ff", "#00f", "0,0,255");

    private final LowerCaseList alternateNames;

    /**
     * Prevent outside instantiation of enumerated constant with alternate names.
     *
     * @param color         the unique name of the constant.
     * @param names         the unique alternate names of the constant.
     * @throws java.lang.IllegalArgumentException
     *                      if the {@code color} is {@code null} or an empty string
     * @throws java.lang.NullPointerException
     *                      if {@code names} is {@code null}.
     */
    private ColorEnum(String color, String... names) {
        super(color);
        alternateNames = new LowerCaseList(names);
        alternateNames.add(color);
    }

    /**
     * Returns an enum constant by {@code #name}. This method is case sensitive and the name must match exactly the name
     * of the enumeration constant.
     *
     * @param color         the unique name of the enum constant.
     * @return              the constant of the specified name or {@code null} if {@code color} is {@code null}.
     */
    public static ColorEnum getEnum(String color) {
        return (ColorEnum) getEnum(ColorEnum.class, color);
    }

    /**
     * Returns the {@code Map} of {@code Enum} constants by {@code name}.
     *
     * @return      a map of unique names to enum constants.
     */
    @SuppressWarnings("unchecked") //underlying commons-lang api uses raw types
    public static Map<String, ColorEnum> getEnumMap() {
        return getEnumMap(ColorEnum.class);
    }

    /**
     * Returns a list of enumeration constants defined in this enumerated type.
     * The list is in the order that the objects were created (source code order).
     *
     * @return      the list of enumerated constants in the order they are declared.
     */
    @SuppressWarnings("unchecked") //underlying commons-lang api uses raw types
    public static List<ColorEnum> getEnumList() {
        return getEnumList(ColorEnum.class);
    }

    /**
     * Returns an {@code iterator} over the constants defined in this enumerated type.
     * The {@code iterator} is in the order that the objects were created (source code order).
     *
     * @return      an iterator of the enumeration constants declared int this enumerated type.
     */
    @SuppressWarnings("unchecked") //underlying commons-lang api uses raw types
    public static Iterator<ColorEnum> iterator() {
        return iterator(ColorEnum.class);
    }

    @Override
    public String name() {
        return getName();
    }

    @Override
    public LowerCaseList getAlternateNames() {
        return alternateNames;
    }

    @Override
    public ColorEnum[] getEnumeratedTypes() {
        final List<ColorEnum> enumList = getEnumList();
        return enumList.toArray(new ColorEnum[enumList.size()]);
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
    public static ColorEnum getByName(String name) {
        return EnumeratedTypeUtil.getByName(name, ColorEnum.BLUE);
    }

}