package util;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LowerCaseListTest {

    private LowerCaseList emptyList;

    @Before
    public void setUp() throws Exception {
        emptyList = new LowerCaseList();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExpectedExceptionWhenNullIsPassedAsArgument() throws Exception {
        new LowerCaseList((String[]) null);
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Test
    public void shouldBeAbleToAddMixedCaseStringThroughConstructorAndGetLowerCaseStringBack() throws Exception {
        final String mixedCase = "Male";
        final LowerCaseList lowerCaseList = new LowerCaseList(mixedCase);

        assertThat(lowerCaseList.size(), is(1));
        assertThat(lowerCaseList.get(0), is(mixedCase.toLowerCase()));
    }

    @Test
    public void shouldBeAbleToAddLowerCaseStringToList() throws Exception {
        final String lowerCase = "male";
        emptyList.add(lowerCase);

        assertThat(emptyList.size(), is(1));
        assertThat(emptyList.get(0), is(lowerCase));
    }

    @Test
    public void shouldBeAbleToAddUpperCaseStringToList() throws Exception {
        final String upperCase = "MALE";
        emptyList.add(upperCase);

        assertThat(emptyList.size(), is(1));
        assertThat(emptyList.get(0), is(upperCase.toLowerCase()));
    }

}