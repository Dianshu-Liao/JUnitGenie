package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing() {
        // Test with str not wrapping, wrapWith being non-empty
        String result = StringUtils.wrapIfMissing("example", "$");
        assertEquals("$example$", result);

        // Test with str not wrapping at start, wrapWith empty
        result = StringUtils.wrapIfMissing("example", "");
        assertEquals("example", result);

        // Test with null str
        try {
            StringUtils.wrapIfMissing(null, "$");
        } catch (Exception e) {
            // Expected behavior
        }

        // Test with str empty, wrapWith being non-empty
        result = StringUtils.wrapIfMissing("", "$");
        assertEquals("", result);

        // Test with str wrapping at start only
        result = StringUtils.wrapIfMissing("$example", "$");
        assertEquals("$example$", result);

        // Test with str wrapping at end only
        result = StringUtils.wrapIfMissing("example$", "$");
        assertEquals("$example$", result);
    }

}