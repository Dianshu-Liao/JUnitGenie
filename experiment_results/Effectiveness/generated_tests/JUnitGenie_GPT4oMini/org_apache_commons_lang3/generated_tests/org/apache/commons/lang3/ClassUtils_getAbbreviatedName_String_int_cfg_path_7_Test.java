package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassUtils_getAbbreviatedName_String_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithValidInputs() {
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 20;
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals("org.apache...", result);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithNullClassName() {
        String className = null;
        int lengthHint = 10;
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals("", result); // Expected to return empty string
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithLengthHintLessThanOrEqualToZero() {
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 0; // This should throw an exception
        try {
            ClassUtils.getAbbreviatedName(className, lengthHint);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("len must be > 0", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithLengthHintGreaterThanClassNameLength() {
        String className = "ShortName";
        int lengthHint = 20; // greater than the className length
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals("ShortName", result);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithLengthHintEqualToClassNameLength() {
        String className = "EqualLength";
        int lengthHint = className.length(); // equal to className length
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals("EqualLength", result);
    }

}