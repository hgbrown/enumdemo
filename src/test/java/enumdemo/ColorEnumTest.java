package enumdemo;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class ColorEnumTest {

    @Test(expected = NullPointerException.class)
    public void shouldThrowExpectedExceptionIfNameIsNull() throws Exception {
        ColorEnum.getByName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExpectedExceptionWhenNoEnumConstantIsFound() throws Exception {
        ColorEnum.getByName("Wednesday");
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByName() throws Exception {
        final ColorEnum blue = ColorEnum.BLUE;
        final ColorEnum foundEthnicity = ColorEnum.getByName(blue.name());
        assertThat(foundEthnicity, is(blue));
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByLowerCaseName() throws Exception {
        final ColorEnum green = ColorEnum.GREEN;
        final ColorEnum foundColorEnum = ColorEnum.getByName(green.name().toLowerCase());
        assertThat(foundColorEnum, is(green));
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByAlternateName() throws Exception {
        final ColorEnum foundColorEnum = ColorEnum.getByName("r");
        assertThat(foundColorEnum, is(ColorEnum.RED));
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByUpperCaseAlternateName() throws Exception {
        final ColorEnum foundColorEnum = ColorEnum.getByName("R");
        assertThat(foundColorEnum, is(ColorEnum.RED));
    }

    @Test
    public void shouldNotBeAbleToGetEnumByAlternateName() throws Exception {
        final ColorEnum colorNotFound = ColorEnum.getEnum("r");
        assertThat(colorNotFound, is(nullValue()));
    }

    @Test
    public void shouldBeAbleToGetEnumByName() throws Exception {
        final ColorEnum red = ColorEnum.RED;
        final ColorEnum foundColorEnum = ColorEnum.getEnum(red.name());
        assertThat(foundColorEnum, is(red));
    }

    @Test
    public void shouldBeAbleToGetMapWithExpectedElements() throws Exception {
        final Map<String, ColorEnum> enumMap = ColorEnum.getEnumMap();

        assertThat(enumMap.size(), is(3));
        assertTrue(enumMap.containsKey(ColorEnum.RED.name()));
        assertTrue(enumMap.containsKey(ColorEnum.BLUE.name()));
        assertTrue(enumMap.containsKey(ColorEnum.GREEN.name()));
    }

    @Test
    public void shouldBeAbleToGetListWithExpectedElements() throws Exception {
        final List<ColorEnum> enumList = ColorEnum.getEnumList();

        assertThat(enumList.size(), is(3));
        assertTrue(enumList.contains(ColorEnum.RED));
        assertTrue(enumList.contains(ColorEnum.GREEN));
        assertTrue(enumList.contains(ColorEnum.BLUE));
    }

    @Test
    public void shouldBeAbleToGetIteratorToReturnItemsInDefinedOrder() throws Exception {
        final Iterator<ColorEnum> it = ColorEnum.iterator();

        assertThat(it, is(notNullValue()));
        assertTrue(it.hasNext());
        assertThat(it.next(), is(ColorEnum.RED));
        assertThat(it.next(), is(ColorEnum.GREEN));
        assertThat(it.next(), is(ColorEnum.BLUE));
        assertFalse(it.hasNext());
    }

}