package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNull() {
        String input = null;
        String expected = null;
        try {
            String result = StringUtils.normalizeSpace(input);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithEmptyString() {
        String input = "";
        String expected = "";
        try {
            String result = StringUtils.normalizeSpace(input);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}