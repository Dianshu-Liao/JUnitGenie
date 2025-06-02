package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_24_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing() {
        // Test case where str is null and wrapWith is a valid string
        String result = StringUtils.wrapIfMissing(null, "*");
        assertEquals("*", result);

        // Test case where str is a valid string and wrapWith is null
        result = StringUtils.wrapIfMissing("test", null);
        assertEquals("test", result);

        // Test case where str does not start or end with wrapWith
        result = StringUtils.wrapIfMissing("test", "*");
        assertEquals("*test*", result);

        // Test case where str starts with wrapWith but does not end with it
        result = StringUtils.wrapIfMissing("*test", "*");
        assertEquals("*test*", result);

        // Test case where str ends with wrapWith but does not start with it
        result = StringUtils.wrapIfMissing("test*", "*");
        assertEquals("*test*", result);

        // Test case where str starts and ends with wrapWith
        result = StringUtils.wrapIfMissing("*test*", "*");
        assertEquals("*test*", result);
    }

}