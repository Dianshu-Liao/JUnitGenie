package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_substringAfter_String_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSubstringAfterWithNullString() {
        // Arrange
        String str = null;
        String separator = "separator";

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals(null, result);
    }

}