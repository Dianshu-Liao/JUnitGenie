package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing() {
        // Test case where str is empty and wrapWith is not empty
        String str = "";
        String wrapWith = "*";
        String expected = "*";
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);

        // Test case where str is not empty and wrapWith is empty
        str = "test";
        wrapWith = "";
        expected = "test";
        actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);

        // Test case where str does not start or end with wrapWith
        str = "test";
        wrapWith = "*";
        expected = "*test*";
        actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);

        // Test case where str starts with wrapWith but does not end with it
        str = "*test";
        wrapWith = "*";
        expected = "*test*";
        actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);

        // Test case where str ends with wrapWith but does not start with it
        str = "test*";
        wrapWith = "*";
        expected = "*test*";
        actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);

        // Test case where str starts and ends with wrapWith
        str = "*test*";
        wrapWith = "*";
        expected = "*test*";
        actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

}