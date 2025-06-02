package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getAbbreviatedName_String_int_cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testGetAbbreviatedName() {
        // Given
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 30;

        // When
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);

        // Then
        assertEquals("org.apache.commons.lang3.ClassUtils", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAbbreviatedNameWithZeroLengthHint() {
        // Given
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 0;

        try {
            // When
            ClassUtils.getAbbreviatedName(className, lengthHint);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("len must be > 0", e.getMessage());
            throw e; // rethrow to satisfy the expected exception
        }
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithNullClassName() {
        // Given
        String className = null;
        int lengthHint = 5;

        // When
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);

        // Then
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithShortClassName() {
        // Given
        String className = "ShortName";
        int lengthHint = 20;

        // When
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);

        // Then
        assertEquals("ShortName", result);
    }

}