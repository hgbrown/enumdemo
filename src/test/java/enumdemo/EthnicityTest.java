package enumdemo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EthnicityTest {

    @Test(expected = NullPointerException.class)
    public void shouldThrowExpectedExceptionIfNameIsNull() throws Exception {
        Ethnicity.getByName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExpectedExceptionWhenNoEnumConstantIsFound() throws Exception {
        Ethnicity.getByName("Wednesday");
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByName() throws Exception {
        final Ethnicity black = Ethnicity.BLACK;
        final Ethnicity foundEthnicity = Ethnicity.getByName(black.name());
        assertThat(foundEthnicity, is(black));
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByLowerCaseName() throws Exception {
        final Ethnicity white = Ethnicity.WHITE;
        final Ethnicity foundEthnicity = Ethnicity.getByName(white.name().toLowerCase());
        assertThat(foundEthnicity, is(white));
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByAlternateName() throws Exception {
        final Ethnicity foundEthnicity = Ethnicity.getByName("b");
        assertThat(foundEthnicity, is(Ethnicity.BLACK));
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByUpperCaseAlternateName() throws Exception {
        final Ethnicity foundEthnicity = Ethnicity.getByName("W");
        assertThat(foundEthnicity, is(Ethnicity.WHITE));
    }

}