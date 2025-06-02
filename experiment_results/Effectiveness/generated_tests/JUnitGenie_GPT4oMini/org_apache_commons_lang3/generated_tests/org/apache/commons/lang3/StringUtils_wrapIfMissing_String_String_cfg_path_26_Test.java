package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing() {
        // Test case where str does not start or end with wrapWith
        String str = "example";
        String wrapWith = "*";
        String expected = "*example*";
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);

        // Test case where str starts with wrapWith
        str = "*example";
        expected = "*example*";
        actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);

        // Test case where str ends with wrapWith
        str = "example*";
        expected = "*example*";
        actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);

        // Test case where str is empty
        str = "";
        expected = "";
        actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);

        // Test case where wrapWith is empty
        str = "example";
        wrapWith = "";
        expected = "example";
        actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);

        // Test case where both str and wrapWith are empty
        str = "";
        wrapWith = "";
        expected = "";
        actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

}