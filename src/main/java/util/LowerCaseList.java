package util;

import java.util.ArrayList;

/**
 * A specialisation of {@link java.util.ArrayList} which allows only lowercase strings to
 * be stored in the list. This class will automatically convert any strings added to the list to their lowercase
 * equivalent using {@link String#toLowerCase()} to perform the conversion.
 */
public final class LowerCaseList extends ArrayList<String> {

    /**
     * Create a new list with the specified elements, converting each element to the lowercase equivalent of the
     * element passed in.
     *
     * @param elements          a non-{@code null} collection of elements to be stored in this list.
     * @throws NullPointerException
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
