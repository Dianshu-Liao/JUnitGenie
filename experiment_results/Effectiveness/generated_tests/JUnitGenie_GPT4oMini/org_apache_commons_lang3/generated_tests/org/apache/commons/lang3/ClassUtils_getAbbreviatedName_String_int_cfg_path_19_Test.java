package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;

public class ClassUtils_getAbbreviatedName_String_int_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_ValidInput() {
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 30;
        String expected = "org.apache.commons.lang3.ClassUtils";
        String actual = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_ClassNameShorterThanLengthHint() {
        String className = "ShortClass";
        int lengthHint = 20;
        String expected = "ShortClass";
        String actual = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_NullClassName() {
        String className = null;
        int lengthHint = 10;
        String expected = ""; // StringUtils.EMPTY
        String actual = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_ZeroLengthHint() {
        String className = "org.example.Class";
        int lengthHint = 0;
        try {
            ClassUtils.getAbbreviatedName(className, lengthHint);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("len must be > 0", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_NegativeLengthHint() {
        String className = "org.example.Class";
        int lengthHint = -5;
        try {
            ClassUtils.getAbbreviatedName(className, lengthHint);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("len must be > 0", e.getMessage());
        }
    }

}