package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing_NullStringAndNullWrapWith() {
        String str = null; // parameter0 must be null
        String wrapWith = null; // parameter1 can also be null

        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Since both parameters are null, the method should return the input string (which is null)
        assertEquals(result, null);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NonEmptyStringWithNullWrapWith() {
        String str = "test"; // non-empty string
        String wrapWith = null; // parameter1 can be null

        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Here, wrapWith is null, so we expect the original string to be returned
        assertEquals(result, "test");
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NullStringWithNonEmptyWrapWith() {
        String str = null; // parameter0 must be null
        String wrapWith = "*"; // non-empty string

        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Since the input string is null, the method should return null
        assertEquals(result, null);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_EmptyStringWithEmptyWrapWith() {
        String str = ""; // empty string
        String wrapWith = ""; // empty string

        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Return the input string (empty string) since both are empty
        assertEquals(result, "");
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_EmptyStringWithNonEmptyWrapWith() {
        String str = ""; // empty string
        String wrapWith = "*"; // non-empty string

        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Since str is empty and wrapWith is "*", it should wrap and return "*"
        assertEquals(result, "*");
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NonEmptyStringWithNonEmptyWrapWith() {
        String str = "test"; // non-empty string
        String wrapWith = "*"; // non-empty string

        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Since str does not start or end with wrapWith,
        // it should return "*test*"
        assertEquals(result, "*test*");
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_AlreadyWrappedString() {
        String str = "*test*"; // non-empty string already wrapped
        String wrapWith = "*"; // non-empty string

        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Since str is already wrapped, it should return the original string
        assertEquals(result, "*test*");
    }

}