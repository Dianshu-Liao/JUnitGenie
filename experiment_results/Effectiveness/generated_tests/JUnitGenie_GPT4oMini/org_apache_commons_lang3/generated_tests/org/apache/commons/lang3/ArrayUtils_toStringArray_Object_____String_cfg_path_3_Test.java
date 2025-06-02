package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ArrayUtils_toStringArray_Object_____String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToStringArray_NullArray() {
        // Given
        Object[] array = null;
        String valueForNullElements = "default";

        // When
        String[] result = ArrayUtils.toStringArray(array, valueForNullElements);

        // Then
        assertNull(result);
    }

}