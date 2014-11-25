package enumdemo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GenderTest {

    @Test(expected = NullPointerException.class)
    public void shouldThrowExpectedExceptionIfNameIsNull() throws Exception {
        Gender.getByName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExpectedExceptionWhenNoEnumConstantIsFound() throws Exception {
        Gender.getByName("Wednesday");
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByName() throws Exception {
        final Gender male = Gender.MALE;
        final Gender foundGender = Gender.getByName(male.name());
        assertThat(foundGender, is(male));
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByLowerCaseName() throws Exception {
        final Gender female = Gender.FEMALE;
        final Gender foundGender = Gender.getByName(female.name().toLowerCase());
        assertThat(foundGender, is(female));
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByAlternateName() throws Exception {
        final Gender foundGender = Gender.getByName("m");
        assertThat(foundGender, is(Gender.MALE));
    }

    @Test
    public void shouldBeAbleToGetEnumConstantByUpperCaseAlternameName() throws Exception {
        final Gender foundGender = Gender.getByName("F");
        assertThat(foundGender, is(Gender.FEMALE));
    }

}
