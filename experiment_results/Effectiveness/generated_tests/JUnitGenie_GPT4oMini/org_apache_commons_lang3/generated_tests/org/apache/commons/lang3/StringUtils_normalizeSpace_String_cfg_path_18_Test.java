package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNullInput() {
        String input = null; // This input meets the constraint for isEmpty method
        String expected = null; // Expected output when input is null
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

}