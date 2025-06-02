package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassUtils_getAbbreviatedName_String_int_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_withValidInputs() {
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 20;
        String expected = "org.apache.commons.l"; // Expected abbreviated name
        String actual = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAbbreviatedName_lengthHintLessThanOrEqualToZero() {
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 0; // This should trigger the exception
        ClassUtils.getAbbreviatedName(className, lengthHint);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_classNameNull() {
        String className = null;
        int lengthHint = 10; 
        String expected = ""; // Should return empty string
        String actual = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_classNameShorterThanLengthHint() {
        String className = "ShortName";
        int lengthHint = 20; 
        String expected = "ShortName"; // Should return className itself
        String actual = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_withEdgeLengthHint() {
        String className = "long.example.class.name";
        int lengthHint = 25; 
        String expected = "long.example.class.name"; // Actual length is less than or equal to lengthHint
        String actual = ClassUtils.getAbbreviatedName(className, lengthHint);
        assertEquals(expected, actual);
    }

}