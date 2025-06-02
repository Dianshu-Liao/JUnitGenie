package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing() {
        // Test case where the string does not start or end with the wrap string
        String result = StringUtils.wrapIfMissing("test", "*");
        assertEquals("*test*", result);

        // Test case where the string starts with the wrap string
        result = StringUtils.wrapIfMissing("*test", "*");
        assertEquals("*test*", result);

        // Test case where the string ends with the wrap string
        result = StringUtils.wrapIfMissing("test*", "*");
        assertEquals("*test*", result);

        // Test case where the string is empty
        result = StringUtils.wrapIfMissing("", "*");
        assertEquals("", result);

        // Test case where the wrap string is empty
        result = StringUtils.wrapIfMissing("test", "");
        assertEquals("test", result);

        // Test case where both strings are empty
        result = StringUtils.wrapIfMissing("", "");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNull() {
        // Test case where the input string is null
        String result = StringUtils.wrapIfMissing(null, "*");
        assertEquals(null, result);

        // Test case where the wrap string is null
        result = StringUtils.wrapIfMissing("test", null);
        assertEquals("test", result);
    }

}