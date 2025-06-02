package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassUtils_getAbbreviatedName_String_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetAbbreviatedName() {
        // Test case for valid className and lengthHint
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 10;
        String expected = "org.apach...";
        String actual = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithLengthHintZero() {
        // Test case for lengthHint <= 0
        try {
            ClassUtils.getAbbreviatedName("org.apache.commons.lang3.ClassUtils", 0);
            fail("Expected IllegalArgumentException for lengthHint <= 0");
        } catch (IllegalArgumentException e) {
            assertEquals("len must be > 0", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithNullClassName() {
        // Test case for className == null
        String actual = ClassUtils.getAbbreviatedName((String) null, 5); // Cast to String to resolve ambiguity
        assertEquals("", actual);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithShortClassName() {
        // Test case for className.length() <= lengthHint
        String className = "ShortName";
        int lengthHint = 10;
        String actual = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(className, actual);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedNameWithUseFullCondition() {
        // Test case to ensure useFull condition is met
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 20; // This should allow for full name
        String actual = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals("org.apache.commons.lang3.ClassUtils", actual);
    }


}