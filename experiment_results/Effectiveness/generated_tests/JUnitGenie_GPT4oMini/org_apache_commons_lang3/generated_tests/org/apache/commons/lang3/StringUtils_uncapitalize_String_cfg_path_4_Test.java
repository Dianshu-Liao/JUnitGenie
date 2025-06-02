package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_uncapitalize_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testUncapitalizeWithEmptyString() {
        // Given
        String input = ""; // This input meets the constraints: non-null and length() returns 0

        // When
        String result = StringUtils.uncapitalize(input);

        // Then
        assertEquals("", result);
    }

}