package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassUtils_getAbbreviatedName_String_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_ValidInput() {
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 10;
        String expected = "org.ap..."; // Expected abbreviated name based on the logic
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_LengthHintZero() {
        try {
            ClassUtils.getAbbreviatedName("org.apache.commons.lang3.ClassUtils", 0);
            fail("Expected IllegalArgumentException for lengthHint <= 0");
        } catch (IllegalArgumentException e) {
            assertEquals("len must be > 0", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_NullClassName() {
        String result = ClassUtils.getAbbreviatedName((String) null, 5); // Cast to String to resolve ambiguity
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_ClassNameShorterThanLengthHint() {
        String className = "ShortName";
        int lengthHint = 20;
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(className, result);
    }


}