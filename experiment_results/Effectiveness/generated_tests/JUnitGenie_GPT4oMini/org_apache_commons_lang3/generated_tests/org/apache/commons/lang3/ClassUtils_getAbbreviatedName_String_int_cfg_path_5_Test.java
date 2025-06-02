package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassUtils_getAbbreviatedName_String_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_ValidInput() {
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 30;
        String expected = "org.apache.commons.lang3.ClassUtils";
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
        String result = ClassUtils.getAbbreviatedName((String) null, 10); // Cast to String to resolve ambiguity
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_LengthHintLessThanClassName() {
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 10;
        String expected = "org.apach";
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_ExactLengthHint() {
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = className.length();
        String expected = className;
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, result);
    }


}