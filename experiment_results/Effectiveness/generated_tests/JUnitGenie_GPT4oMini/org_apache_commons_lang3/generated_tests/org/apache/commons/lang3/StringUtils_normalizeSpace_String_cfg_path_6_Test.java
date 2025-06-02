package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNull() {
        String input = null; // This satisfies the constraint that parameter0 must be null
        String expected = null; // The expected output when input is null
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

}