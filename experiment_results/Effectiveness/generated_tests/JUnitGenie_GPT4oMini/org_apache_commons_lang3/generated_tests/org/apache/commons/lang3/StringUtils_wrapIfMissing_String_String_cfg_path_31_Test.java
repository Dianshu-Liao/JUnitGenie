package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_31_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing() {
        // Test case where str does not start or end with wrapWith
        String result = StringUtils.wrapIfMissing("Hello", "*");
        assertEquals("*Hello*", result);

        // Test case where str only does not start with wrapWith
        result = StringUtils.wrapIfMissing("Hello", "!");
        assertEquals("!Hello!", result);

        // Test case where str only does not end with wrapWith
        result = StringUtils.wrapIfMissing("Hello", "H");
        assertEquals("HHelloH", result);

        // Test case where str is empty
        result = StringUtils.wrapIfMissing("", "*");
        assertEquals("", result);

        // Test case where wrapWith is empty
        result = StringUtils.wrapIfMissing("Hello", "");
        assertEquals("Hello", result);
    }

}