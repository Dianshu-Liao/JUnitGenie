package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getAbbreviatedName_String_int_cfg_path_28_Test {

    @Test(timeout = 4000)
    public void testGetAbbreviatedName_classNameIsNull_lengthHintPositive() {
        // Given
        String className = null;
        int lengthHint = 5;

        // When
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);

        // Then
        assertEquals("", result);
    }

}