package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_normalizeSpace_String_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNullInput() {
        String input = null; // This satisfies the External_Method_Parameters_Constraints
        String expected = null; // The expected output when the input is null
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

}